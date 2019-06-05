import java.util.LinkedList;


class Node<T> {
    private T dane;
    private Node<T> rodzic;
    private LinkedList<Node<T>> dziecko;

    public Node() {
        rodzic = null;
        dziecko = new LinkedList<Node<T>>();
    }

    public Node(Node<T> rodzic) {
        this();
        this.rodzic = rodzic;
    }

    public Node(Node<T> rodzic, T dane) {
        this(rodzic);
        this.dane = dane;
    }

    public Node<T> zwrocRodzica(){
        return rodzic;
    }

    public void ustawRodzica(Node<T> rodzic) {
        this.rodzic = rodzic;
    }

    public T zwrocDane() {
        return dane;
    }

    public void ustawDane(T dane) {
        this.dane = dane;
    }

    public boolean jestLisc(){
        return dziecko.isEmpty();
    }

    public Node<T> dodajDziecko(Node<T> child) {
        child.ustawRodzica(this);
        dziecko.add(child);
        return child;
    }

    public Node<T> dodajDziecko(T dane) {
        Node<T> child = new Node<T>(this, dane);
        dziecko.add(child);
        return child;
    }

    public Node<T> zwrocDziecko(int i){
        return dziecko.get(i);
    }

    public Node<T> usunDziecko(int i) {
        return dziecko.remove(i);
    }

    public void usunDzieci() {
        dziecko.clear();
    }

    public LinkedList<Node<T>> zwrocDzieci() {
        return dziecko;
    }

    public String toString() {
        return dane.toString();
    }
}