package com.changent.jequire;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
//import java.awt.event.*;
//import java.io.*;
//import java.text.*;
//import java.util.*;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;
//import javax.swing.border.*;
//import javax.swing.event.*;
//import javax.swing.table.*;
import com.changent.util.ui.*;

/**
 * Author : Bill Turner Date : 19 Nov 2000
 * 
 * DriversTabs
 */
public class DriversTabs extends JPanel
{
	private static final long serialVersionUID = 1L;

	private JEditorPane pane;

	private JButton cancelPurposeB, clearPurposeB;

	private JTextArea problemText, goalText;

	private JTextField client1, client2, client3, cust1, cust2, cust3;

	private JButton cancelPrincipalB, clearPrincipalB;

	private JTextArea stakeholderKnowledge, stakeholderInvolvement;

	private JTextArea stakeholderInfluence, stakeholderConflictAgreement;

	private JTextField stakeholderName, stakeholderTitle,
			stakeholderOrganization;

	private JButton addStakeholderB, deleteStakeholderB, cancelStakeholderB,
			clearStakeholderB;

	private JButton firstStakeholderB, prevStakeholderB, nextStakeholderB,
			lastStakeholderB;

	// constructor
	public DriversTabs()
	{
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		add(makeTabs(), BorderLayout.CENTER);
	}

	public JTabbedPane makeTabs()
	{
		JTabbedPane tp = new JTabbedPane();
		// tp.addTab("Purpose", makePurposeTab());
		// tp.addTab("Principals", makePrincipalsTab());
		// tp.addTab("Other Stakeholders", makeStakeholdersTab());
		// tp.addTab("Users", makeUsersTab());
		tp.addTab("HTML TextPane", makeEditorTab());
		tp.addTab("HTML EditorPane", makeTestHtmlInputTab());

		tp.setSelectedIndex(0);

		return tp;
	}

	// makePurposeTab
	private JPanel makePurposeTab()
	{
		JPanel p = new JPanel(new BorderLayout());
		p.add(makePurposePane(), BorderLayout.CENTER);
		p.add(makePurposeButtons(), BorderLayout.EAST);
		return p;
	}

	// makePurposePane
	private JPanel makePurposePane()
	{
		problemText = new JTextArea(4, 60);
		problemText.setLineWrap(true);
		problemText.setWrapStyleWord(true);

		goalText = new JTextArea(4, 60);
		goalText.setLineWrap(true);
		goalText.setWrapStyleWord(true);

		FormPanel fp = new FormPanel();

		// add items to fp (in pairs)
		fp.add(new JLabel("Problem"));
		fp.add(new JScrollPane(problemText), BorderLayout.CENTER);

		fp.add(new JLabel("Goal"));
		fp.add(new JScrollPane(goalText), BorderLayout.CENTER);

		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p.add(fp);
		return p;
	}

	// makePurposeButtons
	private JPanel makePurposeButtons()
	{
		cancelPurposeB = new JButton("Cancel");
		cancelPurposeB.setToolTipText("Cancel changes and refresh");

		clearPurposeB = new JButton("Clear");
		clearPurposeB.setToolTipText("Clear fields");

		JButton[] buttons =
			{ cancelPurposeB, clearPurposeB };

		ButtonPanel bp = new ButtonPanel(buttons);

		return bp;
	}

	// makePrincipalsTab
	private JPanel makePrincipalsTab()
	{
		JPanel p = new JPanel(new BorderLayout());
		p.add(makePrincipalsPane(), BorderLayout.CENTER);
		p.add(makePrincipalsButtons(), BorderLayout.EAST);
		return p;
	}

	// makePrincipalsPane
	private JPanel makePrincipalsPane()
	{
		client1 = new JTextField(50);
		client2 = new JTextField(50);
		client3 = new JTextField(50);
		cust1 = new JTextField(50);
		cust2 = new JTextField(50);
		cust3 = new JTextField(50);

		FormPanel fp = new FormPanel();

		// add items to fp (in pairs)
		fp.add(new JLabel("Clients"));
		fp.add(client1);
		fp.add(new JLabel(""));
		fp.add(client2);
		fp.add(new JLabel(""));
		fp.add(client3);

		fp.add(new JLabel("Customers"));
		fp.add(cust1);
		fp.add(new JLabel(""));
		fp.add(cust2);
		fp.add(new JLabel(""));
		fp.add(cust3);

		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p.add(fp);
		return p;
	}

	// makePrincipalsButtons
	private JPanel makePrincipalsButtons()
	{
		cancelPrincipalB = new JButton("Cancel");
		cancelPrincipalB.setToolTipText("Cancel changes and refresh");

		clearPrincipalB = new JButton("Clear");
		clearPrincipalB.setToolTipText("Clear fields");

		JButton[] buttons =
			{ cancelPrincipalB, clearPrincipalB };

		ButtonPanel bp = new ButtonPanel(buttons);

		return bp;
	}

	// makeStakeholdersTab
	private JPanel makeStakeholdersTab()
	{
		JPanel p = new JPanel(new BorderLayout());
		p.add(makeStakeholdersPane(), BorderLayout.CENTER);
		p.add(makeStakeholdersActionButtons(), BorderLayout.EAST);
		p.add(makeStakeholdersNavigationButtons(), BorderLayout.SOUTH);
		return p;
	}

	// makeStakeholdersPane
	private JPanel makeStakeholdersPane()
	{
		stakeholderName = new JTextField(50);
		stakeholderTitle = new JTextField(50);
		stakeholderOrganization = new JTextField(50);

		stakeholderKnowledge = new JTextArea(4, 60);
		stakeholderKnowledge.setLineWrap(true);
		stakeholderKnowledge.setWrapStyleWord(true);

		stakeholderInvolvement = new JTextArea(4, 60);
		stakeholderInvolvement.setLineWrap(true);
		stakeholderInvolvement.setWrapStyleWord(true);

		stakeholderInfluence = new JTextArea(4, 60);
		stakeholderInfluence.setLineWrap(true);
		stakeholderInfluence.setWrapStyleWord(true);

		stakeholderConflictAgreement = new JTextArea(4, 60);
		stakeholderConflictAgreement.setLineWrap(true);
		stakeholderConflictAgreement.setWrapStyleWord(true);

		FormPanel fp = new FormPanel();

		// add items to fp (in pairs)
		fp.add(new JLabel("Name"));
		fp.add(stakeholderName);
		fp.add(new JLabel("Role/Title"));
		fp.add(stakeholderTitle);
		fp.add(new JLabel("Organization"));
		fp.add(stakeholderOrganization);

		fp.add(new JLabel("Knowledge Area"));
		fp.add(new JScrollPane(stakeholderKnowledge), BorderLayout.CENTER);
		fp.add(new JLabel("Required Involvement"));
		fp.add(new JScrollPane(stakeholderInvolvement), BorderLayout.CENTER);
		fp.add(new JLabel("Influence"));
		fp.add(new JScrollPane(stakeholderInfluence), BorderLayout.CENTER);
		fp.add(new JLabel("Conflict Resolution Agreement"));
		fp.add(new JScrollPane(stakeholderConflictAgreement),
				BorderLayout.CENTER);

		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p.add(fp);
		return p;
	}

	// makeStakeholdersActionButtons
	private JPanel makeStakeholdersActionButtons()
	{
		addStakeholderB = new JButton("Add");
		addStakeholderB.setToolTipText("Add stakeholder");

		cancelStakeholderB = new JButton("Cancel");
		cancelStakeholderB.setToolTipText("Cancel changes and refresh");

		clearStakeholderB = new JButton("Clear");
		clearStakeholderB.setToolTipText("Clear fields");

		deleteStakeholderB = new JButton("Delete");
		deleteStakeholderB.setToolTipText("Delete stakeholder");

		JButton[] buttons =
			{ addStakeholderB, cancelStakeholderB, clearStakeholderB,
					deleteStakeholderB };

		ButtonPanel bp = new ButtonPanel(buttons);

		return bp;
	}

	// makeStakeholdersNavigationButtons
	private JPanel makeStakeholdersNavigationButtons()
	{
		firstStakeholderB = new JButton("First");
		firstStakeholderB.setToolTipText("Move to the first stakeholder");

		prevStakeholderB = new JButton("Previous");
		prevStakeholderB
				.setToolTipText("Move to the previous next stakeholder");

		nextStakeholderB = new JButton("Next");
		nextStakeholderB.setToolTipText("Move to the next stakeholder");

		lastStakeholderB = new JButton("Last");
		lastStakeholderB.setToolTipText("Move to the last stakeholder");

		JButton[] buttons =
			{ firstStakeholderB, prevStakeholderB, nextStakeholderB,
					lastStakeholderB };

		ButtonPanel bp = new ButtonPanel(buttons, ButtonPanel.HORIZONTAL);

		return bp;
	}

	// makeUsersTab
	private JPanel makeUsersTab()
	{
		JPanel p = new JPanel(new BorderLayout());
		p.add(makeUsersPane(), BorderLayout.CENTER);
		p.add(makeUsersButtons(), BorderLayout.EAST);
		return p;
	}

	// makeUsersPane
	private JPanel makeUsersPane()
	{
		/*
		 * User name ­ This is most likely to be the name of a user group like:
		 * schoolchildren, road engineers, project managers.
		 * 
		 * User role ­ Summarizes the users' responsibilities.
		 * 
		 * Subject matter experience ­ Summarizes the users' knowledge of the
		 * business. Rate as novice, journeyman or master.
		 * 
		 * Technological experience ­ this describes the users' experience with
		 * relevant technology. Rate as novice, journeyman or master.
		 * 
		 * Other user characteristics
		 * 
		 * Key users. These are critical to the continued success of the
		 * product. Give greater importance to requirements generated by this
		 * category of user.
		 * 
		 * Secondary users. They will use the product, but their opinion of it
		 * has no effect on its long-term success. Where there is a conflict
		 * between secondary users' requirements and those of key users the key
		 * users take precedence.
		 * 
		 * Unimportant users. This category of user is given the lowest
		 * priority. It includes infrequent, unauthorized and unskilled users,
		 * and people who misuse the product.
		 * 
		 * Percentage of this type of user
		 * 
		 * Where appropriate attach to the category of user, a statement of the
		 * participation that you think will be necessary to provide the
		 * requirements. Describe the contribution that you expect this user to
		 * provide ­ business knowledge, interface prototyping, usability
		 * requirements etc. If possible, assess the minimum amount of time that
		 * this user must spend for you to be able to determine the complete
		 * requirements.
		 */
		problemText = new JTextArea(4, 80);
		problemText.setLineWrap(true);
		problemText.setWrapStyleWord(true);

		goalText = new JTextArea(4, 80);
		goalText.setLineWrap(true);
		goalText.setWrapStyleWord(true);

		FormPanel fp = new FormPanel();

		// add items to fp (in pairs)
		fp.add(new JLabel("Problem"));
		fp.add(problemText);

		fp.add(new JLabel("Goal"));
		fp.add(goalText);

		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p.add(fp);
		return p;
	}

	// makeUsersButtons
	private JPanel makeUsersButtons()
	{
		cancelPurposeB = new JButton("Cancel");
		cancelPurposeB.setToolTipText("Cancel changes and refresh");

		clearPurposeB = new JButton("Clear");
		clearPurposeB.setToolTipText("Clear fields");

		JButton[] buttons =
			{ cancelPurposeB, clearPurposeB };

		ButtonPanel bp = new ButtonPanel(buttons);

		return bp;
	}

	// makeEditorTab
	private JPanel makeEditorTab()
	{
		JPanel p = new JPanel(new BorderLayout());
		p.add(makeEditorPane(), BorderLayout.CENTER);
		return p;
	}

	// makeEditorPane
	// use HTML for layout
	//
	private JScrollPane makeEditorPane()
	{
		URL myHtml = null;
		final JTextPane p = new JTextPane();
		File f = new File("C:/cygwin/home/Wizard/jequire/html/test1.html");
		try
		{
			myHtml = f.toURL();
			// p = new JTextPane();
			p.setEditorKit(new HTMLEditorKit());
			p.setPage(myHtml);
//			System.out.println("content type is " + p.getContentType());
			p.setEditable(false);
			p.addHyperlinkListener(new HyperlinkListener()
			{
				public void hyperlinkUpdate(HyperlinkEvent event)
				{
					System.out.println("HyperlinkEvent");
					if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
					{
						JTextPane pane = (JTextPane) event.getSource();
						if (event instanceof HTMLFrameHyperlinkEvent)
						{
							HTMLFrameHyperlinkEvent evt = (HTMLFrameHyperlinkEvent) event;
							HTMLDocument doc = (HTMLDocument) pane.getDocument();
							doc.processHTMLFrameHyperlinkEvent(evt);
						}
						else
						{
							try
							{
								System.out.println("link path is "
										+ event.getURL().toString());
								pane.setPage(event.getURL());
	
							}
							catch (IOException ioe)
							{
								System.out.println("Can't follow link to "
										+ event.getURL().toExternalForm() + ": "
										+ ioe);
							}
						}
					}
				}
			});
//			System.out.println("Number of Components in JTextPane: "
//					+ p.getComponentCount());
			for (int i = 0; i < p.getComponentCount(); i++)
			{
				Container c = (Container) p.getComponent(i);
				Component swingComponentOfHTMLInputType = c.getComponent(0);
				System.out.println(i + ": "
						+ swingComponentOfHTMLInputType.getClass().getName());

			}
		}
		catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new JScrollPane(p);
	}

	// makeTestHtmlInputTab
	private JPanel makeTestHtmlInputTab()
	{
		JPanel p = new JPanel(new BorderLayout());
		p.add(makeTestHtmlInput(), BorderLayout.CENTER);
		p.add(makeTestHtmlButtons(), BorderLayout.SOUTH);
		return p;
	}

	// makeEditorPane
	// use HTML for layout
	//
	private JScrollPane makeTestHtmlInput()
	{
		pane = new JEditorPane();
		pane.setEditorKit(new HTMLEditorKit());
		pane
				.setText("<HTML><BODY><FORM>"
						+ "1.Input your name."
						+ "<INPUT TYPE='text' name='firstName'><br>"
						+ "2.Input your information.<br>"
						+ "<TEXTAREA rows='10' name='StationDescriptions' cols='100'><br>"
						+ "3.Pick ONLY one.<br>"
						+ "<input type='radio' name='thing' value='0' Checked> NO choice <BR>"
						+ "<input type='radio' name='thing' value='1'> First choice <BR>"
						+ "<input type='radio' name='thing' value='2'> Second Choice <BR>"
						+ "4.Pick all you like.<br>"
						+ "<input type='checkbox' name='stuff' value='A'> A <BR>"
						+ "<input type='checkbox' name='stuff' value='B'> B <BR>"
						+ "<input type='checkbox' name='stuff' value='C'> C <BR>"
						+ "5.Choose your nationality.<br>"
						+ "<select name='natio'>" + "<option>12</option>"
						+ "<option selected>13</option>" + "</select>"
						+ "</FORM></BODY></HTML>");
		return new JScrollPane(pane);
	}

	private JPanel makeTestHtmlButtons()
	{
		JButton add = new JButton("add");
		JButton update = new JButton("update");
		JButton delete = new JButton("delete");
		add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Number of Components in JTextPane: "
						+ pane.getComponentCount());
				for (int i = 0; i < pane.getComponentCount(); i++)
				{
					// NOTE FOR BELOW: know its a Container since all Components
					// inside a JTextPane are instances of the inner class
					// ComponentView$Invalidator which is a subclass of the
					// Container Class (ComponentView$Invalidator extends
					// Container)
					Container c = (Container) pane.getComponent(i);
					// the component of this containers will be the Swing
					// equivalents of the HTML Form fields (JButton, JTextField,
					// etc.)

					// Get the # of components inside the
					// ComponentView$Invalidator (the above container)
					Component swingComponentOfHTMLInputType = c.getComponent(0);
					// each ComponentView$Invalidator will only have one
					// component at array base 0
					// DISPLAY OF WHAT JAVA CLASS TYPE THE COMPONENT IS

					System.out.println(i
							+ ": "
							+ swingComponentOfHTMLInputType.getClass()
									.getName());
					// this will show of what type the Component is (JTextField,
					// JRadioButton, etc.)
					if (swingComponentOfHTMLInputType instanceof JTextField)
					{
						JTextField tf = (JTextField) swingComponentOfHTMLInputType;
						// downcast and we have the reference to the component
						// now!! :)
						System.out.println("  Text: " + tf.getText());
						tf.setText("JTextField found!");
					}
					else if (swingComponentOfHTMLInputType instanceof JButton)
					{
					}
					else if (swingComponentOfHTMLInputType instanceof JComboBox)
					{
						JComboBox combo = (JComboBox) swingComponentOfHTMLInputType;
						System.out.println("  Selected index: "
								+ combo.getSelectedIndex());
					}
					else if (swingComponentOfHTMLInputType instanceof JRadioButton)
					{
						JRadioButton radio = (JRadioButton) swingComponentOfHTMLInputType;
						System.out.println("  Selected: "
								+ new Boolean(radio.isSelected()).toString());
					}
					else if (swingComponentOfHTMLInputType instanceof JCheckBox)
					{
						JCheckBox check = (JCheckBox) swingComponentOfHTMLInputType;
						check.setSelected(true);
						System.out.println("  Selected: "
								+ new Boolean(check.isSelected()).toString());
					}
					else if (swingComponentOfHTMLInputType instanceof JScrollPane)
					{
						JScrollPane pane = (JScrollPane) swingComponentOfHTMLInputType;
						for (int j = 0; j < pane.getComponentCount(); j++)
						{
							// JTextArea area =
							// (JTextArea)swingComponentOfHTMLInputType.getComponent(0);
							Container c2 = (Container) pane.getComponent(j);

							for (int k = 0; k < c2.getComponentCount(); k++)
							{
								Component c3 = (Component) c2.getComponent(k);
								if (c3 instanceof JTextArea)
								{
									JTextArea area = (JTextArea) c3;
									System.out.println("  "
											+ area.getClass().getName());
									System.out.println("     Text: "
											+ area.getText());
									area.setText("JTextArea found!");
								}
							}
						}
					}
					else
					{
					}
				}
			}
		});
		JButton[] buttons =
			{ add, update, delete };

		ButtonPanel bp = new ButtonPanel(buttons, ButtonPanel.HORIZONTAL);

		return bp;
	}
} // ~ end of class DriversTabs
