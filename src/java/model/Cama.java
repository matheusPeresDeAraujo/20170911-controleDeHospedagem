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
public abstract class Cama {
    private int largura;
    private int altura;
    
    public abstract String getTipo();
    
    public String getDadosCama(){
        return "Cama: " + getLargura() + "cm x " + getAltura() + "cm - Tipo: " + getTipo();
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    
}
