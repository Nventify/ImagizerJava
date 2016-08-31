package com.nventify;

import java.util.Map;

/**
 * Created by Nicholas Pettas on 8/24/16.
 */
public class ImagizerClient {
    public final static int DEFAULT_QUALITY = 90;
    public final static Double DEFAULT_DPR = 1.0;

    private String host;

    /* use https connection to Imagizer instance */
    private Boolean useHttps = false;

    /* the default device pixel density */
    private Double dpr = DEFAULT_DPR;

    /* the default image quality compression to use */
    private Integer quality;

    /**
     * Initialize Imagizer client
     *
     * @param host the hostname to the Imagizer instance
     */
    public ImagizerClient(String host) {
        this.host = host;
    }

    /**
     * Initialize Imagizer client
     *
     * @param host     the hostname to the Imagizer instance
     * @param useHttps whether to use https for the connection
     */
    public ImagizerClient(String host, Boolean useHttps) {
        this.host = host;
        this.useHttps = useHttps;
    }

    /**
     * Returns an Imagizer URL
     *
     * @param path the path of the image
     * @return ImagizerUrl
     */
    public ImagizerUrl buildUrl(String path) {
        ImagizerUrl imagizerUrl = new ImagizerUrl(host, useHttps, path);
        imagizerUrl.setDpr(this.dpr);
        imagizerUrl.setQuality(this.quality);
        return imagizerUrl;
    }

    /**
     * Returns an Imagizer URL with supplied params
     *
     * @param path   the path for the url
     * @param params the params to add to the url
     * @return ImagizerUrl
     */
    public ImagizerUrl buildUrl(String path, Map<String, Object> params) {
        ImagizerUrl url = new ImagizerUrl(host, useHttps, path);
        url.addParams(params);

        return url;
    }

    /**
     * Returns the hostname to the Imagizer Instance
     *
     * @return host the Imagizer instance hostname
     */
    public String getHost() {
        return host;
    }

    /**
     * Set the hostname
     *
     * @param host the Imagizer instance hostname
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Returns true if using https
     *
     * @return useHttps whether using https or not
     */
    public Boolean isUseHttps() {
        return useHttps;
    }

    /**
     * Sets whether using https
     *
     * @param useHttps whether using https or not
     */
    public void setUseHttps(Boolean useHttps) {
        this.useHttps = useHttps;
    }

    /**
     * Returns the current default device pixel ratio
     *
     * @return dpr the device pixel ratio
     */
    public Double getDpr() {
        return dpr;
    }

    /**
     * Set the default device pixel ratio
     *
     * @param dpr the device pixel ratio. Default is 1.0
     */
    public void setDpr(Double dpr) {
        this.dpr = dpr;
    }

    /**
     * Set the default device pixel ratio
     *
     * @param dpr the device pixel ratio. Default is 1.0
     */
    public void setDpr(int dpr) {
        this.dpr = (double) dpr;
    }

    /**
     * Returns the current default image quality compression
     *
     * @return quality the default quality compression
     */
    public int getQuality() {
        return quality;
    }

    /**
     * Set the default image quality compression
     *
     * @param quality the default quality compression 0 - 100.
     *                Default is 90
     */
    public void setQuality(Integer quality) {
        if (quality == null || quality > 100 || quality < 0) {
            return;
        }

        this.quality = quality;
    }
}
