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
 */
public class BancaIO {
    
    public static boolean save(Banca banca) {
        boolean res = false;
        //File file = new File("C:/dev/serializable/banca/bank.obj");
        File file = new File("./src/oop/saves/banca/bank.obj");
        
        try ( FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos); ) {
            oos.writeInt(banca.size());
            for(int i = 0; i < banca.size(); i++)
                oos.writeObject(banca.read(i));
            res = true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BancaIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BancaIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    public static Banca load() {
        //File file = new File("C:/dev/serializable/banca/bank.obj");
        File file = new File("./src/oop/saves/banca/bank.obj");
        Banca banca;
        
        try (
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
            ) {
            int size = ois.readInt();
            banca = new Banca(size);
            for(int i = 0; i < size; i++) {
                ContoBancario bankAccount = (ContoBancario) ois.readObject();
                banca.create(bankAccount);
            }
        } catch (FileNotFoundException e) {
            banca = null;
        } catch (IOException | ClassNotFoundException e) {
            banca = null;
        }
        
        return banca;
    }
    
}
