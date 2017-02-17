import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Rekt extends Block{
	Color color;
	int velx;
	int vely;
	int r=1;
	
    public Rekt(int x, int y, int alt, int anch, Color color) {
    	super(x,y,alt,anch,color);
		this.color=Color.blue;
    }

}