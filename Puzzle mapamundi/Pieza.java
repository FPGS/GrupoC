import java.awt.*;
import java.applet.*;
public class Pieza extends Rectangle {
	public static final int DIMENSION=60;
	Image imagen;
	int identificador;
	int actual=0;
    public Pieza(Image img,int id) {
   		super(((int)(Math.random()*240))+400,(int)(Math.random()*440),DIMENSION,DIMENSION);
   		imagen = img;
   		identificador=id;
   		
		
   	}
    
     public void dibujar(Graphics gg, Applet a){
     	gg.drawImage(imagen,x,y,a);
     }
     
     public void mover(int posx,int posy){
     	x=posx-(DIMENSION/2);
     	y=posy-(DIMENSION/2);
     }
     
}