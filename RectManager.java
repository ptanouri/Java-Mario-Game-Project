import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Rectangle;
import javax.swing.JApplet;
import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.JFrame;



public class RectManager 
{
	private int width;
	private int height;
	private Rect temp;
	private int x;
	private int y;
	List<Rect> rectangles_list = new ArrayList<>(); // making a list made of rectangles 


	public RectManager() 
	{
		generate_Rectangles(60); // creating a list of 60 rectangles

	}

	

	public void generate_Rectangles(int number_of_rects)
	{
		x = 0;
		height = 400;
		Random rand = new Random(); 
		for (int i = 0; i < number_of_rects; i++) // generating rectangles with random height, width 
		{
			width = rand.nextInt(100)+150;
			y = rand.nextInt(150)+400;

			temp = new Rect(x,y,width,height);

			rectangles_list.add(temp);
			x = x+width+60; // so the gap between each rect is not more than 40 pixels
		}
	}


	public int which_rectangle(int position)
	{
		for (int i = 0; i<rectangles_list.size();i++) // deciding which rectangle does the cgaracter land on
		{
			if (rectangles_list.get(i).get_rect_x() < position && rectangles_list.get(i).get_rect_x() + rectangles_list.get(i).get_rect_width() > position)
			{
				return i;
			}
			if (rectangles_list.get(i).get_rect_x() > position) 
			{
				return i-1;
			}
		}

		return -1;
	}
}


