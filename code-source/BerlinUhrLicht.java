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
import java.util.Objects;

/**
 * Defines an object to represent a single light in a Berlin clock.
 * @author Alonso del Arte
 */
public class BerlinUhrLicht {
    
    private boolean status;
    
    private final Color color;
    
    /**
     * Switches the light on or off.
     */
    public void toggleStatus() {
        this.status = !this.status;
    }
    
    /**
     * Gets the status of this light, whether it's on or off.
     * @return True if the light is on, false if it is off.
     */
    public boolean getStatus() {
        return this.status;
    }
    
    /**
     * Gets the color of this light when it is on. Ought to be either 
     * <code>Color.RED</code> or  <code>Color.ORANGE</code> for an 
     * implementation of the Berlin clock using the original color scheme.
     * @return The <code>java.awt.Color</code> with which this object was 
     * constructed.
     */
    public Color getColor() {
        return this.color;
    }
    
    /**
     * Gives a text representation of this light, indicating whether it's on or 
     * off, and its color. The text is in German.
     * @return Either the word "eingeschaltet" if the light is on, or the word 
     * "ausgeschaltet" if the light is off, followed by " Licht " and then
     * <code>Color.toString()</code> for this light's color. For example, for a 
     * red light that is on, this might be "eingeschaltet Licht 
     * java.awt.Color[r=255,g=0,b=0]"; for a green light that is off, this might 
     * be "ausgeschaltet Licht java.awt.Color[r=0,g=255,b=0]".
     */
    @Override
    public String toString() {
        String lightString = "geschaltet Licht " + this.color.toString();
        if (this.status) {
            lightString = "ein" + lightString;
        } else {
            lightString = "aus" + lightString;
        }
        return lightString;
    }
    
    /**
     * Indicates whether this light is equal to another object.
     * @param obj The object to compare to.
     * @return True if this light is equal to <code>obj</code>, false otherwise. 
     * For two lights to register as equal, they must both be on or both be off, 
     * and they must be of exactly the same color.
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
        final BerlinUhrLicht other = (BerlinUhrLicht) obj;
        if (this.status != other.status) {
            return false;
        }
        return Objects.equals(this.color, other.color);
    }
    
    /**
     * Gives a hash code for this light. The hash code is based on the color's 
     * hash code, though the color's alpha is ignored.
     * @return A positive integer if the light is on, a negative integer if the 
     * light is off. For example, for a green light that is on, this might be 
     * 65280; for a green light that is off, this might be &minus;65280.
     */
    @Override
    public int hashCode() {
        int hash = this.color.getBlue();
        hash += (256 * this.color.getGreen());
        hash += (65536 * this.color.getRed());
        if (!this.status) {
            hash *= -1;
        }
        return hash;
    }

    /**
     * Constructor.
     * @param color A color for when the light is on. Preferably either 
     * <code>Color.RED</code> or  <code>Color.ORANGE</code> for an 
     * implementation of the Berlin clock using the original color scheme.
     */
    public BerlinUhrLicht(Color color) {
        this.status = false;
        this.color = color;
    }
    
}
