package br.com.seito.entities;

import java.util.Date;

public class Dentista extends Pessoa {
    
    private int idDentista;
    private String cro;
    private int idEspecialidade;
    private String status;
    
    public Dentista() {
    }
    
    public Dentista(int idPessoa, String email, String nome, String telefone, String logradouro, Date dataCadastro,
                    int idDentista, String cro, int idEspecialidade, String status) {
        super(idPessoa, email, nome, telefone, logradouro, dataCadastro);
        this.idDentista = idDentista;
        this.cro = cro;
        this.idEspecialidade = idEspecialidade;
        this.status = status;
    }
    
    public int getIdDentista() {
        return idDentista;
    }
    
    public void setIdDentista(int idDentista) {
        this.idDentista = idDentista;
    }
    
    public String getCro() {
        return cro;
    }
    
    public void setCro(String cro) {
        this.cro = cro;
    }
    
    public int getIdEspecialidade() {
        return idEspecialidade;
    }
    
    public void setIdEspecialidade(int idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
