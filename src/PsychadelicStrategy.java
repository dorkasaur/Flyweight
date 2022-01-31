import java.awt.*;

/**
 * An update strategy that causes the ball's color to randomly change every time it is updated.   This will cause balls sharing the same flyweight with 
 * this strategy installed to appear to have different colors because their updates are called sequentially by the Dispatcher.
 */
public class PsychadelicStrategy extends AStrategy
{
  Randomizer rand = new Randomizer();
  /**
	 * @param aBall 
	 */
	public void doAction(ABall b)
	{
    b.setColor(rand.randomColor());
	}
}