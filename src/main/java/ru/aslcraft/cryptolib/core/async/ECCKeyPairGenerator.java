package ru.aslcraft.cryptolib.core.async;

import lombok.SneakyThrows;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.ECGenParameterSpec;

public class ECCKeyPairGenerator {
    public ECCKeyPairGenerator(){
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }
    @SneakyThrows
    public KeyPair getKeys(){
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("ECDH", BouncyCastleProvider.PROVIDER_NAME);
        kpg.initialize(new ECGenParameterSpec("curve25519"), new SecureRandom());
        return kpg.genKeyPair();
    }
}
