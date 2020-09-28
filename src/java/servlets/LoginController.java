/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.UsersFacade;

/**
 *
 * @author ban31
 */
@WebServlet(name = "LoginController", urlPatterns = {
    "/showFormAddUser",
    "/createUser",
    "/showFormLogin",
    "/login",
    "/logout"

})
public class LoginController extends HttpServlet {
    @EJB
    private UsersFacade usersFacade;
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
        String path = request.getServletPath();
        switch (path) {
            case "/index":
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/showFormAddUser":
                request.getRequestDispatcher("/showAddUser.jsp").forward(request, response);
                break;
            case "/createUser":
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                String money = request.getParameter("money");
                Users users = new Users(login, password, Long.parseLong(money) ,"Defaultrole");
                usersFacade.create(users);
                request.setAttribute("info", "Пользователь создан");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/showFormLogin":
                 request.getRequestDispatcher("/showFormLogin.jsp").forward(request, response);
                break;
            case "/login":
                
                break;
            case "/logout":
                
                break;
            
        }
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
