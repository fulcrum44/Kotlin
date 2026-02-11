package org.ieszv.jcl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Main {
      static void main() {

          try {
            Socket cliente = new Socket("localhost", 5000);
            DataInputStream dataIn = new DataInputStream(cliente.getInputStream());
            DataOutputStream dataOut = new DataOutputStream(cliente.getOutputStream());
            String dato = dataIn.readUTF();
            System.out.println("dato recibido" + dato);
            dataOut.writeUTF("saludo");
            dataOut.close();
            dataIn.close();
            cliente.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}