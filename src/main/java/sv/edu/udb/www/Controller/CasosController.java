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
