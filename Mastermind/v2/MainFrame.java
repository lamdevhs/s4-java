import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

public class MainFrame extends Frame {
	MainFrame(){
		super();
		int maxSize = 4;
		int maxAttempts = 10;
		
		Model m = new Model(maxSize, maxAttempts);
		HistoryView d = new HistoryView(m);
		m.addObserver(d);
		BtnPanel p = new BtnPanel();
		Control ctrl = new Control(m);
		p.displayButtons(ctrl);
		this.setLayout(new BorderLayout());
		this.add(d, BorderLayout.CENTER);
		this.add(p, BorderLayout.SOUTH);
		this.setSize(300, 500);
		this.setTitle("MasterMind");
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
	}
}
