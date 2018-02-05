
import java.awt.*;

import javax.swing.ImageIcon;

public class Prop {
	

   public Prop(char c, Image d, int timeout) {
	   icon = c;
	   img = d;
	   this.timeout = timeout;
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
 

   public void setCol(int c) {
      col = c;
   }

   public int getCol() {
      return col;
   }

   public int getScreenCol() {
      return Stage.getX0() + Stage.getTileSize() * getCol();
   }


   public Image getImage() {
      return img;
   }

   public char getIcon() {
	      return icon;
 }
   public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
   private int row;
   private int col;
   private Image img;
   private char icon;
   private int timeout;
}
