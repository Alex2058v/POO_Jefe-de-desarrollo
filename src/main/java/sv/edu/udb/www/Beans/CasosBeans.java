package sv.edu.udb.www.Beans;

public class CasosBeans {
    private int id_caso;
    private String descripcion_caso;
    private int idEstado;
    private String id_estado;
    private String id_programados;
    private int idProgramador;

    private int idProbador;
    private String id_probador;

    private String archivo_pdf;
    private String titulo_caso;
    private String fecha_solicitud;
    private String fecha_limite;
    private String observaciones;
    private String argumento;
    private String id_departamento;
    private int idDepartamento;

    public CasosBeans(){
        this.id_caso = 0;
        this.descripcion_caso = "";
        //los que tiene int y string serviran para que los que son int solo guardarlos directamente en la bdd
        //string serviran para guardar las consultas para mostrar :v
        this.idEstado = 0;
        this.id_estado = "";
        this.id_programados = "";
        this.idProbador = 0;
        this.id_probador = "";
        this.archivo_pdf = "";
        this.titulo_caso = "";
        this.fecha_solicitud = "";
        this.fecha_limite = "";
        this.observaciones = "";
        this.argumento = "";
        this.id_departamento = "";
        this.idDepartamento = 0;
    }

    public int getId_caso() {
        return id_caso;
    }

    public void setId_caso(int id_caso) {
        this.id_caso = id_caso;
    }

    public String getDescripcion_caso() {
        return descripcion_caso;
    }

    public void setDescripcion_caso(String descripcion_caso) {
        this.descripcion_caso = descripcion_caso;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getId_estado() {
        return id_estado;
    }

    public void setId_estado(String id_estado) {
        this.id_estado = id_estado;
    }

    public String getId_programados() {
        return id_programados;
    }

    public void setId_programados(String id_programados) {
        this.id_programados = id_programados;
    }

    public int getIdProgramador() {
        return idProgramador;
    }

    public void setIdProgramador(int idProgramador) {
        this.idProgramador = idProgramador;
    }

    public int getIdProbador() {
        return idProbador;
    }

    public void setIdProbador(int idProbador) {
        this.idProbador = idProbador;
    }

    public String getId_probador() {
        return id_probador;
    }

    public void setId_probador(String id_probador) {
        this.id_probador = id_probador;
    }

    public String getArchivo_pdf() {
        return archivo_pdf;
    }

    public void setArchivo_pdf(String archivo_pdf) {
        this.archivo_pdf = archivo_pdf;
    }

    public String getTitulo_caso() {
        return titulo_caso;
    }

    public void setTitulo_caso(String titulo_caso) {
        this.titulo_caso = titulo_caso;
    }

    public String getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(String fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public String getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(String fecha_limite) {
        this.fecha_limite = fecha_limite;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getArgumento() {
        return argumento;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
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
}
