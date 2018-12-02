package com.changent.jequire;

import java.io.*;
import java.awt.*;
import java.util.*;

import java.net.URL;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JProgressBar;
import javax.swing.text.Utilities;
import com.changent.util.ui.*;

/**
 * Splash screen. This class can also load classes listed in
 * file classlist.
 */

/*
 * JequireSplash.java - Jequire Splash Screen (also a class loader)
 */
public class JequireSplash extends JWindow implements Runnable
{
  // private fields
  private Thread thread;
  private boolean finished;
  private String[] classes;
  private JProgressBar progress;

  /**
   * Creates a new splash screen which displays a picture,
   * a copyright and a progress bar used to indicate the
   * loading progress of the application.
   */

  public JequireSplash()
  {
    setBackground(Color.lightGray);

    JPanel pane = new JPanel(new BorderLayout());

    pane.setFont(new Font("Monospaced", 0, 14));
    String icon = "images/splash" + (Math.abs(
		 new Random().nextInt()	)% 2) + ".gif";
    pane.add(
		BorderLayout.NORTH,
			new JLabel(
				Toolbox.getIcon(icon, Jequire.class, this)
             )
	);

    progress = new JProgressBar(0, 100);
    progress.setStringPainted(true);
    progress.setFont(new Font("Monospaced", Font.BOLD, 9));
    progress.setString("");
    progress.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
    pane.add(BorderLayout.CENTER, progress);
    pane.add(BorderLayout.SOUTH, new JLabel("v" + Jequire.RELEASE +
                                            " - (C) 1999-2004 William Lodge Turner III",
                                            SwingConstants.CENTER));

    pane.setBorder(new EtchedBorder(EtchedBorder.RAISED));
    getContentPane().add(pane);

    pack();

//	boolean load = "on".equals(Jequire.getProperty("load.classes"));
	boolean load = true;
    if (load)
    {
      createClassesList();

      thread = new Thread(this);
      thread.setDaemon(true);
      thread.setPriority(Thread.NORM_PRIORITY);
    }

	Toolbox.centerComponent(this);
	Toolbox.setCursorOnWait(this, true);
    setVisible(true);

    if (load)
    {
      thread.start();
    } else {
      finished = true;
      setProgress(0);
	  setText("starting...");
//	  setText(Jext.getProperty("startup.loading"));
    }
  }

  // get the classes to be loaded from the file 'classlist'.

  private void createClassesList()
  {
    Vector buf = new Vector(30);
    BufferedReader in = new BufferedReader(new InputStreamReader(
                                           Jequire.class.getResourceAsStream("classlist")));
    String buffer;
    try
    {
      while ((buffer = in.readLine()) != null)
        buf.addElement(buffer);
      in.close();
    } catch (IOException ioe) { }

    classes = new String[buf.size()];
    buf.copyInto(classes);
    buf = null;
  }

  /**
   * Loads the classes dinamycally from the list.
   */

  public void run()
  {
    String packs = getClass().getName();
    int i = packs.lastIndexOf('.');
    if (i >= 0)
      packs = packs.substring(0, i + 1);
    else
      packs = "";

    for (i = 0; i < classes.length; i++)
    {
      String n = classes[i];
      int j = n.lastIndexOf('.');
      if (j < 0) n = packs + n;
      progress.setString(n);

      try
      {
        Class c = Class.forName(n);
      } catch(Exception e) { }
      progress.setValue(100 * (i + 1) / classes.length);
    }
    finished = true;
	setText("starting...");
//	setText(Jequire.getProperty("startup.loading"));
    stop();
  }

  /**
   * Sets the current text of the progress bar but
   * only in the case the loading of classes is ended.
   */

  public void setText(String text)
  {
    if (finished)
      progress.setString(text);
  }

  /**
   * Sets the current progress value of the progress bar but
   * only in the case the loading of classes is ended.
   */

  public void setProgress(int percent)
  {
    if (finished)
      progress.setValue(percent);
  }

  /**
   * Stop the loading process.
   */

  public void stop()
  {
    thread = null;
  }
}

// End of JequireSplash.java
