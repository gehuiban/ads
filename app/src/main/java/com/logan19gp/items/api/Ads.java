package com.logan19gp.items.api;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "ads")
public class Ads {

    @ElementList(inline = true)
    private List<AdsItem> ad;
    @Element(name = "responseTime")
    private String responseTime;
    @Element(name = "serverId")
    private String serverId;
    @Element(name = "version")
    private String version;
    @Element(name = "totalCampaignsRequested")
    private Integer totalCampaignsRequested;


    public Ads() {
        this.ad = new ArrayList<AdsItem>();
    }

    public List<AdsItem> getAd() {
        return ad;
    }

    public void setAd(ArrayList<AdsItem> ad) {
        this.ad = ad;
    }
}
