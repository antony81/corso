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
package oop.main.banca;

import javax.swing.JOptionPane;
import oop.banca.Banca;
import oop.banca.BancaIO;
import oop.banca.ContoBancario;
import oop.banca.ContoEsteso;

/**
 *
 * @author Antonio
 */
public class JBanca {
    
    private final static String B = "ContoBancario";
    private final static String E = "ContoEsteso";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Banca banca = new Banca(5);
        
        StringBuilder builder = new StringBuilder();
        builder.append("Scegli l'operazione da effettuare.\n\n");
        builder.append("0. Salva dati\n");
        builder.append("1. Carica dati\n");
        builder.append("2. Inserisci un conto\n");
        builder.append("3. Visualizza un conto\n");
        builder.append("4. Aggiorna un conto\n");
        builder.append("5. Elimina un conto\n");
        builder.append("6. Visualizza tutti i conti\n");
        builder.append("7. Deposita su un conto\n");
        builder.append("8. Preleva da un conto");
        
        while(true) {
            String scelta = JOptionPane.showInputDialog(null, builder, "Banca", JOptionPane.QUESTION_MESSAGE);
            if(scelta == null)
                break;
            
            switch(scelta) {
                case "0":
                    save(banca);
                    break;
                case "1":
                    banca = load();
                    break;
                case "2":
                    add(banca);
                    break;
                case "3":
                    int index = get(banca);
                    if(index != -1) {
                        ContoBancario cb = banca.read(index);
                        JOptionPane.showMessageDialog(null, cb, "Banca", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case "4":
                    set(banca);
                    break;
                case "5":
                    remove(banca);
                    break;
                case "6":
                    show(banca);
                    break;
                case "7":
                    dep(banca);
                    break;
                case "8":
                    pre(banca);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Scelta errata!", "Banca", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private static void save(Banca banca) {
        boolean esito = BancaIO.save(banca);
        String msg = (esito ? "Salvataggio effettuato" : "Salvataggio non effettuato");
        
        JOptionPane.showMessageDialog(null, msg, "Banca", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private static Banca load() {
        Banca bancaLoad = BancaIO.load();
        String msg = (bancaLoad != null ? "Caricamento effettuato" : "Caricamento non effettuato");
        
        JOptionPane.showMessageDialog(null, msg, "Banca", JOptionPane.INFORMATION_MESSAGE);
        
        return bancaLoad;
    }
    
    private static void add(Banca banca) {
        Object accountTypes[] = { B, E };
        
        boolean flag = true;
        while(flag) {
            String scelta = (String) JOptionPane.showInputDialog(null, "Che tipo di conto vuoi creare?", "Banca",
                    JOptionPane.QUESTION_MESSAGE, null, accountTypes, accountTypes[0]);
            if(scelta == null)
                scelta = "";
            
            switch(scelta) {
                case B:
                    createB(banca);
                    break;
                case E:
                    createE(banca);
                    break;
                default:
                    flag = false;
            }
        }
    }
    
    private static void createB(Banca banca) {
        ContoBancario cb;
        
        String numeroConto = JOptionPane.showInputDialog(null, "Qual è il numero di conto?", "Banca", JOptionPane.QUESTION_MESSAGE);
        int esisteSaldo = JOptionPane.showConfirmDialog(null, "Vuoi depositare un bilancio?", "Banca", JOptionPane.YES_NO_OPTION);
        if(esisteSaldo == JOptionPane.YES_OPTION) {
            Double saldi[] = { 1000.0d, 2000.0d, 5000.0d, 10000.0d };
            double saldo = (double) JOptionPane.showInputDialog(null, "Qual è il bilancio iniziale?", "Banca",
                    JOptionPane.QUESTION_MESSAGE, null, saldi, saldi[0]);
            cb = new ContoBancario(numeroConto, saldo);
        } else {
            cb = new ContoBancario(numeroConto);
        }
        
        banca.create(cb);
    }
    
    private static void createE(Banca banca) {
        ContoEsteso ce;
        
        String numero = JOptionPane.showInputDialog(null, "Qual è il numero di conto?", "Banca", JOptionPane.QUESTION_MESSAGE);
        int esisteSaldo = JOptionPane.showConfirmDialog(null, "Vuoi depositare un bilancio?", "Banca", JOptionPane.YES_NO_OPTION);
        if(esisteSaldo == JOptionPane.YES_OPTION) {
            Double saldi[] = { 1000.0d, 2000.0d, 5000.0d, 10000.0d };
            double saldo = (double) JOptionPane.showInputDialog(null, "Qual è il bilancio iniziale?", "Banca",
                    JOptionPane.QUESTION_MESSAGE, null, saldi, saldi[0]);
            ce = new ContoEsteso(numero, saldo);
        } else {
            ce = new ContoEsteso(numero);
        }
        
        int esisteFido = JOptionPane.showConfirmDialog(null, "Vuoi cambiare il fido?", "Banca", JOptionPane.YES_NO_OPTION);
        if(esisteFido == JOptionPane.YES_OPTION) {
            Double fidi[] = { 1000.0d, 2000.0d, 5000.0d, 10000.0d };
            double fido = (double) JOptionPane.showInputDialog(null, "Qual è il fido da applicare?", "Banca",
                    JOptionPane.QUESTION_MESSAGE, null, fidi, fidi[0]);
            ce.setFido(fido);
        }
        
        banca.create(ce);
    }
    
    private static int get(Banca banca) {
        int numConti = banca.size();
        if(numConti == 0)
            return -1;
        
        String contiPresenti[] = new String[numConti];
        for(int i = 0; i < numConti; i++)
            contiPresenti[i] = banca.read(i).getNumeroConto();
        
        String numeroConto = (String) JOptionPane.showInputDialog(null, "Quale conto?", "Banca",
                JOptionPane.QUESTION_MESSAGE, null, contiPresenti, contiPresenti[0]);
        
        if(numeroConto != null) {
            int index = -1;
            for(int i = 0; i < numConti; i++)
                if(numeroConto.equals(banca.read(i).getNumeroConto())) {
                    index = i;
                    break;
                }
            
            return index;
        }
        
        return -1;
    }
    
    private static void set(Banca banca) {
        int index = get(banca);
        if(index == -1)
            return;
        
        ContoBancario newCB;
        
        ContoBancario oldCB = banca.read(index);
        String numeroConto = oldCB.getNumeroConto();
        double saldo = oldCB.getSaldo();
        
        int cambioNumeroConto = JOptionPane.showConfirmDialog(null, "Vuoi cambiare il numero di conto?", "Banca", JOptionPane.YES_NO_OPTION);
        if(cambioNumeroConto == JOptionPane.YES_OPTION)
            numeroConto = JOptionPane.showInputDialog(null, "Qual è il nuovo numero di conto?", "Banca", JOptionPane.QUESTION_MESSAGE);
        
        int cambioSaldo = JOptionPane.showConfirmDialog(null, "Vuoi cambiare il bilancio?", "Banca", JOptionPane.YES_NO_OPTION);
        if(cambioSaldo == JOptionPane.YES_OPTION) {
            Double saldi[] = { 1000.0d, 2000.0d, 5000.0d, 10000.0d };
            saldo = (double) JOptionPane.showInputDialog(null, "Qual è il nuovo bilancio?", "Banca",
                    JOptionPane.QUESTION_MESSAGE, null, saldi, saldi[0]);
        }
        
        if(oldCB instanceof ContoEsteso) {
            double fido = ((ContoEsteso) oldCB).getFido();
            int cambioFido = JOptionPane.showConfirmDialog(null, "Vuoi cambiare il fido?", "Banca", JOptionPane.YES_NO_OPTION);
            if(cambioFido == JOptionPane.YES_OPTION) {
                Double fidi[] = { 1000.0d, 2000.0d, 5000.0d, 10000.0d };
                fido = (double) JOptionPane.showInputDialog(null, "Qual è il nuovo fido?", "Banca",
                        JOptionPane.QUESTION_MESSAGE, null, fidi, fidi[0]);
            }
            newCB = new ContoEsteso(numeroConto, saldo, fido);
        } else
            newCB = new ContoBancario(numeroConto, saldo);
        
        banca.update(index, newCB);
        
        StringBuilder builder = new StringBuilder();
        builder.append("Il conto\n\n");
        builder.append(oldCB);
        builder.append("\n\nè stato aggiornato con\n\n");
        builder.append(newCB);
        
        JOptionPane.showMessageDialog(null, builder, "Banca", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private static void remove(Banca banca) {
        int index = get(banca);
        if(index == -1)
            return;
        
        ContoBancario oldCB = banca.delete(index);
        
        StringBuilder builder = new StringBuilder();
        builder.append("Il conto\n\n");
        builder.append(oldCB);
        builder.append("\n\nè stato rimosso");
        
        JOptionPane.showMessageDialog(null, builder, "Banca", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private static void show(Banca banca) {
        StringBuilder builder = new StringBuilder();
        builder.append("Conti presenti: ").append(banca.size());
        builder.append("\n\n").append(banca);
        
        JOptionPane.showMessageDialog(null, builder, "Banca", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private static void dep(Banca banca) {
        int index = get(banca);
        if(index == -1)
            return;
        
        ContoBancario cb = banca.read(index);
        
        Double somme[] = { 100.0d, 200.0d, 500.0d, 1000.0d };
        double somma = (double) JOptionPane.showInputDialog(null, "Quanto vuoi depositare?", "Banca",
                JOptionPane.QUESTION_MESSAGE, null, somme, somme[0]);
        
        cb.deposita(somma);
    }
    
    private static void pre(Banca banca) {
        int index = get(banca);
        if(index == -1)
            return;
        
        ContoBancario cb = banca.read(index);
        
        Double somme[] = { 100.0d, 200.0d, 500.0d, 1000.0d };
        double somma = (double) JOptionPane.showInputDialog(null, "Quanto vuoi prelevare?", "Banca",
                JOptionPane.QUESTION_MESSAGE, null, somme, somme[0]);
        
        boolean esito = cb.preleva(somma);
        if(esito)
            JOptionPane.showMessageDialog(null, "Prelievo effettuato", "Banca", JOptionPane.WARNING_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Prelievo non effettuato", "Banca", JOptionPane.ERROR_MESSAGE);
    }
}
