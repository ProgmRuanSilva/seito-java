package br.com.seito.entities;

public class EspecialidadeDentista {
    
    private int idEspecialidade;
    private String nome;
    private String codigoEspecialidade;
    
    public EspecialidadeDentista() {
    }
    
    public EspecialidadeDentista(int idEspecialidade, String nome, String codigoEspecialidade) {
        this.idEspecialidade = idEspecialidade;
        this.nome = nome;
        this.codigoEspecialidade = codigoEspecialidade;
    }
    
    public int getIdEspecialidade() {
        return idEspecialidade;
    }
    
    public void setIdEspecialidade(int idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCodigoEspecialidade() {
        return codigoEspecialidade;
    }
    
    public void setCodigoEspecialidade(String codigoEspecialidade) {
        this.codigoEspecialidade = codigoEspecialidade;
    }
}
