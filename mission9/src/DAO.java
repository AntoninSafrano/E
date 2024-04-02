import java.sql.Connection;

public abstract class DAO<T> {
    public Connection connect = null;

    public abstract T select(long id);

    public abstract boolean insert(T obj);

    public abstract boolean update(T obj);

    public abstract boolean delete(long id);
}
