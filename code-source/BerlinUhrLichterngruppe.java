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
import java.util.Arrays;
import java.util.Objects;

/**
 * Represents a group of lights for a given time to be displayed on the 
 * Berlin-Uhr (Berlin Clock). Essentially it groups 24 instances of {@link 
 * BerlinUhrLicht} into three arrays with one light (the seconds blinker) 
 * "loose."
 * @author Alonso del Arte
 */
public class BerlinUhrLichterngruppe implements Comparable<BerlinUhrLichterngruppe> {
    
    private LocalTime currTime;
    
    protected BerlinUhrLicht rundeAnzeige = new BerlinUhrLicht(Color.ORANGE);
    
    protected BerlinUhrLicht[] funfStundenZeile = new BerlinUhrLicht[4];
    protected BerlinUhrLicht[] eineStundeZeile = new BerlinUhrLicht[4];
    
    protected BerlinUhrLicht[] funfMinutenZeile = new BerlinUhrLicht[11];
    protected BerlinUhrLicht[] eineMinuteZeile = new BerlinUhrLicht[4];
    
    private int oneHourIndex, oneMinuteIndex;
    
    private void reviewLights() {
        int count = this.currTime.getHour();
        int singlesBlock = count % 5;
        int multiplesBlock = (count - singlesBlock)/5;
        int currIndex = 0;
        while (multiplesBlock > 0) {
            if (!this.funfStundenZeile[currIndex].getStatus()) {
                this.funfStundenZeile[currIndex].toggleStatus(); // Turn on
            }
            currIndex++;
            multiplesBlock--;
        }
        for (int mhoff = currIndex; mhoff < 4; mhoff++) {
            if (this.funfStundenZeile[mhoff].getStatus()) {
                this.funfStundenZeile[mhoff].toggleStatus(); // Turn off
            }
        }
//        this.fiveHourIndex = currIndex - 1;
        currIndex = 0;
        while (singlesBlock > 0) {
            if (!this.eineStundeZeile[currIndex].getStatus()) {
                this.eineStundeZeile[currIndex].toggleStatus();
            }
            currIndex++;
            singlesBlock--;
        }
        for (int shoff = currIndex; shoff < 4; shoff++) {
            if (this.eineStundeZeile[shoff].getStatus()) {
                this.eineStundeZeile[shoff].toggleStatus();
            }
        }
        this.oneHourIndex = currIndex - 1;
        currIndex = 0;
        count = this.currTime.getMinute();
        singlesBlock = count % 5;
        multiplesBlock = (count - singlesBlock)/5;
        while (multiplesBlock > 0) {
            if (!this.funfMinutenZeile[currIndex].getStatus()) {
                this.funfMinutenZeile[currIndex].toggleStatus();
            }
            currIndex++;
            multiplesBlock--;
        }
        for (int mmoff = currIndex; mmoff < 11; mmoff++) {
            if (this.funfMinutenZeile[mmoff].getStatus()) {
                this.funfMinutenZeile[mmoff].toggleStatus();
            }
        }
//        this.fiveMinuteIndex = currIndex - 1;
        currIndex = 0;
        while (singlesBlock > 0) {
            if (!this.eineMinuteZeile[currIndex].getStatus()) {
                this.eineMinuteZeile[currIndex].toggleStatus();
            }
            currIndex++;
            singlesBlock--;
        }
        for (int smoff = currIndex; smoff < 4; smoff++) {
            if (this.eineMinuteZeile[smoff].getStatus()) {
                this.eineMinuteZeile[smoff].toggleStatus();
            }
        }
        this.oneMinuteIndex = currIndex - 1;
        if (this.currTime.getSecond() % 2 == 1) {
            if (!this.rundeAnzeige.getStatus()) {
                this.rundeAnzeige.toggleStatus();
            }
        } else {
            if (this.rundeAnzeige.getStatus()) {
                this.rundeAnzeige.toggleStatus();
            }
        }
    }
    
    /**
     * Toggles lights on and off to reflect a different time.
     * @param time The time to change to. If it's the exact same time as before, 
     * nothing happens.
     */
    public void setTime(LocalTime time) {
        if (!this.currTime.equals(time)) {
            this.currTime = time;
            this.reviewLights();
        }
    }
    
    /**
     * Retrieves the time object represented by this light group.
     * @return The time object held by this light group. May or may not be the 
     * same time this light group was constructed with.
     */
    public LocalTime getTime() {
        return this.currTime;
    }
    
    /**
     * Decrements the time represented by this light group by one hour. Switches 
     * one or more lights off or on as needed.
     */
    public void decrementHour() {
        this.currTime = this.currTime.minusHours(1);
        if (this.oneHourIndex == -1) {
            this.reviewLights();
        } else {
            this.eineStundeZeile[this.oneHourIndex].toggleStatus();
            this.oneHourIndex--;
        }
    }
    
    /**
     * Increments the time represented by this light group by one hour. Switches 
     * one or more lights on or off as needed.
     */
    public void incrementHour() {
        this.currTime = this.currTime.plusHours(1);
        if (this.oneHourIndex == 3 || this.currTime.getHour() == 0) {
            this.reviewLights();
        } else {
            this.oneHourIndex++;
            this.eineStundeZeile[this.oneHourIndex].toggleStatus();
        }
    }
    
    /**
     * Decrements the time represented by this light group by one minute. 
     * Switches one or more lights off or on as needed.
     */
    public void decrementMinute() {
        this.currTime = this.currTime.minusMinutes(1);
        if (this.oneMinuteIndex == -1) {
            this.reviewLights();
        } else {
            this.eineMinuteZeile[this.oneMinuteIndex].toggleStatus();
            this.oneMinuteIndex--;
        }
    }
    
    /**
     * Increments the time represented by this light group by one minute. 
     * Switches one or more lights on or off as needed.
     */
    public void incrementMinute() {
        this.currTime = this.currTime.plusMinutes(1);
        if (this.oneMinuteIndex == 3) {
            this.reviewLights();
        } else {
            this.oneMinuteIndex++;
            this.eineMinuteZeile[this.oneMinuteIndex].toggleStatus();
        }
    }
    
    /**
     * Decrements the time represented by this light group by one second. In 
     * most cases this will mean toggling the seconds blinker, but if the 
     * minutes and/or lights need to be changed as well, that will be taken care 
     * of as well.
     */
    public void decrementSecond() {
        this.currTime = this.currTime.minusSeconds(1);
        this.rundeAnzeige.toggleStatus();
        if (this.currTime.getSecond() == 59) {
            this.reviewLights();
        }
    }
    
    /**
     * Increments the time represented by this light group by one second. In 
     * most cases this will mean toggling the seconds blinker, but if the 
     * minutes and/or lights need to be changed as well, that will be taken care 
     * of as well.
     */
    public void incrementSecond() {
        this.currTime = this.currTime.plusSeconds(1);
        this.rundeAnzeige.toggleStatus();
        if (this.currTime.getSecond() == 0) {
            this.reviewLights();
        }
    }
    
    /**
     * Gives a textual representation of this light group. Relies on 
     * <code>LocalTime.toString()</code>.
     * @return The word "Lichtern" followed by the time represented by this 
     * light group. For example, for a light group representing noon, this would 
     * be "Lichtern 12:00".
     */
    @Override
    public String toString() {
        return "Lichtern " + this.currTime.toString();
    }
    
    /**
     * Indicates whether this light group is equal to another object. Comparing 
     * to another light group, it might be sufficient for both light groups to 
     * have the same hours and minutes.
     * @param obj The object to compare to.
     * @return Certainly false if <code>obj</code> is not a light group object. 
     * Definitely true if <code>obj</code> is a light group with the same exact 
     * time down to the milliseconds. However, it will also be true if the two 
     * light groups represent times that differ in the seconds but with the same 
     * parity. For example, 12:45:03 would be considered equal to 12:45:05, 
     * 12:45:07, etc., since they would have the same lights on and the same 
     * lights off. None of those would be considered equal to 12:45:04, 
     * 12:45:06, etc., since the seconds blinker would be in a different state.
     */
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
        final BerlinUhrLichterngruppe other = (BerlinUhrLichterngruppe) obj;
        if (!Objects.equals(this.rundeAnzeige, other.rundeAnzeige)) {
            return false;
        }
        if (!Arrays.deepEquals(this.funfStundenZeile, other.funfStundenZeile)) {
            return false;
        }
        if (!Arrays.deepEquals(this.eineStundeZeile, other.eineStundeZeile)) {
            return false;
        }
        if (!Arrays.deepEquals(this.funfMinutenZeile, other.funfMinutenZeile)) {
            return false;
        }
        return Arrays.deepEquals(this.eineMinuteZeile, other.eineMinuteZeile);
    }
    
    /**
     * Returns a hash code for this light group. Guaranteed to be unique. Even 
     * though there are 86400 seconds in a day, there are only 2880 valid states 
     * for the Berlin Clock.
     * @return A number between 0 and 16711679, corresponding to the on or off 
     * status of the lights. For example, for a light group representing 12:00, 
     * this would be 13369344; for a light group representing 23:59:59, this 
     * would be 16711679. This is a lot more than 2880, but a lot of the numbers 
     * between 0 and 16777215 don't correspond to valid states of the Berlin 
     * Clock, such as 16711680, which would be for 24:00, but that's represented 
     * as 0:00 instead.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        for (int mh = 0; mh < 4; mh++) {
            hash *= 2;
            if (this.funfStundenZeile[mh].getStatus()) {
                hash++;
            }
        }
        for (int sh = 0; sh < 4; sh++) {
            hash *= 2;
            if (this.eineStundeZeile[sh].getStatus()) {
                hash++;
            }
        }
        for (int mm = 0; mm < 11; mm++) {
            hash *= 2;
            if (this.funfMinutenZeile[mm].getStatus()) {
                hash++;
            }
        }
        for (int sm = 0; sm < 4; sm++) {
            hash *= 2;
            if (this.eineMinuteZeile[sm].getStatus()) {
                hash++;
            }
        }
        hash *= 2;
        if (this.rundeAnzeige.getStatus()) {
            hash++;
        }
        return hash;
    }

    /**
     * Compares this light group to another light group, and determines if one 
     * is less than, equal to or greater than the other. The times are assumed 
     * to be in the same day. If the times represented by the light groups 
     * differ only in the seconds, they might be considered equal.
     * @param other The light group to compare this light group to. For example, 
     * light groups representing 12:00, 12:45:03, 12:45:04, 12:45:05 and 13:28.
     * @return &minus;1 if this light group represents a time before the other 
     * light group's time; 0 if the light groups represent the same time or they 
     * represent times that differ only in the seconds but the seconds have the 
     * same parity; or 1 if this light group represents a time after the other 
     * light group's time. For example, if this light group is for 12:45:03, the 
     * comparison to 12:00 would be 1 since 12:45:03 is after 12:00; comparison 
     * to 12:45:03 would be 0 since they are equal; comparison to 12:45:04 would 
     * be &minus;1 since that's one second later; however, comparison to 
     * 12:45:05 would be 0 since they have the same pattern of lights; and 
     * comparison to 13:28 would be &minus;1 since that's a later time.
     */
    @Override
    public int compareTo(BerlinUhrLichterngruppe other) {
        int diff = this.hashCode() - other.hashCode();
        if (diff < 0) {
            return -1;
        }
        if (diff > 0) {
            return 1;
        }
        return 0;
    }
    
    /**
     * Constructor.
     * @param time The time according to which to set the lights initially.
     */
    public BerlinUhrLichterngruppe(LocalTime time) {
        this.currTime = time;
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
        int count = this.currTime.getHour();
        int singlesBlock = count % 5;
        int multiplesBlock = (count - singlesBlock)/5;
        int currIndex = 0;
        while (multiplesBlock > 0) {
            this.funfStundenZeile[currIndex].toggleStatus();
            currIndex++;
            multiplesBlock--;
        }
//        this.fiveHourIndex = currIndex - 1;
        currIndex = 0;
        while (singlesBlock > 0) {
            this.eineStundeZeile[currIndex].toggleStatus();
            currIndex++;
            singlesBlock--;
        }
        this.oneHourIndex = currIndex - 1;
        currIndex = 0;
        count = this.currTime.getMinute();
        singlesBlock = count % 5;
        multiplesBlock = (count - singlesBlock)/5;
        while (multiplesBlock > 0) {
            this.funfMinutenZeile[currIndex].toggleStatus();
            currIndex++;
            multiplesBlock--;
        }
//        this.fiveMinuteIndex = currIndex - 1;
        currIndex = 0;
        while (singlesBlock > 0) {
            this.eineMinuteZeile[currIndex].toggleStatus();
            currIndex++;
            singlesBlock--;
        }
        this.oneMinuteIndex = currIndex - 1;
        if (this.currTime.getSecond() % 2 == 1) {
            this.rundeAnzeige.toggleStatus();
        }
    }
    
}
