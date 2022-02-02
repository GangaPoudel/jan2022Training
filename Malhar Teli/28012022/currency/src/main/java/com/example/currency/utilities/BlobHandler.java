package com.example.currency.utilities;

import lombok.NoArgsConstructor;

import java.util.Base64;

@NoArgsConstructor

public class BlobHandler {
    public String blobToString(byte[] blob){
        return Base64.getEncoder().withoutPadding().encodeToString(blob);
    }
    public byte[] stringToBlob(String string){
        return Base64.getDecoder().decode(string);
    }
}
