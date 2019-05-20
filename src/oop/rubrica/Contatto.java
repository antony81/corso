/*
 * Copyright (C) 2018 Antonio
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
package oop.rubrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Antonio
 */
public class Contatto implements Comparable<Contatto> {
    
    private final long id;
    private String nome;
    private String cognome;
    private final List<String> email;
    
    private static long nextId = 1;

    public Contatto(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        email = new ArrayList<>();
        
        id = nextId++;
    }

    public final String getNome() {
        return nome;
    }

    public final void setNome(String nome) {
        this.nome = nome;
    }

    public final String getCognome() {
        return cognome;
    }

    public final void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    public void aggiungi(String email) {
        this.email.add(email);
    }
    
    public boolean rimuovi(String email) {
        return this.email.remove(email);
    }
    
    public String toStringEmail() {
        StringBuilder builder = new StringBuilder();
        builder.append(email);
        builder.append("\n");
        
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cognome);
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
        final Contatto c = (Contatto) obj;
        if (id != c.id) {
            return false;
        }
        if (!Objects.equals(nome, c.nome)) {
            return false;
        }
        
        return Objects.equals(cognome, c.cognome);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("id: ");
        builder.append(id);
        builder.append(", nome: ");
        builder.append(nome);
        builder.append(", cognome: ");
        builder.append(cognome);
        
        return builder.toString();
    }

    @Override
    public int compareTo(Contatto c) {
        int c1 = cognome.compareTo(c.cognome);
        if(c1 == 0) {
            int c2 = nome.compareTo(c.nome);
            if(c2 == 0)
                return Long.valueOf(id).compareTo(c.id);
            
            return c2;
        }
        
        return c1;
    }
    
}
