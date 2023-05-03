package sv.edu.udb.www.Beans;

public class UsuariosBeans {
    private int id_usuario;
    private String nombres;
    private String apellidos;
    private String id_departamento;
    private int idDepartamento;
    private String id_tipousuario;
    private int idTipousuario;
    private String usuario;
    private String contrasenia;

    public UsuariosBeans(){
        int id_usuario = 0;
        this.nombres = "";
        this.apellidos = "";
        this.id_departamento = "";
        this.idDepartamento = 0;
        this.id_tipousuario = "";
        this.idTipousuario = 0;
        this.usuario = "";
        this.contrasenia = "";
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        apellidos = apellidos;
    }

    public String getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(String id_departamento) {
        this.id_departamento = id_departamento;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getId_tipousuario() {
        return id_tipousuario;
    }

    public void setId_tipousuario(String id_tipousuario) {
        this.id_tipousuario = id_tipousuario;
    }

    public int getIdTipousuario() {
        return idTipousuario;
    }

    public void setIdTipousuario(int idTipousuario) {
        this.idTipousuario = idTipousuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
