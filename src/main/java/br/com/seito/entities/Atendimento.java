package br.com.seito.entities;

import java.util.Date;

public class Atendimento {
    
    private int idAtendimento;
    private int idPessoaSolicitante;
    private Date dataHora;
    private int idPessoaDentista;
    private int idStatus;
    private String prioridade;
    private String descricao;
    
    public Atendimento() {
    }
    
    public Atendimento(int idAtendimento, int idPessoaSolicitante, Date dataHora, int idPessoaDentista,
                      int idStatus, String prioridade, String descricao) {
        this.idAtendimento = idAtendimento;
        this.idPessoaSolicitante = idPessoaSolicitante;
        this.dataHora = dataHora;
        this.idPessoaDentista = idPessoaDentista;
        this.idStatus = idStatus;
        this.prioridade = prioridade;
        this.descricao = descricao;
    }
    
    public int getIdAtendimento() {
        return idAtendimento;
    }
    
    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }
    
    public int getIdPessoaSolicitante() {
        return idPessoaSolicitante;
    }
    
    public void setIdPessoaSolicitante(int idPessoaSolicitante) {
        this.idPessoaSolicitante = idPessoaSolicitante;
    }
    
    public Date getDataHora() {
        return dataHora;
    }
    
    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
    
    public int getIdPessoaDentista() {
        return idPessoaDentista;
    }
    
    public void setIdPessoaDentista(int idPessoaDentista) {
        this.idPessoaDentista = idPessoaDentista;
    }
    
    public int getIdStatus() {
        return idStatus;
    }
    
    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }
    
    public String getPrioridade() {
        return prioridade;
    }
    
    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
