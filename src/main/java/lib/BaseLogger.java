package lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseLogger<T extends BaseLog & Comparable<? super T>> {
    private List<T> logs;

    public BaseLogger(){
        logs = new ArrayList<>();
    }

    public void addLog(T log){
        logs.add(log);
    }

    public void addLogs(List<? extends T> logs){
        this.logs.addAll(logs);
    }

    public T sendToSource(Source<? super T> source) {
        T lastAcceptedLog = null;
        Collections.sort(logs);
        for(T log : logs){
            source.accept(log);
            lastAcceptedLog = log;
        }
        return lastAcceptedLog;
    }
}
