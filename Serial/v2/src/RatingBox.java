import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;

public class RatingBox extends Checkbox {
	int stars;
	RatingBox(String label, int stars, CheckboxGroup group) {
		super(label, group, false);
		this.stars = stars;
		this.setBackground(null);
	}
}
