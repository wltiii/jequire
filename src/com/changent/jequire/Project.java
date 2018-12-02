package com.changent.jequire;

import java.util.*;
import java.io.*;
import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.*;

public class Project
{
	private String driverActive,
		purposeActive,
		principalsActive,
		stakeholdersActive;
	private String problem, goal;
	private int clientCount, customerCount, stakeholderCount;
	private ClientList clients;
	private CustomerList customers;
	private StakeholderList stakeholders;
	private String login;
	private String password;
	private int uid;
	private int gid;
	private String name;
	private String home;
	private String shell;

	public Project()
	{
		driverActive =
			purposeActive = principalsActive = stakeholdersActive = null;
		problem = goal = null;
		clientCount = customerCount = stakeholderCount = 0;
		clients = new ClientList();
		customers = new CustomerList();
		stakeholders = new StakeholderList();
	}
	public void setDriverActive(String driverActive)
	{
		this.driverActive = driverActive;
	}
	public void setPurposeActive(String purposeActive)
	{
		this.purposeActive = purposeActive;
	}
	public void setPrincipalsActive(String principalsActive)
	{
		this.principalsActive = principalsActive;
	}
	public void setStakeholdersActive(String stakeholdersActive)
	{
		this.stakeholdersActive = stakeholdersActive;
	}
	public void setProblem(String problem)
	{
		this.problem = problem;
	}
	public void setGoal(String goal)
	{
		this.goal = goal;
	}
	public void setClientCount(int clientCount)
	{
		this.clientCount = clientCount;
	}
	public void setCustomerCount(int customerCount)
	{
		this.customerCount = customerCount;
	}
	public void setStakeholderCount(int stakeholderCount)
	{
		this.stakeholderCount = stakeholderCount;
	}
	public void setClients(ClientList clients)
	{
		this.clients = clients;
	}
	public void setCustomers(CustomerList customers)
	{
		this.customers = customers;
	}
	public void setStakeholders(StakeholderList stakeholders)
	{
		this.stakeholders = stakeholders;
	}

	public String getDriverActive(String driverActive)
	{
		return driverActive;
	}
	public String getPurposeActive(String purposeActive)
	{
		return purposeActive;
	}
	public String getPrincipalsActive(String principalsActive)
	{
		return principalsActive;
	}
	public String getStakeholdersActive(String stakeholdersActive)
	{
		return stakeholdersActive;
	}
	public String getProblem(String problem)
	{
		return problem;
	}
	public String getGoal(String goal)
	{
		return goal;
	}
	public int getClientCount(int clientCount)
	{
		return clientCount;
	}
	public int getCustomerCount(int customerCount)
	{
		return customerCount;
	}
	public int getStakeholderCount(int stakeholderCount)
	{
		return stakeholderCount;
	}
	public ClientList getClients(ClientList clients)
	{
		return clients;
	}
	public CustomerList getCustomers(CustomerList customers)
	{
		return customers;
	}
	public StakeholderList getStakeholders(StakeholderList stakeholders)
	{
		return stakeholders;
	}

	/**
	 * Returns a String representation of the Project.
	 */
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();

		buffer.append(driverActive);
		buffer.append(":");
		buffer.append(purposeActive);
		buffer.append(":");
		buffer.append(principalsActive);
		buffer.append(":");
		buffer.append(stakeholdersActive);
		buffer.append(":");
		buffer.append(problem);
		buffer.append(":");
		buffer.append(goal);
		buffer.append(":");
		buffer.append(clientCount);
		buffer.append(":");
		buffer.append(customerCount);
		buffer.append(":");
		buffer.append(stakeholderCount);
		buffer.append(":");
		buffer.append(clients.toString());
		buffer.append(":");
		buffer.append(customers.toString());
		buffer.append(":");
		buffer.append(stakeholders.toString());

		return buffer.toString();
	}

	public static final Project parseProject(Node node)
		throws ProjectParseException
	{
		Project project = new Project();

		node = node.getFirstChild();

		try
		{
			while (node != null)
			{
				String name = node.getNodeName();
				int id;

				if ("drivers".equals(name))
				{
					project.setLogin(node.getFirstChild().getNodeValue());
				}
				else if ("purpose".equals(name))
				{
					NamedNodeMap attributes;
					String password;

					password = node.getFirstChild().getNodeValue();
					attributes = node.getAttributes();

					name = attributes.getNamedItem("encryption").getNodeValue();

//					if ("none".equals(name))
//						id = ENCRYPTION_NONE;
//					else if ("md5".equals(name))
//						id = ENCRYPTION_MD5;
//					else if ("des".equals(name))
//						id = ENCRYPTION_DES;
//					else
//						throw new ProjectParseException();
//
//					project.setPassword(id, password);
				}
				else if ("uid".equals(name))
				{
					name = node.getFirstChild().getNodeValue();
					id = Integer.parseInt(name);
					project.setUid(id);
				}
				else if ("gid".equals(name))
				{
					name = node.getFirstChild().getNodeValue();
					id = Integer.parseInt(name);
					project.setGid(id);
				}
				else if ("name".equals(name))
				{
					project.setName(node.getFirstChild().getNodeValue());
				}
				else if ("home".equals(name))
				{
					project.setHome(node.getFirstChild().getNodeValue());
				}
				else if ("shell".equals(name))
				{
					project.setShell(node.getFirstChild().getNodeValue());
				}

				node = node.getNextSibling();
			}
		}
		catch (NumberFormatException nfe)
		{
			throw new ProjectParseException();
		}
		return project;
	}

	public static final void parseProjects(
		Document document,
		Collection project)
		throws ProjectParseException
	{
		int length;
		NodeList list;

		list = document.getElementsByTagName("project");
		length = list.getLength();

		for (int i = 0; i < length; i++)
		{
			Node node = list.item(i);
			Project p = parseProject(node);
			project.add(p);
		}
	}

	/***********************************************************/
	// Loads xml project file, creates a Project object and
	// prints to stdout.
	/***********************************************************/
	public static final void main(String args[])
	{
		InputSource input;
		Document document;
		ArrayList list;
		Iterator iterator;
		DocumentBuilderFactory factory;
		DocumentBuilder builder;

		try
		{

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return;
		}

		if (args.length != 1)
		{
			System.err.println("usage: Project xmlfile");
			return;
		}

		try
		{
			factory = DocumentBuilderFactory.newInstance();
			input = new InputSource(new FileReader(args[0]));
			builder = factory.newDocumentBuilder();
			document = builder.parse(input);
			list = new ArrayList();

			Project.parseProjects(document, list);

			iterator = list.iterator();

			while (iterator.hasNext())
			{
				Project project = (Project) iterator.next();
				System.out.println(project.toString());
			}
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
			return;
		}
		catch (SAXException saxe)
		{
			saxe.printStackTrace();
			return;
		}
		catch (ProjectParseException ape)
		{
			ape.printStackTrace();
			return;
		}
		catch (ParserConfigurationException pce)
		{
			pce.printStackTrace();
			return;
		}
	}
	/**
	 * @return
	 */
	public int getGid()
	{
		return gid;
	}

	/**
	 * @return
	 */
	public String getLogin()
	{
		return login;
	}

	/**
	 * @return
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @return
	 */
	public int getUid()
	{
		return uid;
	}

	/**
	 * @param string
	 */
	public void setGid(int string)
	{
		gid = string;
	}

	/**
	 * @param string
	 */
	public void setLogin(String string)
	{
		login = string;
	}

	/**
	 * @param string
	 */
	public void setPassword(String string)
	{
		password = string;
	}

	/**
	 * @param string
	 */
	public void setUid(int string)
	{
		uid = string;
	}

	/**
	 * @return
	 */
	public String getHome()
	{
		return home;
	}

	/**
	 * @return
	 */
	public String getShell()
	{
		return shell;
	}

	/**
	 * @param string
	 */
	public void setHome(String string)
	{
		home = string;
	}

	/**
	 * @param string
	 */
	public void setShell(String string)
	{
		shell = string;
	}

	/**
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param string
	 */
	public void setName(String string)
	{
		name = string;
	}

}
