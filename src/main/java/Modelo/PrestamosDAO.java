package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class PrestamosDAO {

	Conexion cnn= new Conexion();
	Connection conec=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	
	public boolean Inserta_Prestamo(PrestamosDTO p) 
	{
	boolean resul=false;	
	try {
	String sql="INSERT INTO prestamos(Estudiante,Libro,Fecha_Prestamo) VALUES (?,?,?);";
	ps=conec.prepareStatement(sql);
	ps.setString(1, p.getEstudiante());
	ps.setString(2, p.getLibro());
	ps.setString(3, p.getFecha_p());
	resul=ps.executeUpdate()>0;
	if(resul) {
	 sql="select Id_prestamos from prestamos order by Id_prestamos desc limit 1;";	
	 ps=conec.prepareStatement(sql);
	 res=ps.executeQuery();
	 int codigo=0;
	 while(res.next()) {
	  codigo=res.getInt(1); 
	 }
	 sql="update prestamos set fecha_devolucion=fecha_prestamo+7 where Id_prestamos=?;";
	 ps=conec.prepareStatement(sql);
	 ps.setInt(1, codigo);
	 resul=ps.executeUpdate()>0;
	}
	}catch(SQLException ex){
		JOptionPane.showMessageDialog(null,"Error al registra prestamo" +ex);
	}
	return resul;
	}
	
}
