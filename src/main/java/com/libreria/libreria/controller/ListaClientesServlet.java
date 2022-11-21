package com.libreria.libreria.controller;

import com.libreria.libreria.libreria.Cliente;
import com.libreria.libreria.libreria.data.DBGenerator;
import com.libreria.libreria.libreria.data.dao.ClienteDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "agregarClienteServlet", value = "/agregarCliente")
public class AgregarClienteServlet extends HttpServlet {
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
        RequestDispatcher respuesta = req.getRequestDispatcher("/agregarClientes.jsp");
        respuesta.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
        if(req.getParameter("nombreCliente").length()!=0 && req.getParameter("rutCliente").length()!=0  &&
                req.getParameter("correoCliente").length()!=0){
            String nombreCliente = req.getParameter("nombreCliente");
            String rutCliente = req.getParameter("rut");
            String correoCliente = req.getParameter("correoCliente");
            Cliente cliente = new Cliente(nombreCliente, rutCliente, correoCliente);
            try {
                if(agregarCliente(cliente)){
                    req.setAttribute("cliente",cliente);
                    respuesta = req.getRequestDispatcher("/registroExitoso.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private boolean agregarCliente(Cliente cliente) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("ClienteBD");
        List<Cliente> clientes = ClienteDAO.agregarCliente(query,"Cliente";
        if(clientes.size()!=0){
            return false;
        }
        else{
            ClienteDAO.agregarCliente(query,cliente);
            return true;
        }
    }
}