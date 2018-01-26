import java.awt.Color;
import java.util.ArrayList;

public class Row extends ArrayList<Color> {
	public Row() {
		super();
	}
	
	public Hint compare2Attempt(Attempt attempt) {
		Hint res = new Hint();
		int perf = 0;
		for (int i = 0; i < attempt.maxSize; i++) {
			if (attempt.row.get(i) == this.get(i)) {
				perf++;
			}
		}
		int n, m;
		int sum = 0;
		for (Color c: Model.pool) {
			n = Row.count();
		}
		
		res.misplaced = 1;
		res.perfect = 2;
		return res;
	}
}
