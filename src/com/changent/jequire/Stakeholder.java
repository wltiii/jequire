package com.changent.jequire;

public class Stakeholder extends Object {
  private int __id = 0;
  private String __name = null;
  private String __role = null;
  private String __org = null;
  private String __area = null;
  private String __involvement = null;
  private String __influence = null;
  private String __agreement = null;

  public Stakeholder() {
  }

  public Stakeholder(
	  int id,
	  String name
	  ) {
	  __id = id;
	  __name = name.trim();
  }

  public Stakeholder(
	  int id,
	  String name,
	  String role,
	  String org,
	  String area,
	  String involvement,
	  String influence,
	  String agreement
	  ) {
	  __id = id;
	  __name = name.trim();
	  __role = role.trim();
	  __org = org.trim();
	  __area = area.trim();
	  __involvement = involvement.trim();
	  __influence = influence.trim();
	  __agreement = agreement.trim();
  }

  public void setID(int id)			{ __id = id; }

  public void setName(String name)	{ __name = name; }

  public void setRole(String role)	{ __role = role; }

  public void setOrg(String org)	{ __org = org; }

  public void setArea(String area)	{ __area = area; }

  public void setInvolvement(String involvement)	{ __involvement = involvement; }

  public void setInfluence(String influence)	{ __influence = influence; }

  public void setAgreement(String agreement)	{ __agreement = agreement; }

  public int getID()				{ return __id; }

  public String getName()           { return __name; }

  public String getRole()           { return __role; }

  public String getOrg()           { return __org; }

  public String getArea()           { return __area; }

  public String getInvolvement()           { return __involvement; }

  public String getInfluence()           { return __influence; }

  public String getAgreement()           { return __agreement; }

  public String toString() {
    StringBuffer buffer = new StringBuffer();

    buffer.append(__id);
    buffer.append(":");
    buffer.append(__name);
    buffer.append(":");
    buffer.append(__role);
    buffer.append(":");
    buffer.append(__org);
    buffer.append(":");
    buffer.append(__area);
    buffer.append(":");
    buffer.append(__involvement);
    buffer.append(":");
    buffer.append(__influence);
    buffer.append(":");
    buffer.append(__agreement);

    return buffer.toString();
  }

}
