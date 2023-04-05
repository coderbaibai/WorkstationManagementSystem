package com.wms.web.impl;

import com.wms.service.LoginVerify;
import com.wms.service.impl.LoginVerifyNormal;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    private String welcome;
    private String failure;

    public void init() {
        welcome = "Hello World!";
        failure = "failure";
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();

        String usr = request.getParameter("username");
        String pwd = request.getParameter("password");
        if(usr==null||pwd==null){
            response.sendRedirect("http://localhost:63342/WorkstationManagementSystem/src/main/resources/load.html");
            return;
        }
        LoginVerify verification = new LoginVerifyNormal();
        if(verification.verify(usr,pwd)){
            out.println("<html><body>");
            out.println("<h1>" + welcome + "</h1>");
            out.println("</body></html>");
        }
        else{
            out.println("<html><body>");
            out.println("<h1>" + failure + "</h1>");
            out.println("</body></html>");
        }
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        doGet(request,response);
    }
    public void destroy() {
    }
}