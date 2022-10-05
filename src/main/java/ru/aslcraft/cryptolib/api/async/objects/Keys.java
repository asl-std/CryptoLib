package ru.aslcraft.cryptolib.api.async.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Keys {
    @Getter private String pubHex;
    @Getter private byte[] pubByte;
    @Getter private String privHex;
    @Getter private byte[] privByte;
}
