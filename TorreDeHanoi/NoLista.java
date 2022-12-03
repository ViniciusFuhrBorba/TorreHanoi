public class NoLista<T> {
    private T info;
    private NoLista<T> prox;

    public NoLista() {
    }

    public NoLista(T info, NoLista<T> prox) {
        this.info = info;
        this.prox = prox;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoLista<T> getProx() {
        return prox;
    }

    public void setProx(NoLista<T> prox) {
        this.prox = prox;
    }
}
