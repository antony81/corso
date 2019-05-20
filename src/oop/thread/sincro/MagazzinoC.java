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

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import static oop.thread.sincro.Magazzino.ingressiP;

/**
 *
 * @author Antonio
 * @param <E>
 */
public class MagazzinoC<E> extends Magazzino<E> {
    
    private final BlockingQueue<E> queue;

    public MagazzinoC() {
        queue = new ArrayBlockingQueue<>(10);
    }
    
    @Override
    public void aggiungi(E element) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.print("il thread " + threadName + " sta aggiungendo " + element);
        System.out.println(" al " + (++ingressiP) + "° ingresso");
        queue.put(element);
        int time = ThreadLocalRandom.current().nextInt(4)+1;
        TimeUnit.SECONDS.sleep(time);
        System.out.print("il thread " + threadName + " ha impiegato " + time + "s");
        System.out.println(" per inserire il " + queue.size() + "° elemento");
    }
    
    @Override
    public E preleva() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        E element = queue.take();
        System.out.print("il thread " + threadName + " sta prelevando " + element);
        System.out.println( " al " + (++ingressiC) + "° ingresso");
        int time = ThreadLocalRandom.current().nextInt(1000)+1;
        TimeUnit.MILLISECONDS.sleep(time);
        System.out.print("il thread " + threadName + " ha impiegato " + (time < 1000 ? (time + "ms") : "1s"));
        System.out.println("; il magazzino ha ora " + queue.size() + " elementi");
        
        return element;
    }
    
}
