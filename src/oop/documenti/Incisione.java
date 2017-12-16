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
public class Incisione extends Manoscritto {
    
    private Tecnica tecnica;
    
    public Incisione(int qualita, boolean integrita, int eta, Autore autore, String titolo, Tecnica tecnica) {
        super(qualita, integrita, eta, autore, titolo);
        
        this.tecnica = tecnica;
    }
    
    public Tecnica getTecnica() {
        return tecnica;
    }
    
    public void setTecnica(Tecnica tecnica) {
        this.tecnica = tecnica;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", tecnica: ").append(tecnica);
        
        return builder.toString();
    }
    
    @Override
    public Supporto supporto() {
        return Supporto.ANALOGICO;
    }
    
    @Override
    public double percentualeInfo() {
        return (isIntegrita() ? getQualita()-getQualita()*0.1 : getQualita()-getQualita()*0.8);
    }
    
}
