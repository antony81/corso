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
package oop.util;

/**
 *
 * @author Antonio
 */
public enum Elemento {
    
    IDROGENO("H", 1, 1.008),
    ELIO("He", 2, 4.003),
    LITIO("Li", 3, 6.941),
    BERILIO("Be", 4, 9.012),
    BORO("B", 5, 10.811),
    CARBONIO("C", 6, 12.011),
    AZOTO("N", 7, 14.007),
    OSSIGENO("O", 8, 15.999),
    FLUORO("F", 9, 18.998),
    NEON("Ne", 10, 20.179),
    SODIO("Na", 11, 22.990),
    MAGNESIO("Mg", 12, 24.305),
    ALLUMINIO("Al", 13, 26.982),
    SILICIO("Si", 14, 28.086),
    FOSFORO("P", 15, 30.974),
    ZOLFO("S", 16, 32.065),
    CLORO("Cl", 17, 35.453),
    ARGON("Ar", 18, 39.948),
    POTASSIO("K", 19, 39.098),
    CALCIO("Ca", 20, 40.078),
    SCANDIO("Sc", 21, 44.956),
    TITANIO("Ti", 22, 47.867),
    VANADIO("V", 23, 50.942),
    CROMO("Cr", 24, 51.996),
    MANGANESE("Mn", 25, 54.938),
    FERRO("Fe", 26, 55.845),
    COBALTO("Co", 27, 58.933),
    NICHEL("Ni", 28, 58.693),
    RAME("Cu", 29, 63.546),
    ZINCO("Zn", 30, 65.390),
    GALLIO("Ga", 31, 69.723),
    GERMANIO("Ge", 32, 72.640),
    ARSENICO("As", 33, 74.922),
    SELENIO("Se", 34, 78.960),
    BROMO("Br", 35, 79.904),
    KRIPTON("Kr", 36, 83.800),
    RUBIDIO("Rb", 37, 85.468),
    STRONZIO("Sr", 38, 87.620),
    ITTRIO("Y", 39, 88.906),
    ZIRCONIO("Zr", 40, 91.224),
    NIOBIO("Nb", 41, 92.906),
    MOLIBDENO("Mo", 42, 95.940),
    TECNEZIO("Tc", 43, 98.000),
    RUTENIO("Ru", 44, 101.070),
    RODIO("Rh", 45, 102.910),
    PALLADIO("Pd", 46, 106.420),
    ARGENTO("Ag", 47, 107.870),
    CADMIO("Cd", 48, 112.410),
    INDIO("In", 49, 114.820),
    STAGNO("Sn", 50, 118.710),
    ANTIMONIO("Sb", 51, 121.760),
    TELLURIO("Te", 52, 127.600),
    IODIO("I", 53, 126.904),
    XENO("Xe", 54, 131.29),
    CESIO("Cs", 55, 132.910),
    BARIO("Ba", 56, 137.330),
    LANTANIO("La", 57, 138.920),
    CERIO("Ce", 58, 140.120),
    PRASEODIMIO("Pr", 59, 140.910),
    NEODIMIO("Nd", 60, 144.240),
    PROMEZIO("Pm", 61, 145.000),
    SAMARIO("Sm", 62, 150.36),
    EUROPIO("Eu", 63, 151.96),
    GADOLINIO("Gd", 64, 157.25),
    TERBIO("Tb", 65, 158.93),
    DIPROSIO("Dy", 66, 162.500),
    OLMIO("Ho", 67, 164.930),
    ERBIO("Er", 68, 167.260),
    TULIO("Tm", 69, 168.930),
    ITTERBIO("Yb", 70, 173.04),
    LUTEZIO("Lu", 71, 174.970),
    AFNIO("Hf", 72, 178.490),
    TANTALIO("Ta", 73, 180.950),
    TUNGSTENO("W", 74, 183.840),
    RENIO("Re", 75, 186.210),
    OSMIO("Os", 76, 190.230),
    IRIDIO("Ir", 77, 192.220),
    PLATINO("Pt", 78, 195.080),
    ORO("Au", 79, 196.970),
    MERCURIO("Hg", 80, 200.59),
    TALLIO("Tl", 81, 204.380),
    PIOMBO("Pb", 82, 207.200),
    BISMUTO("bi", 83, 208.980),
    POLONIO("Po", 84, 209.000),
    ASTATO("At", 85, 210.000),
    RADON("Rn", 86, 222.000),
    FRANCIO("fr", 87, 223.000),
    RADIO("Ra", 88, 226.000),
    ATTINIO("Ac", 89, 227.000),
    TORIO("Th", 90, 232.040),
    PROTOATTINIO("Pa", 91, 231.040),
    URANIO("U", 92, 238.030),
    NETTUNIO("Np", 93, 237.000),
    PLUTONIO("Pu", 94, 244.000),
    AMERICIO("Am", 95, 243.000),
    CURIO("Cm", 96, 247.000),
    BERKELIO("Bk", 97, 247.000),
    CALIFORNIO("Cf", 98, 251.000),
    EINSTENIO("Es", 99, 252.000),
    FERMIO("Fm", 100, 257.000),
    MENDELEVIO("Md", 101, 258.000),
    NOBELIO("No", 102, 259.000),
    LAURENZIO("Lr", 103, 262.000);
    
    private String simbolo;
    private int numeroAtomico;
    private double massaAtomica;
    
    /**
     * Il costruttore lo definiamo noi e prevede che vangano specificati alcuni
     * parametri e così siamo obbligati a costruire i nostri valori nell'enum,
     * con il costruttore che abbiamo fornito.
     *
     * @param simbolo
     * @param numeroAtomico
     * @param massaAtomica
     */
    private Elemento(String simbolo, int numeroAtomico, double massaAtomica) {
        this.simbolo = simbolo;
        this.numeroAtomico = numeroAtomico;
        this.massaAtomica = massaAtomica;
    }
    
    public String getSimbolo() {
        return simbolo;
    }
    
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    
    public int getNumeroAtomico() {
        return numeroAtomico;
    }
    
    public void setNumeroAtomico(int numeroAtomico) {
        this.numeroAtomico = numeroAtomico;
    }
    
    public double getMassaAtomica() {
        return massaAtomica;
    }
    
    public void setMassaAtomica(double massaAtomica) {
        this.massaAtomica = massaAtomica;
    }
    
}
