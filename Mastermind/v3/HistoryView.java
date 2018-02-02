import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

public class HistoryView extends Canvas implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int pinSize = 25;
	public static int hintSize = 15;
	public static int rowSize = 40;
	public static int colSize = 40;
	public static Color blackHint = Color.black;
	public static Color whiteHint = Color.white;

	public int emptyRow = 0;

	public Model myModel;

	HistoryView(Model m) {
		this.myModel = m;
	}

	public void paint(Graphics g) {
		Model m = this.myModel;
		Attempt att;
		Attempt dummy = new Attempt(this.myModel.maxSize);
		dummy.row = this.myModel.mystery;
		dummy.pointer = this.myModel.maxSize;
		dummy.hint = this.myModel.calculateHint(dummy);
		this.paintAttempt(g, dummy, this.myModel.maxAttempts);
		int i = 0;
		for (; i < m.history.size(); i++) {
			att = m.history.get(i);
			this.paintAttempt(g, att, i);
		}
		if (!m.endOfGame) {
			att = m.currentAttempt;
			this.paintAttempt(g, att, i);
		}
		else {
//			String s = (this.myModel.gameWon) ? "You Won!" : "You Lost!";
//			g.setColor(Color.black);
//			g.setFont(new Font("Arial", Font.PLAIN, 30));
//			g.drawString(s, 0, (m.history.size()) * HistoryView.rowSize);
		}
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

	public void paintPin(Graphics g, int row, int col, Color color) {
		g.setColor(color);
		g.fillOval(col * HistoryView.colSize, row * HistoryView.rowSize, HistoryView.pinSize, HistoryView.pinSize);
	}

	public void paintHint(Graphics g, int row, int col, Hint hint) {
		int misplaced = hint.misplaced;
		int i = 0;
		g.setColor(HistoryView.blackHint);
		while (misplaced != 0) {
			g.fillOval((col + i) * HistoryView.colSize, row * HistoryView.rowSize, HistoryView.hintSize,
					HistoryView.hintSize);
			i++;
			misplaced--;
		}
		int perfect = hint.perfect;
		g.setColor(HistoryView.whiteHint);
		while (perfect != 0) {
			g.fillOval((col + i) * HistoryView.colSize, row * HistoryView.rowSize, HistoryView.hintSize,
					HistoryView.hintSize);
			i++;
			perfect--;
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}
}
