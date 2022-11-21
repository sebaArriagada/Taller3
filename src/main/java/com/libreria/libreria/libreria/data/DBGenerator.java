package com.libreria.libreria.libreria.data;

import org.jooq.DSLContext;
import org.jooq.DataType;
import org.jooq.impl.DSL;

import java.sql.Connection;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class DBGenerator {

    public static void iniciarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root","");
        DSLContext create = DSL.using(connection);
        crearBaseDato(create,nombreBD);
        create = actualizarConexion(connection,nombreBD);
        crearTablaCliente(create);
        crearTablaArticulo(create);
        relacionarTabla(create,"Cliente","Rut_Cliente","Correo_Cliente");
        DBConnector.closeConnection();

    }
    public static DSLContext conectarBD(String nombre) throws ClassNotFoundException {
        Connection connection = DBConnector.connection(nombre,"root","");
        DSLContext create = DSL.using(connection);
        return create;
    }
    private static void crearBaseDato(DSLContext create, String nombreBD){
        create.createDatabaseIfNotExists(nombreBD).execute();
    }

    private static DSLContext actualizarConexion(Connection connection,String nombreBD){
        DBConnector.closeConnection();
        connection= DBConnector.connection(nombreBD,"root","");
        DSLContext create=DSL.using(connection);
        return create;
    }

    private static void crearTablaCliente(DSLContext create){
        create.createTableIfNotExists("Cliente").column("rut_cliente",VARCHAR(100))
                .column("rut_cliente",VARCHAR(50))
                .column("nombreCliente",INTEGER)
                .constraint(primaryKey("rut_cliente")).execute();
    }

    private static void crearTablaArticulo(DSLContext create){
        create.createTableIfNotExists("Articulo").column("nombre_articulo",VARCHAR(50))
                .column("nombre_articulo",VARCHAR(100))
                .column("tipo_Articulo",VARCHAR(50))
                .column("precio_Articulo",int)
                .constraint(primaryKey("nombre_articulo")).execute();

    }
    private static void relacionarTabla(DSLContext create, String nombreTabla, String claveForanea, String nombreTablaRelacion){
        //  create.alterTableIfExists(nombreTabla).add(foreignKey(claveForanea).references(nombreTablaRelacion)).execute();
        create.alterTableIfExists(nombreTabla).alterConstraint(foreignKey(claveForanea).references(nombreTablaRelacion)).enforced();
    }
    private static void agregarColumnaTabla(DSLContext create, String nombreTabla, String columna, DataType tipoColumna){
        create.alterTableIfExists(nombreTabla).addColumn(columna,tipoColumna);
    }

