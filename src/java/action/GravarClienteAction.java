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
public class GravarClienteAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(request.getParameter("textIdade").equals("") || request.getParameter("textNome").equals("") || request.getParameter("textIdentificacao").equals("") || request.getParameter("textTelefone").equals("null") || request.getParameter("textCelular").equals("null") || request.getParameter("textEmail").equals("null")){
            try {
                String resposta = "Alteração recusada";
                
                request.setAttribute("resposta", resposta);
                request.setAttribute("clientes", Cliente.obterClientes());
                RequestDispatcher view = request.getRequestDispatcher("/Cliente.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(AlterarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AlterarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ServletException ex) {
                Logger.getLogger(AlterarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            int idade = Integer.parseInt(request.getParameter("textIdade"));
            String nome = request.getParameter("textNome");
            String identificacao = request.getParameter("textIdentificacao");
            String telefone = request.getParameter("textTelefone");
            String celular = request.getParameter("textCelular");
            String email = request.getParameter("textEmail");
            try{
                Cliente cliente = new Cliente(idade, nome, identificacao, telefone, celular, email);
                try{
                    ClienteDao.getInstance().save(cliente);
                    request.setAttribute("clientes", Cliente.obterClientes());
                    RequestDispatcher view = 
                            request.getRequestDispatcher("/Cliente.jsp");
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
