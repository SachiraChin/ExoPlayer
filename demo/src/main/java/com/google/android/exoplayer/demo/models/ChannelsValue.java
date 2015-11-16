package com.google.android.exoplayer.demo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChannelsValue {

    @SerializedName("odata.type")
    @Expose
    private String odataType;
    @SerializedName("odata.id")
    @Expose
    private String odataId;
    @SerializedName("odata.editLink")
    @Expose
    private String odataEditLink;
    @SerializedName("Description")
    @Expose
    private String Description;
    @SerializedName("Id")
    @Expose
    private String Id;
    @SerializedName("ServerRelativeUrl")
    @Expose
    private String ServerRelativeUrl;
    @SerializedName("TileHtmlColor")
    @Expose
    private String TileHtmlColor;
    @SerializedName("Title")
    @Expose
    private String Title;
    @SerializedName("YammerEnabled")
    @Expose
    private Boolean YammerEnabled;

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
     * The Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     *
     * @param Description
     * The Description
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     *
     * @return
     * The Id
     */
    public String getId() {
        return Id;
    }

    /**
     *
     * @param Id
     * The Id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     *
     * @return
     * The ServerRelativeUrl
     */
    public String getServerRelativeUrl() {
        return ServerRelativeUrl;
    }

    /**
     *
     * @param ServerRelativeUrl
     * The ServerRelativeUrl
     */
    public void setServerRelativeUrl(String ServerRelativeUrl) {
        this.ServerRelativeUrl = ServerRelativeUrl;
    }

    /**
     *
     * @return
     * The TileHtmlColor
     */
    public String getTileHtmlColor() {
        return TileHtmlColor;
    }

    /**
     *
     * @param TileHtmlColor
     * The TileHtmlColor
     */
    public void setTileHtmlColor(String TileHtmlColor) {
        this.TileHtmlColor = TileHtmlColor;
    }

    /**
     *
     * @return
     * The Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     *
     * @param Title
     * The Title
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     *
     * @return
     * The YammerEnabled
     */
    public Boolean getYammerEnabled() {
        return YammerEnabled;
    }

    /**
     *
     * @param YammerEnabled
     * The YammerEnabled
     */
    public void setYammerEnabled(Boolean YammerEnabled) {
        this.YammerEnabled = YammerEnabled;
    }

}
