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
import model.Sala;
import model.SalaAuditorio;
import model.SalaBanquete;
import model.SalaEscolar;
import model.SalaEspinhaDePeixe;
import model.SalaFormatoU;
import model.SalaReuniao;

/**
 *
 * @author matheus
 */
public class SalaDao {
    private static SalaDao instance = new SalaDao();
    
    private SalaDao(){}
    
    public static SalaDao getInstance(){
        return instance;
    }
    
    public void save(Sala sala) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        Statement st = null;
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into sala (numero, preco, nome)" +
                    "values (" +
                    sala.getNumero() + "," +
                    sala.getPreco() + ",'" +
                    sala.getNome() + "')");
        
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
            st.execute("delete from sala where codigo = " + codigo);
        
        }catch(SQLException e){
            throw e;
        }finally{
            closeResources(conn, st);
        }
    }
    
    public static List<Sala> obterSalas() throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        Statement st = null;
        List<Sala> busca = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from sala");
            busca = new ArrayList<Sala>();
            while (rs.next()){
                int codigo = Integer.parseInt(rs.getString("codigo"));
                int numero = Integer.parseInt(rs.getString("numero"));
                double preco = Double.parseDouble(rs.getString("preco"));
                String nome = rs.getString("nome");
                if(nome.equals("auditorio")){
                    SalaAuditorio sala =  new SalaAuditorio(codigo, numero, preco);
                    busca.add(sala);
                }else if(nome.equals("banquete")){
                    busca.add(new SalaBanquete(codigo, numero, preco));
                }else if(nome.equals("escolar")){
                    busca.add(new SalaEscolar(codigo, numero, preco));
                }else if(nome.equals("espinhadepeixe")){
                    busca.add(new SalaEspinhaDePeixe(codigo, numero, preco));
                }else if(nome.equals("formatoU")){
                    busca.add(new SalaFormatoU(codigo, numero, preco));
                }else if(nome.equals("reuniao")){
                    busca.add(new SalaReuniao(codigo, numero, preco));
                }else{
                    busca.add(new SalaAuditorio(codigo, numero, preco));
                }

            }
            return busca;
        }catch(SQLException e){
            throw e;
        }finally{
            closeResources(conn, st);
        }
    }
    
    public static Sala obterSala(int cod) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        Statement st = null;
        Sala sala = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from sala where codigo = " + cod);
            while (rs.next()){
                int codigo = Integer.parseInt(rs.getString("codigo"));
                int numero = Integer.parseInt(rs.getString("numero"));
                double preco = Double.parseDouble(rs.getString("preco"));
                String nome = rs.getString("nome");
                if(nome.equals("auditorio")){
                    sala = new SalaAuditorio(codigo, numero, preco);
                }else if(nome.equals("banquete")){
                    sala = new SalaBanquete(codigo, numero, preco);
                }else if(nome.equals("escolar")){
                    sala = new SalaEscolar(codigo, numero, preco);
                }else if(nome.equals("espinhadepeixe")){
                    sala = new SalaEspinhaDePeixe(codigo, numero, preco);
                }else if(nome.equals("formatoU")){
                    sala = new SalaFormatoU(codigo, numero, preco);
                }else if(nome.equals("reuniao")){
                    sala = new SalaReuniao(codigo, numero, preco);
                }else{
                    sala = new SalaAuditorio(codigo, numero, preco);
                }
            }
            return sala;
        }catch(SQLException e){
            throw e;
        }finally{
            closeResources(conn, st);
        }
    }
    
    public void update(Sala sala) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        Statement st = null;
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE sala SET numero = " + sala.getNumero() + 
                    ", preco = " + sala.getPreco() +
                    ", nome = '" + sala.getNome() +"' where codigo = " + sala.getCodigo());
                    
        
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
