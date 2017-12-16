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

import java.util.Date;
import oop.individui.Autore;

/**
 *
 * @author Antonio
 */
public class Libro extends Manoscritto {
    
    private String genere;
    private String lingua;
    private Date dataUscita;
    private Supporto supporto;
    
    public Libro(int qualita, boolean integrita, int eta, Autore autore, String titolo, String genere, String lingua, Date dataUscita, Supporto supporto) {
        super(qualita, integrita, eta, autore, titolo);
        
        this.genere = genere;
        this.lingua = lingua;
        this.dataUscita = dataUscita;
        this.supporto = supporto;
    }
    
    public String getGenere() {
        return genere;
    }
    
    public void setGenere(String genere) {
        this.genere = genere;
    }
    
    public String getLingua() {
        return lingua;
    }
    
    public void setLingua(String lingua) {
        this.lingua = lingua;
    }
    
    public Date getDataUscita() {
        return dataUscita;
    }
    
    public void setDataUscita(Date dataUscita) {
        this.dataUscita = dataUscita;
    }
    
    public Supporto getSupporto() {
        return supporto;
    }
    
    public void setSupporto(Supporto supporto) {
        this.supporto = supporto;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", genere: ").append(genere);
        builder.append(", lingua: ").append(lingua);
        builder.append(", data uscita: ").append(dataUscita);
        
        return builder.toString();
    }
    
    @Override
    public Supporto supporto() {
        return getSupporto();
    }
    
    @Override
    public double percentualeInfo() {
        if(supporto == Supporto.ANALOGICO)
            return (isIntegrita() ? getQualita()-getQualita()*0.1 : getQualita()-getQualita()*0.8);
        
        return (isIntegrita() ? getQualita() : 0.0);
    }
    
}
