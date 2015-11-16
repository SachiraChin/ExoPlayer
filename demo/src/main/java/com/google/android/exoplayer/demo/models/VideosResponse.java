package com.google.android.exoplayer.demo.models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideosResponse {

    @SerializedName("odata.metadata")
    @Expose
    private String odataMetadata;
    @SerializedName("value")
    @Expose
    private List<VideosValue> value = new ArrayList<VideosValue>();

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
    public List<VideosValue> getValue() {
        return value;
    }

    /**
     *
     * @param value
     * The value
     */
    public void setValue(List<VideosValue> value) {
        this.value = value;
    }

}