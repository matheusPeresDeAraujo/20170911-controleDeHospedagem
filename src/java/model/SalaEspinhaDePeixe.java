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
public class SalaEspinhaDePeixe extends Sala{
    public SalaEspinhaDePeixe(){
        this.nome = "espinhadepeixe";
        this.promocao = new PromocaoNv1();
    }
    
    public SalaEspinhaDePeixe(int numero, double preco){
        super();
        this.nome = "espinhadepeixe";
        this.numero = numero;
        this.preco = preco;
    }
    
    public SalaEspinhaDePeixe(int codigo, int numero, double preco){
        super();
        this.nome = "espinhadepeixe";
        this.codigo = codigo;
        this.numero = numero;
        this.promocao = new PromocaoNv1();
        this.preco = preco;
        this.precoA = preco *(1.0+(double)this.getDesconto()/100);
    }
}
