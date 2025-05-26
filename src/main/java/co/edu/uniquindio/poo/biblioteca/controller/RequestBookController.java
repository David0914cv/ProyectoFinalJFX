package co.edu.uniquindio.poo.biblioteca.controller;

import co.edu.uniquindio.poo.biblioteca.model.*;

import java.util.UUID;

public class RequestBookController {
    Biblioteca biblioteca;
    public RequestBookController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void solicitarPrestamo(String idUser, LibroFisico libro,String tiempo) {
        String id = UUID.randomUUID().toString();
        Usuario user = null;
        TiempoPrestamo tiempoPrestamo =null;
        for (Usuario userList:biblioteca.getListUsuarios()){
            if (userList.getNumeroIdentificacion().equals(idUser)){
                user = userList;
            }
        }

        if (tiempo.equals("Entregar el mismo día")){
            tiempoPrestamo = TiempoPrestamo.MISMO_DIA;
        }
        if (tiempo.equals("Entregar en 5 dias")){
            tiempoPrestamo = TiempoPrestamo.CINCO_DIAS;
        }
        if (tiempo.equals("Entregar en 10 dias")){
            tiempoPrestamo = TiempoPrestamo.DIEZ_DIAS;
        }

        SolicitudPrestamo solicitudPrestamo = new SolicitudPrestamo(id,user,libro,tiempoPrestamo);
        biblioteca.agregarSolicitudPrestamo(solicitudPrestamo);
    }
}