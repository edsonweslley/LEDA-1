package adt.btree;

public class BTreeImpl<T extends Comparable<T>> implements BTree<T> {

    protected BNode<T> root;
    protected int order;

    public BTreeImpl(int order) {
        this.order = order;
        this.root = new BNode<T>(order);
    }

    @Override
    public BNode<T> getRoot() {
        return this.root;
    }

    @Override
    public boolean isEmpty() {
        return this.root.isEmpty();
    }

    @Override
    public int height() {
        return height(this.root);
    }

    private int height(BNode<T> node) {
        int result = 0;
        if (!node.isLeaf()) {
            result = 1 + height(node.getChildren().getFirst());
        }
        return result;
    }

    @Override
    public BNode<T>[] depthLeftOrder() {
        return depthLeftOrder(this.getRoot());
    }

    private BNode<T>[] depthLeftOrder(BNode<T> root) {
        return null;
    }

    @Override
    public int size() {
        // TODO Implement your code here
        throw new UnsupportedOperationException("Not Implemented yet!");
    }

    @Override
    public BNodePosition<T> search(T element) {
        return search(this.getRoot(), element);
    }

    private BNodePosition<T> search(BNode<T> node, T elem) {
        int ind = 0;

        while (ind <= node.size() && elem.compareTo(node.elements.get(ind++)) > 0) {
            ind++;
        }
        if (ind <= node.size() && elem.equals(node.elements.get(ind))) {
            return new BNodePosition<>(node, ind);
        } else if (node.isLeaf()) {
            return new BNodePosition<>(null, -1);
        } else {
            return search(node.getChildren().get(ind), elem);
        }
    }

    @Override
    public void insert(T element) {
        if (element != null) {

        }
    }

    private void split(BNode<T> node) {
        T elemMed = node.getElements().get((int) Math.ceil(node.size()/2.0) - 1);

        BNode<T> left = new BNode<>(node.size());
        BNode<T> right = new BNode<>(node.size());

        for (T elem:node.getElements()) {
            if (elem.compareTo(elemMed) < 0)
                left.addElement(elem);
            else if (elem.compareTo(elemMed) > 0)
                right.addElement(elem);
        }

        if (node.getParent() == null) {
            node.setParent(new BNode<>(order));
            node.getParent().getChildren().addFirst(node);
        }
        node.getParent().addElement(elemMed);


    }

    private void promote(BNode<T> node) {
        T elemMed = node.getElements().get((int) Math.ceil(node.size()/2.0) - 1);

        node.getParent().addElement(elemMed);
        if ()
    }

    // NAO PRECISA IMPLEMENTAR OS METODOS ABAIXO
    @Override
    public BNode<T> maximum(BNode<T> node) {
        // NAO PRECISA IMPLEMENTAR
        throw new UnsupportedOperationException("Not Implemented yet!");
    }

    @Override
    public BNode<T> minimum(BNode<T> node) {
        // NAO PRECISA IMPLEMENTAR
        throw new UnsupportedOperationException("Not Implemented yet!");
    }

    @Override
    public void remove(T element) {
        // NAO PRECISA IMPLEMENTAR
        throw new UnsupportedOperationException("Not Implemented yet!");
    }

}
