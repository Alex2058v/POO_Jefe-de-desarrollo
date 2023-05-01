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

@WebServlet(name = "CasosController", urlPatterns = {"/CasosController.do"})
public class CasosController extends HttpServlet{
    CasosModel casos = new CasosModel();

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
            }
        }
    }
    private void mostarCasos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("mostrarCasos", casos.mostrarPendientes());
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
            CasosBeans casosBean = casos.obtenerCaso(codigo);
            if(casosBean != null){
                request.setAttribute("casos", casosBean);
                request.getRequestDispatcher("/jefeDesarrollo/aprobarCaso.jsp").forward(request, response);
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
