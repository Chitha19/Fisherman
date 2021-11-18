/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fisherman;

import java.awt.geom.Rectangle2D;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class hook extends JPanel{
    public ImageIcon[] imfire = new ImageIcon[5];
    public int y;
    public int x;
    public int count=0;
    hook(int x,int y){
        for(int i=0;i<imfire.length;i++){
            String imageLocation = "hook.png";
            imfire[i] = new ImageIcon(this.getClass().getResource(imageLocation));
	}
            this.x=x;
            this.y=y;
    }
	
    public void move(){
	this.y-=1;
    }
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,25,25));
    }
}
