/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.List;
import persistence.SalaDao;

/**
 *
 * @author matheus
 */
public abstract class Sala {
    
    protected int codigo;
    protected int numero;
    protected double preco;
    protected double precoA;
    protected String nome;
    protected Promocao promocao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPromocao() {
        return promocao.obterPromocao();
    }
    
    public int getDesconto(){
        return promocao.obterDesconto();
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPrecoA() {
        return precoA;
    }

    public void setPrecoA(double precoA) {
        this.precoA = precoA;
    }
    
    public static List<Sala> obterSalas() throws SQLException, ClassNotFoundException{
        return SalaDao.obterSalas();
    }
    
    public static Sala obterSala(int codigo) throws SQLException, ClassNotFoundException{
        return SalaDao.obterSala(codigo);
    }
    
    
}
