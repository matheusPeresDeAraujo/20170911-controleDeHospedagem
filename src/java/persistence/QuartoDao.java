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
import model.Quarto;
import model.QuartoCasal;
import model.QuartoDuploSolteiro;
import model.QuartoSolteiro;

/**
 *
 * @author matheus
 */
public class QuartoDao {
    private static QuartoDao instance = new QuartoDao();
    
    private QuartoDao(){}
    
    public static QuartoDao getInstance(){
        return instance;
    }
    
    public void save(Quarto quarto) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        Statement st = null;
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into quarto (numero, tipo, preco, tamanho, vista, cama, banheiro, frigobar, tv, computador, estado)" +
                    "values (" +
                    quarto.getNumero() + ",'" +
                    quarto.getTipo() + "'," +
                    quarto.getPreco() + "," +
                    quarto.getTamanho() + ",'" +
                    quarto.getVista() + "'," +
                    quarto.getCama() + "," +
                    quarto.getBanheiro() + "," +
                    quarto.getFrigobar() + "," +
                    quarto.getTv() + "," +
                    quarto.getComputador() + ",'" +
                    quarto.getQuartoEstado() + "')");
        
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
            st.execute("delete from quarto where codigo = " + codigo);
        
        }catch(SQLException e){
            throw e;
        }finally{
            closeResources(conn, st);
        }
    }
    
    public static List<Quarto> obterQuartos() throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        Statement st = null;
        List<Quarto> busca = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from quarto");
            busca = new ArrayList<Quarto>();
            while (rs.next()){
                int codigo = Integer.parseInt(rs.getString("codigo"));
                int numero = Integer.parseInt(rs.getString("numero"));
                String tipo = rs.getString("tipo");
                String vista = rs.getString("vista");
                String estado = rs.getString("estado");
                if(tipo.equals("single room")){
                    busca.add(new QuartoSolteiro(codigo, numero, vista, estado, estado));
                }else if(tipo.equals("twin room")){
                    busca.add(new QuartoDuploSolteiro(codigo, numero, vista, estado, estado));
                }else if(tipo.equals("double room")){
                    busca.add(new QuartoCasal(codigo, numero, vista, estado, estado));
                }
            }
            return busca;
        }catch(SQLException e){
            throw e;
        }finally{
            closeResources(conn, st);
        }
    }
    
    public static Quarto obterQuarto(int cod) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        Statement st = null;
        Quarto quarto = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from quarto where codigo = " + cod);
            while (rs.next()){
                int codigo = Integer.parseInt(rs.getString("codigo"));
                int numero = Integer.parseInt(rs.getString("numero"));
                String tipo = rs.getString("tipo");
                String vista = rs.getString("vista");
                String estado = rs.getString("estado");
                if(tipo.equals("single room")){
                    quarto = new QuartoSolteiro(codigo, numero, vista, estado, estado);
                }else if(tipo.equals("twin room")){
                    quarto = new QuartoDuploSolteiro(codigo, numero, vista, estado, estado);
                }else if(tipo.equals("double room")){
                    quarto = new QuartoCasal(codigo, numero, vista, estado, estado);
                }
            }
            return quarto;
        }catch(SQLException e){
            throw e;
        }finally{
            closeResources(conn, st);
        }
    }
    
    public void update(Quarto quarto) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        Statement st = null;
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE quarto SET numero = " + quarto.getNumero() + 
                    ", tipo = '" + quarto.getTipo() +
                    "', preco = " + quarto.getPreco() +
                    ", tamanho = " + quarto.getTamanho() +
                    ", vista = '" + quarto.getVista() +
                    "', cama = " + quarto.getCama() +
                    ", banheiro = " + quarto.getBanheiro() +
                    ", frigobar = " + quarto.getFrigobar() +
                    ", tv = " + quarto.getTv() +
                    ", computador = " + quarto.getComputador()+
                    ", estado = '" + quarto.getEstado()
                            +"' where codigo = " + quarto.getCodigo());
                    
        
        }catch(SQLException e){
            throw e;
        }finally{
            closeResources(conn, st);
        }
    }
    
    public void interesse(Cliente cliente, Quarto quarto) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        Statement st = null;
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into interesse (cod_cliente, cod_quarto)" +
                    "values (" +
                    cliente.getCodigo() + "," +
                    quarto.getCodigo() + ")");
        
        }catch(SQLException e){
            throw e;
        }finally{
            closeResources(conn, st);
        }
    }
    
    public List interessados(Quarto quarto) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        List busca = new ArrayList<>();
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select cod_cliente from interesse where cod_quarto = " + quarto.getCodigo());
            
            while (rs.next()){
                int codigo = Integer.parseInt(rs.getString("cod_cliente"));
                busca.add(codigo);
            }
            return busca;
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
