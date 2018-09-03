package app;

import lib.BaseLog;
import lib.Source;

public class Screen implements Source<BaseLog> {
    @Override
    public void accept(BaseLog log) {
        System.out.println("Screen : " + log);
    }
}
