
public class RatedImage {
	String name;
	int rating; // [0..5]
	
	RatedImage(String name){
		this.name = name;
		this.rating = 0;
	}
	
	void setRating(int newRating){
		this.rating = Math.max(Math.min(newRating,5), 0);
	}
	
	public String toString(){
		return this.name;
	}
}
