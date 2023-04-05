package com.wms.web.impl;

import database.mysql.*;
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
        System.out.println(usr+" "+pwd);
        if(usr==null||pwd==null){
            response.sendRedirect("http://localhost:63342/webTest/src/main/staticSources/load.html");
            return;
        }
//        ApplicationContext context = new ClassPathXmlApplicationContext("beam1.xml");
//        Account account = context.getBean("account",Account.class);
        Account account = new Account(usr,pwd);
        if(account.verify()){
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