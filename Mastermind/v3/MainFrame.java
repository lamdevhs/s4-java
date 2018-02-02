import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

public class MainFrame extends Frame {
	MainFrame(){
		super();
		int maxSize = 4;
		int maxAttempts = 15;

		Model model = new Model(maxSize, maxAttempts);
		Control control = new Control(model);
		
		BtnPanel panel = new BtnPanel(model, control);
		HistoryView hview = new HistoryView(model);
		
		model.addObserver(hview);
		model.addObserver(panel);
		
		this.addWindowListener(control);
		this.setLayout(new BorderLayout());
		this.add(hview, BorderLayout.CENTER);
		this.add(panel, BorderLayout.SOUTH);
		this.setTitle("MasterMind");
		this.setVisible(true);
		this.setSize(Math.max((ColorBtn.size + 10) * model.pool.length, model.maxSize * 2 * hview.colSize),
				panel.getHeight() + (hview.rowSize) * (model.maxAttempts + 1));
	}

	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
	}
}
