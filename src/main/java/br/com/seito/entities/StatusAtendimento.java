package br.com.seito.entities;

public class StatusAtendimento {
    
    private int idStatus;
    private String nome;
    private String descricao;
    
    public StatusAtendimento() {
    }
    
    public StatusAtendimento(int idStatus, String nome, String descricao) {
        this.idStatus = idStatus;
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public int getIdStatus() {
        return idStatus;
    }
    
    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
