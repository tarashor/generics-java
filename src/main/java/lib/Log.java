package lib;


public class Log extends BaseLog implements Comparable<Log> {
    protected final String source;

    Log(String source, String message) {
        super(message);
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    @Override
    public String toString() {
        return "Log:{" + source + "} - " + message;
    }

    @Override
    public int compareTo(Log o) {
        return o != null ? source.compareTo(o.source) : -1;
    }

    public static class Builder extends BaseLog.BaseBuilder<Log>{
        protected String source;

        public Builder setSource(String source) {
            this.source = source;
            return this;
        }


        @Override
        public Log build() {
            return new Log(source, message);
        }
    }

}
