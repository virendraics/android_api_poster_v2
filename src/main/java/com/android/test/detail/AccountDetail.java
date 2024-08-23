package com.android.test.detail;

import java.util.Date;

/**
 * @author Virendra
 * @since 16/08/24
 */
public class AccountDetail extends AbstractDetail{

    private static final long serialVersionUID = 0L;

    private String accountId;
    private String username;
    private String password;
    private String email;
    private String resetLink;
    private String fullName;
    private String btCustomerId;
    private String billingId;
    private String loginBy;
    protected String role;
    private MenusDetail menusDetail;
    private String timeZoneId;
    private String roleType;
    private Date createdOn;
    private Date updatedOn;
    private String createdBy;
    private String updatedBy;
    private String roleId;
    //private EntityRoleDetail roleDetail;
    private String entityId;
    private String entityUID;
    private int isSystemUser;
    private String privileges;
    private boolean preRBAC;
    private boolean isActiveUser;
    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    public int getIsSystemUser() {
        return isSystemUser;
    }

    public void setIsSystemUser(int isSystemUser) {
        this.isSystemUser = isSystemUser;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    private String timeZoneName;

    public String getTimeZoneName() {
        return timeZoneName;
    }

    public void setTimeZoneName(String timeZoneName) {
        this.timeZoneName = timeZoneName;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String mUsername) {
        this.username = mUsername;
    }


    public String getPassword() {
        return password;
    }
    public void setPassword(String mPassword) {
        this.password = mPassword;
    }

    public String getRole() {
        return "Account";
    }
    public void setRole(String role)
    {
        this.role=role;
    }
    public String getResetLink() {
        return resetLink;
    }
    public void setResetLink(String resetLink) {
        this.resetLink = resetLink;
    }
    public String getFullName()
    {
        return getEmail();
    }
    public String getBtCustomerId() {
        return btCustomerId;
    }
    public void setBtCustomerId(String btCustomerId) {
        this.btCustomerId = btCustomerId;
    }
    public void setBillingId(String billingId) {
        this.billingId = billingId;
    }
    public String getLoginBy() {
        if(loginBy == null)
            loginBy = "";
        return loginBy;
    }
    public void setLoginBy(String loginBy) {
        this.loginBy = loginBy;
    }
    public String getTimeZoneId() {
        return timeZoneId;
    }
    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }
    public MenusDetail getMenusDetail() {
        if(menusDetail==null)
            menusDetail = new MenusDetail();
        return menusDetail;
    }
    public void setMenusDetail(MenusDetail menusDetail) {
        this.menusDetail = menusDetail;
    }
    public String getRoleType() {
        return roleType;
    }
    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

	/*public EntityRoleDetail getRoleDetail() {
		return roleDetail;
	}

	public void setRoleDetail(EntityRoleDetail roleDetail) {
		this.roleDetail = roleDetail;
	}*/

    public boolean isPreRBAC()
    {
        //preRBAC = getBooleanFlagValue("preRBAC", FlagConstants.kMerchantFlags);
        return preRBAC;
    }
    public void setPreRBAC(boolean preRBAC)
    {
        this.preRBAC = preRBAC;
        //manageFlags(preRBAC, "preRBAC", FlagConstants.kMerchantFlags);
    }

    public boolean isActiveUser() {
        //isActiveUser = getBooleanFlagValue("status", FlagConstants.kMerchantFlags);
        return isActiveUser;
    }

    public void setActiveUser(boolean isActiveUser) {
        this.isActiveUser = isActiveUser;
        //manageFlags(isActiveUser, "status", FlagConstants.kMerchantFlags);
    }

    public String getEntityUID() {
        return entityUID;
    }

    public void setEntityUID(String entityUID) {
        this.entityUID = entityUID;
    }
}
