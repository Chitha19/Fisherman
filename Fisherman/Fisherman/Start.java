/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fisherman;

import java.awt.event.*;
import javax.sound.sampled.Clip;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Start  extends JFrame implements ActionListener{
    
    Homegames hg = new Homegames();
  
    
    
public Start (){
this.add(hg);
hg.BStart.addActionListener(this);
hg.BExit.addActionListener(this);
}
public void actionPerformed(ActionEvent e) {
if(e.getSource()== hg.BStart){
this.setLocationRelativeTo(null);


}else if(e.getSource() == hg.BExit){
System.exit(0);
}
this.validate();
this.repaint();
}//







public static void main(String[] args) {
JFrame jf = new Start();
jf.setSize(1920,1080);
jf.setTitle("Fisherman");
jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
jf.setVisible(true);
jf.setLocationRelativeTo(null);
}

    

}