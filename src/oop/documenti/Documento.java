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
public abstract class Documento {
    
    private int qualita;
    private boolean integrita;
    
    public Documento(int qualita, boolean integrita) {
        if (qualita < 0 || qualita > 100)
            throw new QualitaException();
        
        this.qualita = qualita;
        this.integrita = integrita;
    }
    
    public int getQualita() {
        return qualita;
    }
    
    public void setQualita(int qualita) {
        this.qualita = qualita;
    }
    
    public boolean isIntegrita() {
        return integrita;
    }
    
    public void setIntegrita(boolean integrita) {
        this.integrita = integrita;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(", qualità: ").append(qualita);
        builder.append(", integrità: ").append(integrita ? "OK" : "KO");
        
        return builder.toString();
    }
    
    public abstract Supporto supporto();
    
    public abstract double percentualeInfo();
    
}
