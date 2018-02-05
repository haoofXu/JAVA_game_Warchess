// The main part of the stage is a 19x19 tile area that is centered on the
// screen.  The tile size is adjusted to make this area as big as possible.

// Alot of this code is dead code.

class Stage {

   private ClassGame current = new ClassGame();
   	
   public Stage() {
//      brd = new char[current.getHeight()][current.getWidth()];
//      clear();
      height = current.getHeight();
      width = current.getWidth();
      setTileSize();
   }

   public void clear() {
      for (int i = 0; i < current.getHeight(); i++)
         for (int j = 0; j < current.getWidth(); j++) {
            if ((i==0 ||i==799) || (j==0 || j==699)) brd[i][j] = '#';
            else brd[i][j] = '.';
      }
   }

   public void show() {
      for (int i = 0; i < current.getHeight(); i++) {
         for (int j = 0; j < current.getWidth(); j++) 
            System.out.print(" "+brd[i][j]);
         System.out.println();
      }
   }

   public void setChar(int i, int j, char c) { brd[i][j] = c;}
   
   public  static int getCurrentWidth(){
	   return width;
   }
   
   public static int getCurrentHeight(){
	   return height;
   }

   public char getChar(int i, int j) { return brd[i][j];}

   public void setTileSize() {
      tileSize = (int) (height/19);
      }

   public static int getX0 () {
      return (width - 19 * tileSize)/2;
   }

   public static int getZ0() {
      return (height - 19 * tileSize)/2;
   }

   public static int getTileSize() {return tileSize;}

   private char[][] brd;
   private static int tileSize;
   private static int height;
   private static int width;
}
         
