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
public interface QuartoEstado {
    public String Disponivel(Quarto quarto);
    public String Ocupado(Quarto quarto);
    public String Manutencao(Quarto quarto);
    public String getEstado(Quarto quarto);
    
}
