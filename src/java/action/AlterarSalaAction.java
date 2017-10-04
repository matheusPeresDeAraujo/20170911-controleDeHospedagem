/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Quarto;
import model.Sala;
import model.SalaAuditorio;
import model.SalaBanquete;
import model.SalaEscolar;
import model.SalaEspinhaDePeixe;
import model.SalaFormatoU;
import model.SalaReuniao;
import persistence.SalaDao;

/**
 *
 * @author matheus
 */
public class AlterarSalaAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        if(request.getParameter("textCodigo").equals("") || request.getParameter("textNumero").equals("") || request.getParameter("textNome").equals("") || request.getParameter("textPreco").equals("")){
            try {
                String resposta = "Alteração recusada";
                
                request.setAttribute("resposta", resposta);
                request.setAttribute("salas", Sala.obterSalas());
                RequestDispatcher view = request.getRequestDispatcher("/Sala.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(AlterarSalaAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AlterarSalaAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ServletException ex) {
                Logger.getLogger(AlterarSalaAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            int codigo = Integer.parseInt(request.getParameter("textCodigo"));
            int numero = Integer.parseInt(request.getParameter("textNumero"));
            String nome = request.getParameter("textNome");
            Double preco = Double.parseDouble(request.getParameter("textPreco"));
            try{
                Sala sala = null;
                if(nome.equals("auditorio")){
                    sala = new SalaAuditorio(codigo, numero, preco);
                }else if(nome.equals("banquete")){
                    sala = new SalaBanquete(codigo, numero, preco);
                }else if(nome.equals("escolar")){
                    sala = new SalaEscolar(codigo, numero, preco);
                }else if(nome.equals("espinhadepeixe")){
                    sala = new SalaEspinhaDePeixe(codigo, numero, preco);
                }else if(nome.equals("formatoU")){
                    sala = new SalaFormatoU(codigo, numero, preco);
                }else if(nome.equals("reuniao")){
                    sala = new SalaReuniao(codigo, numero, preco);
                }else{
                    sala = new SalaAuditorio(codigo, numero, preco);
                }
                SalaDao.getInstance().update(sala);
                request.setAttribute("salas", Sala.obterSalas());
                    RequestDispatcher view = 
                            request.getRequestDispatcher("/Sala.jsp");
                    view.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(AlterarSalaAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AlterarSalaAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ServletException ex) {
                Logger.getLogger(AlterarSalaAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
