package genericity;

public interface Data<E> {
    void add(E e);
    void delete(E e);
    void update(E e);
    void query(E e);
}
