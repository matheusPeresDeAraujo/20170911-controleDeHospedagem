/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.ArrayList;
import model.*;

/**
 *
 * @author matheus
 */
public class Main {
    public static void main(String[] args) {
        
        ArrayList<QuartoMemento> estadosSalvos = new ArrayList();
        
        Quarto quarto = new QuartoCasal(10, "vista", "estado");
        quarto.setQuartoEstado(new QuartoOcupado());
        
        
        System.out.println("Quarto " + quarto.getNumero() + 
                " esta no estado " + quarto.getQuartoEstado() + 
                " - " + quarto.ocupado());
        
        estadosSalvos.add(quarto.saveToMemento());
        quarto.setQuartoEstado(new QuartoDisponivel());
        
        System.out.println("Quarto " + quarto.getNumero() + 
                " esta no estado " + quarto.getQuartoEstado() + 
                " - " + quarto.ocupado());
        
        quarto.resteoreFromMemento(estadosSalvos.get(0));
       
        System.out.println("Quarto " + quarto.getNumero() + 
                " esta no estado " + quarto.getQuartoEstado() + 
                " - " + quarto.ocupado());
          
    }
}
