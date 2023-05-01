package sv.edu.udb.www.Models;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.edu.udb.www.Beans.CasosBeans;

public class jefeDesarrolloModel extends Conexion{
    //Estos métodos solo serviran para la jefeDesarrollo.jsp
    public int totalCasos() throws SQLException{
        try{
            int totCasos = 0;
            String sql = "select count(id_caso) as total from casos where id_estado = 3";
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                totCasos = rs.getInt("total");
            }
            this.desconectar();
            return totCasos;
        }catch (SQLException ex) {
            this.desconectar();
            return 0;
        }
    }
    public int totalCasosProgra() throws SQLException{
        try {
            int totalProga = 0;
            String sql = "select count(id_caso) as total from casos where id_estado = 5";
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                totalProga = rs.getInt("total");
            }
            return totalProga;
        }catch (SQLException ex) {
            this.desconectar();
            return 0;
        }
    }

    public int totalAvance() throws SQLException{
        try {
            int totalAvance = 0;
            String sql = "select count(id_bitacora) as total from bitacora";
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                totalAvance = rs.getInt("total");
            }
            return totalAvance;
        }catch (SQLException ex) {
            this.desconectar();
            return 0;
        }
    }
}
