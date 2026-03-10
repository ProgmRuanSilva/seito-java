package br.com.seito.entities;

public class ProgramaSocial {
    
    private int idPrograma;
    private String nome;
    private String descricao;
    private int idadeMinima;
    private int idadeMaxima;
    
    public ProgramaSocial() {
    }
    
    public ProgramaSocial(int idPrograma, String nome, String descricao, int idadeMinima, int idadeMaxima) {
        this.idPrograma = idPrograma;
        this.nome = nome;
        this.descricao = descricao;
        this.idadeMinima = idadeMinima;
        this.idadeMaxima = idadeMaxima;
    }
    
    public int getIdPrograma() {
        return idPrograma;
    }
    
    public void setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
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
    
    public int getIdadeMinima() {
        return idadeMinima;
    }
    
    public void setIdadeMinima(int idadeMinima) {
        this.idadeMinima = idadeMinima;
    }
    
    public int getIdadeMaxima() {
        return idadeMaxima;
    }
    
    public void setIdadeMaxima(int idadeMaxima) {
        this.idadeMaxima = idadeMaxima;
    }
}
