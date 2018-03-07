/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.connection.modelo.servletEmpleado;

import com.demo.connection.conexionbd;
import com.demo.connection.modelo.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author E201
 */
@WebServlet(name = "EmpleadoServlet", urlPatterns = {"/EmpleadoServlet"})
public class EmpleadoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int id= new Integer(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            Double salario = new Double(request.getParameter("salario"));
            String fechadeIngreso = (request.getParameter("fechadeIngreso"));
            Date fechaI = new Date();
        
            SimpleDateFormat fFormato = new SimpleDateFormat("dd/MM/yyyy");
            fechaI=fFormato.parse(fechadeIngreso);
            
            int idDepto = new Integer(request.getParameter("idDepto"));
            Empleado empleado = new Empleado(id,nombre,salario,fechaI,idDepto);
            
              List <Empleado> list = conexionbd.lista();
            out.print("<html>");
            out.print("<head>");
            out.print("<title>resultado</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("<form>");
            out.print("<table>");
            out.print("<tr>");
            out.print("<td>id</td>");
            out.print("<td>nombre</td>");
            out.print("<td>salario</td>");
            out.print("<td>fechadeIngreso</td>");
            out.print("<td>idDepto</td>");
            out.print("</tr>");
            
            for(Empleado emple1:list){
                out.print("<td>"+emple1.getId()+"</td>");
                out.print("<td>"+emple1.getNombre()+"</td>");
                out.print("<td>"+emple1.getSalario()+"</td>");
                out.print("<td>"+emple1.getFechadeIngreso()+"</td>");
                out.print("<td>"+emple1.getIdDepto()+"</td>");
            }
            
            out.print("</table>");
            out.print("</body>");
            out.print("</html>");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleadoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(EmpleadoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
       
       /* try (PrintWriter out = response.getWriter()) {
            fechaI=fFormato.parse(fechadeIngreso);
            
        }*/
            
            
                    
                    
           
        
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
