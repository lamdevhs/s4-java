import java.io.Serializable;

public class RatedImage implements Serializable {
	public String name;
	public int rating; // [0..5]
	
	public RatedImage(){
	}
	
	
	
	public RatedImage(String name){
		this.name = name;
		this.rating = 0;
	}
	
	void setRating(int newRating){
		this.rating = Math.max(Math.min(newRating, 5), 0);
	}
	
	public String toString(){
		return this.name;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getRating() {
		return rating;
	}
	
	
}
