/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GHELFER
 */
public class MeuServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
             
        try {
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PrimeiroServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='MeuServlet' method='post'>");
            out.println("Usuario<br>");
            out.println("<input type='text' name='usuario' /><br>");
            out.println("Senha<br>");
            out.println("<input type='password' name='senha' /><br>");
            out.println("<input type='submit' value='Validar' />");
            out.println("</form>");            
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PrimeiroServlet</title>");
            out.println("</head>");
            out.println("<body>");
            if (usuario.equals("aula") && senha.equals("poo3")) {
                out.println("Bem-vindo " + usuario + "!<br>");        
                
                
                //informações de parametros HTTP
                out.println("<h3>Parametros HTTP</h3>");
                Enumeration pr = request.getParameterNames();
                while(pr.hasMoreElements()){
                    String p = (String) pr.nextElement();
                    out.println("Name: " + p );
                    out.println(" Value:" + request.getParameter(p));
                    out.println("<br>");
                }
                
                //informações do cabeçalhho HTTP
                out.println("<h3>Cabeçalhos HTTP</h3>");
                Enumeration<String> hn =  request.getHeaderNames();
                while(hn.hasMoreElements()){                    
                    String header = hn.nextElement();
                    out.println("Name: " + header);
                    out.println("<br>");
                    
                    Enumeration<String> hv = request.getHeaders(header);
                    while (hv.hasMoreElements()){
                        String value = hv.nextElement();
                        out.println("Value: " + value);
                        out.println("<br>");
                    }                            
                }  
                
                
            } else {
               out.println("<form action='MeuServlet' method='get'>");
               out.println("<input type='submit' value='Acessar'/>");
               out.println("</form>");
            }
             out.println("</body>");
             out.println("</html>");
        }

    }


}
