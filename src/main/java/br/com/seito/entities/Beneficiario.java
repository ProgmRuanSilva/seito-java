package br.com.seito.entities;

import java.util.Date;

public class Beneficiario extends Pessoa {
    
    private int idBeneficiado;
    private Date dataNascimento;
    private int idPrograma;
    private int idCriterio;
    private String tratamento;
    
    public Beneficiario() {
    }
    
    public Beneficiario(int idPessoa, String email, String nome, String telefone, String logradouro, Date dataCadastro,
                       int idBeneficiado, Date dataNascimento, int idPrograma, int idCriterio, String tratamento) {
        super(idPessoa, email, nome, telefone, logradouro, dataCadastro);
        this.idBeneficiado = idBeneficiado;
        this.dataNascimento = dataNascimento;
        this.idPrograma = idPrograma;
        this.idCriterio = idCriterio;
        this.tratamento = tratamento;
    }
    
    public int getIdBeneficiado() {
        return idBeneficiado;
    }
    
    public void setIdBeneficiado(int idBeneficiado) {
        this.idBeneficiado = idBeneficiado;
    }
    
    public Date getDataNascimento() {
        return dataNascimento;
    }
    
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public int getIdPrograma() {
        return idPrograma;
    }
    
    public void setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
    }
    
    public int getIdCriterio() {
        return idCriterio;
    }
    
    public void setIdCriterio(int idCriterio) {
        this.idCriterio = idCriterio;
    }
    
    public String getTratamento() {
        return tratamento;
    }
    
    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }
}
