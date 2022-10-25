package org.example.cryptography;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Charset UTF_8= StandardCharsets.UTF_8;
    private static final String  OUTPUT_FORMAT="%-20s:%s";

    private static byte[] digest(byte[] input){
        MessageDigest md;
        try {
            md=MessageDigest.getInstance("MD5");

        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result= md.digest(input);
        return result;
    }

    private static String byteToHex(byte[] bytes){
        StringBuilder sb=new StringBuilder();
        for (byte b: bytes){
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    public static void main( String[] args )
    {
        String pText="Password123";
        byte[] md5InByte= App.digest(pText.getBytes(UTF_8));
        System.out.println(String.format(OUTPUT_FORMAT, "MD5 (hex) ", byteToHex(md5InByte)));
    }
}
