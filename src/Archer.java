
import java.awt.*;

import javax.swing.ImageIcon;

public class Archer extends Actor {

   public Archer(char c, int tm, Image d, Image d2, Image l, Image l2, Image r, Image r2, Image u, Image u2) {
      super(c, tm, d, d2, l, l2, r, r2, u, u2);
   }

   private String near4(Actor a) {
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
      if (r == 0) dr = dc;
      if (c == 0) dc = dr;
      if (Math.abs(r) <= 4 && Math.abs(c) <= 4 && (r==0 || c==0 || Math.abs(r)==Math.abs(c))) {
         return (dr + dc);
      }
      return "";
   }

   public void setAction(Stage stage, Prop[] props, Actor[] cast) {
      Actor a,b;
      for (int i=0;i<8;i++) {
         a = cast[i];
         if (a.alive() && a.getTeam() != getTeam() && near4(a) != "") {
            setAction("s" + near4(a));
            return;
         }

         if (a.alive() && a.getTeam() != getTeam()) {
        	 if (a.getIcon()=='w')
        		 setAction(gotoAction(a));
        	 if (a.getIcon()=='k')
        	 {
        	      for (int j=0;j<8;j++) {
        	         b = cast[j];
        	         if (b.getIcon()=='k'){
                		 setAction(gotoAction(b));
        	         }
        	      }
        	 }
             break;
         }
      }
      Actor attacker1 = null;
      // find an attacker
      for (int i = 0;i < 8;i++) {
         a = cast[i];
         if ((a.alive() && a.getTeam() != getTeam()) && near(a) != "") {
            if (attacker1 == null) attacker1 = a;
               break;
         }
      }
      if (attacker1 != null) {
         setAction("a" + near(attacker1));
      }
   }
}
