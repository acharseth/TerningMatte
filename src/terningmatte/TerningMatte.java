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
import terningspill.*;

/**
 * Terningspill for oppøving av regneferdigheter.
 * 
 * @author Arne Hårseth
 * 
 */
public class TerningMatte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("TerningMatte");
        System.out.println("************");
        System.out.println();
        System.out.println("Fyll opp rekken ved å velge hvilke(n) terning(er) du vil bruke");
        System.out.println();
        Terning[] t;
	Integer trekk=0;
        Rekke r=new Rekke();
        t=new Terning[2];
        t[0]=new Terning();
        t[1]=new Terning();
        int svar=0;
        boolean ferdig=false;
        while (!ferdig) {
    	    trekk++;        
            System.out.println("Rekke:");
            r.skrivRekke();
	    System.out.println("Trekk nr:"+trekk);
            System.out.println("Terning 1: "+t[0].giVerdi());
            System.out.println("Terning 2: "+t[1].giVerdi());
            System.out.println("Velg:");
            System.out.println("0: Ingen");
            System.out.println("1: Terning 1");
            System.out.println("2: Terning 2");
            System.out.println("3: Begge (sum)");
            System.out.println("9: Avslutt");

            java.util.Scanner reader = new java.util.Scanner(System.in);  // Reading from System.in
            System.out.print("Valg (0-9): ");
            svar = reader.nextInt(); // Scans the next token of the input as an int.
            System.out.println();
            System.out.println("Du svarte: "+svar);
            try {
                switch (svar) {
                    case (0):
                        break;
                    case (1): 
                        r.sett(t[0].giVerdi()); 
                        break;
                    case (2):
                        r.sett(t[1].giVerdi());
                        break;
                    case (3):
                        r.sett(t[0].giVerdi()+t[1].giVerdi());
                        break;
                    case (9):
                        ferdig=true;
                        break;
                }
            }
            catch (RekkeUtenforException e) 
                { System.out.println("Utenfor rekke!"); }
            catch (RekkeOpptattException e)
                { System.out.println("Posisjon allerede fyllt");}
            if(r.erFull())
            {
                ferdig=true;
                System.out.println();
                r.skrivRekke();
                System.out.println("Gratulerer, rekken er full!");
                System.out.println("Du klarte det på " + trekk + " trekk");
            }
            else
            {
                t[0].kast();
                t[1].kast();
                System.out.println();
            }
        }
        
    }
    
}
