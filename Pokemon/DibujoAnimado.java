import java.awt.*;
import java.applet.*;
public class DibujoAnimado {
	Image imagenes[][];
	int cont = 0;
	int cont2 = 0;
    public DibujoAnimado(Image imgs[][]) {
    	imagenes = imgs;
    }
    /*public void dibujarA(Graphics agus, Applet a ){
    	agus.drawImage(imagenes[0][cont], 50, 400, a );
    }
    public void dibujarAb(Graphics agus, Applet a ){
    	agus.drawImage(imagenes[1][cont], 50, 400, a );
    }
    public void dibujarD(Graphics agus, Applet a ){
    	agus.drawImage(imagenes[2][cont], 50, 400, a );
    }
    
    public void dibujarI(Graphics agus, Applet a ){
    	agus.drawImage(imagenes[3][cont], 50, 400, a );
    }*/
    public void dibujarI(Graphics agus, Applet a,int r ){
    	agus.drawImage(imagenes[r][cont], 50, 400, a );
    }
    public void correr(){
    	cont=(cont+1)%4;
    }
    
}