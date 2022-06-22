package com.example.abiturientapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.abiturientapp.model.UserEntity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.provider.FirebaseInitProvider;

public class StartActivity extends AppCompatActivity {

    Button buttonSign, buttonRegistry;

    FirebaseAuth firebaseAuth;
    DatabaseReference users;
    FirebaseDatabase database;
    RelativeLayout root;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        buttonSign = findViewById(R.id.buttonSign);
        buttonRegistry = findViewById(R.id.buttonRegistry);

        root = findViewById(R.id.rootName);

        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

        buttonRegistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegWindow();
            }
        });

        buttonSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignWindow();
            }
        });
    }

    private void openSignWindow() {
        AlertDialog.Builder dial = new AlertDialog.Builder(this);
        dial.setTitle("Войти");
        dial.setMessage("Введите ваши учетные данные, чтобы войти");

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View signWindow = layoutInflater.inflate(R.layout.sign_window, null);
        dial.setView(signWindow);
        EditText email = signWindow.findViewById(R.id.email);
        EditText password = signWindow.findViewById(R.id.passwordRegistry);

        dial.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        dial.setPositiveButton("Войти", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(TextUtils.isEmpty(email.getText().toString())){
                    Snackbar.make(root, "Введите вашу почту", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if(password.getText().toString().length() < 8){
                    Snackbar.make(root, "Введите пароль, длина которого не меньше 8 символов", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                startActivity(new Intent(StartActivity.this, MainActivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Snackbar.make(root, "Ошибка входа." + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                    }
                });
            }
        });

        dial.show();
    }

    private void openRegWindow() {
        AlertDialog.Builder dial = new AlertDialog.Builder(this);
        dial.setTitle("Зарегистрироваться");
        dial.setMessage("Введите ваши учетные данные необходимые для регистрации");

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View regWindow = layoutInflater.inflate(R.layout.registry_window, null);
        dial.setView(regWindow);
        EditText email = regWindow.findViewById(R.id.email);
        EditText password = regWindow.findViewById(R.id.passwordRegistry);
        EditText phone = regWindow.findViewById(R.id.phone);
        EditText login = regWindow.findViewById(R.id.login);

        dial.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        dial.setPositiveButton("Готово", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(TextUtils.isEmpty(email.getText().toString())){
                    Snackbar.make(root, "Введите вашу почту", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(login.getText().toString())){
                    Snackbar.make(root, "Введите ваш логин", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(phone.getText().toString())){
                    Snackbar.make(root, "Введите ваш номер телефона", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if(password.getText().toString().length() < 8){
                    Snackbar.make(root, "Введите пароль, длина которого не меньше 8 символов", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                //Регистрация пользователя
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                UserEntity user = new UserEntity();
                                user.setEmail(email.getText().toString());
                                user.setPhone(phone.getText().toString());
                                user.setPassword(password.getText().toString());
                                user.setLogin(login.getText().toString());

                                users.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                Snackbar.make(root, "Пользователь успешно добавлен!", Snackbar.LENGTH_SHORT).show();
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Snackbar.make(root, "Ошибка при регистрации" + e.getMessage(), Snackbar.LENGTH_SHORT ).show();
                                    }
                                });

                            }
                        });
            }
        });

        dial.show();
    }
}