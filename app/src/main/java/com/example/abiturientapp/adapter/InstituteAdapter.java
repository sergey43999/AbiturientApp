package com.example.abiturientapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abiturientapp.InstitutePage;
import com.example.abiturientapp.R;
import com.example.abiturientapp.model.InstituteModel;

import java.util.List;

public class InstituteAdapter extends RecyclerView.Adapter<InstituteAdapter.InstituteHolder> {

    Context context;
    List<InstituteModel> institutes;

    public InstituteAdapter(Context context, List<InstituteModel> institutes) {
        this.context = context;
        this.institutes = institutes;
    }

    @NonNull
    @Override
    public InstituteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View instituteItems = LayoutInflater.from(context).inflate(R.layout.institute_item, parent, false);
        return new InstituteAdapter.InstituteHolder(instituteItems);
    }

    @Override
    public void onBindViewHolder(@NonNull InstituteHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.instituteBg.setCardBackgroundColor(Color.parseColor(institutes.get(position).getColor()));
        holder.instituteTittle.setText(institutes.get(position).getTittleEducation());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, InstitutePage.class);

                intent.putExtra("instituteBg", Color.parseColor(institutes.get(position).getColor()));
                intent.putExtra("instituteTittle", institutes.get(position).getTittleEducation());
                intent.putExtra("instituteText", institutes.get(position).getText());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return institutes.size();
    }

    public static final class InstituteHolder extends RecyclerView.ViewHolder {

        CardView instituteBg;
        ImageView instituteImage;
        TextView instituteTittle, instituteDate, instituteProgram;


        public InstituteHolder(@NonNull View itemView) {
            super(itemView);

            instituteBg = itemView.findViewById(R.id.instituteBg);
            instituteTittle = itemView.findViewById(R.id.instituteTittle);
            instituteDate = itemView.findViewById(R.id.instituteDate);
            instituteProgram = itemView.findViewById(R.id.instituteProgram);
        }
    }
}
