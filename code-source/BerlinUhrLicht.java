/*
 * Copyright (C) 2019 Alonso del Arte
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package berlinuhr;

import java.awt.Color;

/**
 *
 * @author Alonso del Arte
 */
public class BerlinUhrLicht {
    
    private boolean status;
    
    private final Color color;
    
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
     * Gets the color of this light when it is on.
     * @return Should be either <code>Color.RED</code> or 
     * <code>Color.ORANGE</code> regardless of whether the light is on or off.
     */
    public Color getColor() {
        return this.color;
    }
    
    public BerlinUhrLicht(Color color) {
        this.status = false;
        this.color = color;
    }
    
}
