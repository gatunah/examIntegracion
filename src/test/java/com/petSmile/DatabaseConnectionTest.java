package com.petSmile;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DatabaseConnectionTest {
	
	public DatabaseConnectionTest() {}
	
	@BeforeClass
	public static void setUpClass() {}
	
	@AfterClass
	public static void tearDownClass() {}
	
	@Before
	public void setUp() {}
	
	@After
	public void tearDown() {}
	
	@Test
    public void testConnection() {
        try {
            Connection connection = DatabaseConnection.getConnection();   
            if(connection!=null) {
            	System.out.println("Base de datos conectada correctamente:");
            
                // Ejecutar una consulta simple
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM usuario LIMIT 1";
                ResultSet resultSet = statement.executeQuery(query);
                
                while (resultSet.next()) {
                	String resultado = "1";
                    // Realiza algo con los datos del resultado
                    String id = resultSet.getString("id");
                    assertEquals(id, resultado);
                    System.out.println("Valor de la columna: " + id);
                }
                
                resultSet.close();
                statement.close();
                connection.close();
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}