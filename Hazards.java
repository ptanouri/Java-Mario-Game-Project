// hazards:
// - what happens if the player hit the hazards
import java.awt.Rectangle;

public class Hazards 
{
	private int hazard_x;
	private int hazard_y;
	private boolean hazard_hit; // change the visibility of the hazards if the boolean turns true

	private int hazard_width;
	private int hazard_height;
	private boolean haz_vis;
	private final int INITIAL_X = 800;
	private int dxx;


	// below are the constructor, getter and setter for all the variables in use

	public Hazards(int hazard_x, int hazard_y)
	{
		this.hazard_x = hazard_x;
		this.hazard_y = hazard_y;
		hazard_hit = false;

		this.hazard_width = 20;
		this.hazard_height = 20;
		haz_vis = true;
		dxx = 2;
	}

	public int get_hazard_x()
	{
		return hazard_x;
	}

	public void set_hazard_x(int hazard_x)
	{
		this.hazard_x = hazard_x;
	}

	public int get_hazard_y()
	{
		return hazard_y;
	}

	public void set_hazard_y(int hazard_y)
	{
		this.hazard_y = hazard_y;
	}

	public boolean get_hazard_hit()
	{
		return hazard_hit;
	}

	public void set_hazard_hit(boolean hazard_hit)
	{
		this.hazard_hit = hazard_hit;
	}

	public int get_hazard_width()
	{
		return hazard_width;
	}

	public void set_hazard_width(int hazard_width)
	{
		this.hazard_width = hazard_width;
	}

	public int get_hazard_height()
	{
		return hazard_height;
	}

	public void set_hazard_height(int hazard_height)
	{
		this.hazard_height = hazard_height;
	}

	// creating bounding boxes

	public Rectangle getHazardBounds() 
	{
		return new Rectangle(hazard_x,hazard_y,hazard_width,hazard_height);
	}


	public boolean isVisible() 
	{
		return haz_vis;
	}

	public void setVisible(Boolean visible) 
	{
		haz_vis = visible;
	}

	public void set_dxx(int dxx)
	{
		this.dxx = dxx;
	}


	public void hazard_move() 
	{

		hazard_x = hazard_x - dxx;
	}

}