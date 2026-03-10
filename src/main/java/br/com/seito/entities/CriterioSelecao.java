package br.com.seito.entities;

public class CriterioSelecao {
    
    private int idCriterio;
    private String nome;
    private String descricao;
    
    public CriterioSelecao() {
    }
    
    public CriterioSelecao(int idCriterio, String nome, String descricao) {
        this.idCriterio = idCriterio;
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public int getIdCriterio() {
        return idCriterio;
    }
    
    public void setIdCriterio(int idCriterio) {
        this.idCriterio = idCriterio;
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
