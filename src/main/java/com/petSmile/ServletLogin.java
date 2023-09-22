package com.petSmile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (verificarCredenciales(username, password)) {
            //List<String> usuario = obtenerDatosDesdeLaBaseDeDatos(username);
            //request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("/formulario.jsp").forward(request, response);
        } else {
            response.sendRedirect("fallido.jsp");
        }
    }
    
    public boolean verificarCredenciales(String username, String password) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM usuario WHERE nombreUsuario = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            
            return rs.next(); // Si hay un resultado, las credenciales son válidas
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}