package com.libreria.libreria.libreria.data.dao;

import com.libreria.libreria.libreria.Cliente;
import jdk.javadoc.internal.doclets.formats.html.markup.Table;

public class ClienteDAO {
    public static void agregarCliente(DSLContext query, Cliente cliente){
        Table tablaCliente= table(name("Cliente"));
        Field[] columnas = tablaCliente.fields("nombreCliete","rutCliente","correoCliente");
        query.insertInto(tablaCliente, columnas[0], columnas[1],columnas[2])
                .values(cliente.getNombreCliente(),cliente.getRutCliente(),cliente.getCorreoCliente())
                .execute();

    }
