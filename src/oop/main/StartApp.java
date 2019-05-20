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
package oop.main;

import java.util.InputMismatchException;
import java.util.Scanner;
import oop.app.AppRazionale;

/**
 *
 * @author Antonio
 */
public class StartApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;
            do {
                System.out.println("scegli il programma da eseguire");
                System.out.println("0. per uscire");
                System.out.println("1. programma dei razionali");
                int scelta = scanner.nextInt();
                scanner.nextLine();
                switch(scelta) {
                    case 0:
                        exit = true;
                        System.out.println("programma terminato");
                        break;
                    case 1:
                        new AppRazionale().init(scanner);
                        break;
                    default:
                        System.out.println("digitare un numero dell'elenco\n\n\n");
                }
            } while(!exit);
        } catch (InputMismatchException e) {
            System.out.println("digitare un numero dell'elenco\n\n\n");
        }
    }
    
}
