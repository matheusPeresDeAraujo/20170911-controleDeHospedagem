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
public class SalaAuditorio extends Sala{
    public SalaAuditorio(){
        this.nome = "auditorio";
        this.promocao = new PromocaoNv1();
    }
    
    public SalaAuditorio(int numero, double preco){
        super();
        this.nome = "auditorio";
        this.numero = numero;
        this.preco = preco;
    }
    
    public SalaAuditorio(int codigo, int numero, double preco){
        super();
        this.nome = "auditorio";
        this.codigo = codigo;
        this.numero = numero;
        this.promocao = new PromocaoNv1();
        this.preco = preco;
        this.precoA = preco *(1.0+(double)this.getDesconto()/100);
    }
}
