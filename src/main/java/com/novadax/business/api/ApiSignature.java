package com.novadax.business.api;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Created by bh on 2019/8/8.
 */
public class ApiSignature {

    private List<String> WITHOUT_CONTENT_BODY_METHOD = Arrays.asList("GET", "DELETE", "HEAD");

    /**
     * URLEncode
     *
     * @param input
     * @return
     */
    public static String urlEncode(String input) {
        try {
            return URLEncoder.encode(input, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return input;
        }
    }

    public String getSignature(String method, String path, String params, String body, String timestamp, String key) {
        String SignatureStr = getSignatureStr(method, path, params, body, timestamp);
        return HmacUtils.hmacSha256Hex(key, SignatureStr);
    }


    private String getSignatureStr(String method, String path, String params, String body, String timestamp) {

        if (!WITHOUT_CONTENT_BODY_METHOD.contains(method)) {
            String contentMd5 = getContentMd5(body);
            return String.format("%s\n%s\n%s\n%s", method, path, contentMd5, timestamp);
        } else {
            return String.format("%s\n%s\n%s\n%s", method, path, params, timestamp);
        }
    }


    private String getContentMd5(String body) {
        try {
            MessageDigest m = null;
            try {
                m = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            m.update(body.getBytes(StandardCharsets.UTF_8));

            byte[] s = m.digest();
            String result = "";
            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000ff & s[i]) | 0xffffff00).substring(6);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }




}
