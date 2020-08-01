import java.awt.Rectangle;

public class Rect
{
	private int rect_x;
	private int rect_y;
	private int rect_width;
	private int rect_height;
	private boolean rect_vis;

	private final int INITIAL_X = 800;
	private int dxx;

	public Rect(int rect_x,int rect_y,int rect_width, int rect_height)
	{
		this.rect_x = rect_x;
		this.rect_y = rect_y;
		this.rect_width = rect_width;
		this.rect_height = rect_height;
		this.dxx = 2;

		rect_vis = true;
	}

	public int get_rect_x()
	{
		return rect_x;
	}
	public void set_rect_x(int rect_x)
	{
		this.rect_x = rect_x;
	}

	public int get_rect_y()
	{
		return rect_y;
	}
	public void set_rect_y(int rect_y)
	{
		this.rect_y = rect_y;
	}

	public int get_rect_width()
	{
		return rect_width;
	}
	public void set_rect_width(int rect_width)
	{
		this.rect_width = rect_width;
	}

	public int get_rect_height()
	{
		return rect_height;
	}
	public void set_rect_height(int rect_height)
	{
		this.rect_height = rect_height;
	}

	public boolean isVisible() 
	{
		return rect_vis;
	}

	public void setVisible(Boolean visible) 
	{
		rect_vis = visible;
	}

	public void rect_move() 
	{

		rect_x = rect_x - dxx;

		if (rect_width+rect_x <= 0)
		{
			rect_vis = false;
		}
	}

	public void set_dxx(int dxx)
	{
		this.dxx = dxx;
	}

	public String toString ()
	{
		String test = "| x: " + rect_x + " | y: "+ rect_y + " | width: " + rect_width +" height" + rect_height;
		return test; 

	}

	// getting the left bounding box of each rectangle

	public Rectangle getLeftBounds() 
	{
		return new Rectangle(rect_x-1,rect_y+20,rect_x, rect_height);
	}
}