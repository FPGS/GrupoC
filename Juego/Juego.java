import java.awt.Graphics;
import java.awt.Event;
import java.awt.Image;
import java.awt.Color;
import java.applet.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.Font;

public class Juego extends Applet implements Runnable {
	Font fuente=new Font("TimesRoman", Font.BOLD, 12);
	List<Rekt> cuadrado; //ccdfgfd
	Thread animacion;
	Image imagen;
	Graphics noseve;
	Color color[]={Color.red,Color.white,Color.green};
	int posx[]={0,40,80,120,160,200,240,280,320,360,400};
	int posy[]={0,40,80};
	public Rekt raqueta;
	public Pelota pelota;
    public void init(){
    	cuadrado = new ArrayList<Rekt>(); //dfsfsdsd
		imagen = createImage(400,400);
		noseve = imagen.getGraphics();
		raqueta = new Rekt(100,350,20,200,Color.blue);
		pelota = new Pelota(180,270,20,20,Color.yellow);
		for(int x=0; x<posx.length; x++)
			for(int y=0; y<posy.length; y++)
				cuadrado.add(new Rekt(posx[x],posy[y],25,25,color[y]));
				
	}
	public void start(){
    	animacion = new Thread(this); 
    	animacion.start();
	}
	public void paint(Graphics g){
			
		noseve.setColor(Color.black);
		noseve.fillRect(0,0,400,400);		
		for(int x=0; x<(cuadrado.size());x++)
				cuadrado.get(x).dibujar(noseve);
		raqueta.dibujar(noseve);
		pelota.dibujarC(noseve);
		if(pelota.fin)
			noseve.drawString("GAMEOVER",160,200);
		g.drawImage(imagen, 0, 0, this);//para dibujar el objeto graphics: poner imagen, posicion en eje Y X y donde lo metemos (applet=this)
	}
	
	public void update(Graphics g){
		paint(g);
	}
	public void run(){
    	while(true){
    		pelota.mover(cuadrado,raqueta);	
    		repaint();
    		try{
    			Thread.sleep(10);
    		}catch(InterruptedException e){};	
    	}
    }
	public boolean keyDown(Event ev, int tecla){	
    	if(tecla == Event.RIGHT)
    		raqueta.x+=15;
    	if(tecla == Event.LEFT)
    		raqueta.x-=15;
    	return true;
    }
}