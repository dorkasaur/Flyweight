import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * The main display frame for the application.   This class contains main().
 */
public class BallFrame extends JFrame
	implements ActionListener
{
  Randomizer rand = new Randomizer();
  ControlStrategy strategy = new ControlStrategy();
  FlyweightFactory factory = new FlyweightFactory();
  Button newBallButton = new Button("New Ball");
  Button nullStrategyButton = new Button("Null Strategy");  
  Button breatheStrategyButton = new Button("Breathe Strategy");
  Button curveStrategyButton = new Button("Curve Strategy");
  Button googleStrategyButton = new Button("Google Strategy");
  Button colorPulseStrategyButton = new Button("Color Pulse Strategy");
  Button psychadelicStrategyButton = new Button("Psychadelic Strategy");
  Button clearButton = new Button("Clear");
  Rectangle maxVel = new Rectangle(30,30);
  Panel buttonPanel=new Panel();
  JPanel ballPanel=new JPanel(){
    public void update(Graphics g)
    {
        paint(g);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
		ballAnimator.paint(g);
    }};

  int repaintInterval = 50;
	BallAnimator ballAnimator = new BallAnimator(repaintInterval, ballPanel);
  BallFlyweight flyweight= factory.getFlyweight(rand.randomInt(3,20),rand.randomColor(),ballPanel,strategy);


  public BallFrame()
  {
		newBallButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
        ballAnimator.addBall(new Ball(flyweight,rand.randomLoc(getBounds()),rand.randomVel(maxVel)));
			}
		});

		nullStrategyButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
        strategy.setStrategy(new NullStrategy());
			}
		});

		curveStrategyButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
        strategy.setStrategy(new CurveStrategy());
			}
		});

		breatheStrategyButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
        strategy.setStrategy(new BreatheStrategy());
			}
		});

		googleStrategyButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
        strategy.setStrategy(new GoogleStrategy());
			}
		});

		colorPulseStrategyButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
        strategy.setStrategy(new ColorPulseStrategy());
			}
		});

		psychadelicStrategyButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
        strategy.setStrategy(new PsychadelicStrategy());
			}
		});

		clearButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
      	ballAnimator.deleteBalls();
			}
		});

	  addWindowListener(new WindowAdapter()
	  {
	    public void windowClosing(WindowEvent e)
	    {
	      System.exit(0);
	    }
    });


    setTitle("Ball FUN!");
    setSize(300,300);
    getContentPane().setLayout(new BorderLayout());
    buttonPanel.setLayout(new GridLayout(3,3));
    buttonPanel.add(newBallButton);
    buttonPanel.add(clearButton);
    buttonPanel.add(nullStrategyButton);
    buttonPanel.add(breatheStrategyButton);
    buttonPanel.add(curveStrategyButton);
    buttonPanel.add(googleStrategyButton);
    buttonPanel.add(colorPulseStrategyButton);
    buttonPanel.add(psychadelicStrategyButton);
    
    getContentPane().add("North",buttonPanel);
    getContentPane().add("Center",ballPanel);

  }

  public void actionPerformed( ActionEvent e)
  {
    repaint();
  }

  /*
  public void update(Graphics g)
  {
    paint(g);
  }

  public void paint(Graphics g)
  {
    super.paint(g);
		ballAnimator.paint(g);
  }
  */
  
  public static void main(String[] args)
	{
		(new BallFrame()).show();
	}

}