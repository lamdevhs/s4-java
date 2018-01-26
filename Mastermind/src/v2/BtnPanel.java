import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Panel;

public class BtnPanel extends Panel {
   BtnPanel() {
	   super();
	   this.setLayout(new FlowLayout());
   }
   
   void displayButtons(Control ctrl){
	   Color[] cs = Model.pool;
	   for (Color c: cs) {
		   this.addButton(c, ctrl);
	   }
	   
   }
   
   void addButton(Color c, Control ctrl){
	   ColorBtn btn = new ColorBtn(c, ctrl);
	   this.add(btn);
   }
}
