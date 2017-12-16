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
package oop.individui;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Antonio
 */
public class Persona {
    
    private String codiceFiscale;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String luogoNascita;
    private String provinciaNascita;
    private char sesso;

    public Persona(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String luogoNascita, String provinciaNascita, char sesso) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.luogoNascita = luogoNascita;
        this.provinciaNascita = provinciaNascita;
        this.sesso = sesso;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    public String getProvinciaNascita() {
        return provinciaNascita;
    }

    public void setProvinciaNascita(String provinciaNascita) {
        this.provinciaNascita = provinciaNascita;
    }

    public char getSesso() {
        return sesso;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codiceFiscale);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona p = (Persona) obj;
        
        return Objects.deepEquals(this.codiceFiscale, p.codiceFiscale);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("codice fiscale: ").append(codiceFiscale);
        builder.append(", nome: ").append(nome);
        builder.append(", cognome: ").append(cognome);
        builder.append(", data di nascita: ").append(dataNascita);
        builder.append(", luogo di nascita: ").append(luogoNascita);
        builder.append(", provincia di nascita: ").append(provinciaNascita);
        builder.append(", sesso: ").append(sesso);
        
        return builder.toString();
    }
    
}
