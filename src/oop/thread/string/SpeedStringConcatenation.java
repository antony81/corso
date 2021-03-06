/*
 * Copyright (C) 2018 Antonio
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
package oop.thread.string;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio
 */
public class SpeedStringConcatenation implements Runnable {

    @Override
    public void run() {
        StringPlusProc p1 = new StringPlusProc();
        StringBuilderProc p2 = new StringBuilderProc();
        StringBufferProc p3 = new StringBufferProc();
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);
        
        t1.start();
        t2.start();
        t3.start();
        
        /*for(int i = 1; t1.isAlive() || t2.isAlive() || t3.isAlive(); i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SpeedStringConcatenation.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(i + "s");
        }*/
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(SpeedStringConcatenation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println();
        System.out.println(String.format("StringPlusProc end in %d ms", p1.getTime()));
        System.out.println(String.format("StringBuilderProc end in %d ms", p2.getTime()));
        System.out.println(String.format("StringBufferProc end in %d ms", p3.getTime()));
    }
    
}
