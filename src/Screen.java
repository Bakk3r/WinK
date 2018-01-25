// The next class imports are for appearance

import java.awt.*;
import javax.swing.JFrame;

public class Screen {
//class Screen to create a full screen game
	private GraphicsDevice vc;
	/*gives interface to videocart, 
	 * with this variable I can access the videocart. 
	 * Controls monitor on computer.*/
	
	public Screen() {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc = env.getDefaultScreenDevice();
	}
	
	/* GetlocalGraphics environment is a collection 
	 * of all your graphics device objects
	 * env = environment variable
	 * getDefaultScreenDevice gives us access to our 
	 * computerscreen. We can do whatever we want 
	 * with the entire screen. We have access to 
	 * entire graphics cart and entire monitor of the computer
	 */
	
	public void setFullScreen(DisplayMode dm, JFrame window) {
		window.setUndecorated(true); //no titlebars and scrollbars etc. gets rid of everything but image
		window.setResizable(false); //its gonna be fullscreen, no messing with it
		vc.setFullScreenWindow(window); //converts window to full screen, no matter the size of the monitor
		
		/*changes view to full screen. 
		 * DisplayMode takes 4 parameters.
		 * 2 for resolution xpi, 
		 * bitdepth(pretty muchhow many colors you can store)
		 * and lastly your refresh rate (how many times your
		 * monitor refreshes itself). 
		 */
		
		if(dm !=null && vc.isDisplayChangeSupported()) {
			try {
				vc.setDisplayMode(dm); //resolutionrefreshrate
			}catch(Exception ex) {}
			
			/*if your videocart is able to change the display (check first)  
			 *checks if you have monitor settings
			 *and checks if its able to display those settings*/
			
		}
	}

public Window getFullScreenWindow() {
	return vc.getFullScreenWindow();
	//returns your window, might not need it
}


public void restireScreen() {
	//Method to change screen back to normal
	Window w = vc.getFullScreenWindow(); //gets the window
	if(w !=null) {
		w.dispose(); //disposes window whenever you're closing it
		}
	vc.setFullScreenWindow(null);//makes sure whatever you do next is not in full screen anymore
	

}

}