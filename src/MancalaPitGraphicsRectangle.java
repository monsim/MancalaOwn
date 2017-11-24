
import java.awt.geom.*;
import java.util.*;

/**
 * A class that holds graphics properties for each pit.
 * 
 * @author Vincent Stowbunenko
 *
 */
public class MancalaPitGraphicsRectangle {

	private Rectangle2D outerBound;
	private Rectangle2D innerBound;
	private LinkedList<MancalaStoneGraphics> stones;
	
	public MancalaPitGraphicsRectangle() {
		stones = new LinkedList<>();
	}
	
	public Rectangle2D getOuterBound() {
		return outerBound;
	}
	public void setOuterBound(Rectangle2D outerBound) {
		this.outerBound = outerBound;
	}
	public Rectangle2D getInnerBound() {
		return innerBound;
	}
	public void setInnerBound(Rectangle2D innerBound) {
		this.innerBound = innerBound;
	}
	public LinkedList<MancalaStoneGraphics> getStones() {
		return stones;
	}
	public void setStones(LinkedList<MancalaStoneGraphics> stones) {
		this.stones = stones;
	}
	

}
