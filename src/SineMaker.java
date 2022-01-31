/**
 * This class is used to create a sine  wave oscillation of an integer value between specified
 *  minimum and maximum values.   This is accomplished through successive calls to next().   
 * The oscillation rate is controlled by a parameter that sets the 
 * angular increment between calls to next().
 */
class SineMaker
{
	/**
	 * The mid-point of the oscillation, i.e. the offset zero point.
	 */
	private double mid = 0.0;
	/**
	 * The range of the oscillation from mid-point to extrema, i.e. the amplitude.
	 */
	private double range = 1.0;
	/**
	 * The angular increment between calls to next(), in radians.
	 */
	private double dtheta = 0.1;
	/**
	 * The current angular position, in radians.
	 */
	private double theta = 0.0;
	/**
	 * The constructor for SineMaker.  It takes three arguments.
	 * @param min The minimum return value for next()
	 * @param max The maximum return value for next()
	 * @param dtheta The angular increment per call to next()
	 */
	public SineMaker(int min, int max, double dtheta)
	{
		mid = ((double)(min+max))/2.0;
        range = ((double)(max-min))/2.0;
	    this.dtheta = dtheta;
	}


	/**
	 * Returns the next value of the sine wave oscillation.
	 */
	public int next()
  {
       theta += dtheta;
       return (int) (mid+range*(Math.sin(theta)));
  }
}

