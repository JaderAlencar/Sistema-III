/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Adm
 */
public class Paciente {

    private int login;
    private String senha;
    private String nome;
    private String cpf;
    private Date datanascimento;
    private String telefone;
    private String endereco;
    private String email;

    public Paciente() {
    }

    public Paciente(int login1, String senha, String nome, String cpf, String telefone, String email1) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.datanascimento = datanascimento;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Paciente{" + "login=" + login + ", senha=" + senha + ", nome=" + nome + ", cpf=" + cpf + ", datanascimento=" + datanascimento + ", telefone=" + telefone + ", endereco=" + endereco + ", email=" + email + '}';
    }
    
}

 

