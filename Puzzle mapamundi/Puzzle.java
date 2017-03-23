import java.awt.*;
import java.applet.*;

public class Puzzle extends Applet{
	Image imagenes[];
	Image imagen;
	Rectangle recuadro[][];
	Pieza pieza[];
	Pieza activo;
	Graphics noseve;
    public void init() {
    	imagenes = new Image[25];
    	for(int a=0;a<25;a++)
    		imagenes[a]= getImage( getCodeBase(), "directorioImagenes/" +(a+1)+ ".png");
    	pieza = new Pieza[25];
    	for(int i=0;i<25;i++)
    		pieza[i] = new Pieza(imagenes[i],i);
    	recuadro=new Rectangle[5][5];
    	for(int a=0;a<5;a++)
    		for(int i=0;i<5;i++)
    			recuadro[a][i]=new Rectangle(((i*Pieza.DIMENSION)+50),((a*Pieza.DIMENSION)+100),Pieza.DIMENSION,Pieza.DIMENSION);
    	imagen = createImage(700, 700);
    	noseve = imagen.getGraphics();
    }
    
    
    
    public void paint(Graphics g){
    	noseve.setColor(Color.white);
    	noseve.fillRect(0, 0, 700, 700);
    	for(int a=0;a<5;a++)
    		for(int i=0;i<5;i++){
    			noseve.setColor(Color.blue);
    			noseve.drawRect(recuadro[a][i].x,recuadro[a][i].y,recuadro[a][i].width,recuadro[a][i].height);
    		}
   		for(int i=0; i<25; i++)
			pieza[i].dibujar(noseve,this);
		
		g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g){
    	paint(g);
    }
    
  
    
    public boolean mouseDown(Event ev, int x, int y){
    	for(int i=0;i<pieza.length;i++)
			if(pieza[i].contains(x,y)){
				activo=pieza[i];
				repaint();
			}
		return true;
    }
    public boolean mouseDrag(Event ev,int x,int y){
    	if(activo!=null){
    		activo.mover(x,y);
    		repaint();
    	}
    	return true;
    }
    public boolean mouseUp(Event ev, int x, int y){
    	if(activo!=null){
    	for(int a=0;a<5;a++)
    		for(int i=0;i<5;i++){
    			if(recuadro[a][i].intersects(activo))
    				if(activo.identificador==(a*5)+i){
    					activo.x=recuadro[a][i].x;
    					activo.y=recuadro[a][i].y;
    					repaint();
    				}
    		}
    	}
    	activo=null;
    	
    	return true;
    }
   
}