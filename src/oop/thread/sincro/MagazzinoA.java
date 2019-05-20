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

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Antonio
 * @param <E>
 */
public class MagazzinoA<E> extends Magazzino<E> {
    
    private final Queue<E> queue;

    public MagazzinoA() {
        queue = new ArrayDeque<>(10);
    }

    @Override
    public synchronized void aggiungi(E element) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        while(queue.size() == 10) {
            System.out.println("il thread " + threadName + " è in wait");
            wait();
            System.out.println("il thread " + threadName + " è stato riattivato");
        }
        
        System.out.print("il thread " + threadName + " sta aggiungendo " + element);
        System.out.println(" al " + (++ingressiP) + "° ingresso");
        queue.offer(element);
        int time = ThreadLocalRandom.current().nextInt(4)+1;
        TimeUnit.SECONDS.sleep(time);
        System.out.print("il thread " + threadName + " ha impiegato " + time + "s");
        System.out.println(" per inserire il " + queue.size() + "° elemento");
        
        notifyAll();
    }

    @Override
    public synchronized E preleva() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        while(queue.isEmpty()) {
            System.out.println("il thread " + threadName + " è in wait");
            wait();
            System.out.println("il thread " + threadName + " è stato riattivato");
        }
        
        E element = queue.poll();
        System.out.print("il thread " + threadName + " sta prelevando " + element);
        System.out.println( " al " + (++ingressiC) + "° ingresso");
        int time = ThreadLocalRandom.current().nextInt(1000)+1;
        TimeUnit.MILLISECONDS.sleep(time);
        System.out.print("il thread " + threadName + " ha impiegato " + (time < 1000 ? (time + "ms") : "1s"));
        System.out.println("; il magazzino ha ora " + queue.size() + " elementi");
        
        notifyAll();
        
        return element;
    }
    
}
