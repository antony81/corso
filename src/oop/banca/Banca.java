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

/**
 *
 * @author Antonio
 */
public class Banca {
    
    private ContoBancario[] conti;
    
    private int numConti, capacita;
    
    public Banca() {
        this(50);
    }
    
    public Banca(int capacita) {
        conti = new ContoBancario[capacita];
        this.capacita = capacita;
        numConti = 0;
    }
    
    public void create(ContoBancario cb) {
        create(numConti, cb);
    }
    
    public void create(int index, ContoBancario cb) {
        if(index < 0 || index > numConti)
            throw new IndexOutOfBoundsException();
        
        if(numConti == capacita) {
            ContoBancario[] tmp = conti;
            capacita *= 2;
            conti = new ContoBancario[capacita];
            System.arraycopy(tmp, 0, conti, 0, numConti);
        }
        
        for(int i = numConti; i > index; i--) {
            conti[i] = conti[i-1];
        }
        
        conti[index] = cb;
        numConti++;
    }
    
    public ContoBancario read(int index) {
        if(index < 0 || index > numConti)
            throw new IndexOutOfBoundsException();
        
        return conti[index];
    }
    
    public void update(int index, ContoBancario cb) {
        if(index < 0 || index > numConti)
            throw new IndexOutOfBoundsException();
        
        conti[index] = cb;
    }
    
    public ContoBancario delete(int index) {
        if(index < 0 || index > numConti)
            throw new IndexOutOfBoundsException();
        
        ContoBancario old = conti[index];
        
        for(int i = (index+1); i < numConti; i++)
            conti[i-1] = conti[i];
        numConti--;
        
        return old;
    }
    
    public void delete(ContoBancario cb) {
        delete(indexOf(cb));
    }
    
    public int indexOf(ContoBancario cb) {
        int index = -1;
        
        for(int i = 0; index == -1 && i < numConti; i++)
            if(conti[i].equals(cb))
                index = i;
        
        return index;
    }
    
    public int size() {
        return numConti;
    }
    
    public boolean contains(ContoBancario cb) {
        return indexOf(cb) != -1;
    }
    
    public boolean isEmpty() {
        return numConti == 0;
    }
    
    public void clear() {
        conti = new ContoBancario[capacita];
        numConti = 0;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Lista dei conti\n\n");
        for(int i = 0; i < numConti; i++) {
            builder.append(i+1).append(") ");
            builder.append(conti[i]).append("\n");
        }
        
        return builder.toString();
    }
    
}
