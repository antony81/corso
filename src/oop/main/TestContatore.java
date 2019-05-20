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
package oop.main;

import oop.thread.sincro.Contatore;
import oop.thread.sincro.ContatoreProc;

/**
 *
 * @author Antonio
 */
public class TestContatore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("start main");
        
        Contatore c1 = new Contatore();
        
        Thread t1 = new Thread(new ContatoreProc(c1, 4), "P-01");
        Thread t2 = new Thread(new ContatoreProc(c1, 5), "P-02");
        Thread t3 = new Thread(new ContatoreProc(c1, 4), "P-03");
        
        System.out.println("thread " + t1.getName() + " start");
        t1.start();
        System.out.println("thread " + t2.getName() + " start");
        t2.start();
        System.out.println("thread " + t3.getName() + " start");
        t3.start();
        
        System.out.println("start main");
    }
    
}
