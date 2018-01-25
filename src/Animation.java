import java.awt.Image;
import java.util.ArrayList;

public class Animation {

	private ArrayList scenes; // every picture is a scene
	private int sceneIndex; // these are gonne be the elements in the ArrayList
	private long movieTime; // the total time that your movie has been running
	private long totalTime; // gonna keep track on the total amount of time, so it don't freeze

	// CONSTRUCTOR
	public Animation() {
		scenes = new ArrayList();
		totalTime = 0; // sets everything to zero
		start(); // starts the animation
	}

	/*
	 * Can only run this method at a time, when this one is done you can run the
	 * other ones. Better control over the program
	 */

	// add scene to arraylist and set time for each scene
	public synchronized void addscene(Image i, long t) {
		totalTime += t; // sum of all individual scenes
		scenes.add(new OneScene(i, totalTime)); // each picture is gonna be an object aka a scene

	}

	// start animation from beginning, resets to zero
	public synchronized void start() {
		movieTime = 0;
		sceneIndex = 0;

	}

	// change scenes
	public synchronized void update(long timePassed) { // time that passes from the last update
		if (scenes.size() > 1) { // this code if theres more then 1 picture
			movieTime += timePassed; // sum of all time passed
			if (movieTime >= totalTime) // time of animation must not exceed totaltime. If it does we wanna restart the
										// animation
				movieTime = 0;
			sceneIndex = 0;
		}
		while (movieTime > getScene(sceneIndex).endTime) {// when get to end of one scene, go to the next one
			sceneIndex++;

		}

	}

	// get animations current scene aka image
	public synchronized Image getImage() {
		if (scenes.size() == 0) {
			return null;
		} else {
			return getScene(sceneIndex).pic;
		}
	}

	// get scene
	private OneScene getScene(int x) {
		return (OneScene) scenes.get(x);
	}

	// PRIVATE INNER CLASS

	private class OneScene {// whenever we create an image its gonna be an object of the class onescene
		Image pic;
		long endTime;

		public OneScene(Image pic, long endTime) {
			this.pic = pic;
			this.endTime = endTime;
		}
	}

}

