/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Quarto;

/**
 *
 * @author matheus
 */
public class PrepararExcluirQuartoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        Quarto quarto = null;
        try {
            quarto = Quarto.obterQuarto(codigo);
            request.setAttribute("quarto", quarto);
            RequestDispatcher view = request.getRequestDispatcher("/QuartoDelete.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
            Logger.getLogger(PrepararExcluirQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
