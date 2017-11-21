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
import model.Cliente;
import model.Quarto;
import persistence.QuartoDao;

/**
 *
 * @author matheus
 */
public class PrepararAviseAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            
            request.setAttribute("clientes", Cliente.obterClientes());
            RequestDispatcher view = 
                    request.getRequestDispatcher("/Aviso.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(PrepararAviseAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PrepararAviseAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrepararAviseAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
