import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

public class HistoryView extends Canvas implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int pinSize = 20;
	public static int hintSize = 10;
	public static int rowSize = 30;
	public static int colSize = 30;
	public static Color blackHint = Color.black;
	public static Color whiteHint = Color.white;
	
	public int emptyRow = 0;
	
	public Model myModel;
	
	HistoryView(Model m){
		this.myModel = m;
	}
	
	public void paint(Graphics g){
		Model m = this.myModel;
		Attempt att;
		int i = 0;
		for (; i < m.history.size(); i++){
			att = m.history.get(i);
			this.paintAttempt(g, att, i);
		}
		if (!m.endGame) {
			att = m.currentAttempt;
			this.paintAttempt(g, att, i);
		}
		/*
		Attempt att = new Attempt(4);
		att.complete(Color.blue);
		att.complete(Color.red);
		att.complete(Color.green);
		this.paintAttempt(g, att, 0);
		Hint h = new Hint();
		h.misplaced = 1;
		h.perfect = 2;
		this.paintAttempt(g, att, 1);
		this.paintHint(g, 1, 3, h);*/
	}
	
	public void paintAttempt(Graphics g, Attempt attempt, int row) {
		int maxCompleted = attempt.pointer;
		int i = 0;
		for (; i < maxCompleted; i++) {
			Color c = attempt.row.get(i);
			this.paintPin(g, row, i, c);
		}
		if (attempt.isComplete()) {
			this.paintHint(g, row, i, attempt.hint);
		}
		
	}
	
	public void paintPin(Graphics g, int row, int col, Color color){
		g.setColor(color);
		g.fillOval(col * HistoryView.colSize,
				row * HistoryView.rowSize,
				HistoryView.pinSize,
				HistoryView.pinSize				
				);
	}
	
	public void paintHint(Graphics g, int row, int col, Hint hint){
		int misplaced = hint.misplaced;
		int i = 0;
		g.setColor(HistoryView.blackHint);
		while (misplaced != 0) {
			g.fillOval((col + i) * HistoryView.colSize,
					row * HistoryView.rowSize,
					HistoryView.hintSize,
					HistoryView.hintSize			
					);
			i++;
			misplaced--;
		}
		int perfect =  hint.perfect;
		g.setColor(HistoryView.whiteHint);
		while (perfect != 0) {
			g.fillOval((col + i) * HistoryView.colSize,
					row * HistoryView.rowSize,
					HistoryView.hintSize,
					HistoryView.hintSize			
					);
			i++;
			perfect--;
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}
}
