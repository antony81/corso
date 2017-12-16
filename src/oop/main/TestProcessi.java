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
package oop.main;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import oop.thread.Processo1;
import oop.thread.Processo2;
import oop.thread.Processo3;
import oop.thread.Processo4;

/**
 *
 * @author Antonio
 */
public class TestProcessi {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("start main");
        
        Processo1 t1 = new Processo1();
        Processo2 t2 = new Processo2();
        Processo3 t3 = new Processo3();
        Thread t4 = new Thread(new Processo4());
        Thread t5 = new Thread(new Processo4());
        
        System.out.println("start t1");
        t1.start();
        System.out.println("start t2");
        t2.start();
        System.out.println("start t3");
        t3.start();
        System.out.println("start t4");
        t4.start();
        System.out.println("start t5");
        t5.start();
        
        Thread t6 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Processo6 lanciato " + i + " volte");
                    try {
                        sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Processo1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        System.out.println("start t6");
        t6.start();
        
        Thread t7 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Processo7 lanciato " + i + " volte");
                try {
                    sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Processo1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        System.out.println("start t7");
        t7.start();
        
        System.out.println("end main");
    }
    
}
