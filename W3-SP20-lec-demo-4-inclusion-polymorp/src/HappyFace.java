/* A Bug class that draws and moves a Bug
 * A demo program created for IAT-265 Spring 15
 * Author: Eric Yang
 * Date of creation: Feb 16 2015
 * All rights reserved
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class HappyFace extends Face {
	Ellipse2D.Double centerDot;
	double dotWidth;
	Color dotColor;

	public HappyFace () {
		super();
	}

	public void draw(Graphics2D g2) {
		
		AffineTransform tf = g2.getTransform();
		g2.translate(bugX, bugY);
		g2.scale(scale, scale);
		
		g2.setTransform(tf);
	
}
