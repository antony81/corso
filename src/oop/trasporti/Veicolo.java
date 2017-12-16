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

import java.util.Objects;
import oop.individui.Persona;

/**
 *
 * @author Antonio
 */
public class Veicolo {
    
    protected String targa;
    protected int cilindrata;
    protected double consumo;
    protected Carburante carburante;
    protected Persona proprietario;
    
    public Veicolo(String targa, int cilindrata, double consumo, Carburante carburante, Persona proprietario) {
        this.targa = targa;
        this.cilindrata = cilindrata;
        this.consumo = consumo;
        this.carburante = carburante;
        this.proprietario = proprietario;
    }
    
    public String getTarga() {
        return targa;
    }
    
    public void setTarga(String targa) {
        this.targa = targa;
    }
    
    public int getCilindrata() {
        return cilindrata;
    }
    
    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }
    
    public double getConsumo() {
        return consumo;
    }
    
    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }
    
    public Carburante getCarburante() {
        return carburante;
    }
    
    public void setCarburante(Carburante carburante) {
        this.carburante = carburante;
    }
    
    public Persona getProprietario() {
        return proprietario;
    }
    
    public void setProprietario(Persona proprietario) {
        this.proprietario = proprietario;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(targa);
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
        final Veicolo v = (Veicolo) obj;
        if (this.cilindrata != v.cilindrata) {
            return false;
        }
        if (Double.doubleToLongBits(this.consumo) != Double.doubleToLongBits(v.consumo)) {
            return false;
        }
        if (this.carburante != v.carburante) {
            return false;
        }
        
        return Objects.equals(this.proprietario, v.proprietario);
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("targa=");
        builder.append(targa);
        builder.append(", cilindrata=");
        builder.append(cilindrata);
        builder.append(", consumo=");
        builder.append(consumo);
        builder.append(", carburante=");
        builder.append(carburante);
        builder.append(", proprietario=");
        builder.append(proprietario);
        
        return builder.toString();
    }
    
}
