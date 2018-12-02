package com.changent.jequire;

import java.awt.*;
import javax.swing.*;

/**
 * Author : Bill Turner Date : 19 Nov 2000
 * 
 * JequireTabs
 */
public class JequireTabs extends JPanel
{
	private static final long serialVersionUID = 1L;

	private JTabbedPane jequireTab;

	private JButton addB, updateB, deleteB, discardB;

	// private JTable jequireTable;

	// constructor
	public JequireTabs()
	{
		setLayout(new BorderLayout());
		add(makeTypeTabs(), BorderLayout.CENTER);
	}

	public JTabbedPane makeTypeTabs()
	{
		jequireTab = new JTabbedPane();
		jequireTab.addTab("Drivers", new DriversTabs());
		jequireTab.addTab("Constraints", makeConstraintsTabs());
		jequireTab.addTab("Functional", makeFunctionalTabs());
		jequireTab.addTab("Non-Functional", makeNonFunctionalTabs());
		jequireTab.addTab("Issues", makeIssuesTabs());

		jequireTab.setSelectedIndex(0);

		return jequireTab;
	}

	// makeDriversTabs
//	private JTabbedPane makeDriversTabs()
//	{
//		final JTabbedPane tp = new JTabbedPane();
//		Runnable r = new Runnable()
//		{
//			public void run()
//			{
//				tp.addTab("Purpose", makePurposePane());
//				tp.addTab("Stakeholders", makePurposePane());
//				tp.addTab("Users", makePurposePane());
//
//				// add(jequireTab, BorderLayout.CENTER);
//				tp.setSelectedIndex(0);
//			}
//		};
//
//		Thread t = new Thread(r);
//		t.start();
//
//		return tp;
//	}
//
	// makePurposePane
	private JPanel makePurposePane()
	{
		JPanel p = new JPanel(new BorderLayout());
		// p.add(makeList(tab), BorderLayout.CENTER);
		return p;
	}

	// makeConstraintsTabs
	private JTabbedPane makeConstraintsTabs()
	{
		final JTabbedPane tp = new JTabbedPane();
		Runnable r = new Runnable()
		{
			public void run()
			{
				tp.addTab("Purpose", makePurposePane());
				tp.addTab("Stakeholders", makePurposePane());
				tp.addTab("Users", makePurposePane());

				// add(jequireTab, BorderLayout.CENTER);
				tp.setSelectedIndex(0);
			}
		};

		Thread t = new Thread(r);
		t.start();

		return tp;
	}

	// makeFunctionalTabs
	private JTabbedPane makeFunctionalTabs()
	{
		final JTabbedPane tp = new JTabbedPane();
		Runnable r = new Runnable()
		{
			public void run()
			{
				tp.addTab("Purpose", makePurposePane());
				tp.addTab("Stakeholders", makePurposePane());
				tp.addTab("Users", makePurposePane());

				// add(jequireTab, BorderLayout.CENTER);
				tp.setSelectedIndex(0);
			}
		};

		Thread t = new Thread(r);
		t.start();

		return tp;
	}

	// makeNonFunctionalTabs
	private JTabbedPane makeNonFunctionalTabs()
	{
		final JTabbedPane tp = new JTabbedPane();
		Runnable r = new Runnable()
		{
			public void run()
			{
				tp.addTab("Purpose", makePurposePane());
				tp.addTab("Stakeholders", makePurposePane());
				tp.addTab("Users", makePurposePane());

				// add(jequireTab, BorderLayout.CENTER);
				tp.setSelectedIndex(0);
			}
		};

		Thread t = new Thread(r);
		t.start();

		return tp;
	}

	// makeIssuesTabs
	private JTabbedPane makeIssuesTabs()
	{
		final JTabbedPane tp = new JTabbedPane();
		Runnable r = new Runnable()
		{
			public void run()
			{
				tp.addTab("Purpose", makePurposePane());
				tp.addTab("Stakeholders", makePurposePane());
				tp.addTab("Users", makePurposePane());

				// add(jequireTab, BorderLayout.CENTER);
				tp.setSelectedIndex(0);
			}
		};

		Thread t = new Thread(r);
		t.start();

		return tp;
	}

	// makeEast
	private JPanel makeEast()
	{
		JButton[] buttons = makeButtons();

		JPanel bp = makeButtonPanel(buttons, false);

		return bp;
	}

	// makeButtons
	private JButton[] makeButtons()
	{
		addB = new JButton("Add");
		addB.setToolTipText("Add a new contact");

		updateB = new JButton("Update");
		updateB.setToolTipText("Update contact");

		deleteB = new JButton("Delete");
		deleteB.setToolTipText("Delete contact");

		discardB = new JButton("Cancel");
		discardB.setToolTipText("Cancel changes and refresh");

		JButton[] buttons =
			{ addB, updateB, deleteB, discardB };

		return buttons;
	}

	// makeButtonPanel
	private JPanel makeButtonPanel(JButton[] b, boolean horizontalLayoutInd)
	{
		JPanel buttonGrid = new JPanel();

		if (horizontalLayoutInd)
		{
			buttonGrid.setLayout(new GridLayout(1, 0, 5, 5));
		}
		else
		{
			buttonGrid.setLayout(new GridLayout(0, 1, 5, 5));
		}

		for (int i = 0; i < b.length; i++)
		{
			buttonGrid.add(b[i]);
		}

		JPanel p = new JPanel(new FlowLayout());
		p.add(buttonGrid);
		/*
		 * JPanel bp = new JPanel(new BorderLayout()); bp.add(buttonGrid,
		 * BorderLayout.CENTER);
		 * 
		 * return bp;
		 */
		return p;
	}
} // ~ end of class JequireTabs
