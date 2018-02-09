import java.io.File;
import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable{
	Control control;
	String nonePath;
	ArrayList<RatedImage> images;
	int currentImage;
	
	Model(Control control, String nonePath) {
		this.control = control;
		this.nonePath = nonePath;
		this.currentImage = -1;
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
	
	void setNoCurrentImage(){
		this.currentImage = -1;
		this.setChanged();
		this.notifyObservers();
	}
}
