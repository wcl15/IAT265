import java.awt.*;
import java.awt.geom.*;
import java.awt.color.*;

import processing.core.*;

public class Face {
	
	protected Ellipse2D.Double face, eye;
	private Line2D.Double eyebrow;
	private Arc2D.Double mouth;
	protected PVector pos;
	int faceSize, scale;
	Color faceColor, eyeColor;
	
	public Face(int x, int y, int scale) {
		this.pos = new PVector(x, y);
		face = new Ellipse2D.Double();
		eye = new Ellipse2D.Double();
		eyebrow = new Line2D.Double();
		mouth = new Arc2D.Double();
	}

	public void setFaceAttributes() {
		face.setFrame(pos.x, pos.y, faceSize, faceSize);
	}
	
	public void drawFace(Graphics2D g2) {
		AffineTransform transform = g2.getTransform();
		g2.translate(pos.x, pos.y);
		g2.scale(scale, scale);
		
		g2.draw(face);
		
		g2.setTransform(transform);
	}

}
