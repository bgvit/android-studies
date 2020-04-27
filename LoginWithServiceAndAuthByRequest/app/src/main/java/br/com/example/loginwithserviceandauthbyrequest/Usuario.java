package br.com.example.loginwithserviceandauthbyrequest;


import java.io.Serializable;

public class Usuario implements Serializable {
    private String Login;
    private String Senha;

    public Usuario() {
    }

    public Usuario(String login, String Senha) {
        Login = login;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
