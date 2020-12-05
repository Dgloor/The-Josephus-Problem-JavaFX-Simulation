package list;

import java.util.ListIterator;

/**
 *
 * @author danny
 * @param <T>
 */
public class CircularDoublyLinkedList<T> implements List<T> {

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
        size++;
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
        size++;
        return true;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T data = head.getContent();
        head.getPrevious().setNext(head.getNext());
        head.getNext().setPrevious(head.getPrevious());
        head = head.getNext();
        size--;
        return data;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T data = head.getPrevious().getContent();
        head.getPrevious().getPrevious().setNext(head);
        head.setPrevious(head.getPrevious().getPrevious());
        size--;
        return data;
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
        head = null;
    }

    @Override
    public void add(int index, T data) {
        if (index == 0) {
            addFirst(data);
        } else if (index > 0 && index < size) {
            Node<T> aux = getNode(index);
            Node<T> newNode = new Node<>(data);
            aux.getPrevious().setNext(newNode);
            newNode.setPrevious(aux.getPrevious());
            newNode.setNext(aux);
            aux.setPrevious(newNode);
            size++;
        }
    }

    @Override
    public T remove(int index) {
        T element = null;
        if (index == 0) {
            element = removeFirst();
        } else if (index > 0 && index < size) {
            Node<T> aux = getNode(index);
            element = aux.getContent();
            aux.getPrevious().setNext(aux.getNext());
            aux.getNext().setPrevious(aux.getPrevious());
            aux.setContent(null);
            aux.setPrevious(null);
            aux.setNext(null);
            size--;
        }
        return element;
    }

    @Override
    public T get(int index) {
        T element = null;
        if (index >= 0 && index < size) {
            Node<T> aux = getNode(index);
            element = aux.getContent();
        }
        return element;
    }

    @Override
    public T set(int index, T data) {
        T element = null;
        if (index >= 0 && index < size) {
            Node<T> aux = getNode(index);
            element = aux.getContent();
            aux.setContent(data);
        }
        return element;
    }

    private Node<T> getNode(int index) {
        Node<T> aux = head;
        if (index <= size / 2) {
            for (; index > 0; index--) {
                aux = aux.getNext();
            }
        } else if (index > size / 2) {
            index = size - index;
            for (; index > 0; index--) {
                aux = aux.getPrevious();
            }
        }
        return aux;
    }

    @Override
    public ListIterator<T> listIterator() {
        ListIterator<T> it = new ListIterator<>() {
            private Node<T> traveler = head;

            @Override
            public boolean hasNext() {
                return size > 0;
            }

            @Override
            public T next() {
                traveler = traveler.getNext();
                return traveler.getPrevious().getContent();
            }

            @Override
            public boolean hasPrevious() {
                return hasNext();
            }

            @Override
            public T previous() {
                traveler = traveler.getPrevious();
                return traveler.getNext().getContent();
            }

            @Override
            public int nextIndex() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public int previousIndex() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void set(T e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override

            public void add(T e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

        };
        return it;
    }

    @Override

    public String toString() {
        String text = "[";
        int counter = 0;
        for (Node<T> node = head; counter < size; counter++) {
            text += node.getContent().toString();
            if (counter != size - 1) {
                text += ", ";
            }
            node = node.getNext();
        }
        return text + "]";
    }

}
