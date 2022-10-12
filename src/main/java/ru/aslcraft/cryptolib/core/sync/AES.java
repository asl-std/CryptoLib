package ru.aslcraft.cryptolib.core.sync;

import lombok.SneakyThrows;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

public class AES {
    public AES(){
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }
    @SneakyThrows
    public byte[] encrypt(byte[] input, IvParameterSpec vector, SecretKey secretKey){
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding", "BC");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, vector);
        return cipher.doFinal(input);
    }
    @SneakyThrows
    public byte[] decrypt(byte[] input, IvParameterSpec vector, SecretKey secretKey){
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding", "BC");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(secretKey.getEncoded(), "AES"), vector);
        return cipher.doFinal(input);
    }
}
