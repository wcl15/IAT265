import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;


public class SadFace extends Face {
	
	
	public SadFace() {
		super();
		
	}
	
	public void draw(Graphics2D g2) {
		AffineTransform transform = g2.getTransform();
		g2.translate(bugX, bugY);
		g2.scale(scale, scale);
		
		g2.setTransform(transform);
}
