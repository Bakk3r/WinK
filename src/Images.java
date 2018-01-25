import java.awt.*;
import javax.swing.ImageIcon; //we can load images ansd use em in Java
import javax.swing.JFrame;

public class Images extends JFrame {
	public static void main(String[] args) {
		
		DisplayMode dm = new DisplayMode(800,600,16,DisplayMode.REFRESH_RATE_UNKNOWN) ;
		//if you don't know what your refreshrate is
		Images i = new Images ();//object
		i.run(dm); //method, gonna take display mode as parameter
		}
	
	private Screen s;
	private Image bg;
	private boolean loaded;
	
	// run method
	public void run(DisplayMode dm) { //need it to call on fullscreen
		setBackground(Color.PINK);
		setForeground(Color.WHITE);
		setFont (new Font("Arial", Font.PLAIN,24)); //font takes 3 parameters
		loaded = false;
				
		s = new Screen (); //Let's us call any of the methods from the Screen class
		try {
			s.setFullScreen(dm, this);//this is reference to whatever object you are working on
			loadpics();
			try {
				Thread.sleep(5000); //puts a thread to sleep
			}catch (Exception ex) {}
		}finally {
			s.restireScreen();
		/* method makes sure to wait for five 
		 * seconds before restoring the screen.
		 */
		
		}
	}
	//loads pictures
	private void loadpics() {
		bg = new ImageIcon("//Users//Naomi//Documents//Test//bg.png").getImage();
		loaded = true;
		repaint ();
	}
	
	public void paint (Graphics g) { //JFrame calls the paint method automaticly, it knows what to paint in it
		//Graphics object is a graphics 2d object
	
		if (loaded) {
			g.drawImage(bg,0,0,null);
		}
		
	}
}