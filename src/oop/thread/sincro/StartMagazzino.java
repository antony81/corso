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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio
 * @param <E>
 */
public class StartMagazzino<E> implements Runnable {
    
    private final Magazzino<E> magazzino;
    private final List<E> elementiProduttore;

    public StartMagazzino(Magazzino<E> magazzino, List<E> elementiProduttore) {
        this.magazzino = magazzino;
        this.elementiProduttore = elementiProduttore;
    }

    @Override
    public void run() {
        Produttore p1 = new Produttore(magazzino, elementiProduttore, 14);
        Produttore p2 = new Produttore(magazzino, elementiProduttore, 6);
        Consumatore c1 = new Consumatore(magazzino, 9);
        Consumatore c2 = new Consumatore(magazzino, 6);
        Consumatore c3 = new Consumatore(magazzino, 5);
        
        Thread t1 = new Thread(p1, "PROD-01");
        t1.setPriority(Thread.MAX_PRIORITY);
        Thread t2 = new Thread(p2, "PROD-02");
        t2.setPriority(Thread.MAX_PRIORITY);
        Thread t3 = new Thread(c1, "CONS-01");
        Thread t4 = new Thread(c2, "CONS-02");
        Thread t5 = new Thread(c3, "CONS-03");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(StartMagazzino.class.getName()).log(Level.SEVERE, null, ex);
            Thread.currentThread().interrupt();
        }
        
        System.out.println();
        System.out.println();
        System.out.println("elementi dei produttori:");
        System.out.println(elementiProduttore);
        System.out.println("elementi del consumatore c1");
        System.out.println(c1.getElementi());
        System.out.println("elementi del consumatore c2");
        System.out.println(c2.getElementi());
        System.out.println("elementi del consumatore c3");
        System.out.println(c3.getElementi());
    }
    
}
