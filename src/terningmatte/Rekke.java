/*
 * Copyright (C) 2016 Arne Hårseth
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

package terningmatte;

/**
 *
 * @author Arne Hårseth
 */
public class Rekke {
    private static final int lengde=9;
    public boolean[] rekke;

    /**
     * Rekkeobjekt for lagring av terningkast.
     * Initieres med usann.
     */
    public Rekke() {
            rekke=new boolean[lengde];
            for(int i=0; i<(lengde-1); i++) {
               rekke[i]=false;
            }
            
    }
    
    /**
     *
     * @param posisjon  Sett sann i gitt posisjon (1-12)
     * @throws RekkeException hvis posisjon > lengde
     */
    public void sett(int posisjon) throws RekkeException {
        if (posisjon > lengde)
            throw new RekkeException();
        rekke[posisjon-1]=true;
    }
    
    /**
     *
     * @param posisjon
     * @return Returnerer om posisjon er satt (sann/usann)
     */
    public boolean erSatt(int posisjon) {
        return rekke[posisjon-1];
    }
    
    /**
     * SKriver ut rekka på kommandolinja.
     */
    public void skrivRekke() {
        for(int i=1; i<=lengde; i++) {
               System.out.printf("%2d", i); 
               System.out.print(" ");
            }
        System.out.println();
        System.out.print(" ");
        for(int i=0; i<lengde; i++) {
               if (rekke[i])
                       System.out.print("X");
               else
                   System.out.print("0");
               System.out.print("  ");
            }
        System.out.println();
    }
}

