public interface Pilha<T> {
    public void push(T obj) throws Exception;

    public T pop() throws Exception;

    public T top() throws Exception;

    public int size() throws Exception;

    public boolean isEmpty();

    public boolean isFull();

    public void clear();
}
