package com.nventify;

import java.util.Map;

/**
 * Created by Nicholas Pettas on 8/24/16.
 */
public class ImagizerClient {
    private String host;
    private Boolean useHttps = false;

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
     * @param host the hostname to the Imagizer instance
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
        return new ImagizerUrl(host, useHttps, path);
    }

    /**
     * Returns an Imagizer URL with supplied params
     *
     * @param path the path for the url
     * @param params the params to add to the url
     * @return ImagizerUrl
     */
    public ImagizerUrl buildUrl(String path, Map<String, Object> params) {
        ImagizerUrl url = new ImagizerUrl(host, useHttps, path);
        url.addParams(params);

        return url;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Boolean getUseHttps() {
        return useHttps;
    }

    public void setUseHttps(Boolean useHttps) {
        this.useHttps = useHttps;
    }
}
