import java.awt.*;

/**
 * An update strategy that causes a balls color to change gradually.
 */
public class ColorPulseStrategy extends AStrategy
{
	SineMaker sineMakerR = new SineMaker(0, 255, .01);
	SineMaker sineMakerG = new SineMaker(0, 255, .02);
	SineMaker sineMakerB = new SineMaker(0, 255, .04);

  /**
	 * @param fly 
	 */
	public void doAction(ABall b)
	{
    b.setColor(new Color(sineMakerR.next(),sineMakerG.next(),sineMakerB.next()));
	}


}