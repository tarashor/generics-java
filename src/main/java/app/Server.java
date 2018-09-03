package app;

import lib.BaseLog;
import lib.Log;
import lib.Source;

public class Server implements Source<BaseLog> {
    @Override
    public void accept(BaseLog log) {
        System.out.println("Server : " + log);
    }
}
