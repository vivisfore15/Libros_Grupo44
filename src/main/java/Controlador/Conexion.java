package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion {

	private String bd="libros_grupo44";
	private String url="jdbc:mysql://localhost:3306/"+bd;
	private String user="root";
	private String pass="admi123";
	Connection conec=null;
	
	public Connection Conecta() {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");	
		conec = DriverManager.getConnection(url,user,pass);
		//JOptionPane.showMessageDialog(null, "Conexion Ok.....");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error en Conexion....."+e);
		}
		
		return conec;
	}
	
}
