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

/**
 *
 * @author Antonio
 */
public abstract class DocumentoDigitale extends Documento {
    
    private int dimensione;
    private String pathName;
    
    public DocumentoDigitale(int qualita, boolean integrita, int dimensione, String pathName) {
        super(qualita, integrita);
        
        this.dimensione = dimensione;
        this.pathName = pathName;
    }
    
    public int getDimensione() {
        return dimensione;
    }
    
    public void setDimensione(int dimensione) {
        this.dimensione = dimensione;
    }
    
    public String getPathName() {
        return pathName;
    }
    
    public void setPathName(String pathName) {
        this.pathName = pathName;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", dimensione: ").append(dimensione);
        
        return builder.toString();
    }
    
    @Override
    public Supporto supporto() {
        return Supporto.DIGITALE;
    }
    
    @Override
    public abstract double percentualeInfo();
    
}
