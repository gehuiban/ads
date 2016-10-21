package com.logan19gp.items.api;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "ad")
public class AdsItem implements Parcelable {
    public static final Parcelable.Creator<AdsItem> CREATOR = new Parcelable.Creator<AdsItem>() {
        @Override
        public AdsItem createFromParcel(Parcel in) {
            return new AdsItem(in);
        }

        @Override
        public AdsItem[] newArray(int size) {
            return new AdsItem[size];
        }
    };
    @Element(name = "appId", type = String.class)
    private String appId;
    @Element(name = "averageRatingImageURL")
    private String averageRatingImageURL;
    @Element(name = "bidRate")
    private Float bidRate;
    @Element(name = "callToAction")
    private String callToAction;
    @Element(name = "campaignDisplayOrder")
    private Integer campaignDisplayOrder;
    @Element(name = "campaignId")
    private Integer campaignId;
    @Element(name = "campaignTypeId")
    private Integer campaignTypeId;
    @Element(name = "categoryName")
    private String categoryName;
    @Element(name = "clickProxyURL")
    private String clickProxyURL;
    @Element(name = "creativeId")
    private Integer creativeId;
    @Element(name = "homeScreen")
    private Boolean homeScreen;
    @Element(name = "impressionTrackingURL")
    private String impressionTrackingURL;
    @Element(name = "isRandomPick")
    private Boolean isRandomPick;
    @Element(name = "minOSVersion", required = false)
    private String minOSVersion;
    @Element(name = "numberOfRatings")
    private String numberOfRatings;
    @Element(name = "productDescription")
    private String productDescription;
    @Element(name = "productId")
    private Integer productId;
    @Element(name = "productName")
    private String productName;
    @Element(name = "productThumbnail")
    private String productThumbnail;
    @Element(name = "rating")
    private Float rating;
    @Element(name = "timeOfAdd", required = false)
    private Long timeOfAdd;

    public AdsItem(Parcel in) {
        rating = (Float) in.readValue(Float.class.getClassLoader());
        productId = (Integer) in.readValue(Integer.class.getClassLoader());
        isRandomPick = (Boolean) in.readValue(Boolean.class.getClassLoader());
        homeScreen = (Boolean) in.readValue(Boolean.class.getClassLoader());
        creativeId = (Integer) in.readValue(Integer.class.getClassLoader());
        campaignTypeId = (Integer) in.readValue(Integer.class.getClassLoader());
        campaignId = (Integer) in.readValue(Integer.class.getClassLoader());
        campaignDisplayOrder = (Integer) in.readValue(Integer.class.getClassLoader());
        bidRate = (Float) in.readValue(Float.class.getClassLoader());
        productThumbnail = in.readString();
        productName = in.readString();
        productDescription = in.readString();
        numberOfRatings = in.readString();
        minOSVersion = in.readString();
        impressionTrackingURL = in.readString();
        clickProxyURL = in.readString();
        categoryName = in.readString();
        callToAction = in.readString();
        averageRatingImageURL = in.readString();
        appId = in.readString();
    }

    public AdsItem() {
        this.timeOfAdd = System.currentTimeMillis();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAverageRatingImageURL() {
        return averageRatingImageURL;
    }

    public void setAverageRatingImageURL(String averageRatingImageURL) {
        this.averageRatingImageURL = averageRatingImageURL;
    }

    public Float getBidRate() {
        return bidRate;
    }

    public void setBidRate(Float bidRate) {
        this.bidRate = bidRate;
    }

    public String getCallToAction() {
        return callToAction;
    }

    public void setCallToAction(String callToAction) {
        this.callToAction = callToAction;
    }

    public Integer getCampaignDisplayOrder() {
        return campaignDisplayOrder;
    }

    public void setCampaignDisplayOrder(Integer campaignDisplayOrder) {
        this.campaignDisplayOrder = campaignDisplayOrder;
    }

    public Integer getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public Integer getCampaignTypeId() {
        return campaignTypeId;
    }

    public void setCampaignTypeId(Integer campaignTypeId) {
        this.campaignTypeId = campaignTypeId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getClickProxyURL() {
        return clickProxyURL;
    }

    public void setClickProxyURL(String clickProxyURL) {
        this.clickProxyURL = clickProxyURL;
    }

    public Integer getCreativeId() {
        return creativeId;
    }

    public void setCreativeId(Integer creativeId) {
        this.creativeId = creativeId;
    }

    public Boolean getHomeScreen() {
        return homeScreen;
    }

    public void setHomeScreen(Boolean homeScreen) {
        this.homeScreen = homeScreen;
    }

    public String getImpressionTrackingURL() {
        return impressionTrackingURL;
    }

    public void setImpressionTrackingURL(String impressionTrackingURL) {
        this.impressionTrackingURL = impressionTrackingURL;
    }

    public Boolean getRandomPick() {
        return isRandomPick;
    }

    public void setRandomPick(Boolean randomPick) {
        isRandomPick = randomPick;
    }

    public String getMinOSVersion() {
        return minOSVersion;
    }

    public void setMinOSVersion(String minOSVersion) {
        this.minOSVersion = minOSVersion;
    }

    public String getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(String numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductThumbnail() {
        return productThumbnail;
    }

    public void setProductThumbnail(String productThumbnail) {
        this.productThumbnail = productThumbnail;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "AdsItem{" +
                "timeOfAdd=" + timeOfAdd +
                ", appId='" + appId + '\'' +
                ", averageRatingImageURL='" + averageRatingImageURL + '\'' +
                ", bidRate=" + bidRate +
                ", callToAction='" + callToAction + '\'' +
                ", campaignDisplayOrder=" + campaignDisplayOrder +
                ", campaignId=" + campaignId +
                ", campaignTypeId=" + campaignTypeId +
                ", categoryName='" + categoryName + '\'' +
                ", clickProxyURL='" + clickProxyURL + '\'' +
                ", creativeId=" + creativeId +
                ", homeScreen=" + homeScreen +
                ", impressionTrackingURL='" + impressionTrackingURL + '\'' +
                ", isRandomPick=" + isRandomPick +
                ", minOSVersion='" + minOSVersion + '\'' +
                ", numberOfRatings='" + numberOfRatings + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productThumbnail='" + productThumbnail + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeValue(rating);
        dest.writeValue(productId);
        dest.writeValue(isRandomPick);
        dest.writeValue(homeScreen);
        dest.writeValue(creativeId);
        dest.writeValue(campaignTypeId);
        dest.writeValue(campaignId);
        dest.writeValue(campaignDisplayOrder);
        dest.writeValue(bidRate);
        dest.writeString(productThumbnail);
        dest.writeString(productName);
        dest.writeString(productDescription);
        dest.writeString(numberOfRatings);
        dest.writeString(minOSVersion);
        dest.writeString(impressionTrackingURL);
        dest.writeString(clickProxyURL);
        dest.writeString(categoryName);
        dest.writeString(callToAction);
        dest.writeString(averageRatingImageURL);
        dest.writeString(appId);
    }
}
