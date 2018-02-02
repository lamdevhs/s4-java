import java.awt.Button;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Control implements MouseListener, WindowListener {

	Model model;
	
	Control(Model m) {
		this.model = m;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		Button btn = (Button) arg0.getSource();
		if (btn.getName() == "colorButton") {
			this.model.completeCurrentAttempt(((ColorBtn)btn).myColor);
		}
		else {
			this.model.init(this.model.maxSize, this.model.maxAttempts);
		}
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

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		System.out.println("here");		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
