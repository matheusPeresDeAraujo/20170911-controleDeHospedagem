/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import persistence.ClienteDao;

/**
 *
 * @author matheus
 */
public class Cliente implements Observer{
        
    private int codigo;
    private int idade;
    private String nome;
    private String identificacao;
    private String telefone;
    private String celular;
    private String email;
    
    private Observable quarto;

    public Cliente() {
    }

    public Cliente(int idade, String nome, String identificacao, String telefone, String celular, String email) {
        this.idade = idade;
        this.nome = nome;
        this.identificacao = identificacao;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
    }

    public Cliente(int codigo, int idade, String nome, String identificacao, String telefone, String celular, String email) {
        this.codigo = codigo;
        this.idade = idade;
        this.nome = nome;
        this.identificacao = identificacao;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public static List<Cliente> obterClientes() throws SQLException, ClassNotFoundException{
        return ClienteDao.obterClientes();
    }
    
    public static Cliente obterCliente(int codigo) throws SQLException, ClassNotFoundException{
        return ClienteDao.obterCliente(codigo);
    }

    public void setQuarto(Observable quarto){
        this.quarto = (Observable)quarto;
        quarto.addObserver(this);
    }
    
    @Override
    public void update(Observable quartoSubject, Object arg) {
        if(quartoSubject instanceof Quarto){
            Quarto quarto = (Quarto) quartoSubject;
            System.out.println("Atençao " + getNome() + ", ficou disponivel o quarto. " + quarto.getNumero());
         }
    }
}
