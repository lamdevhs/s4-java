import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;

public class ColorBtn extends Button {
	
	Color myColor;
	static int size = 30;
	ColorBtn(Color c, Control ctrl){
		super();
		this.setBackground(c);
		this.setPreferredSize(new Dimension(ColorBtn.size,ColorBtn.size));
		this.myColor = c;
		this.setName("colorButton");
		this.addMouseListener(ctrl);
	}
}
