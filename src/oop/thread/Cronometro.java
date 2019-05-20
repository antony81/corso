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
package oop.thread;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Programma che ha la funzione di cronometro. Funziona bene se avviato sul
 * terminale nativo del sistema operativo.
 *
 * @author Antonio
 */
public class Cronometro implements Runnable {

    @Override
    public void run() {
        System.out.println("start time - press enter to stop");
        System.out.println();
        StringBuilder builder = new StringBuilder();
        boolean exit = false;
        int s = 0;
        int m = 0;
        int h = 0;
        while(!exit) {
            try {
                if(h < 10)
                    builder.append("0");
                builder.append(h)
                        .append(":");
                if(m < 10)
                    builder.append("0");
                builder.append(m)
                        .append(":");
                if(s < 10)
                    builder.append("0");
                builder.append(s++)
                        .append("\r");
                System.out.print(builder.toString());
                TimeUnit.SECONDS.sleep(1);
                if(s == 60) {
                    s = 0;
                    m++;
                    if(m == 60) {
                        m = 0;
                        h++;
                        if(h == 24)
                            h = 0;
                    }
                }
            } catch (InterruptedException ex) {
                System.out.println();
                exit = true;
            }
        }
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Thread t1 = new Thread(new Cronometro());
            t1.start();
            scanner.nextLine();
            t1.interrupt();
        }
    }
    
}
