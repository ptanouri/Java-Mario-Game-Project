import java.awt.Rectangle;

public class Powers 
{

	private int power_up_x;
	private int power_up_y;

	private boolean power_up_hit; 


	private int power_up_width;
	private int power_up_height;
	private boolean power_vis;
	private final int INITIAL_X = 800;
	private int dxx;


	// below are the constructor, getter and setter for all the variables in use

	public Powers(int power_up_x,int power_up_y)
	{
		this.power_up_x = power_up_x;
		this.power_up_y = power_up_y;
		power_up_hit = false;

		this.power_up_width = 20;
		this.power_up_height = 20;
		power_vis = true;
		dxx = 2;

	}

	public int get_power_up_x()
	{
		return power_up_x;
	}
	public void set_power_up_x(int power_up_x)
	{
		this.power_up_x = power_up_x;
	}

	public int get_power_up_y()
	{
		return power_up_y;
	}
	public void set_power_up_y(int power_up_y)
	{
		this.power_up_y = power_up_y;
	}

	public boolean get_power_up_hit()
	{
		return power_up_hit;
	}

	public void set_power_up_hit(boolean power_up_hit)
	{
		this.power_up_hit = power_up_hit;
	}


	public int get_power_up_width()
	{
		return power_up_width;
	}

	public void set_power_up_width(int power_up_width)
	{
		this.power_up_width = power_up_width;
	}

	public int get_power_up_height()
	{
		return power_up_height;
	}

	public void set_power_up_height(int power_up_height)
	{
		this.power_up_height = power_up_height;
	}

// creaining a bounding box
	public Rectangle getPowerBounds()
	{
		return new Rectangle(power_up_x,power_up_y,power_up_width,power_up_height);
	}


	public boolean isVisible() 
	{
		return power_vis;
	}

	public void setVisible(Boolean visible) 
	{
		power_vis = visible; // check the visibiolity of character
	}
	
	public void set_dxx(int dxx)
	{
		this.dxx = dxx;
	}

	public void powerUp_move() 
	{

		power_up_x = power_up_x - dxx;
	}

}