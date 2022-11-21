package com.libreria.libreria.controller;

import com.libreria.libreria.libreria.Articulo;
import com.libreria.libreria.libreria.data.DBGenerator;
import com.libreria.libreria.libreria.data.dao.ArticuloDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "listaArticulosServlet", value = "/mostrarArticulos")
public class ListaArticulosServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("ClientesBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("articulos",agregarArticulos());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher respuesta = req.getRequestDispatcher("/mostrarUsuarios.jsp");
        respuesta.forward(req,resp);
    }

    private List agregarArticulos() throws ClassNotFoundException {
        List<Articulo> articulos = new ArrayList<>();
        articulos = ArticuloDAO.agregarArticulo(DBGenerator.conectarBD("ArticulosBD"));
        return articulos;
    }
}