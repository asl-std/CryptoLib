package ru.aslcraft.cryptolib.api.async;

import ru.aslcraft.cryptolib.core.async.CryptoGo;
import ru.zoommax.hul.HexUtils;

import java.nio.charset.StandardCharsets;

public class Decrypt {
    public String decryptHex(String data, String pubKeyHex){
        return new String(decryptByte(data, pubKeyHex), StandardCharsets.UTF_8);
    }

    public String decryptHex(byte[] data, String pubKeyHex){
        return new String(decryptByte(data, pubKeyHex), StandardCharsets.UTF_8);
    }

    public String decryptHex(byte[] data, byte[] pubKeyByte){
        return new String(decryptByte(data, pubKeyByte), StandardCharsets.UTF_8);
    }

    public String decryptHex(String data, byte[] pubKeyByte){
        return new String(decryptByte(data, pubKeyByte), StandardCharsets.UTF_8);
    }




    public byte[] decryptByte(String data, String pubKeyHex){
        byte[] key = HexUtils.fromString(pubKeyHex);
        byte[] data2byte = data.getBytes(StandardCharsets.UTF_8);
        return decryptByte(data2byte, key);
    }

    public byte[] decryptByte(byte[] data, String pubKeyHex){
        byte[] key = HexUtils.fromString(pubKeyHex);
        return decryptByte(data, key);
    }

    public byte[] decryptByte(byte[] data, byte[] pubKeyByte){
        return new CryptoGo().decrypt(data, pubKeyByte);
    }

    public byte[] decryptByte(String data, byte[] pubKeyByte){
        byte[] data2byte = data.getBytes(StandardCharsets.UTF_8);
        return decryptByte(data2byte, pubKeyByte);
    }
}
