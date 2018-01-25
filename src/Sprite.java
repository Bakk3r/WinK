import java.awt.Image;
import java.awt.Window;

public class Sprite {
	
	private Animation a;
	private float x;
	private float y;
	private float vx; //velocity = speed
	private float vy;
	private Window w;
	
	//CONSTRUCTOR
	public Sprite(Animation a, Window w) {
		this.w = w;
		this.a = a;
	}
	
	//change position
	public void update(long timePassed) {
		x += vx * timePassed;
		y += vy * timePassed;
	//	a.update(timePassed); //where in your animation you should be
	
	}
	
	//get x postion
	public float getX() {
		return x;
	}
	//get y postion
	public float getY() {
		return y;
	}
		
	//set sprite x position
		public void setX(float x) {
			this.x =x;		
	}
	
	//set sprite x position
	public void setY(float y) {
		this.y =y;
		
	}
	
	//get sprite width
	public int getWidth() {
		return a.getImage().getWidth(null);
	}
	//get sprite height
		public int getHeigth() {
			return a.getImage().getHeight(null);
		}
		
		//get horizontal velocity
		public float getVelocityX() {
			return vx;
		}
		//get vertical velocity
				public float getVelocityY() {
					return vy;
				}
				
		//set horizontal velocity
				public void setVelocityX(float vx) {
					this.vx = vx;
				}
				
		//set vertical velocity
				public void setVelocityY(float vy) {
					this.vy = vy;
				}
				
		//get sprite/image image
		public Image getImage () {
			return a.getImage();
		}
		
}