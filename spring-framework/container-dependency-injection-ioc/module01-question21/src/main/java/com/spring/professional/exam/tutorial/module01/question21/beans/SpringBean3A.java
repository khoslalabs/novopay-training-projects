package com.spring.professional.exam.tutorial.module01.question21.beans;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

public class SpringBean3A implements SpringBean3 {
    private final MessageDigest messageDigest;

    public SpringBean3A(MessageDigest messageDigest) {
        this.messageDigest = messageDigest;
    }

    public void printHash() {
        byte[] hashBytes = messageDigest.digest("test".getBytes());
        char[] hashString = Hex.encodeHex(hashBytes);
        System.out.println(hashString);
    }
}
