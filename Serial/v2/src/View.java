import java.awt.BorderLayout;
import java.awt.Frame;

public class View extends Frame {
	View(Control control) throws Exception {
		super();
		ImgList imgList = new ImgList(control);
		Displayer displayer = new Displayer(control.model, this);
		RatingArea ratings = new RatingArea(control);
		
		this.addWindowListener(control);
		
		this.setLayout(new BorderLayout());
		this.add(imgList, BorderLayout.WEST);
		this.add(displayer, BorderLayout.CENTER);
		this.add(ratings, BorderLayout.SOUTH);
		this.setTitle("File Displayer");
		this.setSize(300, 300);
		this.pack();
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) throws Exception {
		Control control = new Control("images", "images.dat", "aucune.png");
		// ^ Model.images are supposed to be set already
		View view = new View(control);
	}
}
