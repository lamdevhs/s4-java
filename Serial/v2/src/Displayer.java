import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;

public class Displayer extends Canvas implements Observer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Model model;
	View frame;
	//Control control;
	//String currentImage;
	
	Displayer(Model model, View frame){
		//this.control = control;
		this.model = model;
		model.addObserver(this);
		//this.currentImage = model.nonePath;
		this.frame = frame;
		this.setVisible(true);
		this.setPreferredSize(new Dimension(833,480));
		this.repaint();
	}
	
	public void paint(Graphics g){
		RatedImage currentImage = this.model.currentImage;
		BufferedImage img;
		String name = this.model.control.folderPath + "/";
		if (currentImage != null) {
			name += currentImage.name;
		} else {
			name = model.nonePath;
		}
		try {
			img = ImageIO.read(new File(name));
			g.drawImage(img	,0, 0, 833,480, null);
		
			
			//this.frame.pack();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
		
	}
}
