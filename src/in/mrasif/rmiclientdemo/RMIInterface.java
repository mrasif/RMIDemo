package in.mrasif.rmiclientdemo;

import java.rmi.Remote;

public interface RMIInterface extends Remote {
    public String helloTo(String name);
}
