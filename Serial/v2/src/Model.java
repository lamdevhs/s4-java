import java.io.File;
import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable{
	Control control;
	String nonePath;
	ArrayList<RatedImage> images;
	RatedImage currentImage;
	
	Model(Control control, String nonePath) {
		this.control = control;
		this.nonePath = nonePath;
		this.currentImage = null;
	}
	
	void fromFolder(File[] files){
		this.images = new ArrayList<RatedImage>();
		for (File file : files){
			if (!file.isDirectory()) {
				String name = file.getName();
				String[] bits = name.split("\\.");
				if (bits.length >= 2 && bits[bits.length - 1].equals("jpg")) {
					// ^ not having a .jpg extension
					this.images.add(new RatedImage(name));
				}
			}
		}
	}
	
	void setCurrentImage(int index){
		if (index == -1) this.currentImage = null;
		else {
			this.currentImage = this.images.get(index);
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	void setRating(int stars) {
		if (this.currentImage != null)
			this.currentImage.rating = stars;
	}
}
