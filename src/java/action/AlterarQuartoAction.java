/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cliente;
import model.Quarto;
import model.QuartoCasal;
import model.QuartoDisponivel;
import model.QuartoDuploSolteiro;
import model.QuartoMemento;
import model.QuartoSolteiro;
import persistence.QuartoDao;

/**
 *
 * @author matheus
 */
public class AlterarQuartoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        if(request.getParameter("textCodigo").equals("") || request.getParameter("textNumero").equals("") || request.getParameter("textTipo").equals("") || request.getParameter("textVista").equals("") || request.getParameter("textEstado").equals("")){
            try {
                String resposta = "Alteração recusada";
                
                request.setAttribute("resposta", resposta);
                request.setAttribute("quartos", Quarto.obterQuartos());
                RequestDispatcher view = request.getRequestDispatcher("/Quarto.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(AlterarQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AlterarQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ServletException ex) {
                Logger.getLogger(AlterarQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            int codigo = Integer.parseInt(request.getParameter("textCodigo"));
            int numero = Integer.parseInt(request.getParameter("textNumero"));
            String tipo = request.getParameter("textTipo");
            String vista = request.getParameter("textVista");
            String estado = request.getParameter("textEstado");
            
            try{
                Quarto quartoE = null;
                if(tipo.equals("single room")){
                    quartoE = new QuartoSolteiro(codigo, numero, vista, estado, estado);
                }else if(tipo.equals("twin room")){
                    quartoE = new QuartoDuploSolteiro(codigo, numero, vista, estado, estado);
                }else if(tipo.equals("double room")){
                    quartoE = new QuartoCasal(codigo, numero, vista, estado, estado);
                }  
                QuartoDao.getInstance().update(quartoE);
                
                //Neste momento adiciono memento a lista do quarto alterado
                HttpSession session = request.getSession(true);
                List<Quarto> quartos = (List<Quarto>) session.getAttribute("quartos");
                if (quartos == null) {
                    quartos = new ArrayList<>();
                    for(Quarto quarto : QuartoDao.getInstance().obterQuartos()){
                        quartos.add(quarto);
                    }
                }
                //Adicionando alteração | Momnto add disponivel a lista
                for(Quarto quarto : quartos){
                        if(quarto.getCodigo() == codigo){
//                            quartos.remove(quarto);
//                            quartos.add(quartoE);
                              quarto.setQuartoEstado(new QuartoDisponivel());
                        }
                }
                session.setAttribute("quartos", quartos);
                
                
                //request.setAttribute("quartos", Quarto.obterQuartos());
                    RequestDispatcher view = 
                            request.getRequestDispatcher("/Quarto.jsp");
                    view.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(AlterarQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AlterarQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ServletException ex) {
                Logger.getLogger(AlterarQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
