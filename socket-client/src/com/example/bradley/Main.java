package com.example.bradley;

import java.io.*;
import java.net.Socket;

public class Main {
// test client connection
    public static void main(String[] args) {
        String[] myArgs = {"127.0.0.1","4065"};

        String serverName = myArgs[0];
        int port = Integer.parseInt(myArgs[1]);
        try {
            System.out.println("Connecting to " + serverName + " on port " + port);
            Socket client = new Socket(serverName, port);

            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());


            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);

            System.out.println("Server says " + in.readUTF());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
