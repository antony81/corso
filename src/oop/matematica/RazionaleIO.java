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
package oop.matematica;

import oop.util.LoggerFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio
 */
public final class RazionaleIO {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(Razionale.class); // creazione di un logger
    
    /**
     * Costruttore di default privato che non consente la creazione di oggetti
     * di tipo RazionaleIO. La classe avrà infatti soltanto metodi statici.
     */
    private RazionaleIO() {
    }
    
    /**
     * 
     * @param r - razionale da salvare
     * @return true se il salvataggio va a buon fine, false altrimenti
     * 
     * Metodo statico che permette di salvare un oggetto di tipo razionale in
     * un file in un percorso di default.
     */
    public static boolean save(Razionale r) {
        return save(r, "./src/oop/saves/matematica/razionale.dat");
    }
    
    /**
     * 
     * @param r - razionale da salvare
     * @param pathName - il nome del file con il relativo percorso, da salvare
     * @return true se il salvataggio va a buon fine, false altrimenti
     * 
     * Metodo statico che permette di salvare un oggetto di tipo razionale in
     * un file con il percorso passato al metodo come stringa.
     */
    public static boolean save(Razionale r, String pathName) {
        boolean res = true;
        
        File file = new File(pathName);
        try ( FileOutputStream fos = new FileOutputStream(file);
                DataOutputStream dos = new DataOutputStream(fos); ) {
            dos.writeInt(r.getNumeratore());
            dos.writeInt(r.getDenominatore());
            LOGGER.log(Level.INFO, "Il Razionale {0} \u00e8 stato salvato", r);
        } catch (FileNotFoundException ex) {
            res = false;
            LOGGER.log(Level.SEVERE, "Il Razionale {0} non \u00e8 stato salvato", r);
            LOGGER.log(Level.SEVERE, "Errore accesso al disco\n", ex);
        } catch (IOException ex) {
            res = false;
            LOGGER.log(Level.SEVERE, "Il Razionale {0} non \u00e8 stato salvato", r);
            LOGGER.log(Level.SEVERE, "\n", ex);
        }
        
        return res;
    }
    
    /**
     * 
     * @return il razionale caricato
     * 
     * Metodo statico che consente di caricare da un file salvato in precedenza
     * in un percorso di default. Il metodo ritorna il razionale se tutto va
     * bene, altrimenti ritorna null se il file non esiste o se cisono problemi
     * di input-output.
     */
    public static Razionale load() {
        return load("./src/oop/saves/matematica/razionale.dat");
    }
    
    /**
     * 
     * @param pathName - il nome del file con il relativo percorso, da salvare
     * @return il razionale caricato
     * 
     * Metodo statico che consente di caricare da un file salvato in precedenza
     * in un percorso dato come parametro al metodo. Il metodo ritorna il
     * razionale se tutto va bene, altrimenti ritorna null se il file non esiste
     * o se cisono problemi di input-output.
     */
    private static Razionale load(String pathName) {
        Razionale res;
        
        File file = new File(pathName);
        try ( FileInputStream fis = new FileInputStream(file);
                DataInputStream dis = new DataInputStream(fis); ) {
            int num = dis.readInt();
            int den = dis.readInt();
            res = new Razionale(num, den);
            LOGGER.log(Level.INFO, "Il Razionale {0} \u00e8 stato caricato", res);
        } catch (FileNotFoundException ex) {
            res = null;
            LOGGER.log(Level.SEVERE, "Non \u00e8 stato possibile caricare il Razionale");
            LOGGER.log(Level.SEVERE, "Errore accesso al disco\n", ex);
        } catch (IOException | DenominatoreNulloException ex) {
            res = null;
            LOGGER.log(Level.SEVERE, "Non \u00e8 stato possibile caricare il Razionale");
            LOGGER.log(Level.SEVERE, "\n", ex);
        }
        
        return res;
    }
    
}
