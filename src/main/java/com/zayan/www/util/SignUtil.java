package com.zayan.www.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Slf4j
public class SignUtil {

    public static String generateSign(Map<String, String> params, String secret) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String encodeString = getEncodeString(params, secret);
        log.info(String.format("encodeString: %s", encodeString));
        String sign = generateSign(encodeString);
        log.info(String.format("generateSign: %s", sign));
        return sign;
    }

    private static String getEncodeString(Map<String, String> params, String secret) {
        Iterator<String> keyIter = params.keySet().iterator();
        Set<String> sortedParams = new TreeSet<>();
        while (keyIter.hasNext()) {
            sortedParams.add(keyIter.next());
        }

        StringBuilder strB = new StringBuilder(secret);

        // 排除sign和空值参数
        for (String key : sortedParams) {
            if (key.equals("sfSign")) {
                continue;
            }

            String value = params.get(key);

            if (StringUtils.isNotBlank(value)) {
                strB.append(key).append(value);
            }
        }
        return strB.toString();
    }

    private static String generateSign(String content) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return SHA1Util.Sha1(content).toLowerCase();
    }

    /**
     * PHP的openssl_encrypt方法的Java实现
     *
     * @param dataText
     * @param keyText
     * @return
     */
    public static String opensslEncrypt(String dataText, String keyText) {
        byte[] key = keyText.getBytes();
        byte[] data = dataText.getBytes();

        SecretKey secretKey = new SecretKeySpec(key, "DES");
        Cipher cipher = null;

        try {
            cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }

        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        byte[] encryptedData = null;
        try {
            encryptedData = cipher.doFinal(data);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

        String result = null;
        try {
            result = URLEncoder.encode(new String(Base64.getEncoder().encode(encryptedData)), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 腾讯云签名
     * @return
     */
    public static String tencentSign(Map<String, Object> params, String url, String method, String secretKey) {

        StringBuffer requestStrb = new StringBuffer();
        for(Map.Entry<String, Object> entry : params.entrySet()) {
            requestStrb.append(entry.getKey()+"="+entry.getValue()+"&");
        }
        String requestStr = method+url+"/?"+requestStrb.toString().substring(0,requestStrb.length()-1);
        //SHA1Util.Sha1()
        // TODO
        return null;
    }

    public static String wechatSign(Map<String, String> params, String signKey) {
        SortedMap<String, String> sortedMap = new TreeMap<>(params);

        StringBuilder toSign = new StringBuilder();
        for (String key : sortedMap.keySet()) {
            String value = params.get(key);
            if (StringUtils.isNotEmpty(value) && !"sign".equals(key) && !"key".equals(key)) {
                toSign.append(key).append("=").append(value).append("&");
            }
        }

        toSign.append("key=").append(signKey);
        return DigestUtils.md5Hex(toSign.toString()).toUpperCase();
    }

    public static Boolean verify(Map<String, String> params, String signKey) {
        String sign = wechatSign(params, signKey);
        return sign.equals(params.get("sign"));
    }

    public static String tencentImageSign(long appId, String secretId, String secretKey, String bucketName,
                                 long expired) throws Exception {
        long now = System.currentTimeMillis() / 1000;
        int rdm = Math.abs(new Random().nextInt());
        String plainText = String.format("a=%d&b=%s&k=%s&t=%d&e=%d&r=%d", appId, bucketName,
                secretId, now, now + expired, rdm);
        byte[] hmacDigest = HmacSha1(plainText, secretKey);
        byte[] signContent = new byte[hmacDigest.length + plainText.getBytes().length];
        System.arraycopy(hmacDigest, 0, signContent, 0, hmacDigest.length);
        System.arraycopy(plainText.getBytes(), 0, signContent, hmacDigest.length,
                plainText.getBytes().length);
        return Base64Encode(signContent);
    }

    private static String Base64Encode(byte[] binaryData) {
        String encodedstr = Base64.getEncoder().encodeToString(binaryData);
        return encodedstr;
    }

    /**
     * 生成 hmacsha1 签名
     *
     * @param binaryData
     * @param key
     * @return
     * @throws Exception
     */
    private static byte[] HmacSha1(byte[] binaryData, String key) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA1");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
        mac.init(secretKey);
        byte[] HmacSha1Digest = mac.doFinal(binaryData);
        return HmacSha1Digest;
    }

    /**
     * 生成 hmacsha1 签名
     *
     * @param plainText
     * @param key
     * @return
     * @throws Exception
     */
    private static byte[] HmacSha1(String plainText, String key) throws Exception {
        return HmacSha1(plainText.getBytes(), key);
    }
}
