import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.*;

public class Naomi2 {
	public static void main(String args[]) {
		Naomi2 n = new Naomi2();
		n.run();
	}
	private Sprite sprite;
	private Animation a;
	private ScreenManager s;
	private Image bg;
	private static final DisplayMode modes1[] = {
			new DisplayMode(800,600,32,0),
			new DisplayMode(800,600,24,0),
			new DisplayMode(800,600,16,0),
			new DisplayMode(640,480,32,0),
			new DisplayMode(640,480,24,0),
			new DisplayMode(640,480,16,0),
	};
	
	//load images and add scenes
	public void loadImages() {
		bg = new ImageIcon ("//Users//Naomi//Documents//Test//bg.png").getImage();
		Image bunny1 = new ImageIcon ("//Users//Naomi//Documents//Test//bunny1.png").getImage();
		Image bunny2 = new ImageIcon ("//Users//Naomi//Documents//Test//bunny2.png").getImage();
		
		a = new Animation();
		a.addscene(bunny1, 250);
		a.addscene(bunny2, 250);
		
		sprite = new Sprite(a,s.getFullScreenWindow());
		sprite.setVelocityX(0.3f);
		sprite.setVelocityY(0.3f);
		}
	
	public void run(){
		s = new ScreenManager();
				try {
					DisplayMode dm = s.findFirstCompatibleMode(modes1); //finds perfect display mode
				s.setFullScreen(dm); 
					loadImages();
					movieLoop();
				}finally{
					s.restoreScreen();
				}
			}

	
	//play movie
	public void movieLoop() {
		long startingTime = System.currentTimeMillis();
		long cumTime = startingTime;
		while (cumTime - startingTime <6000) {
		 cumTime = System.currentTimeMillis() - startingTime;
			update(cumTime);
			
			//draw and update screen
			Graphics2D g = s.getGraphics();
			draw(g);
			g.dispose();
			s.update();
			
			try {
				Thread.sleep(20);
			}catch (Exception ex) {}
		}
	}
	
	//draws graphics
	public void draw(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		g.drawImage(sprite.getImage(), Math.round(sprite.getX()), Math.round(sprite.getY()),null);
		
	}
	
	//update sprite 
	public void update (long timePassed) {
		if(sprite.getX() < 0) {
			sprite.setVelocityX(Math.abs(sprite.getVelocityX()));
		}else if(sprite.getX() + sprite.getWidth() >s.getWidth()) {
			sprite.setVelocityX(-Math.abs(sprite.getVelocityX()));
		
		}
		if(sprite.getY() < 0) {
			sprite.setVelocityY(Math.abs(sprite.getVelocityY()));
		}else if(sprite.getY() + sprite.getHeigth() >=s.getHeighth()) {
			sprite.setVelocityY(-Math.abs(sprite.getVelocityY()));
	}
		
		sprite.update(timePassed);
	}
	

}