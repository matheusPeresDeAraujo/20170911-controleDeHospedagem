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
import model.Cliente;
import model.Quarto;
import persistence.AlugaDao;

/**
 *
 * @author matheus
 */
public class PrepararCheckOutQuartoAction implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        Quarto quarto = null;
        Cliente cliente;
        try {
            quarto = Quarto.obterQuarto(codigo);
            
            String resposta = quarto.disponivel();
            if(resposta.equals("Alteração recusada")){
                request.setAttribute("resposta", resposta);
                request.setAttribute("quartos", Quarto.obterQuartos());
                RequestDispatcher view = request.getRequestDispatcher("/painel.jsp");
                view.forward(request, response);
            }
            
            cliente = Cliente.obterCliente(AlugaDao.getInstance().cliente(codigo));
            request.setAttribute("quarto", quarto);
            request.setAttribute("cliente", cliente);
            RequestDispatcher view = request.getRequestDispatcher("/QuartoCheckOut.jsp");
            view.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PrepararCheckOutQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrepararCheckOutQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(PrepararCheckOutQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
