package ru.aslcraft.cryptolib.core.sync;

import lombok.SneakyThrows;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Security;

public class GetKey {
    public GetKey(){
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }
    @SneakyThrows
    public SecretKey key(){
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "BC");
        keyGenerator.init(256);
        return keyGenerator.generateKey();
    }
}
