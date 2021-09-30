package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import Modelo.LibroDAO;
import Modelo.LibroDTO;
import Modelo.PrestamosDAO;
import Modelo.PrestamosDTO;

/**
 * Servlet implementation class Prestamos
 */
@WebServlet("/Prestamos")
public class Prestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
    public Prestamos() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("consultarLib")!=null) {
			
			String isbn=request.getParameter("isbn");
			LibroDAO libDao= new LibroDAO();
			LibroDTO lib= libDao.Buscar_Libro(isbn);
			if(lib!=null) {
			isbn=lib.getIsbn();
			String titulo=lib.getTitulo();
			response.sendRedirect("Prestamos.jsp?codigo="+isbn+"&&titulo="+titulo);
			}else
			{
				response.sendRedirect("Prestamos.jsp?men=El Libro no Existe");
			}
		}
		
		
		if(request.getParameter("registrar")!=null) {
			
			String isbn,estudiante,fecha;
			isbn=request.getParameter("isbn");
			estudiante=request.getParameter("est");
			fecha=request.getParameter("fecha");
			PrestamosDTO p= new PrestamosDTO(estudiante,isbn,fecha);
			PrestamosDAO pDao= new PrestamosDAO();
			if(pDao.Inserta_Prestamo(p)) {
				response.sendRedirect("Prestamos.jsp?men=Prestamo Registrado Exitosamente");
			}
			else {
				response.sendRedirect("Prestamos.jsp?men=El Prestamo no se Registro");
			}
		}
		
		//Manejo de formato Json con Gson
		ArrayList<LibroDTO> lista= new ArrayList<>();
		LibroDAO libDao= new LibroDAO();
		lista=libDao.cargarLibros();
		PrintWriter salida= response.getWriter();
		Gson datos=new Gson();
		salida.println(datos.toJson(lista));
		
	

}
}
