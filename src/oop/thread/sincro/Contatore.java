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

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio
 */
public class Contatore {
    
    private int x;
    
    public Contatore() {
        x = 0;
    }
    
    public synchronized void aggiorna() {
        try {
            TimeUnit.SECONDS.sleep(1);
            x++;
            Thread current = Thread.currentThread();
            System.out.println("il thread " + current.getName() + " ha aggiornato x al valore " + x);
        } catch (InterruptedException ex) {
            Logger.getLogger(Contatore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
