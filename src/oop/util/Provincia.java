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
public enum Provincia {
    
    AOSTA(Regione.VALLE_AOSTA, "AO", true, false),
    TORINO(Regione.PIEMONTE, "TO", true, true),
    ALESSANDRIA(Regione.PIEMONTE, "AL", false, false),
    ASTI(Regione.PIEMONTE, "AT", false, false),
    BIELLA(Regione.PIEMONTE, "BI", false, false),
    CUNEO(Regione.PIEMONTE, "CN", false, false),
    NOVARA(Regione.PIEMONTE, "NO", false, false),
    VERBANO_CUSIO_OSSOLA(Regione.PIEMONTE, "VB", false, false),
    VERCELLI(Regione.PIEMONTE, "VC", false, false),
    GENOVA(Regione.LIGURIA, "GE", true, true),
    IMPERIA(Regione.LIGURIA, "IM", false, false),
    LA_SPEZIA(Regione.LIGURIA, "SP", false, false),
    SAVONA(Regione.LIGURIA, "SV", false, false),
    MILANO(Regione.LOMBARDIA, "MI", true, true),
    BERGAMO(Regione.LOMBARDIA, "BG", false, false),
    BRESCIA(Regione.LOMBARDIA, "BS", false, false),
    COMO(Regione.LOMBARDIA, "CO", false, false),
    CREMONA(Regione.LOMBARDIA, "CR", false, false),
    LECCO(Regione.LOMBARDIA, "LC", false, false),
    LODI(Regione.LOMBARDIA, "LO", false, false),
    MANTOVA(Regione.LOMBARDIA, "MN", false, false),
    MONZA_BRIANZA(Regione.LOMBARDIA, "MB", false, false),
    PAVIA(Regione.LOMBARDIA, "PV", false, false),
    SONDRIO(Regione.LOMBARDIA, "SO", false, false),
    VARESE(Regione.LOMBARDIA, "VA", false, false),
    TRENTO(Regione.TRENTINO_ALTO_ADIGE, "TN", true, false),
    BOLZANO(Regione.TRENTINO_ALTO_ADIGE, "BZ", false, false),
    VENEZIA(Regione.VENETO, "VE", true, true),
    BELLUNO(Regione.VENETO, "BL", false, false),
    PADOVA(Regione.VENETO, "PD", false, false),
    ROVIGO(Regione.VENETO, "RO", false, false),
    TREVISO(Regione.VENETO, "TV", false, false),
    VERONA(Regione.VENETO, "VR", false, false),
    VICENZA(Regione.VENETO, "VI", false, false),
    TRIESTE(Regione.FRIULI_VENEZIA_GIULIA, "TS", true, false),
    GORIZIA(Regione.FRIULI_VENEZIA_GIULIA, "GO", false, false),
    PORDENONE(Regione.FRIULI_VENEZIA_GIULIA, "PN", false, false),
    UDINE(Regione.FRIULI_VENEZIA_GIULIA, "UD", false, false),
    BOLOGNA(Regione.EMILIA_ROMAGNA, "BO", true, true),
    FERRARA(Regione.EMILIA_ROMAGNA, "FE", false, false),
    FORLI_CESENA(Regione.EMILIA_ROMAGNA, "FC", false, false),
    MODENA(Regione.EMILIA_ROMAGNA, "MO", false, false),
    PARMA(Regione.EMILIA_ROMAGNA, "PR", false, false),
    PIACENZA(Regione.EMILIA_ROMAGNA, "PC", false, false),
    RAVENNA(Regione.EMILIA_ROMAGNA, "RA", false, false),
    REGGIO_EMILIA(Regione.EMILIA_ROMAGNA, "RE", false, false),
    RIMINI(Regione.EMILIA_ROMAGNA, "RN", false, false),
    FIRENZE(Regione.TOSCANA, "FI", true, true),
    AREZZO(Regione.TOSCANA, "AR", false, false),
    GROSSETO(Regione.TOSCANA, "GR", false, false),
    LIVORNO(Regione.TOSCANA, "LI", false, false),
    LUCCA(Regione.TOSCANA, "LU", false, false),
    MASSA_CARRARA(Regione.TOSCANA, "MS", false, false),
    PISA(Regione.TOSCANA, "PI", false, false),
    PISTOIA(Regione.TOSCANA, "PT", false, false),
    PRATO(Regione.TOSCANA, "PO", false, false),
    SIENA(Regione.TOSCANA, "SI", false, false),
    ANCONA(Regione.MARCHE, "AN", true, false),
    ASCOLI_PICENO(Regione.MARCHE, "AP", false, false),
    FERMO(Regione.MARCHE, "FM", false, false),
    MACERATA(Regione.MARCHE, "MC", false, false),
    PESARO_URBINO(Regione.MARCHE, "PU", false, false),
    PERUGIA(Regione.UMBRIA, "PG", true, false),
    TERNI(Regione.UMBRIA, "TR", false, false),
    ROMA(Regione.LAZIO, "RM", true, true),
    FROSINONE(Regione.LAZIO, "FR", false, false),
    LATINA(Regione.LAZIO, "LT", false, false),
    RIETI(Regione.LAZIO, "RI", false, false),
    VITERBO(Regione.LAZIO, "VT", false, false),
    L_AQUILA(Regione.ABRUZZO, "AQ", true, false),
    CHIETI(Regione.ABRUZZO, "CH", false, false),
    PESCARA(Regione.ABRUZZO, "PE", false, false),
    TERAMO(Regione.ABRUZZO, "TE", false, false),
    CAMPOBASSO(Regione.MOLISE, "CB", true, false),
    ISERNIA(Regione.MOLISE, "IS", false, false),
    NAPOLI(Regione.CAMPANIA, "NA", true, true),
    AVELLINO(Regione.CAMPANIA, "AV", false, false),
    BENEVENTO(Regione.CAMPANIA, "BN", false, false),
    CASERTA(Regione.CAMPANIA, "CE", false, false),
    SALERNO(Regione.CAMPANIA, "SA", false, false),
    POTENZA(Regione.BASILICATA, "PZ", true, false),
    MATERA(Regione.BASILICATA, "MT", false, false),
    BARI(Regione.PUGLIA, "BA", true, true),
    BARLETTA_ANDRIA_TRANI(Regione.PUGLIA, "BT", false, false),
    BRINDISI(Regione.PUGLIA, "BR", false, false),
    FOGGIA(Regione.PUGLIA, "FG", false, false),
    LECCE(Regione.PUGLIA, "LE", false, false),
    TARANTO(Regione.PUGLIA, "TA", false, false),
    CATANZARO(Regione.CALABRIA, "CZ", true, false),
    REGGIO_CALABRIA(Regione.CALABRIA, "RC", false, true),
    COSENZA(Regione.CALABRIA, "CS", false, false),
    CROTONE(Regione.CALABRIA, "KR", false, false),
    VIBO_VALENTIA(Regione.CALABRIA, "VV", false, false),
    PALERMO(Regione.SICILIA, "PA", true, true),
    CATANIA(Regione.SICILIA, "CT", false, true),
    MESSINA(Regione.SICILIA, "ME", false, true),
    AGRIGENTO(Regione.SICILIA, "AG", false, false),
    CALTANISSETTA(Regione.SICILIA, "CL", false, false),
    ENNA(Regione.SICILIA, "EN", false, false),
    RAGUSA(Regione.SICILIA, "RG", false, false),
    SIRACUSA(Regione.SICILIA, "SR", false, false),
    TRAPANI(Regione.SICILIA, "TP", false, false),
    CAGLIARI(Regione.SARDEGNA, "CA", true, true),
    NUORO(Regione.SARDEGNA, "NU", false, false),
    ORISTANO(Regione.SARDEGNA, "OR", false, false),
    SASSARI(Regione.SARDEGNA, "SS", false, false),
    SUD_SARDEGNA(Regione.SARDEGNA, "SU", false, false);
    
    private final Regione regione;
    private final String sigla;
    private final boolean capoluogo;
    private final boolean metropoli;
    
    private Provincia(Regione regione, String sigla, boolean capoluogo, boolean metropoli) {
        this.regione = regione;
        this.sigla = sigla;
        this.capoluogo = capoluogo;
        this.metropoli = metropoli;
    }
    
    public Regione getRegione() {
        return regione;
    }
    
    public String getSigla() {
        return sigla;
    }
    
    public boolean isCapoluogo() {
        return capoluogo;
    }
    
    public boolean isMetropoli() {
        return metropoli;
    }
    
}
