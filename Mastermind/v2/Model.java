import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable {
	  int maxSize;
	  int maxAttempts;
	  
	  // states for observers
	  static int ATTEMPTING = 0;
	  
	  static Color[] pool = {Color.black, Color.red, Color.green, Color.blue,
			  Color.orange, Color.pink, Color.gray};
	  
	  Row mystery;
	  ArrayList<Attempt> history;
	  Attempt currentAttempt;
	  
	  boolean endGame;
	  boolean hasWon; // only meaningful one endGame == true
	  
	  
	  public Model(int maxSize, int maxAttempts){
		  this.init(maxSize, maxAttempts);
	  }
	  
	  public void init(int maxSize, int maxAttempts){
		  this.endGame = false;
		  this.hasWon = false; // only meaningful one endGame == true
		  this.maxSize = maxSize;
		  this.maxAttempts = maxAttempts;
		  this.history = new ArrayList<Attempt>();
		  this.mystery = this.createMystery();
		  this.newAttempt();
	  }
	  
	  public void newAttempt() {
		  this.currentAttempt = new Attempt(this.maxSize);
	  }
	  
	  public Row createMystery(){
		  Row mys = new Row();
		  mys.add(Color.red);
		  mys.add(Color.blue);
		  mys.add(Color.green);
		  mys.add(Color.black);
		  // todo
		  return mys;
	  }
	  
	  public void archiveAttempt(){
		  this.history.add(this.currentAttempt);
	  }
	  
	  public void completeCurrentAttempt(Color c){
		  if (endGame) {
			 return; // error...
		  }
		  boolean completed = this.currentAttempt.complete(c);
		  if (completed){
			  this.currentAttempt.hint = this.mystery.compare2Attempt(this.currentAttempt);
			  this.archiveAttempt();
			  if (this.currentAttempt.hint.perfect == this.maxSize) {
				  this.endOfGame(true);
			  }
			  else {
				  if (this.remainingAttempts() == 0) {
					  this.endOfGame(false);
				  }
				  else {
					  this.newAttempt();
				  }
			  }
		  }
		  else { // not completed
			  // notify view
		  }
		  
		  this.setChanged();
		  this.notifyObservers();
		  System.out.println("hit! " + c);
	  }
	  
	  public void endOfGame(boolean hasWon){
		  this.endGame = true;
		  this.hasWon = hasWon;
		  // view?
	  }
	  
	  public int remainingAttempts(){
		  return this.maxAttempts - this.history.size();
	  }
  
}
