package com.uniovi.sdi;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletProductos
 */
@WebServlet("/productos")
public class ServletProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletProductos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Producto> productosTienda = new ProductosService().getProductos();
		
		// Retornarla vista con parámetro "productosTienda"
		request.setAttribute("productosTienda", productosTienda);
		getServletContext().getRequestDispatcher("/vista-productos.jsp").forward(request, response);
	}

	private void insertarProductos(HashMap<String, Integer> productosTienda, String producto) {
		if (productosTienda.get(producto) == null) {
			productosTienda.put(producto, new Integer(1));
		} else {
			int numeroArticulos = (Integer) productosTienda.get(producto).intValue();
			productosTienda.put(producto, new Integer(numeroArticulos + 1));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
