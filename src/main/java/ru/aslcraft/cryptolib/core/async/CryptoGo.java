package ru.aslcraft.cryptolib.core.async;

import lombok.SneakyThrows;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class CryptoGo {
    public CryptoGo(){
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }
    @SneakyThrows
    public byte[] encrypt(byte[] input, byte[] pubKey){
        Cipher cipher = Cipher.getInstance("ECIES", BouncyCastleProvider.PROVIDER_NAME);
        PublicKey publicKey = KeyFactory.getInstance("ECDH").generatePublic(new X509EncodedKeySpec(pubKey));
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(input);
    }

    @SneakyThrows
    public byte[] decrypt(byte[] input, byte[] privKey){
        Cipher cipher = Cipher.getInstance("ECIES", BouncyCastleProvider.PROVIDER_NAME);
        PrivateKey privateKey = KeyFactory.getInstance("ECDH").generatePrivate(new PKCS8EncodedKeySpec(privKey));
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(input);
    }
}
