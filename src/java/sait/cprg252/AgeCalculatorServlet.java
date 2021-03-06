/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sait.cprg252;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 752039
 */
public class AgeCalculatorServlet extends HttpServlet {

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
        getServletContext().getRequestDispatcher("/WEB-INF/age-Calculator.jsp").forward(request, response);
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
        String ageText = request.getParameter("age");
        
        if (ageText == null || ageText.isEmpty()) {
            request.setAttribute("errorMessage", "You must give your current age.");
            
            //Keep the same value in the text field
            request.setAttribute("age", ageText);
            
            getServletContext().getRequestDispatcher("/WEB-INF/age-Calculator.jsp").forward(request, response);
            return;
        }
        
        int newAge;
        
        try {
            newAge = Integer.parseInt(ageText);
            request.setAttribute("newAge", "Your age next birthday will be " + (newAge+1));
            getServletContext().getRequestDispatcher("/WEB-INF/age-Calculator.jsp").forward(request, response);
            
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "You must give your current age.");
            
            //Keep the same value in the text field
            request.setAttribute("age", ageText);
            
            getServletContext().getRequestDispatcher("/WEB-INF/age-Calculator.jsp").forward(request, response);
            return;
        }
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
