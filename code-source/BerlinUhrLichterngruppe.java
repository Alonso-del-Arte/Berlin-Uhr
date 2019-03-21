/*
 * Copyright (C) 2019 Alonso del Arte
 *
 * This program is free software: you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software 
 * Foundation, either version 3 of the License, or (at your option) any later 
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more 
 * details.
 *
 * You should have received a copy of the GNU General Public License along with 
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package berlinuhr;

import java.awt.Color;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Alonso del Arte
 */
public class BerlinUhrLichterngruppe {
    
    private LocalTime currUhr;
    
    protected BerlinUhrLicht rundeAnzeige = new BerlinUhrLicht(Color.ORANGE);
    
    protected BerlinUhrLicht[] funfStundenZeile = new BerlinUhrLicht[4];
    protected BerlinUhrLicht[] eineStundeZeile = new BerlinUhrLicht[4];
    
    protected BerlinUhrLicht[] funfMinutenZeile = new BerlinUhrLicht[11];
    protected BerlinUhrLicht[] eineMinuteZeile = new BerlinUhrLicht[4];
    
    public void setTime(LocalTime time) {
        this.currUhr = time;
    }
    
    public LocalTime getTime() {
        return this.currUhr;
    }
    
    public void decrementHour() {
        //
    }
    
    public void incrementHour() {
        //
    }
    
    public void decrementMinute() {
        //
    }
    
    public void incrementMinute() {
        //
    }
    
    public void decrementSecond() {
        //
    }
    
    public void incrementSecond() {
        //
    }
    
    public BerlinUhrLichterngruppe(LocalTime time) {
        this.currUhr = time;
        this.funfStundenZeile[0] = new BerlinUhrLicht(Color.RED);
        this.funfStundenZeile[1] = new BerlinUhrLicht(Color.RED);
        this.funfStundenZeile[2] = new BerlinUhrLicht(Color.RED);
        this.funfStundenZeile[3] = new BerlinUhrLicht(Color.RED);
        this.eineStundeZeile[0] = new BerlinUhrLicht(Color.RED);
        this.eineStundeZeile[1] = new BerlinUhrLicht(Color.RED);
        this.eineStundeZeile[2] = new BerlinUhrLicht(Color.RED);
        this.eineStundeZeile[3] = new BerlinUhrLicht(Color.RED);
        this.funfMinutenZeile[0] = new BerlinUhrLicht(Color.ORANGE);
        this.funfMinutenZeile[1] = new BerlinUhrLicht(Color.ORANGE);
        this.funfMinutenZeile[2] = new BerlinUhrLicht(Color.RED);
        this.funfMinutenZeile[3] = new BerlinUhrLicht(Color.ORANGE);
        this.funfMinutenZeile[4] = new BerlinUhrLicht(Color.ORANGE);
        this.funfMinutenZeile[5] = new BerlinUhrLicht(Color.RED);
        this.funfMinutenZeile[6] = new BerlinUhrLicht(Color.ORANGE);
        this.funfMinutenZeile[7] = new BerlinUhrLicht(Color.ORANGE);
        this.funfMinutenZeile[8] = new BerlinUhrLicht(Color.RED);
        this.funfMinutenZeile[9] = new BerlinUhrLicht(Color.ORANGE);
        this.funfMinutenZeile[10] = new BerlinUhrLicht(Color.ORANGE);
        this.eineMinuteZeile[0] = new BerlinUhrLicht(Color.ORANGE);
        this.eineMinuteZeile[1] = new BerlinUhrLicht(Color.ORANGE);
        this.eineMinuteZeile[2] = new BerlinUhrLicht(Color.ORANGE);
        this.eineMinuteZeile[3] = new BerlinUhrLicht(Color.ORANGE);
    }
    
}
