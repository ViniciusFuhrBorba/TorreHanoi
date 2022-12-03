public class PilhaEncadeada<T> implements Cloneable {

    private NoLista<T> topo;
    private int tam;

    public PilhaEncadeada() {
        this.topo = null;
        this.tam = 0;
    }

    public void push(T obj) throws Exception {
        NoLista<T> newObj = new NoLista<T>();
        newObj.setInfo(obj);
        if (!this.isEmpty()) {
            newObj.setProx(this.topo);
        }
        this.topo = newObj;
        this.tam++;
    }

    public T pop() throws Exception {
        if (!this.isEmpty()) {
            T t = this.topo.getInfo();
            this.topo = this.topo.getProx();
            this.tam -= 1;
            return t;
        }
        return null;
    }

    public T top() throws Exception {
        if (this.isEmpty()) {
            return null;
        }
        return this.topo.getInfo();
    }

    @Override
    public PilhaEncadeada<T> clone() throws CloneNotSupportedException {
        return (PilhaEncadeada<T>) super.clone();
    }


    public int size() throws Exception {
        if (this.isEmpty()) {
            return 0;
        }
        return this.tam;
    }

    public boolean isEmpty() {
        return this.topo == null;
    }

}
