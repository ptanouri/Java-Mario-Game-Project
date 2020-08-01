import java.awt.EventQueue;
import javax.swing.JFrame;


public class Run extends JFrame 
{


	public Run() 
	{

		initUI(); // contructing
	}

	private void initUI() 
	{

		add(new Game()); // create a new game

		setResizable(false);
		pack();

		setTitle("Endless Runner"); // setting title
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the game when exit
	}

	public static void main(String[] args) 
	{

		EventQueue.invokeLater(new Runnable() 
		{
			@Override
			public void run() 
			{
				Run ex = new Run(); // create an instance of Run
				ex.setVisible(true); // make the game visible
			}
		});
	}
}

