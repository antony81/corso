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
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static oop.thread.sincro.Magazzino.ingressiP;

/**
 *
 * @author Antonio
 * @param <E>
 */
public class MagazzinoB<E> extends Magazzino<E> {
    
    private final Queue<E> queue;
    private final Lock lock;
    private final Condition fullQueue;
    private final Condition emptyQueue;

    public MagazzinoB() {
        queue = new ArrayDeque<>(10);
        lock = new ReentrantLock();
        fullQueue = lock.newCondition();
        emptyQueue = lock.newCondition();
    }

    @Override
    public void aggiungi(E element) throws InterruptedException {
        lock.lock();
        try {
            String threadName = Thread.currentThread().getName();
            while(queue.size() == 10) {
                System.out.println("il thread " + threadName + " è in wait");
                fullQueue.await();
                System.out.println("il thread " + threadName + " è stato riattivato");
            }
            
            System.out.print("il thread " + threadName + " sta aggiungendo " + element);
            System.out.println(" al " + (++ingressiP) + "° ingresso");
            queue.offer(element);
            int time = ThreadLocalRandom.current().nextInt(4)+1;
            TimeUnit.SECONDS.sleep(time);
            System.out.print("il thread " + threadName + " ha impiegato " + time + "s");
            System.out.println(" per inserire il " + queue.size() + "° elemento");
            
            emptyQueue.signalAll();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E preleva() throws InterruptedException {
        lock.lock();
        E element;
        try {
            String threadName = Thread.currentThread().getName();
            while(queue.isEmpty()) {
                System.out.println("il thread " + threadName + " è in wait");
                emptyQueue.await();
                System.out.println("il thread " + threadName + " è stato riattivato");
            }
            
            element = queue.poll();
            System.out.print("il thread " + threadName + " sta prelevando " + element);
            System.out.println( " al " + (++ingressiC) + "° ingresso");
            int time = ThreadLocalRandom.current().nextInt(1000)+1;
            TimeUnit.MILLISECONDS.sleep(time);
            System.out.print("il thread " + threadName + " ha impiegato " + (time < 1000 ? (time + "ms") : "1s"));
            System.out.println("; il magazzino ha ora " + queue.size() + " elementi");
            
            fullQueue.signalAll();
        } finally {
            lock.unlock();
        }
        
        return element;
    }
    
}
