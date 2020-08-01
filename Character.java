
// import java.awt.Graphics;
// import java.awt.Color;
// import javax.swing.JComponent;
// import java.awt.event.KeyListener;
// import javax.swing.Timer;

import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import java.awt.event.MouseListener;

public class Character 

{

	private int character_x;
	private int character_y;
	private boolean player_hit; // hit or not hit
	private int number_of_healths;

	private int y_velocity;

	private int character_width;
	private int character_height;
	private double g = 9.81;
	private int dy = 6;
	private Rect rectangle1;
	private int current_y; 
	private boolean jump_again;

// below is the contructor and getter and setter for the variable we want to use

	public Character(int character_x, int character_y,int number_of_healths) 
	{
		this.character_x = character_x;
		this.character_y = character_y;
		current_y = this.character_y;
		this.number_of_healths = number_of_healths;
		this.y_velocity = 0;
		player_hit = false;
		this.character_width = 40;
		this.character_height = 40;
		this.jump_again = false;
	}

	public int get_character_x()
	{
		return character_x;
	}

	public void set_character_x(int character_x)
	{
		this.character_x = character_x;
	}

	public int get_character_y()
	{
		return character_y;
	}

	//public void set_character_y(int character_y)
	//{
	//	this.character_y = character_y;
	//}
	public boolean getPlayerState()
	{
		return player_hit;
	}

	public void setPlayerState(boolean player_hit)
	{
		this.player_hit = player_hit;
	}

	public int getNumberOfHealths()
	{
		return number_of_healths;
	}

	public void setNumberOfHealths(int number_of_healths)
	{
		this.number_of_healths = number_of_healths;
	}


	public int get_y_velocity()
	{
		return y_velocity;
	}

	public void set_y_velocity(int y_velocity)
	{
		this.y_velocity = y_velocity;
	}

	public int get_character_width()
	{
		return character_width;
	}

	public void set_character_width(int character_width)
	{
		this.character_width = character_width;
	}

	public int get_character_height()
	{
		return character_height;
	}

	public void set_character_height(int character_height)
	{
		this.character_height = character_height;
	}


	public Rectangle getUpBounds() 
	{
		return new Rectangle(character_x,character_y-5,30,5);
	}

	public Rectangle getBottomBounds()
	{
		return new Rectangle(character_x,character_y+30,30,5);
	}

	public Rectangle getFrontBounds()
	{
		return new Rectangle(character_x+30,character_y,5,30);
	}

	
	public void jump(RectManager rect_mang2)
	{
		

		jump_again = false; // a boolean to know when to jump
		rectangle1 = rect_mang2.rectangles_list.get(0); // get the first rectangle

		character_y = character_y + dy;

		if (character_y <= current_y - 250) // the character's jump can only be 250 frames max
		{
			dy = 6;
		}

		if (character_y >= rectangle1.get_rect_y()-40 && (rectangle1.get_rect_x()+rectangle1.get_rect_width()> 50)) // this is to make the character fall again and 
		{ 
			character_y = rectangle1.get_rect_y()-40;
			current_y = rectangle1.get_rect_y()-40;
			jump_again = true; // let the character jump again
			
		}


	}

	public void keyPressed(KeyEvent e) 
	{

		int key = e.getKeyCode();

		if(jump_again)
		{

			if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP) // if enter or up key was pressed, jump
			{

				dy = -4;
			}
		}

	}

	public void keyReleased(KeyEvent e) 
	{

		int key = e.getKeyCode();
		if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP) // if key released, fall
		{
			dy = 6;
		}

		
	}


	public void mousePressed(MouseEvent e) 
	{
		if(jump_again) // jump with mouse press
		{

			dy = -4;
		}
	}

	public void mouseReleased(MouseEvent e)
	{
		dy = 6; // fall with mouse relsease
	}

}