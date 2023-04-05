package com.wms.web.impl;

import com.wms.service.EnrollVerify;
import com.wms.service.impl.EnrollVerifyNormal;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EnrollServlet", value = "/EnrollServlet")
public class EnrollServlet extends HttpServlet {
    private String welcome;
    private String failure;
    public void init() {
        welcome = "Hello World!";
        failure = "failure";
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        String usr = request.getParameter("username");
        String pwd = request.getParameter("password");
        if(usr==null||pwd==null){
            response.sendRedirect("http://localhost:63342/WorkstationManagementSystem/src/main/resources/enroll.html");
            return;
        }
        EnrollVerify enrollVerification = new EnrollVerifyNormal();
        if(enrollVerification.enroll(usr,pwd)){
            out.println("<html><body>");
            out.println("<h1>" + welcome + "</h1>");
            out.println("</body></html>");
        }
        else {
            out.println("<html><body>");
            out.println("<h1>" + failure + "</h1>");
            out.println("</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
