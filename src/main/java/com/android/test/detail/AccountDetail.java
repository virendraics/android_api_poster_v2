package com.android.test.detail;

import lombok.Data;

import java.util.Date;

/**
 * @author Virendra
 * @since 16/08/24
 */
@Data
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

}
