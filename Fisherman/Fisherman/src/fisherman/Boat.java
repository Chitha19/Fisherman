/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fisherman;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.*;
public class Boat{
    public Image im ;
    public int x,y;
    public int count = 0;
    Boat(){
    URL imageURL = this.getClass().getResource("Boat.png");
    im = Toolkit.getDefaultToolkit().getImage(imageURL);
    this.x=x;
    this.y=y;
}
    public Image getImage(){
    return im;
}
    
}
