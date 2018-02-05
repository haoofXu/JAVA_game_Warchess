
import java.awt.*;

import javax.swing.ImageIcon;

public class Knight extends Actor {

   public Knight(char c, int tm, Image d, Image d2, Image l, Image l2, Image r, Image r2, Image u, Image u2) {
      super(c, tm, d, d2, l, l2, r, r2, u, u2);
   }

   public void setAction(Stage stage, Prop[] props, Actor[] cast) {
      Actor attacker1 = null;
      // find an attacker
      for (int i = 0;i < 8;i++) {
         Actor a = cast[i];
         if ((a.alive() && a.getTeam() != getTeam()) && near(a) != "") {
            attacker1 = a;
            break;
            }
         if(a.alive() && a.getHitPoints()<2) {
        	 if (a.getTeam() != getTeam()){ 
        		 setAction(gotoAction(a)); 
        	 }
        	 else if (a.getTeam() == getTeam()){
        		 if (a.getIcon()=='w')
        			 setAction(gotoAction(a));
        	 }
         }
         
      }
      if (attacker1 != null) {
         if (attacker1.getIcon() == 'k') {
            int i = (int)(Math.random()*4);
            String directions = "udlr";
            setAction("m" + directions.substring(i,i+1));
         }
         else setAction("a" + near(attacker1));
      }
      else {  // Is there a Knight nearby?
          Boolean knightNearBy = false;
          for (int i = 0; i < 8; i++) {
               Actor a = cast[i];
               if (a.alive() &&
                   a.getIcon() == 'k' && 
                   ((Math.abs(dRow(a)) == 2 && dCol(a) == 0) ||
                    (Math.abs(dCol(a)) == 2 && dRow(a) == 0))) {
                     int j = (int)(Math.random()*4);
                     String directions = "udlr";
                     setAction("m" + directions.substring(j,j+1));
                     knightNearBy = true;
                     break;
               }
          }
          if (!knightNearBy) {
             knightNearBy = true;
             for (int i = 0; i < 8; i++) {
                  Actor a = cast[i];
                  if (a.alive() && a.getTeam() != getTeam() &&
                      a.getIcon() != 'k')
                     {
                        setAction(gotoAction(a));
                        knightNearBy = false;
                        break;
                     }
             }
             if (knightNearBy) setAction("  ");
             
          }
      }
   }
}
