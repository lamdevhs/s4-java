import java.awt.List;
import java.util.Observable;
import java.util.Observer;

public class ImgList extends List implements Observer {
	Control control;
	
	ImgList(Control control){
		super();
		this.control = control;
		this.control.model.addObserver(this);
		this.addItemListener(control);
		this.setup();
	}
	
	void setup(){
		int size = this.control.model.images.size();
		for (int i = 0; i < size; i++){
			this.add(this.control.model
					.images.get(i).name);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
