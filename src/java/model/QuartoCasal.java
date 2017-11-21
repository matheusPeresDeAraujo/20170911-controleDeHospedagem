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
public class QuartoCasal extends Quarto{
    
    public QuartoCasal() {
    }

    public QuartoCasal(int numero, String vista, String estado) {
        this.numero = numero;
        this.vista = vista;
        
        if(estado.equals("disponivel")){
            this.quartoEstado = new QuartoDisponivel();
        }else if(estado.equals("ocupado")){
            this.quartoEstado = new QuartoOcupado();
        }else{
            this.quartoEstado = new QuartoManutencao();
        }
    }
    
    public QuartoCasal(int codigo, int numero, String vista, String estado, String estadoValue) {
        this.codigo = codigo;
        this.numero = numero;
        this.vista = vista;
        
        if(estado.equals("disponivel")){
            this.quartoEstado = new QuartoDisponivel();
        }else if(estado.equals("ocupado")){
            this.quartoEstado = new QuartoOcupado();
        }else{
            this.quartoEstado = new QuartoManutencao();
        }
        
        this.estado = estadoValue;
    }
    
    @Override
    public String getTipo() {
        return "double room";
    }

    @Override
    public double getPreco() {
        return 100;
    }

    @Override
    public double getTamanho() {
        return 100;
    }

    @Override
    public int getCama() {
        return 1;
    }

    @Override
    public int getBanheiro() {
        return 2;
    }

    @Override
    public boolean getFrigobar() {
        return true;
    }

    @Override
    public boolean getTv() {
        return true;
    }

    @Override
    public boolean getComputador() {
        return true;
    }
}
