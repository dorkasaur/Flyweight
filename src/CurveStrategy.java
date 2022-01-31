import java.awt.*;
/**
 * An update strategy that causes a ball to follow a curved path.
 */
public class CurveStrategy extends AStrategy
{
	int curve = 5;

	public void doAction(ABall b)
  {
    b.getVelocity().x += b.getVelocity().y/curve;
    b.getVelocity().y -= b.getVelocity().x/curve;

// Alternatively:
//    b.setVelocity(new Point((b.getVelocity().x+b.getVelocity().y/curve),(b.getVelocity().y-b.getVelocity().x/curve)));
	}
}