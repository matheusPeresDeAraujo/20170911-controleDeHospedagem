/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
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
import model.Aluga;
import model.Cliente;
import model.Quarto;
import persistence.AlugaDao;
import persistence.QuartoDao;

/**
 *
 * @author matheus
 */
public class OcuparQuartoAction implements Action{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        int codCliente = Integer.parseInt(request.getParameter("textCliente"));
        int codQuarto = Integer.parseInt(request.getParameter("textCodigo"));
        try {
            Cliente cliente = Cliente.obterCliente(codCliente);
            Quarto quarto = Quarto.obterQuarto(codQuarto);
            
            Aluga aluga = new Aluga(quarto, cliente);
            
            AlugaDao.getInstance().save(aluga);
            quarto.ocupado();
            quarto.setEstado(quarto.getQuartoEstado());
            QuartoDao.getInstance().update(quarto);
            
            HttpSession session = request.getSession(true);
            Map<Integer, Quarto> quartos = (Map<Integer, Quarto>) session.getAttribute("quartos");
            if (quartos == null) {
                quartos = new HashMap<>();
                for(Quarto qp : QuartoDao.getInstance().obterQuartos()){
                    quartos.put(qp.getCodigo(), qp);
                }
            }
            
            quartos.put(QuartoDao.getInstance().obterQuarto(codQuarto).getCodigo(), quarto);
            
            session.setAttribute("quartos", quartos);
            
            String cont = "true";
            for(Quarto qp : QuartoDao.getInstance().obterQuartos()){
                    if(qp.getEstado().equals("disponivel")){
                    cont = "false";
                }
            }
            
            request.setAttribute("todosOcupados", cont);
            request.setAttribute("quartos", Quarto.obterQuartos());
            RequestDispatcher view = 
                    request.getRequestDispatcher("/painel.jsp");
            view.forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(OcuparQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OcuparQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(OcuparQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
