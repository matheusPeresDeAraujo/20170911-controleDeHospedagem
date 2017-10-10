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
public class QuartoMemento {
    
    private QuartoEstado estado;
    
    public QuartoMemento(QuartoEstado estadoSalvar){
        estado = estadoSalvar;
    }
    
    public QuartoEstado getEstadoSalvo(){
        return estado;
    }
}
