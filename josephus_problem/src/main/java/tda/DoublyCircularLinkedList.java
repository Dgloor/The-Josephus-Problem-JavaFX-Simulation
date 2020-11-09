package tda;

import java.util.Iterator;
import tda.List;
import tda.Node;

/**
 *
 * @author danny
 */
public class DoublyCircularLinkedList<T> implements List<T> {

    Node<T> head;
    int size;

    @Override
    public boolean addFirst(T data) {
        Node<T> newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            head.setNext(newNode);
            head.setPrevious(newNode);
        }
        newNode.setNext(head);
        newNode.setPrevious(head.getPrevious());
        head.getPrevious().setNext(newNode);
        head.setPrevious(newNode);
        head = newNode;
        return true;
    }

    @Override
    public boolean addLast(T data) {
        Node<T> newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            head.setNext(newNode);
            head.setPrevious(newNode);
        }
        newNode.setNext(head);
        newNode.setPrevious(head.getPrevious());
        head.getPrevious().setNext(newNode);
        head.setPrevious(newNode);
        return true;
    }

    @Override
    public T removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, T data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T set(int index, T data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
