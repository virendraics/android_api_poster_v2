package com.android.test.detail;

import lombok.Data;

/**
 * @author Virendra
 * @since 16/08/24
 */
@Data
public class MerchantUserDetail extends AccountDetail{
    private static final long serialVersionUID = 0L;
    //private String accountId;
    private String fname;
    private String accountUID;
    private String lname;
    private String gender;
    private String addressId;
    private String telephone;
    private String businessEntityId;
    private int type;
    private String position;
    private String emailpassword;
    private String roleName;
    private boolean isDeleted;
    private String deliveredOn;
    private String status;
}
