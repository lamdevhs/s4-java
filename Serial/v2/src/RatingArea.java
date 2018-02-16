import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Label;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class RatingArea extends Panel implements Observer {

	/**
	 * 
	 */
	ArrayList<RatingBox> ratingBoxes;
	CheckboxGroup group;
	Model model;
	
	private static final long serialVersionUID = 1L;
	RatingArea(Control control){
		super();
		this.model = control.model;
		this.add(new Label("Ratings:"));
		group = new CheckboxGroup();
		ratingBoxes = new ArrayList<RatingBox>();
		RatingBox rbox;
		int i;
		for (i = 0; i <= 5; i++) {
			rbox = new RatingBox("  " + String.valueOf(i) + " star"
					+ (i == 1 ? "" : "s"), i, group);
			this.ratingBoxes.add(rbox);
			rbox.addItemListener(control);
			this.add(rbox);
		}
		this.model.addObserver(this);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		if (this.model.currentImage != null) {
			this.group.setSelectedCheckbox(this.ratingBoxes.get(this.model.currentImage.rating));
		}
	}
}
