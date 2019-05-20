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

import java.util.List;
import java.util.Scanner;
import oop.thread.sincro.Magazzino;
import oop.thread.sincro.MagazzinoA;
import oop.thread.sincro.MagazzinoB;
import oop.thread.sincro.MagazzinoC;
import oop.thread.sincro.StartMagazzino;
import oop.util.RandomList;

/**
 *
 * @author Antonio
 */
public class TestMagazzino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> list = RandomList.integerList();
        Magazzino<Integer> magazzino;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("1. start magazzino a (wait e notify)");
            System.out.println("2. start magazzino b (lock e condition)");
            System.out.println("3. start magazzino c (blocking queue)");
            int scelta = scanner.nextInt();
            scanner.nextLine();
            switch(scelta) {
                case 1:
                    magazzino = new MagazzinoA<>();
                    break;
                case 2:
                    magazzino = new MagazzinoB<>();
                    break;
                case 3:
                    magazzino = new MagazzinoC<>();
                    break;
                default:
                    magazzino = null;
            }
        }
        
        if(magazzino != null)
            new Thread(new StartMagazzino(magazzino, list)).start();
        else
            System.out.println("scelta errata!");
    }
    
}
