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

import sv.edu.udb.www.Models.jefeDesarrolloModel;

@WebServlet(name = "jefeDesarrolloController", urlPatterns = {"/jefeDesarrollo.do"})
public class jefeDesarolloController extends HttpServlet{
    jefeDesarrolloModel jefeModelo = new jefeDesarrolloModel();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
            if(request.getParameter("op")==null){
                mostrar(request, response);
                return;
            }
        }
    }

    private void mostrar(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setAttribute("totalCasos", jefeModelo.totalCasos());
            request.setAttribute("totalProgra", jefeModelo.totalCasosProgra());
            request.setAttribute("totalAvance", jefeModelo.totalAvance());
            request.getRequestDispatcher("jefeDesarrollo.jsp").forward(request, response);

        }catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(jefeDesarolloController.class.getName()).log(Level.SEVERE, null, ex);
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
