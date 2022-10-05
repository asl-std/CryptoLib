package ru.aslcraft.cryptolib.api.async;

import ru.aslcraft.cryptolib.core.async.CryptoGo;
import ru.zoommax.HexUtils;

import java.nio.charset.StandardCharsets;

public class Encrypt {
    public String encryptHex(String data, String privKeyHex){
        return new String(encryptByte(data, privKeyHex), StandardCharsets.UTF_8);
    }

    public String encryptHex(byte[] data, String privKeyHex){
        return new String(encryptByte(data, privKeyHex), StandardCharsets.UTF_8);
    }

    public String encryptHex(byte[] data, byte[] privKeyByte){
        return new String(encryptByte(data, privKeyByte), StandardCharsets.UTF_8);
    }

    public String encryptHex(String data, byte[] privKeyByte){
        return new String(encryptByte(data, privKeyByte), StandardCharsets.UTF_8);
    }




    public byte[] encryptByte(String data, String privKeyHex){
        byte[] key = HexUtils.fromString(privKeyHex);
        byte[] data2byte = data.getBytes(StandardCharsets.UTF_8);
        return encryptByte(data2byte, key);
    }

    public byte[] encryptByte(byte[] data, String privKeyHex){
        byte[] key = HexUtils.fromString(privKeyHex);
        return encryptByte(data, key);
    }

    public byte[] encryptByte(byte[] data, byte[] privKeyByte){
        return new CryptoGo().encrypt(data, privKeyByte);
    }

    public byte[] encryptByte(String data, byte[] privKeyByte){
        byte[] data2byte = data.getBytes(StandardCharsets.UTF_8);
        return encryptByte(data2byte, privKeyByte);
    }
}
