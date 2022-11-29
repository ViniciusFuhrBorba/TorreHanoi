public class PilhaVetor<T> implements Cloneable {
    private int counter = 0;
    private int size;
    private T[] vet;

    public PilhaVetor(int size) {
        this.size = size;
        this.vet = (T[]) new Object[this.size];
    }

    public void push(T obj) throws Exception {
        if (!this.isFull()) {
            this.vet[this.counter] = obj;
            this.counter++;
        }
    }

    public T pop() throws Exception {
        if (this.isEmpty()) {
            return null;
        }
        return this.vet[--this.counter];
    }

    public T top() throws Exception {
        if (this.isEmpty()) {
            return null;
        }
        return this.vet[this.counter - 1];
    }

    @Override
    public PilhaVetor<T> clone() throws CloneNotSupportedException {
        return (PilhaVetor<T>) super.clone();
    }

    public int size() throws Exception {
        if (this.isEmpty()) {
            return 0;
        }
        return (this.counter);
    }

    public boolean isEmpty() {
        return this.counter == 0;
    }

    public boolean isFull() {
        return this.counter == this.size;
    }

    public void clear() {
        this.vet = null;
        this.counter = 0;
    }
}
