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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Quarto;
import model.QuartoDisponivel;
import model.QuartoMemento;
import persistence.QuartoDao;

/**
 *
 * @author matheus
 */
public class PrepararEditarQuartoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
           int codigo = Integer.parseInt(request.getParameter("codigo"));
            Quarto quartoE;
            quartoE = Quarto.obterQuarto(codigo);
            
            
            
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
                        quarto.setEstadosSalvos(new QuartoMemento(new QuartoDisponivel()));
                    }
            }
            session.setAttribute("quartos", quartos);
            
            request.setAttribute("quarto", quartoE);
            RequestDispatcher view = request.getRequestDispatcher("/QuartoUpdate.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
            Logger.getLogger(PrepararEditarQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
