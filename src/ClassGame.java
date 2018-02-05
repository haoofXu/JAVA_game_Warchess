
import java.awt.*;

import javax.swing.ImageIcon;

public class ClassGame {
	
	private static Stage stage;
	private static Prop[] props = new Prop[10];
        private static Actor[] cast = new Actor[8];
        private static int[] newRow = new int[8];
	private static int[] newCol = new int[8];
	private static char[] cmd = new char[8];
	private static String[] cmd1 = new String[8];
	private int type = 1;
        private static int[] fireballCast = new int[3];
	
	private static ScreenManager screen = new ScreenManager();
	private static int width;
	private static int height;
	private Image bgImage;
        private static int tileSize = 30;
	
	private static final DisplayMode POSSIBLE_MODES[] = {
		//I don't know how, but it is automatically detecting the best possible resolution
    };

   private static int tileize(int x) { // change to a multiple of tile size
      return x - x%(tileSize);
   }

   private static void startGame() {
      stage = new Stage();
      tileSize = stage.getTileSize();
      for(int i=0; i<10; i++){
    	  props[i]=null;
      }
      fireballCast[1] = 0;
      fireballCast[2] = 0;
      System.out.println("height = " + height + " width = " + width);
      int center = (int) (height/2);
      props[0] = new Prop('p', new ImageIcon("Images/castleLeft.png").getImage(),1);
      props[0].setCol(0);
      props[0].setRow(10);
      props[1] = new Prop('p', new ImageIcon("Images/castleRignt.gif").getImage(),1);
      props[1].setCol(18);
      props[1].setRow(10);
      props[2] = new Prop('r',new ImageIcon("Images/smallRock.png").getImage(),1);
      props[2].setCol(8);
      props[2].setRow(6);
      props[3] = new Prop('r',new ImageIcon("Images/smallRock.png").getImage(),1);
      props[3].setCol(10);
      props[3].setRow(12);


      int spacing = tileize((int)(height/5));
      
      cast[0] = new Wizard('w', 0,
    		  new ImageIcon("Images/wizardDown.png").getImage(),
    		  new ImageIcon("Images/wizardDown.png").getImage(),
    		  new ImageIcon("Images/wizardDown.png").getImage(),
    		  new ImageIcon("Images/wizardDown.png").getImage(),
    		  new ImageIcon("Images/wizardDown.png").getImage(),
    		  new ImageIcon("Images/wizardDown.png").getImage(),
    		  new ImageIcon("Images/wizardDown.png").getImage(),
    		  new ImageIcon("Images/wizardDown.png").getImage());
      cast[0].setRow(4);
      cast[0].setCol(0);
      cast[0].setHitPoints(2);

      cast[1] = new Wizard('w', 1,
    		  new ImageIcon("Images/wizardDown.png").getImage(),
    		  new ImageIcon("Images/wizardDown.png").getImage(),
    		  new ImageIcon("Images/wizardDown.png").getImage(),
    		  new ImageIcon("Images/wizardDown.png").getImage(),
    		  new ImageIcon("Images/wizardDown.png").getImage(),
    		  new ImageIcon("Images/wizardDown.png").getImage(),
    		  new ImageIcon("Images/wizardRight1.png").getImage(),
    		  new ImageIcon("Images/wizardRight1.png").getImage());
      cast[1].setRow(4);
      cast[1].setCol(18);
      cast[1].setHitPoints(2);
      
      cast[2] = new Knight('k', 2,
    		  new ImageIcon("Images/heroImgDown.png").getImage(),
    		  new ImageIcon("Images/heroImgDown2.png").getImage(),
    		  new ImageIcon("Images/heroImgLeft.png").getImage(),
    		  new ImageIcon("Images/heroImgLeft2.png").getImage(),
    		  new ImageIcon("Images/heroImgRight.png").getImage(),
    		  new ImageIcon("Images/heroImgRight2.png").getImage(),
    		  new ImageIcon("Images/heroImgUp.png").getImage(),
    		  new ImageIcon("Images/heroImgUp2.png").getImage());
      cast[2].setCol(0);
      cast[2].setRow(8);
      cast[2].setHitPoints(2);
      
      cast[3] = new Knight('k', 3,
    		  new ImageIcon("Images/heroImgDown.png").getImage(),
    		  new ImageIcon("Images/heroImgDown2.png").getImage(),
    		  new ImageIcon("Images/heroImgLeft.png").getImage(),
    		  new ImageIcon("Images/heroImgLeft2.png").getImage(),
    		  new ImageIcon("Images/heroImgRight.png").getImage(),
    		  new ImageIcon("Images/heroImgRight2.png").getImage(),
    		  new ImageIcon("Images/heroImgUp.png").getImage(),
    		  new ImageIcon("Images/heroImgUp2.png").getImage());
      cast[3].setCol(18);
      cast[3].setRow(8);
      cast[3].setHitPoints(2);
      
      cast[4] = new Archer('a', 4,
    		  new ImageIcon("Images/badDown.png").getImage(),
    		  new ImageIcon("Images/badDown2.png").getImage(),
    		  new ImageIcon("Images/badLeft.png").getImage(),
    		  new ImageIcon("Images/badLeft2.png").getImage(),
    		  new ImageIcon("Images/badRight.png").getImage(),
    		  new ImageIcon("Images/badRight2.png").getImage(),
    		  new ImageIcon("Images/badUp.png").getImage(),
    		  new ImageIcon("Images/badUp2.png").getImage());
      cast[4].setCol(0);
      cast[4].setRow(12);
      cast[4].setHitPoints(2);
      
      cast[5] = new Archer('a', 5,
    		  new ImageIcon("Images/badDown.png").getImage(),
    		  new ImageIcon("Images/badDown2.png").getImage(),
    		  new ImageIcon("Images/badLeft.png").getImage(),
    		  new ImageIcon("Images/badLeft2.png").getImage(),
    		  new ImageIcon("Images/badRight.png").getImage(),
    		  new ImageIcon("Images/badRight2.png").getImage(),
    		  new ImageIcon("Images/badUp.png").getImage(),
    		  new ImageIcon("Images/badUp2.png").getImage());
      cast[5].setCol(18);
      cast[5].setRow(12);
      cast[5].setHitPoints(2);
      
      cast[6] = new Healer('h', 6,
    		  new ImageIcon("Images/bearDown.png").getImage(),
    		  new ImageIcon("Images/bearDown2.png").getImage(),
    		  new ImageIcon("Images/bearLeft.png").getImage(),
    		  new ImageIcon("Images/bearLeft2.png").getImage(),
    		  new ImageIcon("Images/bearRight.png").getImage(),
    		  new ImageIcon("Images/bearRight2.png").getImage(),
    		  new ImageIcon("Images/bearUp.png").getImage(),
    		  new ImageIcon("Images/bearUp2.png").getImage());
      cast[6].setCol(0);
      cast[6].setRow(16);
      cast[6].setHitPoints(2);
      
      cast[7] = new Healer('h', 7,
    		  new ImageIcon("Images/bearDown.png").getImage(),
    		  new ImageIcon("Images/bearDown2.png").getImage(),
    		  new ImageIcon("Images/bearLeft.png").getImage(),
    		  new ImageIcon("Images/bearLeft2.png").getImage(),
    		  new ImageIcon("Images/bearRight.png").getImage(),
    		  new ImageIcon("Images/bearRight2.png").getImage(),
    		  new ImageIcon("Images/bearUp.png").getImage(),
    		  new ImageIcon("Images/bearUp2.png").getImage());
      cast[7].setCol(18);
      cast[7].setRow(16);
      cast[7].setHitPoints(2);
      
   }

   private static Boolean gameOver() {
      int alive0 = 0;
      for (int i = 0; i < 7;i=i+2) {
         if (cast[i].alive()) alive0++;
      }
      if (alive0==0) return true;
      alive0 = 0;
      for (int i = 1; i < 8;i=i+2) {
         if (cast[i].alive()) alive0++;
      }
      if (alive0==0) return true;
      return false;
   }


   private static void setActions() {
      for (int i=0;i<8;i++) {
         if (cast[i].alive())
            cast[i].setAction(stage,props,cast);
      }
   }

   private static void resolveActions() {
      for(int i=0;i<8;i++) {
         if (cast[i].alive()) {
            System.out.println(i);
            System.out.println(cast[i].getAction());
            cmd[i] = cast[i].getAction().charAt(0);
            cmd1[i] = cast[i].getAction();
            newRow[i] = cast[i].getNewRow();
            newCol[i] = cast[i].getNewCol();
         }
      }
      resolveMoves();
      doMoves();
      doAttacks();
      fireAttack();
      fireTimeout();
   }

   private static Boolean sameTile(int X, int Y) {
      return X==Y;
   }

   private static Boolean closeEnough3(int X, int Y) {
      return Math.abs(X - Y) <= 3;
   }

   private static void resolveMoves() {
      for(int i = 0; i < 8; i++) {
         if (cast[i].alive() && cmd[i] == 'm') {
            int rank = cast[i].getRank();
            int r = newRow[i];
            int c = newCol[i];
            for (int j = 0; j < 8; j++) {
               if (cast[j].alive() && j != i) {
                  if (cmd[j] == 'm' && sameTile(r,newRow[j]) &&
                     sameTile(c,newCol[j])) {
                        if (cast[j].getRank() > rank) {
                           newRow[i] = cast[i].getRow();
                           newCol[i] = cast[i].getCol();
                           break;
                        }
                        if (cast[j].getRank() < rank) {
                           newRow[j] = cast[j].getRow();
                           newCol[j] = cast[j].getCol();
                        }
                        if (cast[j].getRank() == rank) {
                           newRow[i] = cast[i].getRow();
                           newRow[j] = cast[j].getRow();
                           newCol[i] = cast[i].getCol();
                           newCol[j] = cast[j].getCol();
                        }
                  }
                  else if (cmd[j] != 'm' && sameTile(r,cast[j].getRow()) &&
                     sameTile(c,cast[j].getCol())) {
                     newRow[i] = cast[i].getRow();
                     newCol[i] = cast[i].getCol();
                     break;
                  }
               }
            }
            for (int j = 2; j < 10; j++)
                {
                if (props[j] != null && props[j].getIcon() == 'r')
                    {
                    if (sameTile(r,props[j].getRow()) && sameTile(c,props[j].getCol()))
                        {
                        newRow[i] = cast[i].getRow();
                        newCol[i] = cast[i].getCol();
                        break;
                        }
                    }
                }
         }
      }
   }

   private static void doMoves() {
      for (int i=0;i<8;i++) {
         if (cast[i].alive() && cmd[i] == 'm') {
            if (newCol[i] < 0) newCol[i] = 0;
            if (newCol[i] > 18) newCol[i] = 18;
            if (newRow[i] < 0) newRow[i] = 0;
            if (newRow[i] > 18) newRow[i] = 18;
            cast[i].setCol(newCol[i]);
            cast[i].setRow(newRow[i]);
         }
      }
   }

   private static void doAttacks() {
      int firstMeleeAttacker = -1;
      int[] wounds = new int[8];
      for (int i=0;i<8;i++) wounds[i] = 0;
      Boolean mobAttack = false;
      for (int i=0;i<8;i++) { // find melee attackers of cast[i]
         if (!cast[i].alive()) continue;
         firstMeleeAttacker = -1;
         for (int j=0; j<8;j++) {
            if ((cast[j].alive()) &&
               cmd[j] == 'a'&&
               j!=i &&
               cast[j].near(cast[i]).equals(String.valueOf(cmd1[j].charAt(1)))){
               if (firstMeleeAttacker != -1) { // there are two attackers
                 wounds[i] += 1;
                 System.out.println(firstMeleeAttacker+" and "+j+" attack "+i);
                 mobAttack = true;
                 break;
                  }
               else { // found firstMeleeAttacker
                   firstMeleeAttacker = j;
               }
            }
         }
       if (!mobAttack && firstMeleeAttacker!=-1) { // only one attacker
          if (cast[firstMeleeAttacker].getRank() > cast[i].getRank()) {
             wounds[i] += 1;
             System.out.println(firstMeleeAttacker+" attacks "+i);
          }
          if (cast[firstMeleeAttacker].getRank() < cast[i].getRank()) {
             wounds[firstMeleeAttacker] += 1;
             System.out.println(firstMeleeAttacker+" wounded by "+i);
          }
       }
    }
      for (int i=0;i<8;i++) { // do other actions
         if (cmd[i] == 'h') {
            Actor a;
            if (!cast[i].alive()) continue;
            for (int j=0;j<8;j++) {
               a = cast[j];
               if (a.getTeam() == cast[i].getTeam() && cast[i].near(a).equals(String.valueOf(cmd1[i].charAt(1)))) {
                  double hP = a.getHitPoints();
                  if (hP < 4) a.setHitPoints(hP+1);
                  if (hP <= 0 && hP > -1 && a.getIcon() == 'w') fireballCast[a.getTeam()] = 0;
               }
            }
         }
         if (cmd[i] == 's') {
            Actor a = cast[i];
            if (!a.alive()) continue;
            for (int j=0;j<8;j++) {
               Actor b = cast[j];
               if (!b.alive() || a == b) continue;
               if (cmd1[i].equals("suu") && sameTile(a.getCol(),b.getCol())
                   && b.getRow() <= a.getRow() && a.getRow()-5 < b.getRow())
                  {
                  wounds[j] += 1;
                  }
               if (cmd1[i].equals("sdd") && sameTile(a.getCol(),b.getCol())
                   && b.getRow() >= a.getRow() && a.getRow()+5 > b.getRow())
                  {
                  wounds[j] += 1;
                  }
               if (cmd1[i].equals("sll") && sameTile(a.getRow(),b.getRow())
                   && b.getCol() <= a.getCol() && a.getCol()-5 < b.getCol())
                  {
                  wounds[j] += 1;
                  }
               if (cmd1[i].equals("srr") && sameTile(a.getRow(),b.getRow())
                   && b.getCol() >= a.getCol() && a.getCol()+5 > b.getCol())
                  {
                  wounds[j] += 1;
                  }
               if (cmd1[i].equals("sul") && sameTile(a.getCol()-b.getCol(),a.getRow()-b.getRow())
                   && b.getRow() <= a.getRow() && a.getRow()-5 < b.getRow())
                  {
                  wounds[j] += 1;
                  }
               if (cmd1[i].equals("sur") && sameTile(a.getRow()-b.getRow(),b.getCol()-a.getCol())
                   && b.getRow() <= a.getRow() && a.getRow()-5 < b.getRow())
                  {
                  wounds[j] += 1;
                  }
               if (cmd1[i].equals("sdl") && sameTile(a.getRow()-b.getRow(),b.getCol()-a.getCol())
                   && b.getRow() >= a.getRow() && a.getRow()+5 > b.getRow())
                  {
                  wounds[j] += 1;
                  }
               if (cmd1[i].equals("sdr") && sameTile(a.getCol()-b.getCol(),a.getRow()-b.getRow())
                   && b.getRow() >= a.getRow() && a.getRow()+5 > b.getRow())
                  {
                  wounds[j] += 1;
                  }
            }
         }
         //Creating new fire balls
         int team = cast[i].getTeam();
         if (cmd[i] == 'f' && fireballCast[team] == 0) {
             int j=2;
             Boolean chk=true;
             if (!cast[i].alive()) continue;
             fireballCast[team] = 1;
             while(j<10){
            	 if(props[j]==null){
            		 props[j] = new Fireball('f', new ImageIcon("Images/explosion3.png").getImage(),3);
            		 if(cmd1[i].charAt(4) == 'l'){
            			 props[j].setCol(cast[i].getCol()-Integer.parseInt(""+cmd1[i].charAt(3))-1); 
            		 }
            		 else
            			 props[j].setCol(cast[i].getCol()+Integer.parseInt(""+cmd1[i].charAt(3))-1);
            		 
            		 if(cmd1[i].charAt(2) == 'u')
            			 props[j].setRow(cast[i].getRow()-Integer.parseInt(""+cmd1[i].charAt(1))-1); 
            		 else
            			props[j].setRow(cast[i].getRow()+Integer.parseInt(""+cmd1[i].charAt(1))-1);
                 break;
            	 }
            	 j++;
             }
          }
      }
      for (int i=0;i<8;i++)
      {
      cast[i].setHitPoints(cast[i].getHitPoints() - wounds[i]);
      }
   }

   //New method for removing fire balls from prop list 
   public static void fireTimeout(){
	   for (int i=2; i<10; i++){
		   if(props[i]!=null && props[i].getIcon() == 'f'){
			   props[i].setTimeout(props[i].getTimeout()-1);
			   if(props[i].getTimeout()<=0) {
                                   System.out.println("Fireball at " +
                                   props[i].getRow() + "," + props[i].getCol()
                                   + " dies");
				   props[i]=null;
                           }
		   }
	   }   
   }
   public static void fireAttack(){
      for(int i=0;i<8;i++) {
         Actor a = cast[i];
         if (a.alive()) {
            for (int j=2;j<10;j++) {
               Prop p = props[j];
               if (p != null && props[j].getIcon()=='f') {
                  if (a.getRow() >= p.getRow()  &&
                      a.getRow() <= p.getRow() + 2 &&
                      a.getCol() >= p.getCol()  &&
                      a.getCol() <= p.getCol() + 2) {
                     a.setHitPoints(a.getHitPoints() - 0.5);
                     if (a.getHitPoints() < 0) a.setHitPoints(0);
                     System.out.println(a.getMyID() + " gets burnt");
                  }
               }
            }
         }
      }
   }

   private static void adjustAliveStatus() {
      for (int i=0;i<8;i++) {cast[i].updateAliveStatus();}
   }

   private static void declareOutcome() {
      int alive0 = 0;
      int alive1 = 0;
      for (int i = 0; i < 7;i=i+2) {
         if (cast[i].alive()) alive0++;
      }
      for (int i = 1; i < 8;i=i+2) {
         if (cast[i].alive()) alive1++;
      }
      if (alive0 == 0) System.out.println("Team 1 is dead");
      if (alive1 == 0) System.out.println("Team 2 is dead");
      if (alive0>0 && alive1==0) {
         System.out.println("Team 1 wins!");
         return;
      }
      if (alive1>0 && alive0==0) {
         System.out.println("Team 2 wins!");
         return;
      }
      System.out.println("Draw.");
   }

   public int getWidth(){
	   return width;
   }
   
   public int getHeight(){
	   return height;
   }

   public static void main(String[] args) {
      
      ClassGame test = new ClassGame();
      test.run();
   }
   
   public void run() {
	   Boolean running = true;
           int rounds = 50;
       //screen = new ScreenManager();
       try {
           DisplayMode displayMode =
               screen.findFirstCompatibleMode(POSSIBLE_MODES);
           screen.setFullScreen(displayMode);
           width = screen.getWidth();
           height = screen.getHeight();
           startGame();
           while (running) {
        	   Graphics2D g = screen.getGraphics();
               draw(g);
        	   g.dispose();
               screen.update();
             //show where everyone is
             for (int i=0;i<8;i++) {
                System.out.println("character "+i+" is at "+cast[i].getCol()+","+cast[i].getRow()+" hits "+cast[i].getHitPoints());
             }
             if (gameOver() || rounds == 0) running = false;
             else {
                rounds += -1;
                System.out.println();
                try {Thread.sleep(1000);}
                catch (Exception e) {}
                adjustAliveStatus();
                setActions();
                resolveActions();
             }
          }
          declareOutcome();
        
           
       }
       finally {
           screen.restoreScreen();
       }
   }
   
   public void draw(Graphics g) {
	   //background
	   g.drawImage(new ImageIcon("Images/newWorld.png").getImage(),0, 0, width, height, null);
	   type = -type;
	   // Loop for displaying the fire ball
	   for(int i=0; i<10; i++){
		   if(props[i]!=null && props[i].getIcon() == 'f' &&  props[i].getTimeout()>0){
			   g.drawImage(props[i].getImage(), props[i].getScreenCol(), props[i].getScreenRow(), 3*tileSize, 3*tileSize, null);
		   }
                   if (props[i] !=null && props[i].getIcon() != 'f')
                       {
	               g.drawImage(props[i].getImage(), props[i].getScreenCol(), props[i].getScreenRow(), tileSize, tileSize, null);
                       }
	   }
	   for (int i=0;i<8;i++) {
	         if (cast[i].alive()){
	            g.drawImage(cast[i].getImage(cast[i].getAction().charAt(1), type), cast[i].getScreenCol(), cast[i].getScreenRow(), tileSize, tileSize, null);
                 }
	         else g.drawImage(cast[i].getImage('d',0), cast[i].getScreenCol(), cast[i].getScreenRow(), tileSize, tileSize, null);
	   }	
           // draw archer fire.
           for (int i=0;i<8;i++) {
              Actor a = cast[i];
              if (a.alive() && cmd[i] == 's') {
                g.setColor(Color.yellow);
                if (cmd1[i].equals("suu")) {
                   g.drawLine(a.getScreenCol()+tileSize/2,a.getScreenRow()+tileSize/2,a.getScreenCol()+tileSize/2,a.getScreenRow() - 4*tileSize+tileSize/2);
                }
                if (cmd1[i].equals("sdd")) {
                   g.drawLine(a.getScreenCol()+tileSize/2,a.getScreenRow()+tileSize/2,a.getScreenCol()+tileSize/2,a.getScreenRow() + 4*tileSize+tileSize/2);
                }
                if (cmd1[i].equals("sll")) {
                   g.drawLine(a.getScreenCol()+tileSize/2,a.getScreenRow()+tileSize/2,a.getScreenCol() - 4*tileSize+tileSize/2,a.getScreenRow()+tileSize/2);
                }
                if (cmd1[i].equals("srr")) {
                   g.drawLine(a.getScreenCol()+tileSize/2,a.getScreenRow()+tileSize/2,a.getScreenCol() + 4*tileSize+tileSize/2,a.getScreenRow()+tileSize/2);
                }
                if (cmd1[i].equals("sul")) {
                   g.drawLine(a.getScreenCol()+tileSize/2,a.getScreenRow()+tileSize/2,a.getScreenCol()-4*tileSize+tileSize/2,a.getScreenRow() - 4*tileSize+tileSize/2);
                }
                if (cmd1[i].equals("sur")) {
                   g.drawLine(a.getScreenCol()+tileSize/2,a.getScreenRow()+tileSize/2,a.getScreenCol()+4*tileSize+tileSize/2,a.getScreenRow() - 4*tileSize+tileSize/2);
                }
                if (cmd1[i].equals("sdl")) {
                   g.drawLine(a.getScreenCol()+tileSize/2,a.getScreenRow()+tileSize/2,a.getScreenCol() - 4*tileSize+tileSize/2,a.getScreenRow()+4*tileSize+tileSize/2);
                }
                if (cmd1[i].equals("sdr")) {
                   g.drawLine(a.getScreenCol()+tileSize/2,a.getScreenRow()+tileSize/2,a.getScreenCol() + 4*tileSize+tileSize/2,a.getScreenRow()+4*tileSize+tileSize/2);
                }
             }
         }
   }
}
