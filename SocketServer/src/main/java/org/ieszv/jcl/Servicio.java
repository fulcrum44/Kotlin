package org.ieszv.jcl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servicio {

    private int puerto;
    private ServerSocket servicio;
    private Socket socket = null;
    private DataInputStream flujoEntrada;
    private DataOutputStream flujoSalida;

    public Servicio(int puerto) {
        this.puerto = puerto;
        try {
            this.servicio = new ServerSocket(this.puerto);
        } catch (IOException e) {
            this.servicio = null;
        }
    }

    public void abrir() {
        try {
            this.socket = servicio.accept();
            this.flujoEntrada = new DataInputStream(this.socket.getInputStream());
            this.flujoSalida = new DataOutputStream(this.socket.getOutputStream());
            this.flujoSalida.writeUTF("conexión establecida");
            String dato = "";
            while (dato.compareToIgnoreCase("fin")) {
                dato = this.flujoEntrada.readUTF();
                System.out.println(dato);
                this.flujoSalida.writeUTF("me has escrito" + dato);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cerrar() {
        try {
            this.socket.close();
            this.servicio.close();
        } catch (IOException e) {

        }
    }

    static void main() {
        System.out.println("Servicio abierto");
        Servicio servicio = new Servicio(5000);
        servicio.abrir();
    }
}
