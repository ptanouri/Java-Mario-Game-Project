

import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.applet.Applet;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.Timer;
import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

import java.util.ArrayList;
import java.awt.FontMetrics;
import java.util.Random;
import java.time.Instant;
import java.util.Formatter;
import java.text.Format;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.awt.Image;
import javax.swing.ImageIcon;






public class Game extends JPanel implements ActionListener
{
	Random random = new Random();
	Character character;
	private ArrayList<Hazards> hazard_list;
	private ArrayList<Powers> power_list;

	RectManager rect_mang ;

	private Timer timer;
	private boolean ingame;
	private boolean fin_game;
	private final int DELAY = 10;
	private final int G_WIDTH = 800;
	private final int G_HEIGHT = 800;

	private int haz_x;
	private int haz_y;
	private int power_x;
	private int power_y;
	private int total_width; 
	private long start_time;
	private long end_time;
	private double temp_time;
	// private int healths_left;
	private boolean took_hit = false;
	private int score;
	private int test_health;
	private int test_power;

	private int fin_rect;

	

	public Game()
	{
		initGame();

	}

	// initializing the game

	public void initGame() 
	{
		// adding adaptors
		addKeyListener(new TAdapter());
		addMouseListener(new Madaptor());
		setFocusable(true);
		setBackground(Color.BLACK);
		ingame = true;
		fin_game = false;

		setPreferredSize(new Dimension(G_WIDTH,G_HEIGHT));
		rect_mang = new RectManager();
		total_width = rect_mang.rectangles_list.get(59).get_rect_x() + rect_mang.rectangles_list.get(59).get_rect_width();
		fin_rect = rect_mang.rectangles_list.get(4).get_rect_x() + rect_mang.rectangles_list.get(4).get_rect_width();
		

		character = new Character(50,300,3);
		
		initHazard();
		initPower();

		
		timer = new Timer(DELAY,this);
		timer.start();
		score = 0;
		test_power = 0;

		
	}


	// initialzing a hazard list

	public void initHazard()
	{
		hazard_list = new ArrayList<>();
		haz_x = random.nextInt(400)+300;
		haz_y = random.nextInt(20)+400;

		for (int i = 0; i < 14; i++) // Number of hazards is 15 total
		{
			

			int haz_temp_x = random.nextInt(total_width-100)+100;

			int haz_temp_y = rect_mang.rectangles_list.get(rect_mang.which_rectangle(haz_temp_x)).get_rect_y()-20;

			Hazards temp_haz = new Hazards(haz_temp_x,haz_temp_y);
			hazard_list.add(temp_haz);

		}

		
	}

	// initialzing the power list

	public void initPower()
	{
		power_list = new ArrayList<>();
		power_x = random.nextInt(400)+300;
		power_y = random.nextInt(20)+400;
		// power = new Powers(power_x,power_y);

		for (int i = 0; i < 24; i++)
		{
			int power_temp_x =random.nextInt(total_width-100)+100;
			int power_temp_y = rect_mang.rectangles_list.get(rect_mang.which_rectangle(power_temp_x)).get_rect_y()-50;
			Powers temp_power = new Powers (power_temp_x,power_temp_y);
			power_list.add(temp_power);
		}
	}



	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawObjects(g); // draw everything

		if (ingame) 
		{

			drawObjects(g); 

			if (fin_game)
			{
				drawWin(g); // draw the winning message if character won the game
			}


		}


		else 
		{

			drawGameOver(g); // otherwise print Game over!
		}

		

		Toolkit.getDefaultToolkit().sync();
	}

	private void drawObjects(Graphics g)
	{
				// DRAWING ALL THE VISIAL ELEMENTS ON THE SCREEN
		test_health = hazard_list.size()-11; // calculating lives left

		
		NumberFormat formatter = new DecimalFormat("#000.00");

		if (temp_time <12) // day time
		{
			setBackground(Color.CYAN);


			ImageIcon k = new ImageIcon("rain4.png");
			Image image3 = k.getImage();
			g.drawImage(image3,-25,200,this);

			ImageIcon cloud = new ImageIcon("cloud2.png");
			Image image4 = cloud.getImage();
			g.drawImage(image4,100,20,this);

			ImageIcon cloud3 = new ImageIcon("cloud3.png");
			Image image5 = cloud3.getImage();
			g.drawImage(image5,500,180,this);

			Color brown = new Color(150, 70, 20);

			g.setColor(brown);
			for (Rect r : rect_mang.rectangles_list) 
			{
				g.fillRect(r.get_rect_x(), r.get_rect_y(),r.get_rect_width(),r.get_rect_height());
				
			}


			g.setColor(Color.RED);
			g.fillRect(character.get_character_x(),character.get_character_y(),character.get_character_width(),character.get_character_height());

			g.setColor(Color.BLACK);

			
		
			

			g.drawString("Elapsed Time: " + formatter.format(temp_time),5,15); // presenting Elapsed time
			g.drawString("Lives Left: " + test_health,670,15);
			


			for (Hazards h : hazard_list) // drawing the hazards
			{
				if (h.isVisible())
				{
					g.fillRect(h.get_hazard_x(),h.get_hazard_y(),20,20);
				}
			}

			g.setColor(Color.ORANGE);

			for (Powers p: power_list) // drawing the powers
			{
				if (p.isVisible())
				{
					g.fillRect(p.get_power_up_x(),p.get_power_up_y(),20,20);
				}
			}

			ImageIcon i = new ImageIcon("sun3.png");
			Image image = i.getImage();
			g.drawImage(image,550,50,this);
		}


		if (temp_time >= 12) // night time
		{



			for (int i = 0; i <rect_mang.rectangles_list.size(); i++)
			{
				rect_mang.rectangles_list.get(i).set_dxx(3);

			}

			for (int i = 0; i <power_list.size(); i++)
			{
				power_list.get(i).set_dxx(3);

			}

			for (int i = 0; i <hazard_list.size(); i++)
			{
				hazard_list.get(i).set_dxx(3);

			}


			setBackground(Color.darkGray);
			g.drawString("Elapsed Time: " + formatter.format(temp_time),5,15);

			
			g.drawString("Healths Left: " + test_health,670,15);
			

			ImageIcon j = new ImageIcon("star2.png");
			Image image2 = j.getImage();
			g.drawImage(image2,0,0,this);
			g.drawImage(image2,290,0,this);
			g.drawImage(image2,580,0,this);
			g.drawImage(image2,0,290,this);
			g.drawImage(image2,290,290,this);
			g.drawImage(image2,580,290,this);

			// g.drawImage(image2,300,0,this);

			ImageIcon i = new ImageIcon("moon2.png");
			Image image = i.getImage();
			g.drawImage(image,100,70,this);
			g.setColor(Color.lightGray);

			for (Rect r : rect_mang.rectangles_list) 
			{
				g.fillRect(r.get_rect_x(), r.get_rect_y(),r.get_rect_width(),r.get_rect_height());
				
			}

			g.setColor(Color.RED);
			g.fillRect(character.get_character_x(),character.get_character_y(),character.get_character_width(),character.get_character_height());
			
			g.setColor(Color.BLACK);



			for (Hazards h : hazard_list)
			{
				if (h.isVisible())
				{
					g.fillRect(h.get_hazard_x(),h.get_hazard_y(),20,20);
				}
			}

			g.setColor(Color.ORANGE);

			for (Powers p: power_list)
			{
				if (p.isVisible())
				{
					g.fillRect(p.get_power_up_x(),p.get_power_up_y(),20,20);
				}
			}

			

		}

		if (test_health == 0)
		{
			ingame = false;
		}

	}



	public void drawGameOver(Graphics g) 
	{
		// drawing the game over message

		String msg = "Game Over, Your Score Was: " + (score+(10*(24-power_list.size())));
		Font small = new Font("Helvetica", Font.BOLD, 26);
		FontMetrics fm = getFontMetrics(small);

		g.setColor(Color.RED);
		g.setFont(small);
		g.drawString(msg,(G_WIDTH - fm.stringWidth(msg))/2,G_HEIGHT/2);
	}

	public void drawWin(Graphics g)
	{
		// drawing the win message 

		String msg2 = "YOU FINISHED THE GAME :') Your Final Score was: " + (score+(10*(24-power_list.size())));
		Font small = new Font("Helvetica", Font.BOLD, 26);
		FontMetrics fm = getFontMetrics(small);

		g.setColor(Color.ORANGE);
		g.setFont(small);
		g.drawString(msg2,(G_WIDTH - fm.stringWidth(msg2))/2,G_HEIGHT/2);
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		// updating the game after every delay

		inGame();
		finGame();
		updateGround();
		updatePower();
		updateCharacter();
		updateHazard();
		checkCollisions();

		temp_time += 0.01;

		score = (int)(temp_time*10);
		
		repaint();
	}

	public void inGame() 
	{ // see if in game or not

		if (!ingame) {
			timer.stop();
			// end_time = System.currentTimeMillis();
		}
	}

	public void finGame()
	{ // check to see if the player finished the game

		if(fin_game)
		{
			timer.stop();
		}
	}

	// update character
	public void updateCharacter()
	{
		character.jump(rect_mang);
	}

	// update power
	public void updatePower()
	{
		for (int i = 0; i< power_list.size(); i++)	
		{

			Powers pow1 = power_list.get(i);

			if (pow1.isVisible())
			{
				pow1.powerUp_move();
			}

			else
			{
				power_list.remove(i);
			}


		}

	}

	// update hazards

	public void updateHazard()
	{
		for (int i = 0; i < hazard_list.size(); i++)
		{
			Hazards haz1 = hazard_list.get(i);
			if (haz1.isVisible())
			{
				haz1.hazard_move();
			}
			else
			{
				hazard_list.remove(i); // remove from the list
			}
		}
	}

	// uodate ground

	public void updateGround()
	{


		for (int i = 0; i <rect_mang.rectangles_list.size(); i++)
		{
			Rect rect1 = rect_mang.rectangles_list.get(i);
			if (rect1.isVisible())
			{
				rect1.rect_move();
			}
			else 
			{
				rect_mang.rectangles_list.remove(i);

				if (rect_mang.rectangles_list.size() == 1)
				{
					fin_game = true;
				}
			}
		}


	}


	public void checkCollisions() 
	{ // creating a bounding box and check for collision

		Rectangle char_up = character.getUpBounds();
		Rectangle char_down = character.getBottomBounds();
		Rectangle char_front = character.getFrontBounds();

		for (Powers pow: power_list)
		{
			if (!power_list.isEmpty()) // whe power-ups is hit
			{
	
				if (pow.getPowerBounds().intersects(char_down)|| pow.getPowerBounds().intersects(char_up)|| pow.getPowerBounds().intersects(char_front))
				{
					pow.setVisible (false);
				}
			}	
		}

		for (Hazards haz: hazard_list) // when hazard is hit
		{
			if(!hazard_list.isEmpty())
			{
				if (haz.getHazardBounds().intersects(char_down)|| haz.getHazardBounds().intersects(char_up)|| haz.getHazardBounds().intersects(char_front))
				{
					haz.setVisible (false);

					
				}
			}

		}

		for (Rect rec: rect_mang.rectangles_list) // if this happen, game over
		{

			if (rec.getLeftBounds().intersects(char_front))
			{
				ingame = false;
			}
		
		}



		if (character.get_character_x() == fin_rect)
		{
			fin_game = true;
		}

	}


// following methods, refer the program to the character class to decide what to do when a key or mouse is pressed

	private class TAdapter extends KeyAdapter 
	{

		@Override
		public void keyReleased(KeyEvent e) {
			character.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			character.keyPressed(e);
		}
	}


	private class Madaptor extends MouseAdapter
	{
		@Override
		public void mousePressed(MouseEvent e) 
		{
			character.mousePressed(e);

		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
			character.mouseReleased(e);
		}
	}

	
}
