/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.HistoryProduct;
import entity.Product;
import entity.Users;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.HistoryProductFacade;
import session.ProductFacade;
import session.UsersFacade;

/**
 *
 * @author ban31
 */
@WebServlet(name = "ProductController", urlPatterns = {
    "/showFormAddProduct",
    "/createProduct",
    "/listProduct",
    "/delete",
    "/editProduct",
    "/buy",
})
public class ProductController extends HttpServlet {
    @EJB
    private ProductFacade productFacade;
    @EJB
    private UsersFacade usersFacade;
    @EJB
    private HistoryProductFacade historyProductFacade;
    
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
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        HttpSession session = request.getSession(false);
        
        
        Users users = null;
        users = (Users) session.getAttribute("users");
        
       
        if(users == null){ 
                request.setAttribute("info", "Войдите в систему");
                request.getRequestDispatcher("/showFormLogin.jsp").forward(request, response);

        }
        users = (Users) session.getAttribute("users");
        request.setAttribute("showMoney","Ваш баланс: "+users.getMoney()+" евро");
        
       
        switch (path) {
            case "/showFormAddProduct":
                
            
            request.getRequestDispatcher("/showFormAddProduct.jsp").forward(request, response);
            break;
            
            case "/createProduct":
                String name = request.getParameter("name");
                String price = request.getParameter("price");
                Product product = new Product(name, Long.parseLong(price));
                productFacade.create(product);
                request.setAttribute("info", "Продукт создан : "+product.getName());
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                
                
                break;
            case "/listProduct":
            users = new Users();
            List<Product> listProduct = productFacade.findAll();
            request.setAttribute("listProduct",listProduct);
            request.getRequestDispatcher("/listProduct.jsp") .forward(request, response);
            request.setAttribute("showMoney", "Ваш Баланс: "+users.getMoney());

                break;
            case "/delete":
                String id = request.getParameter("id");
                if(id == null || "".equals(id)){
                    request.setAttribute("info","Нет такого продукта");
                    request.getRequestDispatcher("/listProduct.jsp") .forward(request, response);
                    break;
                }
                Product delete = productFacade.find(Long.parseLong(id));
                listProduct = productFacade.findByUser(users);
                historyProductFacade.removeByProduct(delete);
                productFacade.remove(delete);
                request.setAttribute("info", "Продукт удален");
                request.getRequestDispatcher("/listProduct.jsp") .forward(request, response);
                
                
                break;
            
            case "/editProduct":
               request.getRequestDispatcher("/editProduct.jsp").forward(request, response);
               id = request.getParameter("id");
               if(id == null || "".equals(id)){
                    request.setAttribute("info","Нет такого продукта");
                    request.getRequestDispatcher("/listProduct.jsp") .forward(request, response);
                
                    break;
                }
               name = request.getParameter("name");
               price = request.getParameter("price");
               product = productFacade.find(Long.parseLong(id));
               product.setName(name);
               product.setPrice(Long.parseLong(price));
               productFacade.edit(product);
               request.setAttribute("product", product);
               request.getRequestDispatcher("/listProduct.jsp").forward(request,response);
                break;
            
            case "/buy":
                id = request.getParameter("id");
                if(id == null || "".equals(id)){
                    request.setAttribute("info","Нет такого продукта");
                    request.getRequestDispatcher("/listProduct.jsp") .forward(request, response);
                
                    break;
                }
                Product buyProduct = productFacade.find(Long.parseLong(id));
                users = (Users) session.getAttribute("users");
                if(users.getMoney() > 0){
                   users.setMoney(users.getMoney()-buyProduct.getPrice());
                   usersFacade.edit(users);
                   
                }
                Calendar c = new GregorianCalendar();
                HistoryProduct historyProduct = new HistoryProduct(users, buyProduct, c.getTime());
                historyProductFacade.create(historyProduct);
                
                request.setAttribute("info","Вы купили продукт");
                request.setAttribute("info2", "Вернуться обратно");
                request.getRequestDispatcher("/listProduct.jsp") .forward(request, response);
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