package com.google.android.exoplayer.demo.models;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ChannelsResponse {

    @SerializedName("odata.metadata")
    @Expose
    private String odataMetadata;
    @SerializedName("value")
    @Expose
    private List<ChannelsValue> value = new ArrayList<ChannelsValue>();

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
     * The value
     */
    public List<ChannelsValue> getValue() {
        return value;
    }

    /**
     *
     * @param value
     * The value
     */
    public void setValue(List<ChannelsValue> value) {
        this.value = value;
    }

}
