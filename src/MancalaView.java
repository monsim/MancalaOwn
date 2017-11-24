import java.awt.*;
import javax.swing.*;

/**
 * Displays the GUI frame of a Mancala board.
 * The action listeners in this are the "controllers" of the MVC model.
 * 
 * @author Vincent Stowbunenko
 *
 */
public class MancalaView extends JFrame {

	private MancalaModel model;
//	private MancalaBoardPanelRectangle board;
	private Button buttonStart;
	private Button buttonUndo;
	private final MancalaBoardContext context;
	ButtonGroup bg;
	ButtonGroup bg2; //button group for strategy buttons
	private MancalaBoardFormatter board;
	
	public MancalaView(MancalaModel model) {
		
		context = new MancalaBoardContext();
		
		// Connect the view to the model
		this.model = model;

		// A panel with just radio buttons
		JPanel radioPanel = new JPanel();
		JRadioButton rbutton1 = new JRadioButton("3", true);
		rbutton1.setActionCommand(rbutton1.getText());
		JRadioButton rbutton2 = new JRadioButton("4");
		rbutton2.setActionCommand(rbutton2.getText());
		bg = new ButtonGroup();
		bg.add(rbutton1);
		bg.add(rbutton2);
		radioPanel.add(rbutton1);
		radioPanel.add(rbutton2);

		//A panel with radio button for strategy pattern
		JPanel strategyPanel = new JPanel();
		JRadioButton sbutton1 = new JRadioButton("1", true);
		sbutton1.setActionCommand(sbutton1.getText());
		JRadioButton sbutton2 = new JRadioButton("2");
		sbutton2.setActionCommand(sbutton2.getText());
		bg2 = new ButtonGroup();
		bg2.add(sbutton1);
		bg2.add(sbutton2);
		strategyPanel.add(sbutton1);
		strategyPanel.add(sbutton2);
		
		
		// Top right panel, merging radio buttons with its label and stategy buttons with label and merging all four into one
		JPanel topRightPanel = new JPanel(new BorderLayout());
		JPanel topRightStonePanel = new JPanel(new BorderLayout());
		topRightStonePanel.add(new Label("Initial number of stones:"), BorderLayout.NORTH);
		topRightStonePanel.add(radioPanel, BorderLayout.SOUTH);
		JPanel topRightStrategyPanel = new JPanel(new BorderLayout());
		topRightStrategyPanel.add(new Label("Style number:"), BorderLayout.NORTH);
		topRightStrategyPanel.add(strategyPanel, BorderLayout.SOUTH);
		topRightPanel.add(topRightStonePanel, BorderLayout.NORTH);
		topRightPanel.add(topRightStrategyPanel, BorderLayout.SOUTH);
		
		MancalaView outsideThis = this;
		
		// Top left panel, just all push buttons
		JPanel topLeftPanel = new JPanel();
		buttonStart = new Button("Start");
		buttonStart.addActionListener(event -> {
			model.emptyPits();
			model.setPlayerTurn('A');
			model.populatePits(Integer.parseInt(bg.getSelection().getActionCommand()));
			int input = Integer.parseInt(bg2.getSelection().getActionCommand());
			System.out.println("input: " + input);
			if (input == 1) { //rounded rectangle
				board = new MancalaBoardPanelRound(1000,400,model);
				System.out.println("rounded rectangle");
//				board.format(formatter);
				outsideThis.add((Component) board, BorderLayout.CENTER);
			} else {			//input == 2. normal rectangle
				board = new MancalaBoardPanelRectangle(1000,400,model);
				System.out.println("rectangle");
				outsideThis.add((Component) board, BorderLayout.CENTER);
			}
			board.clearStones();
			board.populateStones(model.getPits());
			board.randomizeAllPositions();
			board.setGameStarted(true);
			board.repaint();
			board.setVisible(true);
		});
		buttonUndo = new Button("Undo");
		buttonUndo.addActionListener(event -> {
			System.out.println("undoign");
			model.undo();
			board.repaint();
		});
		buttonStart.setPreferredSize(new Dimension(80, 40));
		buttonUndo.setPreferredSize(new Dimension(80, 40));
		topLeftPanel.add(buttonStart);
		topLeftPanel.add(buttonUndo);

		// Add panel with start and undo buttons at upper left corner
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.add(topLeftPanel, BorderLayout.WEST);
		topPanel.add(topRightPanel, BorderLayout.EAST);

		// Make a new board for the bottom panel
//		board = new MancalaBoardPanelRectangle(1000, 400, model);
		//taken care above in buttonStart's action listener
		
		// Put all panels in one frame
		add(topPanel, BorderLayout.NORTH);
//		add(board, BorderLayout.CENTER);
		setTitle("Mancala");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null); // Center the window
		setVisible(true);
		board.setVisible(false);

	}

	public Button getButtonStart() {
		return buttonStart;
	}

	public Button getButtonUndo() {
		return buttonUndo;
	}

	public MancalaBoardFormatter getBoard() {
		return board;
	}

}