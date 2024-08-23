package com.android.test.detail;


import java.util.ArrayList;


public class MenuDetail extends AbstractDetail
{
	private static final long serialVersionUID = 1L;
	private String tabName;
//	private String title;
	private String url;
	private String iconClass;
	private String description;
	private String bgColor;
	private String menuImage;
	private String onDashboard;
	private String onMainMenu;
	private String parentId;
	private String privilegeId;
	private String sequence;
	private String menuUID;
	private ArrayList<MenuDetail> subMenu  =new ArrayList<MenuDetail>();
	
	
	public String getTabName() 
	{
		return tabName;
	}
	public void setTabName(String tabName) 
	{
		this.tabName = tabName;
	}
//	public String getTitle()
//	{
//		return title;
//	}
//	public void setTitle(String title)
//    {
//		this.title = title;
//	}
	public String getUrl() 
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public String getIconClass() 
	{
		return iconClass;
	}
	public void setIconClass(String iconClass)
	{
		this.iconClass = iconClass;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public ArrayList<MenuDetail> getSubMenu() 
	{
		return subMenu;
	}
	public void setSubMenu(ArrayList<MenuDetail> subMenu) 
	{
		this.subMenu = subMenu;
	}
	public String getMenuImage() {
		return menuImage;
	}
	public void setMenuImage(String menuImage) {
		this.menuImage = menuImage;
	}
	public String getOnDashboard() {
		return onDashboard;
	}
	public void setOnDashboard(String onDashboard) {
		this.onDashboard = onDashboard;
	}
	public String getOnMainMenu() {
		return onMainMenu;
	}
	public void setOnMainMenu(String onMainMenu) {
		this.onMainMenu = onMainMenu;
	}
	public String getBgColor() {
		return bgColor;
	}
	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}
	/**
	 * @author Simran
	 * @version SPR_V_6_0
	 * menuUID created because earlier we used to get Id but now because of entity framework changes we get menuUID
	 */
	public String getMenuUID() {
		return menuUID;
	}

	public void setMenuUID(String menuUID) {
		this.menuUID = menuUID;
	}
}
