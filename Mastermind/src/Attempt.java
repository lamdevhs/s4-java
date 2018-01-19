import java.awt.Color;

public class Attempt {
	Row row;
	Hint hint;
	int pointer = 0;
	int maxSize;
	
	public Attempt(int maxSize){
		this.row = new Row();
		this.maxSize = maxSize;
	}
	
	
	public boolean complete(Color c){
		if (this.isComplete()) {
			return true; // or raise?
		}
		this.row.add(c);
		this.pointer++;
		return this.isComplete();
	}
	
	public boolean isComplete(){
		return this.pointer == this.row.size();
	}
}
