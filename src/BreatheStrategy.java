/**
 * An update strategy that causes a ball's radius to expand and contract.
 */
public class BreatheStrategy extends AStrategy
{
	SineMaker sineMaker = new SineMaker(5, 30, .1);

  /**
	 * @param fly 
	 */
	public void doAction(ABall b)
	{
    b.setRadius(sineMaker.next());
	}


}