package com.nventify;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Nicholas Pettas on 8/24/16.
 */
public class ImagizerUrl {
    protected String host;
    protected Boolean useHttps = false;
    protected String path;
    protected Map<String, Object> params = new TreeMap<String, Object>();

    /* hostname of the origin image storage server */
    protected String originHost;

    /* the default device pixel density */
    protected Double dpr;

    /* the default image quality compression to use */
    protected Integer quality;

    /**
     * Construct Imagizer URL
     *
     * @param host     the hostname of the Imagizer instance
     * @param useHttps whether to use https or not
     * @param path     the path of the image
     */
    public ImagizerUrl(String host, Boolean useHttps, String path) {
        this.host = host;
        this.useHttps = useHttps;
        this.path = path;
    }

    /**
     * Construct Imagizer URL
     *
     * @param host     the Hostname of the Imagizer instance
     * @param useHttps whether to use https or not
     * @param path     the path of the image
     * @param params   the parameters to add to the url
     */
    public ImagizerUrl(String host, Boolean useHttps, String path, Map<String, Object> params) {
        this.host = host;
        this.useHttps = useHttps;
        this.path = path;
        this.params = params;
    }

    /**
     * Returns Imagizer URL with added parameter
     *
     * @param key   the key of the parameter to add
     * @param value the value of the parameter to add
     * @return ImagizerUrl
     */
    public ImagizerUrl addParam(String key, int value) {
        params.put(key, value);
        return this;
    }

    /**
     * Returns Imagizer URL with added parameter
     *
     * @param key   the key of the parameter to add
     * @param value the value of the parameter to add
     * @return ImagizerUrl
     */
    public ImagizerUrl addParam(String key, String value) {
        params.put(key, value);

        return this;
    }

    /**
     * Returns Imagizer URL with added parameter
     *
     * @param key   the key of the parameter to add
     * @param value the value of the parameter to add
     * @return ImagizerUrl
     */
    public ImagizerUrl addParam(String key, double value) {
        params.put(key, value);

        return this;
    }

    /**
     * Returns Imagizer URL with added parameters
     *
     * @param params the parameters to add to the url
     * @return ImagizerUrl
     */
    public ImagizerUrl addParams(Map<String, Object> params) {
        this.params.putAll(params);

        return this;
    }

    /**
     * Returns string that textually represents an Imagizer URL
     *
     * @return string of imagizer URL
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat format = new DecimalFormat("0.#");

        sb.append(this.useHttps ? "https" : "http");
        sb.append("://");
        sb.append(host);
        sb.append(this.cleanPath(this.path));

        if (this.originHost != null) {
            this.params.put("hostname", this.originHost);
        }

        if (!this.params.containsKey("dpr") && this.dpr != null && !this.dpr.equals(ImagizerClient.DEFAULT_DPR)) {
            this.params.put("dpr", this.dpr);
        }

        if (!this.params.containsKey("quality") && this.quality != null) {
            this.params.put("quality", this.quality);
        }

        if (this.params.size() > 0) {
            int i = 0;
            for (Map.Entry<String, Object> param : this.params.entrySet()) {
                if (i == 0) {
                    sb.append("?");
                } else {
                    sb.append("&");
                }

                sb.append(param.getKey());
                sb.append("=");

                if (param.getKey().equals("dpr")) {
                    sb.append(format.format(param.getValue()));
                } else {
                    sb.append(param.getValue().toString());
                }

                i++;
            }
        }

        return sb.toString();
    }

    protected String cleanPath(String path) {
        if (!path.startsWith("/")) {
            path = "/" + path;
        }

        return path;
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
     * Returns the current default image quality compression
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

    /**
     * Returns the origin image storage hostname
     * @return the origin image storage hostname
     */
    public String getOriginHost() {
        return originHost;
    }

    /**
     * Sets the origin image storage host
     *
     * @param originHost the origin image storage hostname
     */
    public void setOriginHost(String originHost) {
        this.originHost = originHost;
    }
}
