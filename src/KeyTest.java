import java.awt.*;
import java.awt.event.*;



public class KeyTest extends Core implements KeyListener {
	public static void main(String[] args) {
		new KeyTest().run();
	}
	
	private String mess = "";
	
	//init also call init from superclass (core)
	public void init() {
		super.init();
		Window w = s.getFullScreenWindow();
		w.setFocusTraversalKeysEnabled(false); //make buttons like tab work like normal buttons
		w.addKeyListener(this);
		mess = "press escape to exit";
	}
	
	//keyPressed
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode(); //EVERY KEY ON KEYBOARD HAS KEYCODE
		if(keyCode == KeyEvent.VK_ESCAPE) {
			stop();
		}else {
			mess = "Pressed : "+ KeyEvent.getKeyText(keyCode);
			e.consume();
		}
	}

	//keyreleased
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		mess = "Released : "+ KeyEvent.getKeyText(keyCode);
		e.consume();
	}
	
	//last method from interface
	public void keyTyped(KeyEvent e) {
		e.consume();
	}
	
	//draw
	public synchronized void draw(Graphics2D g) { //no other method is gonna run at the same time
		Window w = s.getFullScreenWindow();
		g.setColor(w.getBackground());
		g.fillRect(0, 0, s.getWidth(), s.getHeighth());
		g.setColor(w.getForeground());
		g.drawString(mess, 30, 30);
	}
}