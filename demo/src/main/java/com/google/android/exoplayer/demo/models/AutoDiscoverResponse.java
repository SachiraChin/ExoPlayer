package com.google.android.exoplayer.demo.models;

import com.google.gson.annotations.SerializedName;


        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

public class AutoDiscoverResponse {

    @SerializedName("odata.metadata")
    @Expose
    private String odataMetadata;
    @SerializedName("odata.type")
    @Expose
    private String odataType;
    @SerializedName("odata.id")
    @Expose
    private String odataId;
    @SerializedName("odata.editLink")
    @Expose
    private String odataEditLink;
    @SerializedName("ChannelUrlTemplate")
    @Expose
    private String ChannelUrlTemplate;
    @SerializedName("IsVideoPortalEnabled")
    @Expose
    private Boolean IsVideoPortalEnabled;
    @SerializedName("PlayerUrlTemplate")
    @Expose
    private String PlayerUrlTemplate;
    @SerializedName("VideoPortalLayoutsUrl")
    @Expose
    private String VideoPortalLayoutsUrl;
    @SerializedName("VideoPortalUrl")
    @Expose
    private String VideoPortalUrl;

    /**
     *
     * @return
     * The odataMetadata
     */
    public String getOdataMetadata() {
        return odataMetadata;
    }

    /**
     *
     * @param odataMetadata
     * The odata.metadata
     */
    public void setOdataMetadata(String odataMetadata) {
        this.odataMetadata = odataMetadata;
    }

    /**
     *
     * @return
     * The odataType
     */
    public String getOdataType() {
        return odataType;
    }

    /**
     *
     * @param odataType
     * The odata.type
     */
    public void setOdataType(String odataType) {
        this.odataType = odataType;
    }

    /**
     *
     * @return
     * The odataId
     */
    public String getOdataId() {
        return odataId;
    }

    /**
     *
     * @param odataId
     * The odata.id
     */
    public void setOdataId(String odataId) {
        this.odataId = odataId;
    }

    /**
     *
     * @return
     * The odataEditLink
     */
    public String getOdataEditLink() {
        return odataEditLink;
    }

    /**
     *
     * @param odataEditLink
     * The odata.editLink
     */
    public void setOdataEditLink(String odataEditLink) {
        this.odataEditLink = odataEditLink;
    }

    /**
     *
     * @return
     * The ChannelUrlTemplate
     */
    public String getChannelUrlTemplate() {
        return ChannelUrlTemplate;
    }

    /**
     *
     * @param ChannelUrlTemplate
     * The ChannelUrlTemplate
     */
    public void setChannelUrlTemplate(String ChannelUrlTemplate) {
        this.ChannelUrlTemplate = ChannelUrlTemplate;
    }

    /**
     *
     * @return
     * The IsVideoPortalEnabled
     */
    public Boolean getIsVideoPortalEnabled() {
        return IsVideoPortalEnabled;
    }

    /**
     *
     * @param IsVideoPortalEnabled
     * The IsVideoPortalEnabled
     */
    public void setIsVideoPortalEnabled(Boolean IsVideoPortalEnabled) {
        this.IsVideoPortalEnabled = IsVideoPortalEnabled;
    }

    /**
     *
     * @return
     * The PlayerUrlTemplate
     */
    public String getPlayerUrlTemplate() {
        return PlayerUrlTemplate;
    }

    /**
     *
     * @param PlayerUrlTemplate
     * The PlayerUrlTemplate
     */
    public void setPlayerUrlTemplate(String PlayerUrlTemplate) {
        this.PlayerUrlTemplate = PlayerUrlTemplate;
    }

    /**
     *
     * @return
     * The VideoPortalLayoutsUrl
     */
    public String getVideoPortalLayoutsUrl() {
        return VideoPortalLayoutsUrl;
    }

    /**
     *
     * @param VideoPortalLayoutsUrl
     * The VideoPortalLayoutsUrl
     */
    public void setVideoPortalLayoutsUrl(String VideoPortalLayoutsUrl) {
        this.VideoPortalLayoutsUrl = VideoPortalLayoutsUrl;
    }

    /**
     *
     * @return
     * The VideoPortalUrl
     */
    public String getVideoPortalUrl() {
        return VideoPortalUrl;
    }

    /**
     *
     * @param VideoPortalUrl
     * The VideoPortalUrl
     */
    public void setVideoPortalUrl(String VideoPortalUrl) {
        this.VideoPortalUrl = VideoPortalUrl;
    }

}