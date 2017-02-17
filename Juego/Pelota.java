import java.awt.*;
import java.util.List;
import java.util.ArrayList;
public class Pelota extends Block {

    int velX, velY;
	Color color;
	boolean fin;
    public Pelota(int x, int y, int alt, int anch, Color color) {
    	super(x,y,alt,anch,color);
    	fin = false;
		this.color=Color.blue;
		velX= (int)((Math.random()* 11)-5); //(int) es para convertir a entero.
		velY=(int)((Math.random()* 11)-5);
    }
    public void mover(List<Rekt>cuadrado, Rekt raqueta){
		x+=velX;
		y+=velY;
    	if((x>=400) || (x<=0))
    		velX=-velX;
    	if(y<=0)
    		velY=-velY;
    	if(y>360){
    		fin=true;
    		
    	}
    		
		for(int x=0; x<cuadrado.size(); x++)
    				if(cuadrado.get(x).intersects(this)){
    						cuadrado.remove(x);
    						this.velY=-this.velY;
    						break;
    					}
    		if(this.intersects(raqueta))
    			this.velY=-this.velY;
    		
	}
    
}