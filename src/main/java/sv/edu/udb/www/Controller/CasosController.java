package sv.edu.udb.www.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sv.edu.udb.www.Beans.CasosBeans;
import sv.edu.udb.www.Models.CasosModel;
import sv.edu.udb.www.Models.UsuariosModel;

@WebServlet(name = "CasosController", urlPatterns = {"/CasosController.do"})
public class CasosController extends HttpServlet{
    CasosModel casos = new CasosModel();
    UsuariosModel usuarios = new UsuariosModel();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            if(request.getParameter("op")==null){
                mostarCasos(request, response);
                return;
            }

            String operacion = request.getParameter("op");
            switch (operacion){
                case "mostarCasos":
                    mostarCasos(request, response);
                    break;
                case "obtenerCaso":
                    obtenerCaso(request, response);
                    break;
                case "aprobarCaso":
                    aprobarCaso(request, response);
                    break;
                case "rechazarCaso":
                    rechazarCaso(request, response);
                    break;


                case "gestionProgramadores":
                    gestionProgramadores(request, response);
                    break;
                case "casoObtener":
                    casoObtener(request, response);
                    break;
                case "asignarCaso":
                    asignarCaso(request, response);
                    break;
                    //casoObtener
            }
        }
    }
    private void mostarCasos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("mostrarCasos", casos.mostrarCasos());
            request.getRequestDispatcher("/jefeDesarrollo/gestionCasos.jsp").forward(request,response);
        } catch (SQLException ex) {
            response.sendRedirect("error404.jsp");
            ex.printStackTrace();
        } catch (ServletException ex) {
            response.sendRedirect("error404.jsp");
            ex.printStackTrace();
        } catch (IOException ex) {
            response.sendRedirect("error404.jsp");
            ex.printStackTrace();
        }
    }

    private void obtenerCaso(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            int codigo = Integer.parseInt(request.getParameter("id"));
            int cod = Integer.parseInt(request.getParameter("c"));
            CasosBeans casosBean = casos.obtenerCaso(codigo);
            if(cod == 1){
                if(casosBean != null){
                    request.setAttribute("casos", casosBean);
                    request.getRequestDispatcher("/jefeDesarrollo/aprobarCaso.jsp").forward(request, response);
                }else{
                    response.sendRedirect(request.getContextPath() + "/error404.jsp");
                }
            }
            else if(cod == 2){
                if(casosBean != null){
                    request.setAttribute("casos", casosBean);
                    request.getRequestDispatcher("/jefeDesarrollo/rechazarCaso.jsp").forward(request, response);
                }else{
                    response.sendRedirect(request.getContextPath() + "/error404.jsp");
                }
            }else{
                response.sendRedirect(request.getContextPath() + "/error404.jsp");
            }
        }catch (SQLException | ServletException | IOException ex) {
            //
            response.sendRedirect(request.getContextPath() + "/error404.jsp");
        }
    }
    private void aprobarCaso(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            CasosBeans caso = new CasosBeans();
            caso.setId_caso(Integer.parseInt(request.getParameter("idCaso")));
            caso.setTitulo_caso(request.getParameter("idTitulo"));
            caso.setDescripcion_caso(request.getParameter("idDescipcion"));
            caso.setArchivo_pdf(request.getParameter("archivoPDF"));

            if (casos.aprobarCaso(caso) > 0){
                request.getSession().setAttribute("éxito", "El caso se ha aprobado con éxito.");
                response.sendRedirect(request.getContextPath() +"/CasosController.do?op=mostarCasos");
            }else {
                request.getSession().setAttribute("fracaso", "El caso no se pudo aprobar");
                response.sendRedirect(request.getContextPath() + "/CasosController.do?op=mostarCasos");
            }
        }catch (IOException ex) {
            //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void rechazarCaso(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            CasosBeans caso = new CasosBeans();
            caso.setId_caso(Integer.parseInt(request.getParameter("idCaso")));
            caso.setDescripcion_caso(request.getParameter("idDescipcion"));
            caso.setArchivo_pdf(request.getParameter("archivoPDF"));
            caso.setArgumento(request.getParameter("argumento"));
            if (casos.rechazarCaso(caso) > 0){
                request.getSession().setAttribute("éxito", "El caso se ha rechazado con éxito.");
                response.sendRedirect(request.getContextPath() +"/CasosController.do?op=mostarCasos");
            }else {
                request.getSession().setAttribute("fracaso", "El caso no se pudo rechazar");
                response.sendRedirect(request.getContextPath() + "/CasosController.do?op=mostarCasos");
            }
        }catch (IOException ex) {
            //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    //A partir de aquí será para el punto 3, osea el de darle los casos a los programadores
    private void gestionProgramadores(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            request.setAttribute("casosProgramadores", casos.casosProgramadores());
            request.getRequestDispatcher("/jefeDesarrollo/gestionProgramadores.jsp").forward(request,response);
        } catch (SQLException ex) {
            response.sendRedirect("error404.jsp");
            ex.printStackTrace();
        } catch (ServletException ex) {
            response.sendRedirect("error404.jsp");
            ex.printStackTrace();
        } catch (IOException ex) {
            response.sendRedirect("error404.jsp");
            ex.printStackTrace();
        }
    }
    private void casoObtener(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            int codigo = Integer.parseInt(request.getParameter("id"));
            CasosBeans casosBean = casos.casoObtener(codigo);
            if(casosBean != null){
                request.setAttribute("casoObtener", casosBean);
                request.setAttribute("listaProgramadores", usuarios.mostrarUsuarios());
                request.getRequestDispatcher("/jefeDesarrollo/asignarProgramador.jsp").forward(request, response);
            }else{
                response.sendRedirect(request.getContextPath() + "/error404.jsp");
            }
        }catch (SQLException | ServletException | IOException ex) {
            response.sendRedirect(request.getContextPath() + "/error404.jsp");
        }
    }

    private void asignarCaso(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            CasosBeans caso = new CasosBeans();
            caso.setId_caso(Integer.parseInt(request.getParameter("idCaso")));
            caso.setIdProgramador(Integer.parseInt(request.getParameter("programador")));
            caso.setFecha_solicitud(request.getParameter("fechaSolicitud"));
            caso.setFecha_limite(request.getParameter("fechaLimite"));
            if (casos.casoAsignado(caso) > 0){
                request.getSession().setAttribute("éxito", "El caso se ha aprobado con éxito.");
                response.sendRedirect(request.getContextPath() +"/CasosController.do?op=gestionProgramadores");
            }else {
                request.getSession().setAttribute("fracaso", "El caso no se pudo aprobar");
                response.sendRedirect(request.getContextPath() + "/CasosController.do?op=gestionProgramadores");
            }
        }catch (IOException ex) {
            //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
