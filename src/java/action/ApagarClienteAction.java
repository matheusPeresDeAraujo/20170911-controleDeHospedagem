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
import model.Cliente;
import persistence.ClienteDao;

/**
 *
 * @author matheus
 */
public class ApagarClienteAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigo = Integer.parseInt(request.getParameter("textCodigo"));
        
        if(codigo == 0){
            response.sendRedirect("index.html");
        } else{
            try{
                ClienteDao.getInstance().drop(codigo);
                request.setAttribute("clientes", Cliente.obterClientes());
                RequestDispatcher view =
                        request.getRequestDispatcher("/Cliente.jsp");
                view.forward(request, response);
            }catch(ClassNotFoundException ex){
                Logger.getLogger(ApagarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ServletException ex) {
                Logger.getLogger(ApagarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ApagarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
