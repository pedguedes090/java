package th.myInterface;

public interface IManager<T> {
    void add(T item);
    void delete(int id);
    void update(T item);
    void displayAll();
}
