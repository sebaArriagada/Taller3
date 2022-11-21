package com.libreria.libreria.libreria.data.dao;
import com.libreria.libreria.libreria.Articulo;
import jdk.javadoc.internal.doclets.formats.html.markup.Table;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.VARCHAR;

public class ArticuloDAO {
    public static List<Articulo> agregarArticulo(DSLContext query){
        Table tablaArticulo = table(name("Articulo"));
        Field[] columnas = tablaArticulo.fields("nombreArticulo","tipoArticulo","pesoArticulo","precioArticulo");
        query.insertIntro(tablaArticulo, columnas[0],columnas[1],columnas[2],columnas[3])
                .values(Articulo.getNombreArticulo(), Articulo.getTipoArticulo(), Articulo.getPesoArticulo(), Articulo.getPrecioArticulo())
                .execute();

    }
    public static Articulo buscarArticulo(DSLContext query, Object dato){
        Result resultados = (Result) buscarArticulo(query, "nombreArticulo");
        String nombreArticulo = (String) resultados.getValue(0,"nombreArticulo");
        return new Articulo(nombreArticulo, tipoArticulo, pesoArticulo, precioArticulo);
    }

}
