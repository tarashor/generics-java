package lib;

public abstract class BaseLog {
    protected final String message;

    BaseLog(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public abstract static class BaseBuilder<T extends BaseLog, S extends BaseBuilder<T, S>>{
        protected String message;

        public S setMessage(String message){
            this.message = message;
            return self();
        }

        protected abstract S self();

        public abstract T build();
    }
}
