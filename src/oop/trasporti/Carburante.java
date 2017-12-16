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
package oop.trasporti;

/**
 *
 * @author Antonio
 */
public enum Carburante {
    
    BENZINA('S', 101) {
        @Override
        public String dscrizione() {
            return "Liquido altamente infiammabile ottenuto dalla distillazione del petrolio greggio";
        }
    },
    DIESEL('D', 20) {
        @Override
        public String dscrizione() {
            return "Miscela di idrocarburi liquidi ottenuta dalla distillazione frazionata del petrolio";
        }
    },
    GPL('G', 93) {
        @Override
        public String dscrizione() {
            return "Miscela di idrocarburi alcani a basso peso molecolare composta principalmente da propano e butano";
        }
    },
    METANO('M', 122) {
        @Override
        public String dscrizione() {
            return "Idrocarburo semplice formato da un atomo di carbonio e quattro di idrogeno";
        }
    };
    
    private char sigla;
    private int ottani;
    
    private Carburante(char sigla, int ottani) {
        this.sigla = sigla;
        this.ottani = ottani;
    }
    
    public char getSigla() {
        return sigla;
    }
    
    public void setSigla(char sigla) {
        this.sigla = sigla;
    }
    
    public int getOttani() {
        return ottani;
    }
    
    public void setOttani(int ottani) {
        this.ottani = ottani;
    }
    
    public abstract String dscrizione();
    
}
