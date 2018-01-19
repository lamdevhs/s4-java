import java.awt.Color;
import java.util.ArrayList;

public class Model {
	  int maxSize;
	  int maxAttempts;
	  
	  Row mystery;
	  ArrayList<Attempt> history;
	  Attempt currentAttempt;
	  
	  boolean endGame;
	  
	  
	  public Model(int maxSize, int maxAttempts){
		  this.init(maxSize, maxAttempts);
		  
	  }
	  
	  public void init(int maxSize, int maxAttempts){
		  this.endGame = false;
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
		  // todo
		  return mys;
	  }
	  
	  public void archiveAttempt(){
		  this.history.add(this.currentAttempt);
	  }
	  
	  public void completeCurrentAttempt(Color c){
		  if (endGame) {
			 return; 
		  }
		  boolean completed = this.currentAttempt.complete(c);
		  if (completed){
			  this.currentAttempt.hint = this.mystery.compare2Attempt(this.currentAttempt);
			  this.archiveAttempt();
			  if (this.currentAttempt.hint.perfect == this.maxSize) {
				  this.gameWon();
			  }
			  else {
				  if (this.remainingAttempts() == 0) {
					  this.gameLost();
				  }
				  else {
					  this.newAttempt();
				  }
			  }
		  }
		  
		  // notify view
	  }
	  
	  public void gameWon(){
		  
	  }
	  
	  public void gameLost(){
		  
	  }
	  
	  public int remainingAttempts(){
		  return this.maxAttempts - this.history.size();
	  }
  
}
