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
import javax.servlet.http.HttpSession;


@WebServlet("/ServletServlet")
public class ServletServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("formulario.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("accion");

		if ("agregarDueno".equals(accion)) {
			agregarDueno(request, response);
		} else if ("agregarMascota".equals(accion)) {
			agregarMascota(request, response);
		} else if ("agregarAgenda".equals(accion)) {
			agregarAgenda(request, response);
		}
	}
	private void agregarDueno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Procesamiento del formulario de agregarDueno
		String rut = request.getParameter("rut");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String correo = request.getParameter("correo");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		try {
			Connection conn = DatabaseConnection.getConnection();
			String query = "INSERT INTO dueno (rut, nombre, apellido, correo, direccion, telefono) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, rut);
			stmt.setString(2, nombre);
			stmt.setString(3, apellido);
			stmt.setString(4, correo);
			stmt.setString(5, direccion);
			stmt.setString(6, telefono);
			System.out.println(nombre + rut + apellido + correo + direccion + telefono);
			int filasInsertadas = stmt.executeUpdate();

			if (filasInsertadas > 0) {
				HttpSession session = request.getSession();
				session.setAttribute("mensaje2", "Datos guardados correctamente");
			} else {
				System.out.println("ups, hubo un error");   
			}
		} catch (Exception e) {
			System.out.println("ups, hubo un error en la conexión a la bd");   
			e.printStackTrace();
		}
		request.getRequestDispatcher("formulario.jsp").forward(request, response);

	}
	private void agregarMascota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nombre = request.getParameter("nombreM");
		int edad = Integer.parseInt(request.getParameter("edad"));
		String tipo = request.getParameter("tipo");



		try {
			Connection conn = DatabaseConnection.getConnection();
			String query = "INSERT INTO mascota (nombreMascota, edad, tipoMascota) VALUES (?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, nombre);
			stmt.setInt(2, edad);
			stmt.setString(3, tipo);

			int filasInsertadas = stmt.executeUpdate();

			if (filasInsertadas > 0) {
				HttpSession session = request.getSession();
				session.setAttribute("mensaje2", "Datos guardados correctamente");
			} else {
				System.out.println("ups, hubo un error");   
			}
		} catch (Exception e) {
			System.out.println("ups, hubo un error en la conexión a la bd");   
			e.printStackTrace();
		}
		request.getRequestDispatcher("formulario.jsp").forward(request, response);
	}
	private void agregarAgenda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String hora = request.getParameter("hora");
		String fecha= request.getParameter("fecha");
		
		try {
			Connection conn = DatabaseConnection.getConnection();
			String query = "INSERT INTO agenda (hora, fecha) VALUES (?, ?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, hora);
			stmt.setString(2, fecha);
	

			int filasInsertadas = stmt.executeUpdate();

			if (filasInsertadas > 0) {
				HttpSession session = request.getSession();
				session.setAttribute("mensaje3", "Datos guardados correctamente");
			} else {
				System.out.println("ups, hubo un error");   
			}
		} catch (Exception e) {
			System.out.println("ups, hubo un error en la conexión a la bd");   
			e.printStackTrace();
		}
		request.getRequestDispatcher("formulario.jsp").forward(request, response);
	}
	
}



