package com.nventify;

import junit.framework.TestCase;

import java.util.HashMap;

/**
 * Created by Nicholas Pettas on 8/24/16.
 */
public class ImagizerClientTest extends TestCase {

    public void testBuildUrl() {
        ImagizerClient client = new ImagizerClient("example.com");
        String url = client.buildUrl("image.jpg").toString();

        assertEquals("http://example.com/image.jpg", url);
    }

    public void testBuildUrlWithAddParams() throws Exception {
        ImagizerClient client = new ImagizerClient("example.com");

        String url = client.buildUrl("image.jpg")
                .addParam("width", 200)
                .addParam("height", 400)
                .addParam("crop", "fit")
                .toString();

        assertEquals("http://example.com/image.jpg?crop=fit&height=400&width=200", url);
    }

    public void testBuildUrlWithHashMap() throws Exception {
        ImagizerClient client = new ImagizerClient("example.com");

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("width", 200);
        params.put("height", 400);

        ImagizerUrl imagizerUrl = client.buildUrl("image.jpg", params);

        assertEquals("http://example.com/image.jpg?height=400&width=200", imagizerUrl.toString());
    }

    public void testBuildUrlWithQuality() throws Exception  {
        ImagizerClient client = new ImagizerClient("example.com");

        String url = client.buildUrl("image.jpg")
                .addParam("quality", 100)
                .toString();

        assertEquals("http://example.com/image.jpg?quality=100", url);
    }

    public void testBuildUrlWithGlobalQuality() throws Exception  {
        ImagizerClient client = new ImagizerClient("example.com");
        client.setQuality(100);

        String url = client.buildUrl("image.jpg").toString();

        assertEquals("http://example.com/image.jpg?quality=100", url);
    }

    public void testBuildUrlWithGlobalQualityOverride() throws Exception  {
        ImagizerClient client = new ImagizerClient("example.com");
        client.setQuality(100);

        String url = client.buildUrl("image.jpg").addParam("quality", 99).toString();

        assertEquals("http://example.com/image.jpg?quality=99", url);
    }

    public void testBuildUrlWithDpr() throws Exception  {
        ImagizerClient client = new ImagizerClient("example.com");

        String url = client.buildUrl("image.jpg")
                .addParam("dpr", 2)
                .toString();

        assertEquals("http://example.com/image.jpg?dpr=2", url);
    }

    public void testBuildUrlWithGlobalDpr() throws Exception  {
        ImagizerClient client = new ImagizerClient("example.com");
        client.setDpr(2);

        String url = client.buildUrl("image.jpg").toString();

        assertEquals("http://example.com/image.jpg?dpr=2", url);
    }

    public void testBuildUrlWithGlobalDprOverride() throws Exception  {
        ImagizerClient client = new ImagizerClient("example.com");
        client.setDpr(2);

        String url = client.buildUrl("image.jpg").addParam("dpr", 2.3).toString();

        assertEquals("http://example.com/image.jpg?dpr=2.3", url);
    }
}