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

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Antonio
 */
public class Audio extends DocumentoDigitale implements Riproducibile {
    
    private int bitrate;
    
    public Audio(int qualita, boolean integrita, int dimensione, String pathName, int bitrate) {
        super(qualita, integrita, dimensione, pathName);
        
        this.bitrate = bitrate;
    }
    
    public int getBitrate() {
        return bitrate;
    }
    
    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", bitrate: ").append(bitrate);
        
        return builder.toString();
    }
    
    @Override
    public double percentualeInfo() {
        return (isIntegrita() ? getQualita()-getQualita()*100/bitrate : 0.0);
    }
    
    @Override
    public void play() {
        try {
            File file = new File(getPathName());
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
            clip.open(inputStream);
            clip.start();
            SwingUtilities.invokeLater(() -> {
                JOptionPane.showMessageDialog(null, "Close to exit!");
            });
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void pause() {
        System.out.println("Pause!");
    }
    
    @Override
    public void stop() {
        System.out.println("Stop!");
    }
    
}
