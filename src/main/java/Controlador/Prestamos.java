package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class Prestamos
 */
@WebServlet("/Prestamos")
public class Prestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Controlador.HttpServletRequest request;

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
		this.request = request;
		JOptionPane.showMessageDialog(null, "hola mundo");
	}

}
