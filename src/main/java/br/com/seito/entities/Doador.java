package br.com.seito.entities;

import java.util.Date;

public class Doador extends Pessoa {
    
    private int idDoador;
    private String cpfCnpj;
    private int idTipoDoacao;
    private Double valorDoacao;
    private Date dataDoacao;
    
    public Doador() {
    }
    
    public Doador(int idPessoa, String email, String nome, String telefone, String logradouro, Date dataCadastro,
                  int idDoador, String cpfCnpj, int idTipoDoacao, Double valorDoacao, Date dataDoacao) {
        super(idPessoa, email, nome, telefone, logradouro, dataCadastro);
        this.idDoador = idDoador;
        this.cpfCnpj = cpfCnpj;
        this.idTipoDoacao = idTipoDoacao;
        this.valorDoacao = valorDoacao;
        this.dataDoacao = dataDoacao;
    }
    
    public int getIdDoador() {
        return idDoador;
    }
    
    public void setIdDoador(int idDoador) {
        this.idDoador = idDoador;
    }
    
    public String getCpfCnpj() {
        return cpfCnpj;
    }
    
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
    
    public int getIdTipoDoacao() {
        return idTipoDoacao;
    }
    
    public void setIdTipoDoacao(int idTipoDoacao) {
        this.idTipoDoacao = idTipoDoacao;
    }
    
    public Double getValorDoacao() {
        return valorDoacao;
    }
    
    public void setValorDoacao(Double valorDoacao) {
        this.valorDoacao = valorDoacao;
    }
    
    public Date getDataDoacao() {
        return dataDoacao;
    }
    
    public void setDataDoacao(Date dataDoacao) {
        this.dataDoacao = dataDoacao;
    }
}
