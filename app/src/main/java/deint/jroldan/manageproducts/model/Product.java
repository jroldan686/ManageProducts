package deint.jroldan.manageproducts.model;

/**
 * Created by usuario on 19/10/16.
 */

import java.util.Locale;
import java.util.UUID;

/**
 * Class Product
 */
public class Product {
    private int mId;
    private String mName;
    private String mDescription;
    private String mBrand;
    private String mDosage;
    private double mPrice;
    private int mStock;
    private int mImage;

    public Product(String mName, String mDescription, String mBrand, String mDosage, double mPrice, int mStock, int mImage) {
        //this.mId = UUID.randomUUID().toString();
        this.mName = mName;
        this.mDescription = mDescription;
        this.mBrand = mBrand;
        this.mDosage = mDosage;
        this.mPrice = mPrice;
        this.mStock = mStock;
        this.mImage = mImage;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmBrand() {
        return mBrand;
    }

    public void setmBrand(String mBrand) {
        this.mBrand = mBrand;
    }

    public String getmDosage() {
        return mDosage;
    }

    public void setmDosage(String mDosage) {
        this.mDosage = mDosage;
    }

    public double getmPrice() {
        return mPrice;
    }

    public void setmPrice(double mPrice) {
        this.mPrice = mPrice;
    }

    public int getmStock() {
        return mStock;
    }

    public void setmStock(int mStock) {
        this.mStock = mStock;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public String getFormattedUnitsInStock() {
        return String.format(Locale.getDefault(), "%d u.", mStock);
    }

    public String getFormattedPrice() {
        return String.format("$%s", mPrice);
    }

    @Override
    public String toString() {
        return "Product { " + Integer.toString(mId) + ", " +
                mName + ", " + mDescription + ", " + mBrand + ", " +
                Double.toString(mPrice) + ", " + Integer.toString(mStock) + "}";
    }

    /* Two products are the same, when they have the same name, brand and dosage */

    @Override
    public boolean equals(Object obj) {
        /*
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Product product = (Product)obj;

        if(!mName.equals(product.mName)) return false;
        if(!mBrand.equals(product.mBrand)) return false;
        return mDosage.equals(product.mDosage);
        */
        if (obj instanceof Product) {
            Product product = (Product) obj;
            if (mName.equals(product.mName) &&
                    mBrand.equals(product.mBrand) &&
                    mDosage.equals(product.mDosage))
                return true;
            else
                return false;
        }
        return false;
    }
}
