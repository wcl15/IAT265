/* A App that creates a JFrame window
 * A demo program created for IAT-265 Spring 15
 * Author: Eric Yang
 * Date of creation: Feb 2 2015
 * Date of Modification: Feb 4 2015
 * All rights reserved
 */

public class FaceApp extends javax.swing.JFrame {
	public FaceApp(String title) {
		super(title);
		this.setSize(800, 700);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.add(new FacePanel());
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new FaceApp("IAT265 Lab 4 Activity");
	}
}