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
package oop.banca;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio
 * 
 * Classe con metodi statici i quali consentono di salvare e caricare oggetti
 * di tipo Banca sfruttando la serializzazione.
 */
public class BancaIO {
    
    private final static Logger LOGGER = Logger.getLogger(BancaIO.class.getName()); // creazione di un logger
    
    private BancaIO() {
    }
    
    /**
     * 
     * @param banca - l'oggetto da salvare
     * @return true se l'oggetto è stato salvato, false altrimenti
     * 
     * Metodo statico che consente di salvare un oggetto di tipo Banca in
     * memoria secondaria. Se tutto va bene il metodo ritorna true.
     */
    public static boolean save(Banca banca) {
        boolean esito = true;
        
        //File file = new File("C:/dev/serializable/banca/bank.obj");
        File file = new File("./src/oop/saves/banca/bank.obj");
        
        try ( FileOutputStream fos = new FileOutputStream(file, true);
                ObjectOutputStream oos = new ObjectOutputStream(fos); ) {
            oos.writeInt(banca.size());
            for(int i = 0; i < banca.size(); i++)
                oos.writeObject(banca.get(i));
            
            LOGGER.log(Level.INFO, "Salvataggio andato a buon fine");
        } catch (FileNotFoundException ex) {
            esito = false;
            LOGGER.log(Level.SEVERE, "errore", ex);
        } catch (IOException ex) {
            esito = false;
            LOGGER.log(Level.SEVERE, "errore", ex);
        }
        
        return esito;
    }
    
    /**
     * 
     * @return l'oggetto caricato dalla memoria secondaria
     * 
     * Metodo statico che consente di ricare un oggetto di tipo Banca
     * precedentemente salvato. Il metodo ritorna 'null' se il file non c'è.
     */
    public static Banca load() {
        //File file = new File("C:/dev/serializable/banca/bank.obj");
        File file = new File("./src/oop/saves/banca/bank.obj");
        
        Banca banca;
        try ( FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis); ) {
            int size = ois.readInt();
            banca = new Banca(size);
            for(int i = 0; i < size; i++) {
                ContoBancario bankAccount = (ContoBancario) ois.readObject();
                banca.add(bankAccount);
            }
            
            LOGGER.log(Level.INFO, "Caricamento andato a buon fine");
        } catch (FileNotFoundException ex) {
            banca = null;
            LOGGER.log(Level.SEVERE, "errore", ex);
        } catch (IOException | ClassNotFoundException ex) {
            banca = null;
            LOGGER.log(Level.SEVERE, "errore", ex);
        }
        
        return banca;
    }
    
}
