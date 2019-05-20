/*
 * Copyright (C) 2018 Consultant
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
package oop.rubrica;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import oop.util.LoggerFactory;

/**
 *
 * @author Consultant
 */
public class MenuRubrica {
    
    private final Scanner scanner;
    private final Rubrica rubrica;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuRubrica.class);
    
    public MenuRubrica() {
        scanner = new Scanner(System.in);
        rubrica = new Rubrica();
        
        LOGGER.setUseParentHandlers(false);
    }
    
    public void openMenu() {
        System.out.println();
        System.out.println("--- rubrica ---");
        System.out.println();
        int scelta = 0;
        do {
            System.out.println("effettua una scelta...");
            System.out.println("0. per uscire dal programma");
            System.out.println("1. per aggiungere un contatto");
            System.out.println("2. per cercare un contatto, dato il numero telefonico");
            System.out.println("3. per cercare un numero telefonico, dato il nome e il cognome");
            System.out.println("4. per rimuovere un contatto, dato il numero telefonico");
            System.out.println("5. per visualizzare i contatti in rubrica");
            try {
                scelta = scanner.nextInt();
                switch(scelta) {
                    case 0:
                        System.out.println("sto chiudendo l'applicazione");
                        break;
                    case 1:
                        aggiungi();
                        break;
                    case 2:
                        cercaContatto();
                        break;
                    case 3:
                        cercaNumeroTelefono();
                        break;
                    case 4:
                        rimuovi();
                        break;
                    case 5:
                        visualizza();
                        break;
                    default:
                        System.out.println();
                        System.err.println("scelta errata - digita un numero compreso tra 0 e 5");
                        scelta = 1;
                }
            } catch(InputMismatchException ex) {
                System.err.println("scelta errata - digita la scelta corretta");
                LOGGER.log(Level.SEVERE, "non è un intero", ex);
            }
        } while(scelta > 0 && scelta < 6);
        scanner.close();
        System.out.println();
        System.out.println("--- programma terminato ---");
        System.out.println();
    }
    
    private void returnMenu() {
        System.out.println("digita un tasto per tornare al menu");
        scanner.next();
        scanner.nextLine();
        System.out.println();
        System.out.println();
    }

    private void aggiungi() {
        scanner.nextLine();
        boolean check;
        do {
            System.out.println();
            System.out.println();
            try {
                System.out.println("inserisci il numero telefonico (digitare il prefisso, poi uno spazio e poi il numero)");
                String numTel = scanner.nextLine();
                String[] split = numTel.split(" ");
                int prefisso = Integer.parseInt(split[0]);
                int numero = Integer.parseInt(split[1]);
                NumeroTelefono telefono = new NumeroTelefono(prefisso, numero);
                
                System.out.println("inserisci prima il nome e poi il cognome del contatto");
                System.out.print("nome: ");
                String nome = scanner.nextLine();
                System.out.print("cognome: ");
                String cognome = scanner.nextLine();
                Contatto c = new Contatto(nome, cognome);
                String yn = "Y";
                while(!yn.toUpperCase().equals("N")) {
                    System.out.println();
                    System.out.print("vuoi aggiungere un indirizzo email? (Y/N) ");
                    yn = scanner.nextLine();
                    if(yn.toUpperCase().equals("Y")) {
                        System.out.print("email: ");
                        String email = scanner.nextLine();
                        c.aggiungi(email);
                    }
                }
                
                rubrica.aggiungi(telefono, c);
                check = true;
            } catch (NumberFormatException ex) {
                check = false;
                System.err.println("il numero telefonico non è nel formato corretto");
                LOGGER.log(Level.SEVERE, "inseriti caratteri non numerici", ex);
            } catch (ArgomentoInvalidoException ex) {
                check = false;
                System.err.println("il numero telefonico non può avere valori negativi");
                LOGGER.log(Level.SEVERE, "valore negativo", ex);
            }
        } while(!check);
    }

    private void visualizza() {
        System.out.println();
        System.out.println();
        System.out.println(rubrica);
        returnMenu();
    }

    private void cercaContatto() {
        scanner.nextLine();
        System.out.println();
        System.out.println();
        try {
            System.out.println("inserisci il numero telefonico (digitare il prefisso, poi uno spazio e poi il numero)");
            String numTel = scanner.nextLine();
            String[] split = numTel.split(" ");
            int prefisso = Integer.parseInt(split[0]);
            int numero = Integer.parseInt(split[1]);
            NumeroTelefono telefono = new NumeroTelefono(prefisso, numero);
            Contatto c = rubrica.cercaContatto(telefono);
            if(c != null) {
                System.out.println(c);
                System.out.println();
                String risposta;
                do {
                    System.out.println("vuoi modificare il nome o il cognome? (S/N) ");
                    risposta = scanner.nextLine();
                    switch(risposta.toUpperCase()) {
                        case "S":
                            System.out.println("digita il nome: ");
                            String nome = scanner.nextLine();
                            System.out.println("digita il cognome: ");
                            String cognome = scanner.nextLine();
                            c.setNome(nome);
                            c.setCognome(cognome);
                            System.out.println("contatto modificato");
                            System.out.println(c);
                            break;
                        case "N":
                            System.out.println();
                            break;
                        default:
                            System.out.println("scelta errata");
                    }
                } while(!risposta.equalsIgnoreCase("N"));
            } else
                System.out.println("contatto e numero non presente in rubrica");
            System.out.println();
        } catch (NumberFormatException ex) {
            System.err.println("il numero telefonico non è nel formato corretto");
            LOGGER.log(Level.SEVERE, "inseriti caratteri non numerici", ex);
        } catch (ArgomentoInvalidoException ex) {
            System.err.println("il numero telefonico non può avere valori negativi");
            LOGGER.log(Level.SEVERE, "valore negativo", ex);
        }
        
        returnMenu();
    }

    private void cercaNumeroTelefono() {
        scanner.nextLine();
        System.out.println();
        System.out.println();
        System.out.println("inserisci prima il nome e poi il cognome del contatto");
        System.out.print("nome: ");
        String nome = scanner.nextLine();
        System.out.print("cognome: ");
        String cognome = scanner.nextLine();
        NumeroTelefono numTel = rubrica.cercaNumeroTelefono(nome, cognome);
        System.out.println(numTel != null ? numTel : "contatto e numero non presente in rubrica");
        System.out.println();
        
        returnMenu();
    }

    private void rimuovi() {
        scanner.nextLine();
        System.out.println();
        System.out.println();
        System.out.println("inserisci il numero telefonico (digitare il prefisso, poi uno spazio e poi il numero)");
        try {
            String numTel = scanner.nextLine();
            String[] split = numTel.split(" ");
            int prefisso = Integer.parseInt(split[0]);
            int numero = Integer.parseInt(split[1]);
            NumeroTelefono telefono = new NumeroTelefono(prefisso, numero);
            rubrica.rimuovi(telefono);
            System.out.println();
        } catch (NumberFormatException ex) {
            System.err.println("il numero telefonico non è nel formato corretto");
            LOGGER.log(Level.SEVERE, "inseriti caratteri non numerici", ex);
        } catch (ArgomentoInvalidoException ex) {
            System.err.println("il numero telefonico non può avere valori negativi");
            LOGGER.log(Level.SEVERE, "valore negativo", ex);
        }
        
        returnMenu();
    }
    
}
