/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import persistence.QuartoDao;

/**
 *
 * @author matheus
 */
public abstract class Quarto extends Observable{
    
    protected int codigo;
    protected QuartoEstado quartoEstado;
    protected String estado;
    protected int numero;
    protected String vista;
    
    protected String tipo;
    protected double preco;
    protected double tamanho;
    protected int cama;
    protected int banheiro;
    protected boolean frigobar;
    protected boolean tv;
    protected boolean computador;
    
    private List<Observer> observers = new ArrayList();
    
    public abstract String getTipo();
    public abstract double getPreco();
    public abstract double getTamanho();
    public abstract int getCama();
    public abstract int getBanheiro();
    public abstract boolean getFrigobar();
    public abstract boolean getTv();
    public abstract boolean getComputador();
    
    public String getDadosQuarto(){
        return "Tipo: " + getTipo() + " - Preco: " + getPreco() + 
                " - Tamanho: " + getTamanho() + " - Cama: " + getCama() + 
                " - Banheiro: " + getBanheiro() + " - Frigobar: " + getFrigobar() + 
                " - Tv: " + getTv() + " - Computador: " + getComputador() ;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    } 

    public String getQuartoEstado() {
        return quartoEstado.getEstado(this);
    }

    public void setQuartoEstado(QuartoEstado quartoEstado) {
        this.quartoEstado = quartoEstado;
        
        if(quartoEstado.getEstado(this).equals("disponivel")){
            setChanged();
            notifyObservers();
        }
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getVista() {
        return vista;
    }

    public void setVista(String vista) {
        this.vista = vista;
    }
    
    public String disponivel(){
        return this.quartoEstado.Disponivel(this);
    }
    
    public String ocupado(){
        return this.quartoEstado.Ocupado(this);
    }
    
    public String manutencao(){
        return this.quartoEstado.Manutencao(this);
    }
    
    public static List<Quarto> obterQuartos() throws SQLException, ClassNotFoundException{
        return QuartoDao.obterQuartos();
    }
    
    public static Quarto obterQuarto(int codigo) throws SQLException, ClassNotFoundException{
        return QuartoDao.obterQuarto(codigo);
    }
    
    public void registerObserver(Observer observer){
        observers.add(observer);
    }
    
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    
    public QuartoMemento saveToMemento(){
        return new QuartoMemento(quartoEstado);
    }
    
    public void notifyObservers(){
        for(Observer ob : observers){
            System.out.println("Notificando observers");
            ob.update(this, ob);
        }
    }
    
    public void resteoreFromMemento(QuartoMemento memento){
        quartoEstado = memento.getEstadoSalvo();
    }
}
