package fisherman;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class PlayGames extends JFrame implements ActionListener{  
	Homegames homegames1 = new Homegames();
	State1 state1 = new State1() {};
	GameOver gover = new GameOver();
	public PlayGames(){
		this.setSize(1000,800);
		this.add(homegames1);
		homegames1.BExit.addActionListener(this);
                homegames1.BStart.addActionListener(this);
                state1.BExithome.addActionListener(this);
                state1.BPause.addActionListener(this);
                state1.Bresum.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
            if(e.getSource()== homegames1.BStart){
		this.setLocationRelativeTo(null);
		this.remove(homegames1);
                this.setSize(1000,800);
                this.add(state1);
                state1.requestFocusInWindow();
		state1.timestart = false;
		state1.scor=0;
		state1.HP =3;
		state1.times = 100;
		state1.startfish=false;
		state1.timestart=false;
            }else if(e.getSource() == state1.BExithome){
		System.exit(0);
            }else if(e.getSource() == homegames1.BExit){
		System.exit(0);
            }else if(e.getSource() == state1.BPause){
		this.setLocationRelativeTo(null);
		this.setSize(1000,800);
		this.add(state1);
		state1.requestFocusInWindow();
		state1.t.suspend();
		state1.time.suspend();
		state1.actor.suspend();                               
	
			
            }else if(e.getSource() == state1.Bresum){
		this.setLocationRelativeTo(null);
		this.setSize(1000,800);
		this.add(state1);
		state1.requestFocusInWindow();
		state1.t.resume();
		state1.time.resume();
		state1.actor.resume();
	
            }
            this.validate();
            this.repaint();
	}
        
     public static void main(String[] args) {
            JFrame jf = new PlayGames();
            jf.setSize(1000,800);
            jf.setTitle("Fisherman");
            jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
            jf.setVisible(true);
            jf.setLocationRelativeTo(null);
    }    
        
        
	
}
