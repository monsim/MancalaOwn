import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

import javax.swing.*;

public interface MancalaBoardFormatter{
	public void repaint();
	public void setVisible(boolean bool);
	public void randomizePosition(MancalaStoneGraphics stone, RectangularShape shape, boolean animate);
	public void randomizeAllPositions();
	public double distance(MancalaStoneGraphics stone1, MancalaStoneGraphics stone2);
	public double distanceFinal(MancalaStoneGraphics stone1, MancalaStoneGraphics stone2);
	public double distance(double x1, double y1, double x2, double y2);
	public void clearStones();
	public void populateStones(ArrayList<LinkedList<Integer>> pits);
	public void updateStonePositions();
	public boolean isBoardStillAnimating();
	public boolean isGameStarted();
	public void setGameStarted(boolean gameStarted);
	public void mouseClicked(MouseEvent e);
	public void mouseEntered(MouseEvent e);
	public void mouseExited(MouseEvent e);
	public void mousePressed(MouseEvent e);
	public void mouseReleased(MouseEvent event);
	public void mouseDragged(MouseEvent arg0);
	public void mouseMoved(MouseEvent event);
	public void actionPerformed(ActionEvent arg0);
	
}
