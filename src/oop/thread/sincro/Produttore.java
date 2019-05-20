/*
 * Copyright (C) 2019 Antonio
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
package oop.thread.sincro;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio
 * @param <E>
 */
public class Produttore<E> implements Runnable {
    
    private final Magazzino<E> magazzino;
    private final List<E> elementi;
    private final int accessi;
    
    public Produttore(Magazzino<E> magazzino, List<E> elementi, int accessi) {
        if(elementi.isEmpty())
            throw new IllegalArgumentException("empty list");
        
        this.magazzino = magazzino;
        this.elementi = elementi;
        this.accessi = accessi;
    }

    @Override
    public void run() {
        try {
            for(int i = 0; i < accessi; i++)
                magazzino.aggiungi(elementi.get(ThreadLocalRandom.current().nextInt(elementi.size())));
        } catch (InterruptedException ex) {
            Logger.getLogger(Produttore.class.getName()).log(Level.SEVERE, null, ex);
            Thread.currentThread().interrupt();
        }
    }
    
}
