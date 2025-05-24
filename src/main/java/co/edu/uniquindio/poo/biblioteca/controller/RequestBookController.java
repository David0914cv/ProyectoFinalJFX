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
        if (tiempo.equals("Entregar en una semana")){
            tiempoPrestamo = TiempoPrestamo.UNA_SEMANA;
        }
        if (tiempo.equals("Entregrar en dos semanas")){
            tiempoPrestamo = TiempoPrestamo.DOS_SEMANAS;
        }

        SolicitudPrestamo solicitudPrestamo = new SolicitudPrestamo(id,user,libro,tiempoPrestamo);
        biblioteca.agregarSolicitudPrestamo(solicitudPrestamo);
    }
}