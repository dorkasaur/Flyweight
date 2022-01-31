import java.util.*;
import java.awt.*;

/**
 * A factory that creates BallFlyweights with specific radii, colors, containers, and strategies.   If a flyweight with the given specifications already exists, the same flyweight is reused, otherwise a new instance is created.
 */
public class FlyweightFactory
{
  Hashtable hash = new Hashtable();
  private BallFlyweight tempFlyweight;
  private BallFlyweight hashFlyweight;

  public BallFlyweight getFlyweight(int r, Color col, Container c, AStrategy a)
  {
    tempFlyweight=new BallFlyweight(r,col,c,a);
    hashFlyweight=((BallFlyweight)hash.get(tempFlyweight));

    if(hashFlyweight==null)
    {
      hash.put(tempFlyweight,tempFlyweight);
      return tempFlyweight;
    }
    else
    {
      return hashFlyweight;
    }
  }
}
    