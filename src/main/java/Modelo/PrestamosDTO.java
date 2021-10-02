package Modelo;

public class PrestamosDTO {
	
	private int Id_Prestamo;
	private String Estudiante;
	private String Libro;
	private String Fecha_p;
	private String Fecha_d;
	
	
	public PrestamosDTO(String estudiante, String libro, String fecha_p) {
		Estudiante = estudiante;
		Libro = libro;
		Fecha_p = fecha_p;
	}
	
	
	public PrestamosDTO(int id_Prestamo, String estudiante, String libro, String fecha_p, String fecha_d) {
		Id_Prestamo = id_Prestamo;
		Estudiante = estudiante;
		Libro = libro;
		Fecha_p = fecha_p;
		Fecha_d = fecha_d;
	}




	public int getId_Prestamo() {
		return Id_Prestamo;
	}


	public void setId_Prestamo(int id_Prestamo) {
		Id_Prestamo = id_Prestamo;
	}


	public String getEstudiante() {
		return Estudiante;
	}


	public void setEstudiante(String estudiante) {
		Estudiante = estudiante;
	}


	public String getLibro() {
		return Libro;
	}


	public void setLibro(String libro) {
		Libro = libro;
	}


	public String getFecha_p() {
		return Fecha_p;
	}


	public void setFecha_p(String fecha_p) {
		Fecha_p = fecha_p;
	}


	public String getFecha_d() {
		return Fecha_d;
	}


	public void setFecha_d(String fecha_d) {
		Fecha_d = fecha_d;
	}
	
	
	

}
