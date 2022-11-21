package com.libreria.libreria.principal;

import com.libreria.libreria.gui.VentanaPrincipal;
import com.libreria.libreria.libreria.data.DBGenerator;
import com.libreria.libreria.gui.VentanaPrincipal;
import com.libreria.libreria.libreria.data.DBGenerator;

public class Principal {
    public static void main(String[] args) throws ClassNotFoundException{
        DBGenerator.iniciarBD("Libreria");
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
    }
}
