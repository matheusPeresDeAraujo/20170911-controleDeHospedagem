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
public class QuartoDisponivel implements QuartoEstado{
    @Override
    public String Disponivel(Quarto quarto) {
        return "Alteração recusada";
    }

    @Override
    public String Ocupado(Quarto quarto) {
        quarto.setQuartoEstado(new QuartoOcupado());
        return "Alteração aceita";
    }

    @Override
    public String Manutencao(Quarto quarto) {
        quarto.setQuartoEstado(new QuartoManutencao());
        return "Alteração aceita";
    }

    @Override
    public String getEstado(Quarto quarto) {
        quarto.setEstado("disponivel");
        return "disponivel";
    }

    @Override
    public String toString() {
        return "QuartoDisponivel";
    }
    
    
}
