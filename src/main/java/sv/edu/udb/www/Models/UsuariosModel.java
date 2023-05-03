package sv.edu.udb.www.Models;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.edu.udb.www.Beans.UsuariosBeans;

public class UsuariosModel extends Conexion{
    public List<UsuariosBeans> mostrarUsuarios() throws SQLException{
        try {
            List<UsuariosBeans> lista = new ArrayList<>();
            String sql = "SELECT id_usuario, CONCAT(nombres, ' ', apellidos) as nombre_completo FROM usuarios WHERE id_tipousuario = 4";
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()){
                UsuariosBeans linea = new UsuariosBeans();
                linea.setId_usuario(rs.getInt("id_usuario"));
                linea.setNombres(rs.getString("nombre_completo"));
                lista.add(linea);
            }
            this.desconectar();
            return lista;
        }catch (SQLException ex) {
            this.desconectar();
            return null;
        }
    }
}
