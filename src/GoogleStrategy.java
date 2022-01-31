import java.awt.*;

/**
 * An update strategy that causes the ball to follow a seemingly random curving path.
 */
public class GoogleStrategy extends AStrategy
{
	SineMaker sineMakerX = new SineMaker(-2, 2, .01);
	SineMaker sineMakerY = new SineMaker(-2, 2, .03);

	public void doAction(ABall b)
	{
        b.getVelocity().x += sineMakerX.next();
        b.getVelocity().y += sineMakerY.next();
// Alternatively:
//        b.setVelocity(new Point((b.getVelocity().x+sineMakerX.next()),(b.getVelocity().y+sineMakerY.next())));
	}
}