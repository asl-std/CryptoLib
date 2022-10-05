# CryptoLib
[![GitHub license](https://img.shields.io/github/license/asl-std/CryptoLib?style=plastic)](https://github.com/asl-std/CryptoLib/blob/release/LICENSE)
[![GitHub issues](https://img.shields.io/github/issues/asl-std/CryptoLib?style=plastic)](https://github.com/asl-std/CryptoLib/issues)
![GitHub Workflow Status](https://img.shields.io/github/workflow/status/asl-std/CryptoLib/Build?style=plastic)
![GitHub Workflow Status](https://img.shields.io/github/workflow/status/asl-std/CryptoLib/Maven%20Central%20deploy?style=plastic)
[![Maven Central](https://img.shields.io/maven-central/v/ru.aslcraft/cryptolib.svg?label=Maven%20Central&style=plastic)](https://search.maven.org/search?q=g:%22ru.aslcraft%22%20AND%20a:%22cryptolib%22)


### Dependencies
![dependency maven](https://img.shields.io/badge/DEPENDENCY-Maven-C71A36?style=plastic&logo=apachemaven)
```xml
<dependencies>
    <dependency>
        <groupId>ru.aslcraft</groupId>
        <artifactId>CryptoLib</artifactId>
        <version>1.0</version>
    </dependency>
</dependencies>
```

![dependency gradle](https://img.shields.io/badge/DEPENDENCY-Gradle-02303A?style=plastic&logo=gradle)
```groovy
implementation 'ru.aslcraft:CryptoLib:1.0'
```

### How to use

```java
package test.java;

import ru.aslcraft.cryptolib.api.async.Decrypt;
import ru.aslcraft.cryptolib.api.async.Encrypt;
import ru.aslcraft.cryptolib.api.async.GetKeys;
import ru.aslcraft.cryptolib.api.async.objects.Keys;
import ru.zoommax.hul.HexUtils;

import java.nio.charset.StandardCharsets;

public class TestMain {
    public static void main(String[] args) {
        Keys keys = new GetKeys().get();
        byte[] privKey = keys.getPrivByte();
        byte[] pubKey = keys.getPubByte();
        String in = "Test string";

        byte[] enc = new Encrypt().encryptByte(in, pubKey);
        byte[] dec = new Decrypt().decryptByte(enc, privKey);
        System.out.println(in);
        System.out.println("Encrypt text: " + new String(enc, StandardCharsets.UTF_8));
        System.out.println("Decrypt text: " + new String(dec, StandardCharsets.UTF_8));
    }
}
```

### P.S.
Library work in progress