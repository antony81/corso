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
package oop.documenti;

import oop.individui.Autore;

/**
 *
 * @author Antonio
 */
public abstract class Manoscritto extends Documento {
    
    private int eta;
    private Autore autore;
    private String titolo;
    
    public Manoscritto(int qualita, boolean integrita, int eta, Autore autore, String titolo) {
        super(qualita, integrita);
        
        this.eta = eta;
        this.autore = autore;
        this.titolo = titolo;
    }
    
    public int getEta() {
        return eta;
    }
    
    public void setEta(int eta) {
        this.eta = eta;
    }
    
    public Autore getAutore() {
        return autore;
    }
    
    public void setAutore(Autore autore) {
        this.autore = autore;
    }
    
    public String getTitolo() {
        return titolo;
    }
    
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", età: ").append(eta);
        builder.append(", autore: ").append(autore);
        builder.append(", titolo: ").append(titolo);
        
        return builder.toString();
    }
    
    @Override
    public abstract Supporto supporto();
    
    @Override
    public abstract double percentualeInfo();
    
}
