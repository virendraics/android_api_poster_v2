package com.android.test.detail;

/**
 * @author Virendra
 * @since 16/08/24
 */
public class ProductConfigurationDetail
{
    private static final long serialVersionUID = 1L;
    private String UID;
    private String ownerId;
    private int productType;
    private int type;
    private int state;


    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
