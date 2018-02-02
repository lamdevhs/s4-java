import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.util.Observable;
import java.util.Observer;

public class BtnPanel extends Panel implements Observer {
	Model myModel;
	Control myControl;
	
	boolean postGame = false;
	BtnPanel(Model m, Control c) {
		super();
		this.myModel = m;
		this.myControl = c;
		this.setLayout(new FlowLayout());
		this.displayButtons();
	}

	void displayButtons() {
		Color[] cs = Model.pool;
		for (Color c : cs) {
			this.addButton(c, this.myControl);
		}

	}

	void addButton(Color c, Control ctrl) {
		ColorBtn btn = new ColorBtn(c, ctrl);
		this.add(btn);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (this.myModel.endOfGame) {
			this.removeAll();
			//this.setLayout(new FlowLayout());
			this.add(new RestartBtn(this.myControl, this.myModel.gameWon));
			this.revalidate();
			this.postGame = true;
		}
		else if (this.postGame) {
			this.postGame = false;
			this.removeAll();
			this.displayButtons();
			this.revalidate();
		}
	}
}
