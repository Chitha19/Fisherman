package fisherman;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;



public class State1 extends JPanel implements ActionListener{
    
	private final ImageIcon imgstate1 = new ImageIcon(this.getClass().getResource("Background.jpg"));
	private final ImageIcon imgstate2 = new ImageIcon(this.getClass().getResource("Background2.jpeg"));
	private final ImageIcon pause = new ImageIcon(this.getClass().getResource("pause.png"));
	private final ImageIcon resume = new ImageIcon(this.getClass().getResource("Resume.png"));
	private final ImageIcon back = new ImageIcon(this.getClass().getResource("back.png"));
	Boat b = new Boat();
        Homegames hg = new Homegames();
	ImageIcon feildover = new ImageIcon(this.getClass().getResource("BackgroundGO.jpeg"));
	ImageIcon exitover = new ImageIcon(this.getClass().getResource("Exit.png"));
	ImageIcon restart = new ImageIcon(this.getClass().getResource("Play.png"));
        public JButton BPause = new JButton(pause);
        public JButton Bresum = new JButton(resume);
        JButton BStartover = new JButton(restart);
	JButton BExitover  = new JButton(exitover);
    
	private JLabel score = new JLabel(); 
        public JButton BExithome  = new JButton(back); 
	public ArrayList<hook> h = new ArrayList<hook>();
	public ArrayList<Fish> F = new ArrayList<Fish>();
	public ArrayList<Fish2> F2 = new ArrayList<Fish2>();
	public ArrayList<Octopus> O = new ArrayList<Octopus>();
        public ArrayList<Turtle> T = new ArrayList<Turtle>();
        
	public int times ;
	public int HP = 3;
	public int rs1 = 1;
	public int rs2 = 2;
	boolean timestart = true;
	boolean startfish = false;
	
	private GameOver gover = new GameOver();
	public int scor = 0;
	boolean paralyze1 = false;
	int time_paralyze=5;
	
	Thread time = new Thread(new Runnable(){
            public void run(){
		while(true){
                    try{
			Thread.sleep(10);
                    }catch(Exception e){ }
                    
                    if(timestart == false){
			repaint();
                    }
		}
            }
	});
	
	Thread actor = new Thread(new Runnable(){
            public void run(){
		while(true){
                	try{
                            Thread.sleep(1);
			}catch(Exception e){}
                            repaint();
		}
            }
	});
	Thread tballs1 = new Thread(new Runnable(){
            public void run() {
                while(true){
                	try{
                            if(startfish == false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startfish == false){
                           F.add(new Fish());
			}
		}
            }
	});
	Thread tballs2 = new Thread(new Runnable(){
            public void run() {
		while(true){
			try{
                            if(startfish==false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startfish == false){
                            F2.add(new Fish2());
			}
		}
            }
	});
        Thread tballs3 = new Thread(new Runnable(){
            public void run() {
		while(true){
			try{
                            if(startfish==false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startfish == false){
                            O.add(new Octopus());
			}
		}
            }
	});
	
	Thread tballs5 = new Thread(new Runnable(){
            public void run() {
            	while(true){
			try{
                            if(startfish==false){
                                Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startfish == false){
                            T.add(new Turtle());
			}
		}
            }
	});
	
        Thread t = new Thread(new Runnable(){
            public void run() {
		while(true){
                	if(timestart == false){
                            times = (times-1) ;
                            if(paralyze1){
				time_paralyze--;
                            }
			}
			try{
                            Thread.sleep(1000);
			}catch(InterruptedException e)
			{
                            e.printStackTrace();
			}
		}
            }
	});
	
	State1(){
		this.setFocusable(true);
		this.setLayout(null);
		BPause.setBounds(850,100,40,40);
		BExithome.setBounds(850,30,40,40);
		Bresum.setBounds(850, 170, 40,40);
		BPause.addActionListener(this);
		BExithome.addActionListener(this);
		Bresum.addActionListener(this);
		BExithome.addActionListener(this);
		this.add(BPause);
		this.add(BExithome);
		this.add(score);
		this.add(Bresum);
		
		this.addKeyListener(new KeyAdapter(){
                    public void keyPressed(KeyEvent e){
                        int a = e.getKeyCode();
			if(!paralyze1){
			    if(a == KeyEvent.VK_LEFT){
                                if(b.x < 20){
                                    b.x= 0 ;
                                    b.count++;
                                }
                                else{
                                    b.x -=10 ; 
                                }
                            }
                            else if (a == KeyEvent.VK_RIGHT) {
                                if(b.x>520){
                                b.x=520;
                                b.count++;
                                }
                                else{
                                b.x += 10;
                                }
                            }
                            if(b.count>3){
                                b.count=0;
                            }
                            else if(a == KeyEvent.VK_SPACE){
                               b.count=5;
			       h.add(new hook(b.x,b.y));
			    }
			}
                    }
                    public void keyReleased(KeyEvent e){
			b.count=0;
		    }
		});
		
		b.x = 0;
		time.start();
		actor.start();
		t.start();
		tballs1.start();
		tballs2.start();
                tballs3.start();
		tballs5.start();
		
	}
	
	
	
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            if(times <= 0 || HP<=0){
                this.remove(BPause);
                this.remove(Bresum);
                this.remove(BExithome);
                this.setLayout(null);
                g.drawImage(feildover.getImage(),0,0,1000,800,this);
		g.setColor(Color.BLACK);
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,40));		
                g.drawString("SCORE   "+scor,380,200);	     
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,70));
                g.drawString("GAME OVER",290,150);
                
				    
            }else if(times <= 30){
                g.drawImage(imgstate2.getImage(),0,0,1000,800,this);
                g.drawImage(b.getImage(), b.x, 120,604,369, this);
   		for(int i=0;i<h.size();i++){
                    hook ba = h.get(i);
      		    g.drawImage(ba.imfire[ba.count%5].getImage(), ba.x, ba.y,50,50, null);
      		    ba.move();
      		    ba.count++;
      		    if(ba.y<0){
      		    	h.remove(i);
      		    }
   		}
 		//===========Fish1================
		for(int i=0 ; i<F.size();i++){
                    g.drawImage( F.get(i).getImage() ,F.get(i).getX(),F.get(i).getY(),100,100,this);
		}
                for(int i=0 ; i<h.size();i++){
                    for(int j=0 ; j<F.size();j++){
		    	if(Intersect(h.get(i).getbound(),F.get(j).getbound())){
                            F.remove(j);
			    h.remove(i);
                            scor += 10;
			    g.drawString("+10",b.x+100,650);
                        } 
		    }
		}
		//===========Fish2================
		for(int i=0 ; i<F2.size();i++){
                    g.drawImage(F2.get(i).getImage(),F2.get(i).getX(),F2.get(i).getY(),100,100,this);
		}
		for(int i=0 ; i<h.size();i++){
		    for(int j=0 ; j<F2.size();j++){
		    	if(Intersect(h.get(i).getbound(),F2.get(j).getbound())){
			    F2.remove(j);
			    h.remove(i);
			    scor += 20;
			    g.drawString("+20",b.x+100,650);
   			} 
		    }
		}
                //===========Octopus================
		for(int i=0 ; i<O.size();i++){
                    g.drawImage(O.get(i).getImage(),O.get(i).getX(),O.get(i).getY(),100,100,this);
		}
		for(int i=0 ; i<h.size();i++){
		    for(int j=0 ; j<O.size();j++){
		    	if(Intersect(h.get(i).getbound(),T.get(j).getbound())){
			    O.remove(j);
			    h.remove(i);
			    scor += 20;
			    g.drawString("+20",b.x+100,650);
   			} 
		    }
		}
		//===========Turtle================
		for(int i=0 ; i<T.size();i++){
		    g.drawImage(T.get(i).getImage(),T.get(i).getX(),T.get(i).getY(),100,100,this);
		}
		for(int i=0 ; i<h.size();i++){
                    for(int j=0 ; j<T.size();j++){
                        if(Intersect(h.get(i).getbound(),T.get(j).getbound())){
                            T.remove(j);
			    h.remove(i);
			    scor -=20;
			    HP=HP-1;
			    g.drawString("-1HP",b.x+100,580);
			    g.drawString("-20",b.x+100,650);
			} 
		    }
		}
		      
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,30));
		g.setColor(Color.WHITE);
		g.drawString("SCORE =  "+scor,80, 100);	     
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,50));
		g.drawString("STATE "+rs2,350,80);    
		g.drawString("Time "+times,335,150);
		g.drawString("HP  "+HP,100,200);
		      
            }else if(times <= 0 || HP<=0){
		this.remove(BPause);
		this.remove(Bresum);
		this.remove(BExithome);
                this.setLayout(null);
                g.drawImage(feildover.getImage(),0,0,1000,800,this);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,40));		
		g.drawString("SCORE   "+scor,380,200);	     
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,70));
		g.drawString("GAME OVER",290,150);
		g.drawImage(b.getImage(), 580, 360, 400, 400, this);
            }else{
                g.drawImage(imgstate1.getImage(),0,0,1000,800,this);
                g.drawImage(b.getImage(), b.x, 120,604,369, this);
		if(b.x<0){
                    b.x=this.getWidth()-10;
		}
		if(b.x>this.getWidth()){
                    b.x=20;
		}
		for(int i=0;i<h.size();i++){
		    hook ba = h.get(i);
                    g.drawImage(ba.imfire[ba.count%5].getImage(), ba.x, ba.y,50,50, null);
		    ba.move();
                    ba.count++;
		    if(ba.y<0){
		    	h.remove(i);
		    }
		}
		  
		//========================================Fish1================= 
                for(int i=0 ; i<F.size();i++){
                    g.drawImage(F.get(i).getImage(),F.get(i).getX(),F.get(i).getY(),100,100,this);
 		}
		for(int i=0 ; i<h.size();i++){
		    for(int j=0 ; j<F.size();j++){
		    	if(Intersect(h.get(i).getbound(),F.get(j).getbound())){
			    F.remove(j);
			    h.remove(i);
			    scor += 10;
			    g.drawString("+10",b.x+100,650);
			} 
		    }
		}
		//========================Fish2=========================
		for(int i=0 ; i<F2.size();i++){
		    g.drawImage(F2.get(i).getImage(),F2.get(i).getX(),F2.get(i).getY(),100,100,this);
		 }
		for(int i=0 ; i<h.size();i++){
		    for(int j=0 ; j<F2.size();j++){
		    	if(Intersect(h.get(i).getbound(),F2.get(j).getbound())){
			    F2.remove(j);
			    h.remove(i);
			    scor += 20;
			    g.drawString("+10",b.x+100,650);
			 } 
		    }
		}
                //========================Octopus=========================
		for(int i=0 ; i<O.size();i++){
		    g.drawImage(O.get(i).getImage(),O.get(i).getX(),O.get(i).getY(),100,100,this);
		 }
		for(int i=0 ; i<h.size();i++){
		    for(int j=0 ; j<O.size();j++){
		    	if(Intersect(h.get(i).getbound(),O.get(j).getbound())){
			    O.remove(j);
			    h.remove(i);
			    scor += 20;
			    g.drawString("+10",b.x+100,650);
			 } 
		    }
		}
		//=================================Turtle=============
		for(int i=0 ; i<T.size();i++){
		    g.drawImage(T.get(i).getImage(),T.get(i).getX(),T.get(i).getY(),100,100,this);
		}
		for(int i=0 ; i<h.size();i++){
		    for(int j=0 ; j<T.size();j++){
		    	if(Intersect(h.get(i).getbound(),T.get(j).getbound())){
			    T.remove(j);
			    h.remove(i);
			    scor -=20;
			    HP=HP-1;
			    g.drawString("-1HP",b.x+100,650);
			    g.drawString("-20",b.x+100,580);
			} 
		    }
		}
		      
		
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,30));
		g.setColor(Color.BLACK);
		g.drawString("SCORE =  "+scor,80, 100);	     
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,50));
		g.drawString("STATE "+rs1,350,80);
		g.drawString("Time "+times,335,150);
		g.setColor(Color.RED);
		g.drawString("HP  "+HP,100,200);
		      
	    }

	}

	public boolean Intersect(Rectangle2D a, Rectangle2D b){
		return (a.intersects(b));
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== BStartover){		
                    this.setSize(1000,800);
                    this.add(hg);
                    this.setLocation(null);
                    timestart = true;
                    startfish = true;
		}else if(e.getSource() == BExitover){
                    System.exit(0);
		}		
	}
}
