/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author matheus
 */
public class Aluga {
    
    private int codigo;
    private Quarto codQuarto;
    private Cliente codCliente;

    public Aluga() {
    }

    public Aluga(int codigo, Quarto codQuarto, Cliente codCliente) {
        this.codigo = codigo;
        this.codQuarto = codQuarto;
        this.codCliente = codCliente;
    }
    
    public Aluga(Quarto codQuarto, Cliente codCliente) {
        this.codQuarto = codQuarto;
        this.codCliente = codCliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Quarto getCodQuarto() {
        return codQuarto;
    }

    public void setCodQuarto(Quarto codQuarto) {
        this.codQuarto = codQuarto;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }
    
    
}
