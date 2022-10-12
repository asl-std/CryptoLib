package ru.aslcraft.cryptolib.core.sync;

import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

public class GetVector {
    public IvParameterSpec vector(){
        byte[] vb = new byte[256];
        SecureRandom random = new SecureRandom();
        random.nextBytes(vb);
        return new IvParameterSpec(vb);
    }
}
