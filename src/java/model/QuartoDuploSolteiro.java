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
public class QuartoDuploSolteiro extends Quarto{
    
    public QuartoDuploSolteiro() {
    }

    public QuartoDuploSolteiro(int numero, String vista, String estado) {
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
    
    public QuartoDuploSolteiro(int codigo, int numero, String vista, String estado, String estadoValue) {
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
        return "twin room";
    }

    @Override
    public double getPreco() {
        return 200;
    }

    @Override
    public double getTamanho() {
        return 200;
    }

    @Override
    public int getCama() {
        return 2;
    }

    @Override
    public int getBanheiro() {
        return 1;
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
        return false;
    }
}
