package com.example.abiturientapp.model;

public class UserEntity {
    private String login, email, password, phone;
    public UserEntity (){}

    public UserEntity (String login, String password, String phone, String email){
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.email = email;

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
