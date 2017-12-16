/*
 * Copyright (C) 2017 Antonio
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package oop.lista;

/**
 *
 * @author Antonio
 * @param <E>
 */
public class ListaConcatenata<E> {
    
    private class Nodo<T> {
        T info;
        Nodo<E> next;
        
        Nodo(T info, Nodo<E> next) {
            this.info = info;
            this.next = next;
        }
    }
    
    private Nodo<E> inizio, fine;
    private int size;

    public ListaConcatenata() {
        clear();
    }
    
    public void add(E element) {
        if(size == 0) {
            Nodo<E> nuovo = new Nodo<>(element, null);
            inizio = fine = nuovo;
            size++;
        } else
            addLast(element);
    }
    
    public void add(int index, E element) {
        if(index < 0 || index > size)
            throw new IndiceFuoriRangeException();
        
        if(size == 0)
            add(element);
        else {
            if(index == 0)
                addFirst(element);
            else if(index == size)
                addLast(element);
            else {
                Nodo<E> cursore = findNodo(index-1);
                Nodo<E> nuovo = new Nodo<>(element, cursore.next);
                cursore.next = nuovo;
                size++;
            }
        }
    }

    private Nodo<E> findNodo(int index) {
        Nodo<E> cursore = inizio;
        for(int i = 0; i < index; i++)
            cursore = cursore.next;
        
        return cursore;
    }

    public void addFirst(E element) {
        if(size == 0)
            add(element);
        else {
            Nodo<E> nuovo = new Nodo<>(element, inizio);
            inizio = nuovo;
            size++;
        }
    }

    public void addLast(E element) {
        if(size == 0)
            add(element);
        else {
            Nodo<E> nuovo = new Nodo<>(element, null);
            fine.next = nuovo;
            fine = nuovo;
            size++;
        }
    }
    
    public E get(int index) {
        if(index < 0 || index >= size)
            throw new IndiceFuoriRangeException();
        
        return findNodo(index).info;
    }
    
    public E getFirst() {
        if(isEmpty())
            throw new NessunElementoException();
        
        return inizio.info;
    }
    
    public E getLast() {
        if(isEmpty())
            throw new NessunElementoException();
        
        return fine.info;
    }
    
    public E set(int index, E element) {
        if(index < 0 || index >= size)
            throw new IndiceFuoriRangeException();
        
        Nodo<E> cursore = findNodo(index);
        E oldValue = cursore.info;
        cursore.info = element;
        
        return oldValue;
    }
    
    public E remove(int index) {
        if(index < 0 || index >= size)
            throw new IndiceFuoriRangeException();
        
        Nodo<E> precedente, corrente;
        if(index == 0)
            return removeFirst();
        else if(index == (size-1))
            return removeLast();
        else {
            precedente = findNodo(index-1);
            corrente = precedente.next;
            precedente.next = corrente.next;
            corrente.next = null;
            size--;
        }
        
        return corrente.info;
    }
    
    public E removeFirst() {
        Nodo<E> cursore = inizio.next;
        inizio.next = null;
        inizio = cursore;
        size--;
        
        return cursore.info;
    }
    
    public E removeLast() {
        Nodo<E> cursore = findNodo(size-2);
        fine = cursore;
        fine.next = null;
        size--;
        
        return cursore.info;
    }
    
    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }
    
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }
    
    public int indexOf(E element) {
        int index = -1;
        
        Nodo<E> cursore = inizio;
        for(int i = 0; index == -1 && cursore != null; i++) {
            if(cursore.info.equals(element))
                index = i;
            cursore = cursore.next;
        }
        
        return index;
    }

    private void clear() {
        inizio = fine = null;
        size = 0;
    }
    
    public Iteratore<E> iterator() {
        return new Iteratore<E>() {
            Nodo<E> cursore = inizio;
            
            @Override
            public boolean haSuccessivo() {
                return cursore != null;
            }

            @Override
            public E successivo() {
                if(cursore == null)
                    throw new NessunElementoException();
                
                E element = cursore.info;
                cursore = cursore.next;
                
                return element;
            }
        };
    }
    
    @Override
    public String toString() {
        Iteratore<E> it = iterator();
        StringBuilder builder = new StringBuilder();
        builder.append("[").append(it.successivo());
        while (it.haSuccessivo())
            builder.append(", ").append(it.successivo());
        builder.append("]");
        
        return builder.toString();
    }
    
}
