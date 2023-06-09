package sv.edu.udb.www.Models;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sv.edu.udb.www.Beans.CasosBeans;

public class CasosModel extends Conexion{
    //parte donde solo se manejara el aprobar o rechazar un caso
    public List<CasosBeans> mostrarCasos() throws SQLException{
        try {
            List<CasosBeans> lista = new ArrayList<>();
            String sql = "SELECT casos.id_caso, casos.descripcion_caso, estado.estado, casos.archivo_pdf, departamento.departamento\n" +
                    "FROM casos\n" +
                    "INNER JOIN estado ON casos.id_estado = estado.id_estado\n" +
                    "INNER JOIN departamento ON casos.id_departamento = departamento.id_departamento\n" +
                    "WHERE estado.id_estado = 3\n" +
                    "ORDER BY casos.id_caso ASC;\n";

            this.conectar();
            st = conexion.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                CasosBeans casos = new CasosBeans();
                casos.setId_caso(Integer.parseInt(rs.getString("id_caso")));
                casos.setDescripcion_caso(rs.getString("descripcion_caso"));
                casos.setId_estado(rs.getString("estado"));
                casos.setArchivo_pdf(rs.getString("archivo_pdf"));
                casos.setId_departamento(rs.getString("departamento"));
                lista.add(casos);
            }
            this.desconectar();
            return lista;
        }catch (SQLException ex) {
            this.desconectar();
            return  null;
        }
    }

    public CasosBeans obtenerCaso(int id) throws SQLException{
        try {
            String sql = "SELECT id_caso, descripcion_caso, archivo_pdf FROM casos WHERE id_caso = ?";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                CasosBeans casos = new CasosBeans();
                casos.setId_caso(Integer.parseInt(rs.getString("id_caso")));
                casos.setArchivo_pdf(rs.getString("archivo_pdf"));
                casos.setDescripcion_caso(rs.getString("descripcion_caso"));
                this.desconectar();
                return casos;
            }
            this.desconectar();
            return null;
        }catch (SQLException ex) {
            this.desconectar();
            return null;
        }
    }
    public int aprobarCaso(CasosBeans casos) throws SQLException{
        try {
            int filasAfectadas = 0;
            String sql = "UPDATE casos set titulo_caso = ?, descripcion_caso = ?, archivo_pdf = ?, id_estado = 5 WHERE id_caso = ?";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setString(1, casos.getTitulo_caso());
            st.setString(2, casos.getDescripcion_caso());
            st.setString(3, casos.getArchivo_pdf());
            st.setInt(4, casos.getId_caso());

            filasAfectadas = st.executeUpdate();
            this.desconectar();
            return filasAfectadas;
        }catch (SQLException ex) {
            //Logger.getLogger(LibrosModel.class.getName()).log(Level.SEVERE, null, ex);
            this.desconectar();
            return 0;
        }
    }

    public int rechazarCaso(CasosBeans casos) throws SQLException{
        try {
            int filasAfectadas = 0;
            String sql = "UPDATE casos set argumento = ?, descripcion_caso = ?, archivo_pdf = ?, id_estado = 4 WHERE id_caso = ?";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setString(1, casos.getArgumento());
            st.setString(2, casos.getDescripcion_caso());
            st.setString(3, casos.getArchivo_pdf());
            st.setInt(4, casos.getId_caso());
            filasAfectadas = st.executeUpdate();
            this.desconectar();
            return filasAfectadas;
        }catch (SQLException ex) {
            //Logger.getLogger(LibrosModel.class.getName()).log(Level.SEVERE, null, ex);
            this.desconectar();
            return 0;
        }
    }

    //Desde aquí solo se va a manejar el darle a un programador un caso en particular.
    public List<CasosBeans> casosProgramadores() throws SQLException{
        try {
            List<CasosBeans> lista = new ArrayList<>();
            String sql = "SELECT c.id_caso, c.titulo_caso, c.descripcion_caso, c.archivo_pdf, d.departamento " +
                    "FROM casos c INNER JOIN departamento d ON c.id_departamento = d.id_departamento " +
                    "INNER JOIN estado e ON c.id_estado = e.id_estado " +
                    "WHERE c.id_estado = 5";
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                CasosBeans caso = new CasosBeans();
                caso.setId_caso(Integer.parseInt(rs.getString("id_caso")));
                caso.setTitulo_caso(rs.getString("titulo_caso"));
                caso.setDescripcion_caso(rs.getString("descripcion_caso"));
                caso.setArchivo_pdf(rs.getString("archivo_pdf"));
                caso.setId_departamento(rs.getString("departamento"));
                lista.add(caso);
            }
            this.desconectar();
            return lista;
        }catch (SQLException ex) {
            this.desconectar();
            return  null;
        }
    }

    public CasosBeans casoObtener(int id) throws SQLException{
        try {
            String sql = "SELECT id_caso, titulo_caso FROM casos WHERE id_caso = ?";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()) {
                CasosBeans casos = new CasosBeans();
                casos.setId_caso(Integer.parseInt(rs.getString("id_caso")));
                casos.setTitulo_caso(rs.getString("titulo_caso"));
                this.desconectar();
                return casos;
            }
            this.desconectar();
            return null;
        }catch (SQLException ex) {
            this.desconectar();
            return null;
        }
    }

    public int casoAsignado(CasosBeans casos) throws SQLException{
        try {
            int filasAfectadas = 0;
            String sql = "UPDATE casos SET id_programador = ?, fecha_solicitud = ?, fecha_limite = ?, id_estado = 6 WHERE id_caso = ?";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setInt(1, casos.getIdProgramador());
            st.setString(2, casos.getFecha_solicitud());
            st.setString(3, casos.getFecha_limite());
            st.setInt(4, casos.getId_caso());
            filasAfectadas = st.executeUpdate();
            this.desconectar();
            return filasAfectadas;
        }catch (SQLException ex) {
            this.desconectar();
            return 0;
        }

    }
}
