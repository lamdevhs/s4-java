import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
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
	//Control control;
	String currentImage;
	
	Displayer(Model model){
		//this.control = control;
		this.model = model;
		model.addObserver(this);
		this.currentImage = model.nonePath;
		this.setVisible(true);
		this.repaint();
	}
	
	public void paint(Graphics g){
		if (this.currentImage != null) {
			try {
				g.drawImage(ImageIO.read(new File(this.currentImage)),
						0, 0, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("xaaaaa");
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if this.model
	}
}
