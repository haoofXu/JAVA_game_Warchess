
import java.awt.*;

import javax.swing.ImageIcon;

public class Healer extends Actor {

   public Healer(char c, int tm, Image d, Image d2, Image l, Image l2, Image r, Image r2, Image u, Image u2) {
      super(c, tm, d, d2, l, l2, r, r2, u, u2);
   }

   public void setAction(Stage stage, Prop[] props, Actor[] cast) {
      Actor attacker1 = null;
      int count =0;
      // find an attacker or someone to heal
      for (int i = 0;i < 8;i++) {
         Actor a = cast[i];
         for (int j=0;j<8;j++){
        	 Actor b = cast[j];
             if (a.alive() && near(a) != "") {
                if (attacker1 == null) attacker1 = a;
                   break;
             }
             if (a.getTeam() == getTeam()) {

            	 if(!a.alive()){
            		 count ++;
            	 }
            	 if(a.alive()){
            		 if (a.getIcon() == 'k' && a.getHitPoints()!=2) {setAction(gotoAction(a));}
                	 else if (a.getIcon() == 'w'&& a.getHitPoints()!=2) {setAction(gotoAction(a));}
                	 else if (a.getIcon() == 'a') {setAction(gotoAction(a));}
                     break;
            	 }
             }
         }
      }
      if (attacker1 != null) {
    	  System.out.println("healer attacking " + attacker1.getMyID());
          if (attacker1.getTeam() != getTeam())
             setAction("a" + near(attacker1));
          else setAction("h" + near(attacker1));
      }
      else {
         Boolean healing = false;
         Actor a = null;
         //find someone to heal
         for (int i = 0;i < 8;i++) {
            Actor b = cast[i];
            if (b.getTeam() == getTeam() && b.getHitPoints() <= 0) {
               a = b;
               healing = true;
               break;
            }
         }
         if (healing) {
            String direction = near(a);
            if (direction == "") setAction(gotoAction(a));
            else setAction("h" + near(a));
         }
      }
   }
}
