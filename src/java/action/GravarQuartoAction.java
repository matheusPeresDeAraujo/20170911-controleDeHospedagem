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
import model.QuartoCasal;
import model.QuartoDuploSolteiro;
import model.QuartoSolteiro;
import persistence.QuartoDao;

/**
 *
 * @author matheus
 */
public class GravarQuartoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        if(request.getParameter("textNumero").equals("") || request.getParameter("textTipo").equals("") || request.getParameter("textVista").equals("") || request.getParameter("textEstado").equals("")){
            try {
                String resposta = "Alteração recusada";
                
                request.setAttribute("resposta", resposta);
                request.setAttribute("quartos", Quarto.obterQuartos());
                RequestDispatcher view = request.getRequestDispatcher("/Quarto.jsp");
                try {
                    view.forward(request, response);
                } catch (ServletException ex) {
                    Logger.getLogger(AlterarQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AlterarQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AlterarQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            int numero = Integer.parseInt(request.getParameter("textNumero"));
            String tipo = request.getParameter("textTipo");
            String vista = request.getParameter("textVista");
            String estado = request.getParameter("textEstado");
            try{
                Quarto quarto = null;
                if(tipo.equals("single room")){
                    quarto = new QuartoSolteiro(numero, vista, estado);
                }else if(tipo.equals("twin room")){
                    quarto = new QuartoDuploSolteiro(numero, vista, estado);
                }else if(tipo.equals("double room")){
                    quarto = new QuartoCasal(numero, vista, estado);
                } 
                try{
                    QuartoDao.getInstance().save(quarto);
                    request.setAttribute("quartos", Quarto.obterQuartos());
                    RequestDispatcher view = 
                            request.getRequestDispatcher("/painel.jsp");
                    view.forward(request, response);
                }catch(ClassNotFoundException ex){
                    Logger.getLogger(GravarQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ServletException ex) {
                    Logger.getLogger(GravarQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }catch(SQLException ex){
                response.sendRedirect("PaginaErro.jsp");
                ex.printStackTrace();
            }
        }
    }
    
}
