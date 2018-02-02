import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable {
	public static int randNb(int nb) {
		return (int) (Math.floor(Math.random() * nb));
	}

	static Color pool[] = {
			Color.red, Color.orange, Color.yellow,
			Color.green, Color.cyan, Color.blue, Color.magenta,
			Color.pink, Color.gray, Color.black };

	int maxSize;
	int maxAttempts;

	Row mystery;
	ArrayList<Attempt> history;
	Attempt currentAttempt;

	boolean endOfGame;
	boolean gameWon;

	public Model(int maxSize, int maxAttempts) {
		this.init(maxSize, maxAttempts);

	}

	public void init(int maxSize, int maxAttempts) {
		this.endOfGame = false;
		this.gameWon = false; // not yet at least !!
		this.maxSize = maxSize;
		this.maxAttempts = maxAttempts;
		this.history = new ArrayList<Attempt>();
		this.mystery = this.createMystery();
		this.newAttempt();
		this.setChanged();
		this.notifyObservers();
	}

	public void newAttempt() {
		this.currentAttempt = new Attempt(this.maxSize);
	}

	public Row createMystery() {
		Row mys = new Row();
		for (int i = 0; i < this.maxSize; i++)
			mys.add(Model.pool[Model.randNb(Model.pool.length)]);
		return mys;
	}

	public void closeAttempt() {
		this.currentAttempt.hint = this.calculateHint(this.currentAttempt);
		this.history.add(this.currentAttempt);

	}

	public Hint calculateHint(Attempt att) {
		Hint hint = new Hint();
		
		int minSum = 0;
		// get hint.perfect
		for (int i = 0; i < this.maxSize; i++){
			if (att.row.get(i) == this.mystery.get(i)) {
				++hint.perfect;
			}
		}
		for (Color c: Model.pool){
			minSum += Math.min(att.row.count(c), this.mystery.count(c));
		}
		
		hint.misplaced = minSum - hint.perfect;
		return hint;
	}

	public void completeCurrentAttempt(Color c) {
		if (this.endOfGame) {
			return;
		}
		boolean completed = this.currentAttempt.complete(c);
		if (completed) {
			this.closeAttempt();
			if (this.currentAttempt.hint.perfect == this.maxSize) {
				this.gameOver(true);
			} else {
				if (this.remainingAttempts() == 0) {
					this.gameOver(false);
				} else {
					this.newAttempt();
				}
			}
		}

		this.setChanged();
		this.notifyObservers();
	}

	public void gameOver(boolean hasWon) {
		this.endOfGame = true;
		this.gameWon = hasWon;
	}

	public int remainingAttempts() {
		return this.maxAttempts - this.history.size();
	}

}
