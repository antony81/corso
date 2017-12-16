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
    
    private final static Logger LOGGER = LoggerFactory.getLogger(Razionale.class);
    
    private RazionaleIO() {
    }
    
    public static boolean save(Razionale r) {
        return save(r, "./src/oop/saves/matematica/razionale.dat");
    }
    
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
    
    public static Razionale load() {
        return load("./src/oop/saves/matematica/razionale.dat");
    }
    
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
