package app;

import lib.*;

import java.util.ArrayList;
import java.util.List;


public class App {
    private Screen screen = new Screen();
    private Server server = new Server();

    private Logger logger = new Logger();
    private Log.Builder logBuilder = new Log.Builder();
    private String logSource = App.class.getSimpleName();

    private int N = 100;

    void start(){
        Log log = logBuilder.setMessage("started").setSource(logSource).build();
        logger.addLog(log);
    }

    void execute(){
        List<Log> executingLogs = new ArrayList<>();
        for (int i = 0; i < N; i+=10){
            String message = String.format("executing %d %%", i+10);
            Log log = logBuilder.setMessage(message).setSource(logSource).build();
            executingLogs.add(log);
        }
        logger.addLogs(executingLogs);

    }

    void end(){
        Log log = logBuilder.setMessage("ended").setSource(logSource).build();
        logger.addLog(log);

        BaseLog lastLog = logger.sendToSource(server);
        displayLastLog(lastLog);

    }

    private void displayLastLog(BaseLog lastLog) {
        screen.accept(lastLog);
    }

    public static void main(String[] args){
        App app = new App();
        app.start();
        app.execute();
        app.end();
    }

}
