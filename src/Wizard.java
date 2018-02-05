
import java.awt.*;

import javax.swing.ImageIcon;

public class Wizard extends Actor {

   public Wizard(char c, int tm, Image d, Image d2, Image l, Image l2, Image r, Image r2, Image u, Image u2) {
      super(c, tm, d, d2, l, l2, r, r2, u, u2);

   fireBallFired[1] = false;  // needed because the same code is being used
   fireBallFired[2] = false;  // for both knights 
   }
   public static Boolean[] fireBallFired = new Boolean[3];


   private String near9(Actor a) {
      int dR = dRow(a);
      int dC = dCol(a);
      int r = dR;
      int c = dC;
      String dr;
      String dc;
      if (r > 0) dr = "d";
      else dr = "u";
      if (c > 0) dc = "r";
      else dc = "l";
      if (Math.abs(r) <= 9 && Math.abs(c) <= 9) {
         return (String.valueOf(Math.abs(r)) + dr + String.valueOf(Math.abs(c)) + dc);
      }
      return "";
   }

   public void setAction(Stage stage, Prop[] props, Actor[] cast) {
	  int count = 0;
      Actor attacker1 = null;
      Actor a;
      // find an attacker
      for (int i = 7;i >= 0;i--) {
         a = cast[i];
         if ((a.alive() && a.getTeam() != getTeam()) && near9(a) != "") {
            if (attacker1 == null) attacker1 = a;
               break;
         }
         if (a.getTeam() == getTeam()) {
        	 {
        		 setAction(gotoAction(a));
        	 }
        	 break;
         }
         if ((a.alive() && a.getTeam() == getTeam()) && a.getHitPoints() <= 1) {
        	 if (near9(a) != "") {setAction(gotoAction(a));}
             count ++;
         }
      }
      if (attacker1 != null && !fireBallFired[getTeam()] && (count == 4||this.getHitPoints()<=2)) {
         setAction("f" + near9(attacker1));
         fireBallFired[getTeam()] = true;
      }
   }
}
