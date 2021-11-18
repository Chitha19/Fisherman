/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fisherman;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameOver extends JPanel{
	
	private ImageIcon feildover = new ImageIcon("BackgroundGO.jpg");
	private ImageIcon exitover = new ImageIcon("Exit.jpg");
	private ImageIcon restart = new ImageIcon("Start.jpg");
	public JButton BStartover = new JButton(restart);
	public JButton BExitover  = new JButton(exitover);
	
	GameOver(){
		
		this.setLayout(null);
		BExitover.setBounds(500, 650, 150,90);
		add(BExitover);
		add(BStartover);
		BStartover.setBounds(750,650,150,90);
                add(BStartover);
		
	}
	public void paintComponent(Graphics g){
		  super.paintComponent(g);
		  g.drawImage(feildover.getImage(),0,0,1000,800,this);
		  
		  
	      
	  }
}
