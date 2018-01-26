import java.awt.Button;
import java.awt.Color;

public class ColorBtn extends Button {
	
	Color myColor;
	
	ColorBtn(Color c, Control ctrl){
		super();
		this.setBackground(c);
		this.setSize(1000, 1000);
		this.myColor = c;
		this.addMouseListener(ctrl);
	}
}
