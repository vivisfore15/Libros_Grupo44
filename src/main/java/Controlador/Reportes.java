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
 * Servlet implementation class Reportes
 */
@WebServlet("/Reportes")
public class Reportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reportes() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op=request.getParameter("opcion");
		JOptionPane.showMessageDialog(null, op);
		PrintWriter salida= response.getWriter();
		Gson datos= new Gson();
		
		if(op.equals("Libros")) {
			LibroDAO libDao= new LibroDAO();
			ArrayList<LibroDTO> lista= new ArrayList<>();
			lista=libDao.cargarLibros();
			salida.println(datos.toJson(lista));
		}
		
		if(op.equals("Prestamos")) {
			PrestamosDAO pre= new PrestamosDAO();
			ArrayList<PrestamosDTO> lista= new ArrayList<>();
			lista=pre.todosPrestamos();
			salida.println(datos.toJson(lista));
		}
		
	}

}
