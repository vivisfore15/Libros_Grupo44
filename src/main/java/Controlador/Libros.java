package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

import Modelo.LibroDAO;
import Modelo.LibroDTO;

/**
 * Servlet implementation class Libros
 */
@WebServlet("/Libros")
public class Libros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Libros() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LibroDAO libDao= new LibroDAO();
		
		if(request.getParameter("insertar")!=null) {
			String isbn,titulo,editorial,autor;
			int paginas;
			isbn =request.getParameter("isbn");
			titulo = request.getParameter("titulo");
			editorial = request.getParameter("editorial");
			autor = request.getParameter("autor");
			paginas = Integer.parseInt(request.getParameter("paginas"));
			LibroDTO lib= new LibroDTO(isbn,titulo,editorial,autor,paginas);
			if(libDao.Inserta_Libro(lib)) {
				//JOptionPane.showMessageDialog(null, "Se Registro el Libro exitosamente!!");
				response.sendRedirect("Libros.jsp?men=Se Registro el Libro exitosamente!!");
			}else {
				//JOptionPane.showMessageDialog(null, "No se Registro el Libro.....");
				response.sendRedirect("Libros.jsp?men=No se Registro el Libro.....");
			}
			
		}
		
		if(request.getParameter("consultar")!=null) {
			
			String codigo=request.getParameter("codigo");
			LibroDTO lib=libDao.Buscar_Libro(codigo);
			if(lib!=null) {
			String titulo,editorial,autor;
			int paginas;
			codigo=lib.getIsbn();
			titulo=lib.getTitulo();
			editorial=lib.getEditorial();
			autor=lib.getAutor();
			paginas=lib.getNo_paginas();
			response.sendRedirect("Libros.jsp?codigo="+codigo+"&&titulo="+titulo+"&&editorial="
					+editorial+"&&autor="+autor+"&&paginas="+paginas);
			}else
			{
				JOptionPane.showMessageDialog(null, "El Libro no Existe");
				response.sendRedirect("Libros.jsp");
			}
		}
		
		if(request.getParameter("actualizar")!=null) {
			String isbn,titulo,editorial,autor;
			int paginas;
			isbn =request.getParameter("cod");
			titulo = request.getParameter("titulo");
			editorial = request.getParameter("editorial");
			autor = request.getParameter("autor");
			paginas = Integer.parseInt(request.getParameter("paginas"));
			LibroDTO lib= new LibroDTO(isbn,titulo,editorial,autor,paginas);
			if(libDao.Actualiza_Libro(lib)) {
				//JOptionPane.showMessageDialog(null, "Se Registro el Libro exitosamente!!");
				response.sendRedirect("Libros.jsp?men=Se Actualizo el Libro exitosamente!!");
			}else {
				//JOptionPane.showMessageDialog(null, "No se Registro el Libro.....");
				response.sendRedirect("Libros.jsp?men=No se Actualizo el Libro.....");
			}
			
		}
		
		if(request.getParameter("eliminar")!=null) {
			
			String isbn;
			isbn=request.getParameter("cod");
			int op=JOptionPane.showConfirmDialog(null, "Desea Eliminar el Libro Cod: "+isbn);
			if(op==0){
			if(libDao.Eliminar_Libro(isbn)) {
				response.sendRedirect("Libros.jsp?men=Libro Eliminado");
			}else {
				response.sendRedirect("Libros.jsp?men=El Libro no se elimino");
			}
			}else
			{
				response.sendRedirect("Libros.jsp");
			}
		}
	}

}
