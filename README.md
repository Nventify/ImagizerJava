# Imagizer Java Client
The official Java client for the Imagizer Media Engine for generating Imagizer URLs. Imagizer Media Engine is a blazing fast dynamic image processing soloution. More infomation can be found at [nventify.com](http://nventify.com).

## Install from JCenter or Maven
```gradle
dependencies {
    compile 'com.nventify:ImagizerClient:0.1.4'
}
```

## Build Jar from Source
```bash
gradle build
```

## Unit Tests
```bash
gradle test
```

## Basic Usage
Using the free to test Imagizer Demo Service 
```java
import com.nventify.ImagizerClient;

public class ImagizerClientExample {
    public static void main(String[] args) {
        ImagizerClient client = new ImagizerClient();
        client.setOriginHost("example.com");

        String url = client.buildUrl("image.jpg")
                .addParam("width", 200)
                .addParam("height", 400)
                .addParam("crop", "fit")
                .toString();

        System.out.println(url);
    }
}

// prints out
// http://demo.imagizercdn.com/image.jpg?crop=fit&height=400&hostname=example.com&width=200
```

Using your own Imagizer Instance
```java
import com.nventify.ImagizerClient;

public class ImagizerClientExample {
    public static void main(String[] args) {
        ImagizerClient client = new ImagizerClient("your-imagizer-host.com");

        String url = client.buildUrl("image.jpg")
                .addParam("width", 200)
                .addParam("height", 400)
                .addParam("crop", "fit")
                .toString();

        System.out.println(url);
    }
}

// prints out
// http://your-imagizer-host.com/image.jpg?crop=fit&height=400&width=200
```
