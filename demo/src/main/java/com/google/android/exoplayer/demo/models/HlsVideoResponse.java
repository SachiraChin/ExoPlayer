package com.google.android.exoplayer.demo.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HlsVideoResponse {

    @SerializedName("odata.metadata")
    @Expose
    private String odataMetadata;
    @SerializedName("value")
    @Expose
    private String value;

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
    public String getValue() {
        return value;
    }

    /**
     *
     * @param value
     * The value
     */
    public void setValue(String value) {
        this.value = value;
    }

}