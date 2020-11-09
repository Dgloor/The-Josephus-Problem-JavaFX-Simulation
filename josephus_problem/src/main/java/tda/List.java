/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tda;

import java.util.Iterator;

/**
 *
 * @author danny
 * @param <E>
 */
public interface List<E> {
    
    public boolean addFirst(E e);

    public boolean addLast(E e);

    public E removeFirst();

    public E removeLast();

    public int size();

    public boolean isEmpty();

    public void clear();

    public void add(int index, E element); 

    public E remove(int index);

    public E get(int index); 

    public E set(int index, E element); 

    public Iterator<E> iterator();
    
    @Override
    public String toString();
    
}
