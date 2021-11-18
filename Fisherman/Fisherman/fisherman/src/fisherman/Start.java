
package fisherman;
import java.awt.event.*;
import javax.sound.sampled.Clip;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class Start  extends JFrame implements ActionListener{
Homegames homegames1 = new Homegames();
State1 state1 = new State1();
public Start (){
this.add(homegames1);
homegames1.BStart.addActionListener(this);
homegames1.BExit.addActionListener(this);

state1.BExithome.addActionListener(this);
state1.BPause.addActionListener(this);
state1.Bresum.addActionListener(this);
}
public void actionPerformed(ActionEvent e) {
if(e.getSource()== homegames1.BStart){
this.setLocationRelativeTo(null);
this.remove(homegames1);
this.add(state1);
state1.requestFocusInWindow();
state1.timestart = false;
state1.times = 60;

}else if(e.getSource() == homegames1.BExit){
System.exit(0);
}
else if(e.getSource()==state1.BPause){
    this.requestFocusInWindow();
state1.t.suspend();
state1.time.suspend();
state1.actor.suspend();
state1.tballs1.suspend();
state1.tballs2.suspend();
}
else if(e.getSource()==state1.BExithome){
this.setLocationRelativeTo(null);
this.remove(state1);
this.add(homegames1);
homegames1.requestFocusInWindow();

}
else if(e.getSource()==state1.Bresum){
    state1.t.resume();
state1.time.resume();
state1.actor.resume();
state1.tballs1.resume();
state1.tballs2.resume();
}
this.validate();
this.repaint();
}
public static void main(String[] args) {
JFrame jf = new Start();
jf.setSize(1000,800);
jf.setTitle("Fisherman");
jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
jf.setVisible(true);
jf.setLocationRelativeTo(null);
}

}

