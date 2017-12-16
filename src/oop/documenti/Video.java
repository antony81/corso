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

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio
 */
public class Video extends DocumentoDigitale implements Riproducibile {
    
    private double framerate;
    
    public Video(int qualita, boolean integrita, int dimensione, String pathName, double framerate) {
        super(qualita, integrita, dimensione, pathName);
        
        this.framerate = framerate;
    }
    
    public double getFramerate() {
        return framerate;
    }
    
    public void setFramerate(double framerate) {
        this.framerate = framerate;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", framerate: ").append(framerate);
        
        return builder.toString();
    }
    
    @Override
    public double percentualeInfo() {
        return (isIntegrita() ? getQualita()-getQualita()*100/framerate : 0.0);
    }
    
    @Override
    public void play() {
        ProcessBuilder builder = new ProcessBuilder("\"\\Program Files\\VideoLAN\\VLC\\vlc.exe\"", "C:\\dev\\media\\VM.mp4");
        try {
            Process process = builder.start();
            int code = process.waitFor();
            Logger.getLogger(Video.class.getName()).log(Level.INFO, "exit with code {0}", code);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Video.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void pause() {
        System.out.println("Il video è in pausa!");
    }
    
    @Override
    public void stop() {
        System.out.println("Riproduzione terminata!");
    }
    
}
