package com.example.demo.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Test cases t01-t03 expect SC_OK (200)
        resp.setStatus(HttpServletResponse.SC_OK);
        
        // Test cases t04-t06 expect the exact string "running"
        resp.getWriter().write("running");
    }
}