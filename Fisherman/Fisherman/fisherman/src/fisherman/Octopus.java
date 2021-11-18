package fisherman;

import java.awt.*;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
public class Octopus {
	Image img;
	public int x = 0;
	public int y= (int) ((Math.random()*500)+200);
	public int count = 0;
	Octopus(){
                String imageLocation = "octopus.png";
                URL imageURL = this.getClass().getResource(imageLocation);
		img = Toolkit.getDefaultToolkit().getImage(imageURL);
		runner.start();
	}
	Thread runner = new Thread(new Runnable() {
            @Override
            public void run() {
		while(true){
                    x += 2;
                    if(x >= 21000){
			img = null;
			runner = null;
			x = -500;
			y = -700;
                    }
                    try{
			runner.sleep(10);
                    }catch(InterruptedException e){}
                }
            }
	});
	public Image getImage(){
            return img;
	}
	
	public int getX(){
            return x;
	}
	public int getY(){
            return y;
	}
	public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,150,140));
	}
}
