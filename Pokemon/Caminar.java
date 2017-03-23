import java.applet.*;
import java.awt.*;

public class Caminar extends Applet implements Runnable  {
Thread animacion;
Image fotogramas[][];
DibujoAnimado dibujo;
Graphics agus;
Image imagen;
Image fondo;
int r=0;
boolean correr=false;
    public void init() {
    	imagen = createImage(600,600);
		agus = imagen.getGraphics();
    	fotogramas = new Image[4][4];
    	//fondo = getImage(getCodeBase(), "pkn/f1.jpg");
    	fondo = Toolkit.getDefaultToolkit().createImage("pkn/f1.jpg");
    	for(int cont2=0;cont2<4;cont2++)
    		for (int cont3=0;cont3<4;cont3++){
    			if(cont2==0)
					fotogramas[cont2][cont3] = getImage(getCodeBase(), "pkn/a"+ (cont3+1)+".png");
				else if(cont2==1)
    				fotogramas[cont2][cont3]  = getImage(getCodeBase(), "pkn/ab"+ (cont3+1)+".png");
    			else if(cont2==2)
    				fotogramas[cont2][cont3]  = getImage(getCodeBase(), "pkn/i"+ (cont3+1)+".png");
    			else if(cont2==3)
    				fotogramas[cont2][cont3]  = getImage(getCodeBase(), "pkn/d"+ (cont3+1)+".png");
    	}
		dibujo = new DibujoAnimado(fotogramas);
	}
	public void start(){
    	animacion = new Thread(this); 
    	animacion.start();
	}
	public void paint(Graphics g){
		
		g.drawImage(fondo, 0, 0, this);
		/*if(r==0)
			dibujo.dibujarI(g, this);
		if(r==1)
			dibujo.dibujarD(g, this);
		if(r==2)
			dibujo.dibujarA(g, this);
		if(r==3)
		dibujo.dibujarAb(g, this);*/
		
		dibujo.dibujarI(g, this,r);
		//g.drawImage(imagen, 200, 200, this);
	    
	   
	}
	
	public void update(Graphics g){
		paint(g);
	}
	public void run(){
 			while(true){
 				if(correr)
 					dibujo.correr();
			repaint();
    		try{
    			Thread.sleep(100);
    		}catch(InterruptedException e){};	
    	}
	}
	/*public boolean keyDown(Event ev, int tecla){	
    	if(tecla == Event.RIGHT){
    		r=0;
    		correr=true;
    	}
    	
    	else if(tecla == Event.LEFT){
    		r=1;
    		correr=true;
    	}
    	if(tecla == Event.UP){
    		r=2;
    		correr=true;
    	}
    	
    	else if(tecla == Event.DOWN){
    		r=3;
    		correr=true;
    	 }
    	return true;
   
}*/
	public boolean keyDown(Event ev, int tecla){	
    	if(tecla ==  100){
    		r=3;
    		correr=true;
    	}
    	
    	else if(tecla == 97 ){
    		r=2;
    		correr=true;
    	}
    	if(tecla == 119){
    		r=0;
    		correr=true;
    	}
    	
    	else if(tecla == 115){
    		r=1;
    		correr=true;
    	 }
    	return true;
   
}
    public boolean keyUp(Event ev, int tecla){
    	correr=false;
    	return true;
    }
	
}