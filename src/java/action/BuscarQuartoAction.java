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
import model.Quarto;
import model.QuartoDisponivel;
import model.QuartoEstado;
import model.QuartoMemento;
import persistence.QuartoDao;

/**
 *
 * @author matheus
 */
public class BuscarQuartoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            // Adiciono os qaurtos na sessão
            // Neste momento nada esta salvo nenhuma alteração esta salva na sessão.
            HttpSession session = request.getSession(true);
            List<Quarto> quartos = (List<Quarto>) session.getAttribute("quartos");
            if (quartos == null) {
                quartos = new ArrayList<>();
                for(Quarto quarto : QuartoDao.getInstance().obterQuartos()){
                    quartos.add(quarto);
                }
            }
            session.setAttribute("quartos", quartos);
            //request.setAttribute("quartos", quartos);
            RequestDispatcher view = 
                    request.getRequestDispatcher("/Quarto.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(BuscarQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BuscarQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuscarQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
