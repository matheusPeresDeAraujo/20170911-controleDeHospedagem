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
public class QuartoOcupado implements QuartoEstado{

    @Override
    public String Disponivel(Quarto quarto) {
        quarto.setQuartoEstado(new QuartoDisponivel());
        return "Alteração aceita";
    }

    @Override
    public String Ocupado(Quarto quarto) {
        return "Alteração recusada";
    }

    @Override
    public String Manutencao(Quarto quarto) {
        quarto.setQuartoEstado(new QuartoManutencao());
        return "Alteração aceita";
    }

    @Override
    public String getEstado(Quarto quarto) {
        quarto.setEstado("ocupado");
        return "ocupado";
    }

    @Override
    public String toString() {
        return "QuartoOcupado";
    }
    
}
