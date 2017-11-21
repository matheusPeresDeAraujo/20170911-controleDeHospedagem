/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

/**
 *
 * @author matheus
 */
public class ClienteDao {
    
    private static ClienteDao instance = new ClienteDao();
    
    private ClienteDao(){}
    
    public static ClienteDao getInstance(){
        return instance;
    }
    
    public void save(Cliente cliente) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        Statement st = null;
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into cliente (nome, idade, identificacao, telefone, celular, email)" +
                    "values ('" +
                    cliente.getNome() + "'," +
                    cliente.getIdade() + ",'" +
                    cliente.getIdentificacao() + "','" +
                    cliente.getTelefone() + "','" +
                    cliente.getCelular() + "','" +
                    cliente.getEmail() + "')");
        
        }catch(SQLException e){
            throw e;
        }finally{
            closeResources(conn, st);
        }
    }
      
    
    
    public void drop(int codigo) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        Statement st = null;
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("delete from cliente where codigo = " + codigo);
        
        }catch(SQLException e){
            throw e;
        }finally{
            closeResources(conn, st);
        }
    }
    
    public static List<Cliente> obterClientes() throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        Statement st = null;
        List<Cliente> busca = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from cliente");
            busca = new ArrayList<Cliente>();
            while (rs.next()){
                int codigo = Integer.parseInt(rs.getString("codigo"));
                String nome = rs.getString("nome");
                int idade = Integer.parseInt(rs.getString("idade"));
                String identificacao = rs.getString("identificacao");
                String telefone = rs.getString("telefone");
                String celular = rs.getString("celular");
                String email = rs.getString("email");
               
                busca.add(new Cliente(codigo, idade, nome, identificacao, telefone, celular, email));
            }
            return busca;
        }catch(SQLException e){
            throw e;
        }finally{
            closeResources(conn, st);
        }
    }
    
    public static Cliente obterCliente(int cod) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        Statement st = null;
        Cliente cliente = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from cliente where codigo = " + cod);
            while (rs.next()){
                int codigo = Integer.parseInt(rs.getString("codigo"));
                String nome = rs.getString("nome");
                int idade = Integer.parseInt(rs.getString("idade"));
                String identificacao = rs.getString("identificacao");
                String telefone = rs.getString("telefone");
                String celular = rs.getString("celular");
                String email = rs.getString("email");
               
                cliente = new Cliente(codigo, idade, nome, identificacao, telefone, celular, email);
            }
            return cliente;
        }catch(SQLException e){
            throw e;
        }finally{
            closeResources(conn, st);
        }
    }
    
    public void update(Cliente cliente) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        Statement st = null;
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE cliente SET nome = '" + cliente.getNome() + 
                    "', idade = " + cliente.getIdade() +
                    ", identificacao = '" + cliente.getIdentificacao() +
                    "', telefone = '" + cliente.getTelefone() +
                    "', celular = '" + cliente.getCelular() +
                    "', email = '" + cliente.getEmail() +"' where codigo = " + cliente.getCodigo());
                    
        
        }catch(SQLException e){
            throw e;
        }finally{
            closeResources(conn, st);
        }
    }
    
    public static void closeResources (Connection conn, Statement st) throws SQLException{
        try{
            if(st!=null) st.close();
            if(conn!=null) st.close();
        }catch(SQLException e){
            throw e;
        }
    }
}
