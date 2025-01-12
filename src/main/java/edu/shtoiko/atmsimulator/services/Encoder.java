package edu.shtoiko.atmsimulator.services;

import javax.crypto.SecretKey;

public interface Encoder {
    SecretKey generateKey();

    String encrypt(String plainText, String secretKey);

    String decrypt(String encryptedText, String secretKeyString);

}
