/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fisherman;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Homegames extends JPanel{
        private ImageIcon feild = new ImageIcon(this.getClass().getResource("Pre.jpg"));
	private ImageIcon imgBoat = new ImageIcon(this.getClass().getResource("Boat2.png"));
	private ImageIcon exit = new ImageIcon(this.getClass().getResource("Exit.png"));
	private ImageIcon starts = new ImageIcon(this.getClass().getResource("Play.png"));
	public JButton BStart = new JButton(starts);
	public JButton BExit  = new JButton(exit);
	Homegames(){
            setLayout(null);
            BExit.setBounds(200, 650, 150,90);
            add(BExit);
            add(BStart);
            BStart.setBounds(450,650,150,90);
            add(BStart);
	}
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(feild.getImage(),0,0,1000,800,this);
            g.drawImage(imgBoat.getImage(), 580, 380, 400, 400, this);
            g.setColor(Color.YELLOW);
            g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,65));		
            g.drawString("Fisherman",200,200);	
	}
}