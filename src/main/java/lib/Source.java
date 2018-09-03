package lib;

public interface Source<T extends BaseLog> {
    void accept(T log);
}
