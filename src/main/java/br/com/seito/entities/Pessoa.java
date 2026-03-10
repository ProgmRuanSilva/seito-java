package br.com.seito.entities;

import java.util.Date;

/**
 * Base class for all persons in the system.
 */
public class Pessoa {
    
    private int idPessoa;
    private String email;
    private String nome;
    private String telefone;
    private String logradouro;
    private Date dataCadastro;
    
    public Pessoa() {
    }
    
    public Pessoa(int idPessoa, String email, String nome, String telefone, String logradouro, Date dataCadastro) {
        this.idPessoa = idPessoa;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.dataCadastro = dataCadastro;
    }
    
    public int getIdPessoa() {
        return idPessoa;
    }
    
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getLogradouro() {
        return logradouro;
    }
    
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    
    public Date getDataCadastro() {
        return dataCadastro;
    }
    
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
