package org.bedu.postwork.javase2project.async;

import org.bedu.postwork.javase2project.model.SolicitudEstudiante;

@FunctionalInterface
public interface NotificadorInscripcion {
    void notificacion(SolicitudEstudiante event);
}

