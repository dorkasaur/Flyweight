/**
 * An update strategy that enables the update strategy to be changed dynamically.
 */
public class ControlStrategy extends AStrategy
{
  private AStrategy strategy=new NullStrategy();

	public void doAction(ABall b)
  {
    strategy.doAction(b);
	}

  public void setStrategy(AStrategy s)
  {
    strategy=s;
  }
}