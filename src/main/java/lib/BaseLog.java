package lib;

public abstract class BaseLog {
    protected final String message;

    BaseLog(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public abstract static class BaseBuilder<T extends BaseLog>{
        protected String message;

        public BaseBuilder<T> setMessage(String message){
            this.message = message;
            return this;
        }

        public abstract T build();
    }
}
