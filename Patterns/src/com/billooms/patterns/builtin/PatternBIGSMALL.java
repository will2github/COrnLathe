package com.billooms.patterns.builtin;

import com.billooms.patterns.BasicPattern;
import com.billooms.patterns.Pattern;
import org.openide.util.lookup.ServiceProvider;

/**
 * Alternate big and small lobes of a flower
 *
 * @author Bill Ooms. Copyright 2015 Studio of Bill Ooms. All rights reserved.
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
@ServiceProvider(service = Pattern.class, position = 80)
public class PatternBIGSMALL extends BasicPattern {

  // this pattern uses the FLOWER pattern
  private final Pattern flower = new PatternFLOWER();

  /**
   * Create a new BIGSMALL
   */
  public PatternBIGSMALL() {
    super("BigSmall");
    needsRepeat = true;
    minRepeat = 3;
  }

  /**
   * Get a normalized value (in the range of 0 to 1) for the given normalized
   * input (also in the range of 0 to 1).
   *
   * @param n input value (in the range of 0.0 to 1.0)
   * @param r pattern repeat
   * @return normalized pattern value (in the range 0.0 to 1.0)
   */
  @Override
  public double getValue(double n, int r) {
    // Make sure nn is in the range 0.0 to 1.0
    double nn = n;
    if ((nn > 1.0) || (nn < 0.0)) {
      nn = nn - Math.floor(nn);
    }
    // Make sure r is at least the minimum
    int rr = Math.max(r, minRepeat);
    double z;
    if (nn < 1.0 / 3.0) {
      z = flower.getValue(nn * 3.0, rr * 3);	// small Flower for 1/3
    } else {
      z = flower.getValue((nn - 1.0 / 3.0) * 3.0 / 2.0, rr * 3 / 2);	// big flower for 2/3
    }
    return z;
  }
}
