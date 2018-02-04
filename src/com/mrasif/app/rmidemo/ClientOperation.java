package com.mrasif.app.rmidemo;

import com.mrasif.app.rmidemo.ClientOperation;

import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientOperation {

    private static RMIInterface look_up;

    public static void main(String[] args)
            throws MalformedURLException, RemoteException, NotBoundException {

        Registry registry= LocateRegistry.getRegistry();
        look_up = (RMIInterface) Naming.lookup(AppConfig.SERVER);
        String txt = JOptionPane.showInputDialog("What is your name?");

        String response = look_up.helloTo(txt);
        JOptionPane.showMessageDialog(null, response);

    }

}
