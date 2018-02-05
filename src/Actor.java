import javax.swing.ImageIcon;

import java.awt.*;

// Actor coordinates are integers designating which tile the actor is on.

public abstract class Actor {

   public Actor(char c, int id, Image d, Image d2, Image l, Image l2, Image r, Image r2, Image u, Image u2) {
      icon = c;
      myID = id;
      team = 1 + id%2;
      target = 2 - team;
	   down = d;
	   down2 = d2;
	   left = l;
	   left2 = l2;
	   right = r;
	   right2 = r2;
	   up = u;
	   up2 = u2;
   }

   public void setHitPoints(double hp) {
      hitPoints = hp;
   }

   public double getHitPoints() {
      return hitPoints;
   }

   public Boolean alive() {
      return aliveStatus;
   }

   public void updateAliveStatus() {
      if (hitPoints > 0) aliveStatus = true;
      else aliveStatus = false;
   }

   public void setRow(int r) {
      row = r;
   }

   public int getRow() {
      return row;
   }

   public int getScreenRow() {
      return Stage.getZ0() + Stage.getTileSize() * getRow();
   }

   public int dRow(Prop p) {return p.getRow() - row;}

   public int dRow(Actor a) {return a.getRow() - row;}
    

   public int nextRow(char direction, int row) {
      if (direction == 'u') return row - 1;
      else if (direction == 'd') return row + 1;
      else return row;
   }

   public int getNewRow() { // assumes action has a value
      if (action.charAt(0) != 'f') {
         char direction = action.charAt(1);
         return nextRow(direction,row);
      }
      else return row;
   }

   public void setCol(int c) {
      col = c;
   }

   public int getCol() {
      return col;
   }

   public int getScreenCol() {
      return Stage.getX0() + Stage.getTileSize() * getCol();
   }

   public int dCol(Prop p) {return p.getCol() - col;}

   public int dCol(Actor a) {return a.getCol() - getCol();}

   public int nextCol(char direction, int col) {
      if (direction == 'l') return col - 1;
      else if (direction == 'r') return col + 1;
      else return col;
   }

   public int getNewCol() { // assumes action has a value
      if (action.charAt(0) != 'f') {
         char direction = action.charAt(1);
         return nextCol(direction,col);
      }
      else return col;
   }

   public Boolean verticallyAligned(int dR) {
      return dR==0;
   }

   public Boolean horizontallyAligned(int dC) {
      return dC==0;
   }

   public Boolean contacting(int dR, int dC) {
      dR -= getRow();
      dC -= getCol();
      return verticallyAligned(dR) && horizontallyAligned(dC);
   }

   public String near(Actor a) {
      int dR = a.getRow() - getRow();
      int dC = a.getCol() - getCol();
      if (verticallyAligned(dR)) {
         if (dC == 1) return "r";
         if (dC == -1) return "l";
      }
      if (horizontallyAligned(dC)) {
         if (dR == 1) return "d";
         if (dR == -1) return "u";
      }
      return "";
   }

   public String verticalDirection(int dR) {
      if (verticallyAligned(dR)) return "";
      if (dR > 0) return "d";
      if (dR < 0) return "u";
      return "";
   }

   public String horizontalDirection(int dC) {
      if (horizontallyAligned(dC)) return "";
      if (dC > 0) return "r";
      if (dC < 0) return "l";
      return "";
   }

   public Image getImage(char d1, int type) {
      if(type>0){
    	  if(d1 == 'l')
    		  return left;
    	  else if(d1 == 'u')
    		  return up;
    	  else if(d1 == 'd')
    		  return down;
    	  else
    		  return right;
      }
      else {
    	  if(d1 == 'l')
    		  return left2;
    	  else if(d1 == 'u')
    		  return up2;
    	  else if(d1 == 'd')
    		  return down2;
    	  else 
    		  return right2;
      }
      
   }

   public abstract void setAction(Stage stage, Prop[] props, Actor[] cast);

   public void setAction(String str) {action = str;}

   public String getAction() {
      return action;
   }

   public char getDirection() {
      return (char)direction;
   }
   
   public char getIcon() {
	      return icon;
   }

   public int getRank() {
     int r = 0;
     char c = getIcon();
     if (c == 'w') r = 1;
     if (c == 'a') r = 2;
     if (c == 'h') r = 3;
     if (c == 'k') r = 4;
     return r;
   }

/*
   GotoAction goes to target and moves onto it
*/

   public String gotoAction(Prop p) {
      String direction = horizontalDirection(dCol(p));
      if (direction != "") return "m" + direction;
      direction = verticalDirection(dRow(p));
      if (direction != "") return "m" + direction;
      return "  ";
   }

   public String gotoAction(Actor a) {
      String direction = horizontalDirection(dCol(a));
      if (direction != "") return "m" + direction;
      direction = verticalDirection(dRow(a));
      if (direction != "") return "m" + direction;
      return "  ";
   }


   public int getTeam () { return team;}

   public int getTarget () { return target;}

   public int getMyID () {return myID;}

   private double hitPoints;
   private int row;
   private int col;
   private Image down;
   private Image down2;
   private Image left;
   private Image left2;
   private Image right;
   private Image right2;
   private Image up;
   private Image up2;
   private char icon;
   private int myID;
   private int team;
   private int target;
   private Boolean aliveStatus = true;
   private String action = "  ";
   public int direction;
}
