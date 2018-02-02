import java.awt.Color;
import java.util.ArrayList;

public class Row extends ArrayList<Color> {
	public Row() {
		super();
	}
	public int count(Color c){
		int out = 0;
		for (int i = 0; i < this.size(); i++){
			if (this.get(i) == c) ++out;
		}
		return out;
	}
}
