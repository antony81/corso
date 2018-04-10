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
        private T info;
        private Nodo<E> next;
        
        Nodo(T info, Nodo<E> next) {
            this.info = info;
            this.next = next;
        }

        public T getInfo() {
            return info;
        }

        public void setInfo(T info) {
            this.info = info;
        }

        public Nodo<E> getNext() {
            return next;
        }

        public void setNext(Nodo<E> next) {
            this.next = next;
        }
        
    }
    
    private Nodo<E> inizio, fine;
    private int size;

    public ListaConcatenata() {
        clear();
    }
    
    private void init(E element) {
        Nodo<E> nuovo = new Nodo<>(element, null);
        inizio = fine = nuovo;
        size++;
    }

    private Nodo<E> findNodo(int index) {
        Nodo<E> corrente = inizio;
        for(int i = 0; i < index; i++)
            corrente = corrente.next;
        
        return corrente;
    }
    
    public void add(E element) {
        if(size == 0)
            init(element);
        else
            addLast(element);
    }
    
    public void add(int index, E element) {
        if(index < 0 || index > size)
            throw new IndiceFuoriRangeException();
        
        if(size == 0)
            init(element);
        else if(index == 0)
            addFirst(element);
        else if(index == size)
            addLast(element);
        else {
            Nodo<E> corrente = findNodo(index-1);
            Nodo<E> nuovo = new Nodo<>(element, corrente.next);
            corrente.next = nuovo;
            size++;
        }
    }

    public void addFirst(E element) {
        if(size == 0)
            init(element);
        else {
            Nodo<E> nuovo = new Nodo<>(element, inizio);
            inizio = nuovo;
            size++;
        }
    }

    public void addLast(E element) {
        if(size == 0)
            init(element);
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
        
        Nodo<E> corrente = findNodo(index);
        E oldValue = corrente.info;
        corrente.info = element;
        
        return oldValue;
    }
    
    public E remove(int index) {
        if(index < 0 || index >= size)
            throw new IndiceFuoriRangeException();
        
        if(index == 0)
            return removeFirst();
        else if(index == (size-1))
            return removeLast();
        
        Nodo<E> precedente = findNodo(index-1);
        Nodo<E> corrente = precedente.next;
        E old = corrente.info;
        precedente.next = corrente.next;
        corrente.next = null;
        size--;
        
        return old;
    }
    
    public boolean remove(E element) {
        boolean trovato = false;
        
        Nodo<E> precedente = inizio;
        Nodo<E> corrente = precedente.next;
        while(!trovato && corrente != null) {
            if(corrente.info.equals(element)) {
                precedente.next = corrente.next;
                corrente.next = null;
                size--;
                trovato = true;
            }
            precedente = corrente;
            corrente = corrente.next;
        }
        
        return trovato;
    }
    
    public E removeFirst() {
        Nodo<E> corrente = inizio.next;
        E old = inizio.info;
        inizio.next = null;
        inizio = corrente;
        size--;
        
        return old;
    }
    
    public E removeLast() {
        Nodo<E> precedente = findNodo(size-2);
        E old = fine.info;
        fine = precedente;
        fine.next = null;
        size--;
        
        return old;
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
        
        Nodo<E> corrente = inizio;
        for(int i = 0; index == -1 && corrente != null; i++) {
            if(corrente.info.equals(element))
                index = i;
            corrente = corrente.next;
        }
        
        return index;
    }

    private void clear() {
        inizio = fine = null;
        size = 0;
    }
    
    public Iteratore<E> iterator() {
        return new Iteratore<E>() {
            Nodo<E> corrente = inizio;
            
            @Override
            public boolean haSuccessivo() {
                return corrente != null;
            }

            @Override
            public E successivo() {
                if(corrente == null)
                    throw new NessunElementoException();
                
                E element = corrente.info;
                corrente = corrente.next;
                
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
