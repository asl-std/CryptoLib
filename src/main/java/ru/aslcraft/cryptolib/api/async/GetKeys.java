package ru.aslcraft.cryptolib.api.async;

import ru.aslcraft.cryptolib.api.async.objects.Keys;
import ru.aslcraft.cryptolib.core.async.ECCKeyPairGenerator;
import ru.zoommax.HexUtils;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class GetKeys {
    public Keys get(){
        KeyPair kp = new ECCKeyPairGenerator().getKeys();
        PublicKey pubKey = kp.getPublic();
        PrivateKey privKey = kp.getPrivate();
        return new Keys(HexUtils.toString(pubKey.getEncoded()), pubKey.getEncoded(), HexUtils.toString(privKey.getEncoded()), privKey.getEncoded());
    }
}
