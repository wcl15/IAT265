/* A Ladybug Panel that draws a collection of ladybug moving around in a garden
 * A demo program created for IAT-265 Spring 15
 * Author: Eric Yang
 * Date of creation: Feb 2 2015
 * Date of Modification: Feb 4 2015
 * All rights reserved
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class FacePanel extends JPanel implements ActionListener {
	public final static int GARDEN_W = 600;
	public final static int GARDEN_H = 400;
	public final static int GARDEN_X = 100;
	public final static int GARDEN_Y = 50;
	private int count = 30;
	private Bug[] bugs = new Bug[count];
	private Rectangle2D.Double garden;
	private Timer timer;

	public FacePanel() {
		super();
		this.setBackground(java.awt.Color.white);
		garden = new Rectangle2D.Double();

		for (int i = 0; i < count / 3; i++) {
			double scale = Util.random(0.4, 1.2);
			double speedX = Util.random(-2.0, 2.0);
			double speedY = Util.random(-2.0, 2.0);
			bugs[i] = new EatingBug(GARDEN_X + Util.random(60, GARDEN_W - 60), GARDEN_Y
					+ Util.random(30, GARDEN_H - 30), speedX, speedY, scale);
		}

		for (int i = count / 3; i < count; i++) {
			double scale = Util.random(0.4, 1.2);
			double speedX = Util.random(-2.0, 2.0);
			double speedY = Util.random(-2.0, 2.0);
			bugs[i] = new VeggieBug(GARDEN_X + Util.random(60, GARDEN_W - 60), GARDEN_Y
					+ Util.random(30, GARDEN_H - 30), speedX, speedY, scale);
		}
		garden.setFrame(GARDEN_X, GARDEN_Y, GARDEN_W, GARDEN_H);

		timer = new Timer(30, this);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(0, 200, 0));
		g2.fill(garden);
		for (int i = 0; i < bugs.length; i++) {
			for (int j = 0; j < bugs.length; j++) {
				// if bug i is an instance of EatingBug
				if (i != j) {
					if (bugs[i] instanceof EatingBug) {
						EatingBug bugi = (EatingBug) bugs[i];
						// check collision between an EatingBug and any other
						// bug (eating or viggie)
						if (bugi.detectCollision(bugs[j]) && bugi.checkHeadOn(bugs[j])) {
							bugi.eat(bugs[j]);
						} else if (bugi.detectCollision(bugs[j]) && !bugi.checkHeadOn(bugs[j])) {
							bugi.bounce(bugs[j]);
						}

						// check collision between VeggieBug objects
					} else if (bugs[i].detectCollision(bugs[j])) {
						bugs[i].bounce(bugs[j]);
					}

				}
			}
			bugs[i].drawBug(g2);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < bugs.length; i++) {
			bugs[i].move();
		}
		repaint();
	}
}