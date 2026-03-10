package br.com.seito.entities;

public class TipoDoacao {
    
    private int idTipoDoacao;
    private String nome;
    private String descricao;
    
    public TipoDoacao() {
    }
    
    public TipoDoacao(int idTipoDoacao, String nome, String descricao) {
        this.idTipoDoacao = idTipoDoacao;
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public int getIdTipoDoacao() {
        return idTipoDoacao;
    }
    
    public void setIdTipoDoacao(int idTipoDoacao) {
        this.idTipoDoacao = idTipoDoacao;
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
