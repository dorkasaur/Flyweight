import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class encapsulates the animation process for all the instantiated ABalls.
 */
public class BallAnimator implements ActionListener
{
	Timer aTimer;
	Dispatcher ballDispatcher = new Dispatcher();
	JComponent component;

	/**
	 * @param refresh
	 * @param frame
	 * @SBGen Constructor
	 */
	public BallAnimator(int refresh, JComponent component)
	{
		aTimer = new Timer(refresh, this);
		this.component = component;
	    aTimer.start();
	}

	/**
	 * @param g
	 */
	public void paint(Graphics g)
	{
 		  ballDispatcher.notifyAll(g);
	}

	/**
	 * @param aBall
	 */
	public void addBall(Ball aBall)
	{
		ballDispatcher.addObserver(aBall);
	}

	public void actionPerformed(ActionEvent e)
  {
    component.repaint();
  }

	public void deleteBalls()
	{
	    ballDispatcher.deleteObservers();
	}
}

