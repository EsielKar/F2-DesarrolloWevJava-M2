package org.bedu.postwork.javase2project.multithreading;

import org.bedu.postwork.javase2project.async.NotificadorInscripcion;
import org.bedu.postwork.javase2project.model.SolicitudEstudiante;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class ReceptorSolicitudes implements Runnable{

    private boolean flag = false;
    private final Queue<SolicitudEstudiante> listSolicitudes;
    private final NotificadorInscripcion worker;

    public ReceptorSolicitudes(NotificadorInscripcion worker) {
        this.worker = worker;
        this.listSolicitudes = new LinkedList<>();
    }

    @Override
    public void run() {

        try {
            while (flag || !listSolicitudes.isEmpty()){
                SolicitudEstudiante event = listSolicitudes.poll();
                if (event == null) {
                    System.out.println("Esperando solicitudes ...");
                    TimeUnit.SECONDS.sleep(1);
                    continue;
                }
                worker.notificacion(event);
                TimeUnit.SECONDS.sleep(1);
            }
        }catch (InterruptedException e){
            flag = false;
            e.printStackTrace();
        }

    }

    public void activar(){
        this.flag = true;
        new Thread(this).start();
    }

    public void detener(){
        this.flag = false;
    }

    public void agregarSolicitud(SolicitudEstudiante solicitud ){
        listSolicitudes.add(solicitud);
    }

    public boolean isEjecucion(){
        return flag;
    }

}
