package com.nventify;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Nicholas Pettas on 8/24/16.
 */
public class ImagizerUrl {
    private String host;
    private Boolean useHttps = false;
    private String path;
    private Map<String, Object> params = new TreeMap<String, Object>();

    /**
     * Construct Imagizer URL
     *
     * @param host the hostname of the Imagizer instance
     * @param useHttps whether to use https or not
     * @param path the path of the image
     */
    public ImagizerUrl(String host, Boolean useHttps, String path) {
        this.host = host;
        this.useHttps = useHttps;
        this.path = path;
    }

    /**
     * Construct Imagizer URL
     *
     * @param host the Hostname of the Imagizer instance
     * @param useHttps whether to use https or not
     * @param path the path of the image
     * @param params the parameters to add to the url
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
     * @param key the key of the parameter to add
     * @param value the value of the parameter to add
     * @return ImagizerUrl
     */
    public ImagizerUrl addParam(String key, Integer value) {
        params.put(key, value);

        return this;
    }

    /**
     * Returns Imagizer URL with added parameter
     *
     * @param key the key of the parameter to add
     * @param value the value of the parameter to add
     * @return ImagizerUrl
     */
    public ImagizerUrl addParam(String key, String value) {
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

        sb.append(this.useHttps ? "https" : "http");
        sb.append("://");
        sb.append(host);
        sb.append(this.cleanPath(this.path));

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
                sb.append(param.getValue().toString());

                i++;
            }
        }

        return sb.toString();
    }

    private String cleanPath(String path) {
        if (!path.startsWith("/")) {
            path = "/" + path;
        }

        return path;
    }
}
