import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Control implements MouseListener {

	Model model;
	
	Control(Model m) {
		this.model = m;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		ColorBtn btn = (ColorBtn) arg0.getSource();
		System.out.println(btn.myColor);
		this.model.completeCurrentAttempt(btn.myColor);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
