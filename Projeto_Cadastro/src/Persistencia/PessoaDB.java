package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class PessoaDB {
    private PreparedStatement select;
    private PreparedStatement update;
    private ResultSet rs;

    private ConexaoMySQL con;

    public PessoaDB(){
        con = new ConexaoMySQL();
   }
    
           
    public int Incluir(String CPF, String Sexo, String Nome, String Endereço,String Telefone, String Placa, String Marca, int Ano, String Modelo, String Obs ){
            
        int res = 0 ;
        
        try{
            
            if (ConexaoMySQL.getConexaoMySQL()!= null){
    String SQL = "Insert into bancodb (CPF,Sexo,Nome,Endereço,Telefone,Placa,Marca,Ano,Modelo,Obs)";
           SQL = SQL + "Values (?,?,?,?,?,?,?,?,?,?)";
                update = ConexaoMySQL.getConexaoMySQL().prepareStatement(SQL);
                update.setString(1, CPF);
                update.setString(2, Sexo);
                update.setString(3, Nome);
                update.setString(4, Endereço);
                update.setString(5, Telefone);
                update.setString(6, Placa);
                update.setString(7, Marca);
                update.setInt(8, Ano);
                update.setString(9, Modelo);
                update.setString(10, Obs);
                
                
                update.executeUpdate();
                update.close();
                res = 1;
                
                
            }   
        } catch( SQLException cnfe ){
            System.out.println("Salvo com sucesso");
            res=2;
        
        
        }            
        
        
        return res;
    }
        
    
    
    public ResultSet Cons (int Parametro, String Valor) throws SQLException {
        ResultSet rs1;
        rs1 = null;
       if(Parametro == 1){
        String SQL="";
        SQL = "Select * from bancodb where cpf=" + "'" +  Valor + "'" ;
        update = ConexaoMySQL.getConexaoMySQL().prepareStatement(SQL);
        rs1 = update.executeQuery(SQL);
       
        
    }
    else{
        String SQL="";
        SQL = "Select * from bancodb where placa =" + "'" +  Valor + "'" ;
        update = ConexaoMySQL.getConexaoMySQL().prepareStatement(SQL);
        rs1 = update.executeQuery(SQL);
    }
     return rs1;
    }
    
    public Cliente procurarCliente(int Parametro, String Valor)  {
    ResultSet resultado;
    Cliente c = null;
    if (Parametro == 1){
      String SQL = "SELECT * FROM cliente WHERE CPF = ? ";
    
    try {
        con = new ConexaoMySQL();
        update = con.PreparedStatement();
        update.setString(1, Valor);
        resultado = update.executeQuery();
    if (resultado.next()) {
        c = new Cliente();
        c.setCPF(resultado.getString("CPF"));
        c.setSexo(resultado.getString("Sexo"));
        c.setNome(resultado.getString("Nome"));
        c.setEndereço(resultado.getString("Endereço"));
        c.setTelefone(resultado.getString("Telefone"));
        c.setPlaca(resultado.getString("Placa"));
        c.setMarca(resultado.getString("Marca"));
        c.setAno(resultado.getInt("Ano"));
        c.setModelo(resultado.getString("Modelo"));
        c.setObs(resultado.getString("Obs"));
        
    }
    update.close();
    con.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao procurar cliente" + ex.getMessage());
    }
    
    return c;
        
    }else{
    String SQL = "SELECT * FROM cliente WHERE Placa = ? ";
    // JOptionPane.showMessageDialog(null,sSelect);
    try {
        con = (ConexaoMySQL) ConexaoMySQL.getConexaoMySQL();
        update = con.PreparedStatement();
        update.setString(1, Valor);
        resultado = update.executeQuery();
    if (resultado.next()) {
        c = new Cliente();
        c.setCPF(resultado.getString("CPF"));
        c.setSexo(resultado.getString("Sexo"));
        c.setNome(resultado.getString("Nome"));
        c.setEndereço(resultado.getString("Endereço"));
        c.setTelefone(resultado.getString("Telefone"));
        c.setPlaca(resultado.getString("Placa"));
        c.setMarca(resultado.getString("Marca"));
        c.setAno(resultado.getInt("Ano"));
        c.setModelo(resultado.getString("Modelo"));
        c.setObs(resultado.getString("Obs"));
    
    }
    update.close();
    con.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao procurar cliente" + ex.getMessage());
    }
    
    }
     return c;
    }
    
    public int Alterar(String CPF, String Nome, String Endereço, String Telefone, String Obs){
        int res = 0 ;
        try{
            if (ConexaoMySQL.getConexaoMySQL()!= null){
            String sql="";
                   sql = "UPDATE bancodb SET  Nome ='" + Nome + "', Endereço = '" + Endereço + "', Telefone = '" + Telefone + "', Obs = '" + Obs + "'";
                   sql = sql + "  Where cpf ='" + CPF + "'";
                   
                  
            update = ConexaoMySQL.getConexaoMySQL().prepareStatement(sql);
        
            update.executeUpdate(sql);
            update.close();
            res = 1;    
            }   
        } catch( SQLException cnfe ){
            System.out.println("ERROR");
            
            res=2;
        }            
        return res;
   }

public int Excluir(String CPF, String Nome, String Endereço,String Telefone, String Placa, String Marca, int Ano, String Modelo, String Obs){
        int res = 0 ;
        try{
            if (ConexaoMySQL.getConexaoMySQL()!= null){
            String sql="";
                   sql = "DELETE FROM bancodb WHERE CPF ='" + CPF + "'";
                   
                   
                  
            update = ConexaoMySQL.getConexaoMySQL().prepareStatement(sql);
        
            update.executeUpdate(sql);
            update.close();
            res = 1;    
            }   
        } catch( SQLException cnfe ){
            System.out.println("ERROR");
            
            res=2;
        }            
        return res;
   }






    
}
    

    
   