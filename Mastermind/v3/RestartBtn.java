import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;

public class RestartBtn extends Button{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	RestartBtn(Control ctrl, boolean gameWon){
		super();
		this.setBackground(gameWon ? Color.green : Color.red);
		this.setPreferredSize(new Dimension(200,30));
		this.setLabel((gameWon ? "You Won!" : "You Lost!") + " Restart?");
		this.setName("restartButton");
		this.addMouseListener(ctrl);
	}
}
