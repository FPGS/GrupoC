import java.awt.*;
public class Block extends Rectangle {
	public int velX, velY;
	Color color;
    public Block(int x, int y, int alt, int anch, Color color) {
    	this.x=x;
		this.y=y;
		height=alt;
		width=anch;
		this.color=color;
		velX= (int)((Math.random()* 11)); //(int) es para convertir a entero.
		velY=(int)((Math.random()* 11));
     }
     public void dibujar(Graphics g){
		g.setColor(color);
		g.fillRect(x,y,width,height);
	}
	public void dibujarC(Graphics g){
		g.setColor(color);
		g.fillOval(x,y,width,height);
		}
	
	
    
    
}