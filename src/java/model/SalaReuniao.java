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
public class SalaReuniao extends Sala{
    public SalaReuniao(){
        this.nome = "reuniao";
        this.promocao = new PromocaoNv2();
    }
    
    public SalaReuniao(int numero, double preco){
        super();
        this.nome = "reuniao";
        this.numero = numero;
        this.preco = preco;
    }
    
    public SalaReuniao(int codigo, int numero, double preco){
        super();
        this.nome = "reuniao";
        this.codigo = codigo;
        this.numero = numero;
        this.promocao = new PromocaoNv2();
        this.preco = preco;
        this.precoA = preco *(1.0+(double)this.getDesconto()/100);
    }
}
