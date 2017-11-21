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
public class GravarSalaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        if(request.getParameter("textNumero").equals("") || request.getParameter("textNome").equals("") || request.getParameter("textPreco").equals("")){
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
            int numero = Integer.parseInt(request.getParameter("textNumero"));
            String nome = request.getParameter("textNome");
            Double preco = Double.parseDouble(request.getParameter("textPreco"));
            try {
                Sala sala = null;
                if(nome.equals("auditorio")){
                    sala = new SalaAuditorio(numero, preco);
                }else if(nome.equals("banquete")){
                    sala = new SalaBanquete(numero, preco);
                }else if(nome.equals("escolar")){
                    sala = new SalaEscolar(numero, preco);
                }else if(nome.equals("espinhadepeixe")){
                    sala = new SalaEspinhaDePeixe(numero, preco);
                }else if(nome.equals("formatoU")){
                    sala = new SalaFormatoU(numero, preco);
                }else if(nome.equals("reuniao")){
                    sala = new SalaReuniao(numero, preco);
                }else{
                    sala = new SalaAuditorio(numero, preco);
                }

                try {
                    SalaDao.getInstance().save(sala);
                    request.setAttribute("salas", Sala.obterSalas());
                    RequestDispatcher view
                            = request.getRequestDispatcher("/Sala.jsp");
                    view.forward(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GravarSalaAction.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ServletException ex) {
                    Logger.getLogger(GravarSalaAction.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                response.sendRedirect("PaginaErro.jsp");
                ex.printStackTrace();
            }
        }
    }

}
