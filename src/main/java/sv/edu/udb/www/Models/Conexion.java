package sv.edu.udb.www.Models;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    protected static Connection conexion = null;

    protected PreparedStatement st;
    protected PreparedStatement st2;
    //protected CallableStatement cs;
    protected ResultSet rs;

    public Conexion(){
        this.st2 = null;
        this.st = null;
        this.rs = null;
    }

    protected void conectar(){
        try {
            if(conexion==null || conexion.isClosed()){
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/poo2023ofp", "root", "");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void desconectar() throws SQLException{
        //Cierro los objetos en el orden inverso del que se crean
        // es decir: primero el resulset, luego el statement
        if (rs != null) {
            rs.close();
        }
        if (st != null) {
            st.close();
        }
    }
}
