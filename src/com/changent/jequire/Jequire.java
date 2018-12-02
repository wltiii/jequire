package com.changent.jequire;

import java.awt.*;
import java.awt.event.*;
import java.util.Properties;

import javax.swing.*;
//import javax.swing.border.*;

/**
 * Author : Bill Turner
 * Date   : 19 Nov 2000
 *
 * Jequire
 *
 * Encapsulates the Volere Requirements Specification Template
 * (copyright © 1996 - 2000 Atlantic Systems Guild) to allow
 * easy management of requirements. It also provides other
 * features useful to the requirements engineer.
 *
 * @author Bill Turner
 * last updated by: $Author$
 * @version $Revision$
 * @date 17-Feb-04
 * last committed: $Date$
 * tag: $Name$
 **/
public class Jequire extends JFrame {
  /**
	 * 
	 */
	private static final long serialVersionUID = -5356636014697377772L;
/** Jequire home directory. */
	public static final String JEQUIRE_HOME = System.getProperty("user.dir");
	/** Current Jequire release. */
	public static final String RELEASE = "0.0";
	/** Last Jequire build date. */
	public static final String BUILD = "03.02.00.03";
	private JMenu fileM;
	private JMenu helpM;
	private JMenuItem exitMI;
	private JMenuItem aboutMI;

	// constructor
	public Jequire() {
		super("Jequire");
		makeMenuBar();
	//	setAccelerators();
		addListeners();
		JequireTabs jt = new JequireTabs();
		getContentPane().add(jt, BorderLayout.CENTER);
	}

	private void makeMenuBar() {
		JMenuBar mb = new JMenuBar();

		fileM = makeFileMenu();
		helpM = makeHelpMenu();

		mb.add(fileM);
		mb.add(helpM);

		this.setJMenuBar(mb);
	}

	private JMenu makeFileMenu() {
		// create menu
		fileM = new JMenu( "File" );
		fileM.setMnemonic('F');

		exitMI = new JMenuItem( "Exit", 'x' );

		//add menu items
		fileM.add(exitMI);

		return fileM;
	}

	private JMenu makeHelpMenu() {
		// create menu
		helpM = new JMenu( "Help" );
		helpM.setMnemonic('H');

		aboutMI = new JMenuItem( "About", 'a' );

		//add menu items
		helpM.add(aboutMI);

		return helpM;
	}
/*
	private void setAccelerators() {
		exitMI.setAccelerator(
			KeyStroke.getKeyStroke( KeyEvent.VK_X, Event.CTRL_MASK )
		);
	}
*/
	private void addListeners() {
    	exitMI.addActionListener( new exitHandler() );
    	aboutMI.addActionListener( new aboutHandler() );
	}

  	class exitHandler implements ActionListener {
		public void actionPerformed( ActionEvent e ) {
			System.exit(0);
    	}
  	}

  	class aboutHandler implements ActionListener {
		public void actionPerformed( ActionEvent e ) {
			// not defined yet
    	}
  	}

	// main
	public static void main(String args[]) {
		Properties p = System.getProperties();
		
		p.list(System.out);
		
		System.out.println("");
		
		
//		for (Enumeration e = p.keys() ; e.hasMoreElements() ;) {
//	         System.out.println(e.nextElement());
//
//	     }
//		
//		System.out.println("");
		
		JFrame f = new Jequire();
		f.addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent e){
					System.exit(0);
				}
			}
		);

		// Determine position and size of the screen
		Toolkit tk = f.getToolkit();
		Dimension d = tk.getScreenSize();
		int w = (int) d.width;
		int h = (int) (d.height * .90);
		int x = (d.width - w ) / 2;
		int y = (d.height - h ) / 4;
		f.setBounds(x, y, w, h);

		f.setVisible(true);
	}
}