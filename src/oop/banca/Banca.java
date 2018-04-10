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
package oop.banca;

/**
 *
 * @author Antonio
 * 
 * Classe che rappresenta una banca la quale conterrà conti bancari e conti
 * estesi. Per fare ciò la classe incapsula un array di oggetti di tipo
 * ContoBancario, un intero che conta il numero di conti preseti nella banca e
 * un altro intero che rappresenta la capacità massima dell'array. La capacità
 * verrà usata esclusivamente per controllare che l'array sia pieno in modo tale
 * che la dimensione possa essere raddoppiata qualora fosse saturo.
 * Inoltre l'array potrà contenere sia oggetti di tipo ContoBancario, sia
 * oggetti di tipo ContoEsteso perché è un'estensione di ContoBancario.
 */
public class Banca {
    
    private ContoBancario[] conti; // variabile d'instanza
    
    private int size, capacity; // variabili d'instanza
    
    /**
     * Costruttore di default che richiama l'altro costruttore in overloading
     * passando il valore 5. Ciò significa che richiamando questo costruttore
     * l'array inizialmente avrà una capacità di 5 elementi.
     */
    public Banca() {
        this(5);
    }
    
    /**
     * 
     * @param capacity - la capacità iniziale della banca
     * 
     * Costruttore responsabile alla creazione di un oggetto di tipo Banca in
     * cui viene inizializzato l'array con dimensione pari alla capacità passata
     * come parametro al metodo.
     */
    public Banca(int capacity) {
        conti = new ContoBancario[capacity];
        size = 0;
        this.capacity = capacity;
    }
    
    /**
     * 
     * @param cb - l'oggetto da inserire in banca
     * 
     * Metodo in overloading che richiama l'altro metodo 'add' passando come
     * 'index' la variabile d'istanza 'size' e l'oggetto 'cb'. In sostanza
     * questo metodo inserisce l'oggetto 'cb' in coda all'array.
     */
    public void add(ContoBancario cb) {
        add(size, cb);
    }
    
    /**
     * 
     * @param index - l'indice in cui inserire l'oggetto cb
     * @param cb - l'oggetto da inserire in banca
     * 
     * Questo metodo ha il compito di inserire un oggetto di tipo ContoBancario
     * alla posizione 'index' passata come parametro. Inoltre il metodo è in
     * grado di aumentare la dimensione dell'array qualora fosse saturo.
     * Il metodo lancia un eccezione (IndexOutOfBoundsException) se l'indice
     * non rientra in un range corretto.
     */
    public void add(int index, ContoBancario cb) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        
        if(size == capacity) {
            capacity *= 2;
            ContoBancario[] tmp = conti;
            conti = new ContoBancario[capacity];
            System.arraycopy(tmp, 0, conti, 0, size);
        }
        
        for(int i = size; i > index; i--)
            conti[i] = conti[i-1];
        
        conti[index] = cb;
        size++;
    }
    
    /**
     * 
     * @param index - l'indice da cui poter leggere un oggetto di tipo ContoBancario
     * @return un oggetto di tipo ContoBancario
     * 
     * Questo metodo permette di leggere un oggetto di tipo ContoBancario dato
     * un indice valido.
     * Il metodo lancia un eccezione (IndexOutOfBoundsException) se l'indice
     * non rientra in un range corretto.
     */
    public ContoBancario get(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        
        return conti[index];
    }
    
    /**
     * 
     * @param index - l'indice su cui aggiornare un oggetto di tipo ContoBancario
     * @param cb - l'oggetto di tipo ContoBancario
     * @return l'oggetto presente prima dell'aggiornamento
     * 
     * Metodo che sostituisce un oggetto di tipo ContoBancario in una
     * determinata posizione data dal parametro 'index'.
     * Il metodo lancia un eccezione (IndexOutOfBoundsException) se l'indice
     * non rientra in un range corretto e restituisce l'oggetto che c'era prima
     * dell'aggiornamento.
     */
    public ContoBancario set(int index, ContoBancario cb) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        
        ContoBancario old = conti[index];
        conti[index] = cb;
        
        return old;
    }
    
    /**
     * 
     * @param index - l'indice dell'oggetto da rimuovere
     * @return l'oggetto rimosso
     * 
     * Metodo che rimuove un oggetto di tipo ContoBancario ad un determinato
     * indice.
     * Il metodo lancia un eccezione (IndexOutOfBoundsException) se l'indice
     * non rientra in un range corretto e restituisce l'oggetto rimosso.
     */
    public ContoBancario delete(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        
        ContoBancario old = conti[index];
        
        for(int i = (index+1); i < size; i++)
            conti[i-1] = conti[i];
        size--;
        
        return old;
    }
    
    /**
     * 
     * @param cb - l'oggetto da rimuovere
     * @return true se l'oggetto è presente e quindi si può rimuovere, false altrimenti
     * 
     * Metodo che rimuove l'oggetto 'cb' passato come parametro se è presente.
     * Se l'oggetto c'è il metodo lo rimuove e ritorna true. Se l'oggetto non
     * c'è ritorna false.
     */
    public boolean delete(ContoBancario cb) {
        int index = indexOf(cb);
        if(index == -1)
            return false;
        
        delete(index);
        
        return true;
    }
    
    /**
     * 
     * @param cb - l'oggetto di tipo ContoBancario da cercare
     * @return l'indice di appartenenza dell'oggetto passato
     * 
     * Metodo che ritorna l'indice di appartenenza dell'oggetto 'cb' se c'è.
     * Se l'oggetto passato non c'è ritorna -1.
     */
    public int indexOf(ContoBancario cb) {
        int index = -1;
        
        for(int i = 0; index == -1 && i < size; i++)
            if(conti[i].equals(cb))
                index = i;
        
        return index;
    }
    
    /**
     * 
     * @param cb - l'oggetto da cercare
     * @return true se l'oggetto è presente, false altrimenti
     * 
     * Metodo che cerca un oggetto di tipo ContoBancario nella banca e se è
     * presente ritorna true. Se l'oggetto non c'è ritorna false.
     */
    public boolean contains(ContoBancario cb) {
        return indexOf(cb) != -1;
    }
    
    /**
     * 
     * @return il numero di conti presenti in banca
     * 
     * Metodo che ritorna la quantità di conti bancari presenti in banca.
     */
    public int size() {
        return size;
    }
    
    /**
     * 
     * @return true se la banca non ha conti, false se la banca ha almeno un conto
     * 
     * Metodo che ritorna true se nella banca non è presente alcun conto.
     * Se invece nella banca è presente almeno un conto il metodo ritorna false.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Metodo che elimina tutti i conti dalla banca. Il metodo è un reset della
     * banca dove tutti i conti vengono eliminati.
     */
    public void clear() {
        conti = new ContoBancario[capacity];
        size = 0;
    }
    
    /**
     * 
     * @return la stringa che rappresenta un oggetto di tipo Banca
     * 
     * Sovrascrittura del metodo 'toString' in modo che possa rappresentare un
     * oggetto di tipo Banca. In pratica la stringa elenca la lista dei conti
     * presenti in banca.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("lista dei conti\n\n");
        if(size == 0)
            builder.append("nessun conto presente");
        else
            for(int i = 0; i < size; i++) {
                builder.append(i+1).append(") ");
                builder.append(conti[i]).append("\n");
            }
        
        return builder.toString();
    }
    
}
