package com.mrasif.app.rmidemo;

import in.mrasif.rmiclientdemo.RMIInterface;
import lipermi.exception.LipeRMIException;
import lipermi.handler.CallHandler;
import lipermi.net.IServerListener;
import lipermi.net.Server;

import java.io.IOException;
import java.net.Socket;

public class AndroidRMIServer implements RMIInterface {

    public AndroidRMIServer(){
        try {
            CallHandler callHandler = new CallHandler();
            callHandler.registerGlobal(RMIInterface.class, this);
            Server server = new Server();
            server.bind(7777, callHandler);
            server.addServerListener(new IServerListener() {

                @Override
                public void clientDisconnected(Socket socket) {
                    System.out.println("Client Disconnected: " + socket.getInetAddress());
                }

                @Override
                public void clientConnected(Socket socket) {
                    System.out.println("Client Connected: " + socket.getInetAddress());
                }
            });
            System.out.println("Server Listening");
        } catch (LipeRMIException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AndroidRMIServer androidRMIServer=new AndroidRMIServer();
    }

    @Override
    public String helloTo(String name){
        System.err.println(name + " is trying to contact!");
        return "Server says hello to " + name;
    }
}
