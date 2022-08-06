package com.flysky.study.springweb.controller;

import com.flysky.study.springweb.restfull.SHACoder;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class MyClass {

    private static final String KEY_PRIVATE = "-----BEGIN PRIVATE KEY-----\n" +
            "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDOabCih9nH9rRP\n" +
            "nu3WVMqBd3L+czkEPPnqxomd7ZMb2YcYI58scBzCiWZ/KJb4KlCOvx+xKN5BF1SM\n" +
            "B+vhOCx8ggIB98Gp+0FXJEPjbWxQHgFcwAeHStcUNycvqbf5ee9X8ObtR36xJJbM\n" +
            "shgHJAmfmhXw3F3/ZdggOe2PeclXhvk5QBCVbDra6NQps7eF8cZZwnVShaf4muF1\n" +
            "KO66cgrw4r6hJjpirj+BPneu9fkdOBW2B4+QxkD3fERYNn7k/i4qarbmGQUTtkMk\n" +
            "0Q5CHRJH0fp89sodRFSiiZHqa4EwCn59dwuQuy/BTOErPu5/8JB1vxOfdaI/1gZw\n" +
            "ZZeXPyitAgMBAAECggEAPtpIAvXDBvTEawpF+eHP2CR7S6fiULwQjcDu3rwc83oF\n" +
            "fQA709g/qa0VHNtLPT4FUbI5AEUliESGZi1zUh08zpz354l92zi66MIOOg5z0OGS\n" +
            "IKAIqtXLMEirEgRoFPtgOjMM3mvK1D4D/UitsF703ziYPcOci8yDRyzcfbfj61aO\n" +
            "PluIocmFJNGg+LsgX5/RhCKZBZ83trXyXOHI9DZIHbL4gnkDMESAHX3F6sWaZgXA\n" +
            "2xKbbIcT7qD/Nc57VJOz3HT4plQsiWVG2bZcE5/bt0kTPar171EnAzkJ3PXf1a1Q\n" +
            "X6wj2N44v5O63rXImMFir8D7NUe/JdHEVSrdeRuyMQKBgQDq1kC0i/Q/drId56Ru\n" +
            "A92nFFov2dGfBvyxkEcd1QMakwUBHBfq2QuLZl+dmVQucWW3KgNwqWG16133hdvC\n" +
            "XqDLURdCID8GtnkPAmbTy7vruky3a1gXHKeNH1NvJVtqKaJShigkQ+RvM9+59spZ\n" +
            "TqTboAgMZ83wezMve++yftFa5wKBgQDhA6/JQ+LuiIH3CTQqvIWCTjtOcsyYv8WU\n" +
            "5JKDl+jNhoSHua7zNZbLRdizsgoyyjJxAkyYA23GCQcVQ+NeOU4j/RSVarWTdZbl\n" +
            "Omny6CQYwrjMjVu9spPFC3JP2SEqvCR2t12i8D5vTRLp5/CDJi/MoR+d/zlq4oou\n" +
            "j0gkKMhhSwKBgDkLsswo8zw3aS06iAbxiXZ8yyu0jedDmz7G/X+Rrx9Vd3G9kVHL\n" +
            "R7KlO7Tc+kYN5deIrS1A+Cto8XqfWbLtqcG6ARxfGPBYgy/SNYhdhVjN+LTVrqBu\n" +
            "pYTyhyIIwRwY4QWK8VVd6K/aug5ClQT8xa9UQKBC1xQD2Xs/cAq8I78hAoGACN80\n" +
            "VyMuF2madjsOq4CzYufivr0YBA3LpIs+m6GptDDRmOhhVYWPZIRkfvFOJaKDSqFk\n" +
            "k7nO4jgI53W9yUFJK3IXFa0Xa7D/OhqLguBUTAWhc68/JsObv/ErmKpe/Ghep6+j\n" +
            "KYF/dLP9Quu6N/GRgOf5bylZAjXcbOmJVqOlAvECgYAuuFrwhH+hd+4DVdU4w4GP\n" +
            "PYDRCcbfLKjepTIJ9SrornYSftZugW3mtf8+TM5y9dotd74wVFlXcR4VjcaESzTP\n" +
            "7SKSJniACcoEBll+ZI9sqFfjs2JxGPPZ8kbNGGaMDU4VZKJFUhaTis3sxuHdP2+Y\n" +
            "BrGHrtXzg38Y/52Mm5rxLg==\n" +
            "-----END PRIVATE KEY-----\n";

    private static final String KEY_PUBLIC = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzmmwoofZx/a0T57t1lTK\n" +
            "gXdy/nM5BDz56saJne2TG9mHGCOfLHAcwolmfyiW+CpQjr8fsSjeQRdUjAfr4Tgs\n" +
            "fIICAffBqftBVyRD421sUB4BXMAHh0rXFDcnL6m3+XnvV/Dm7Ud+sSSWzLIYByQJ\n" +
            "n5oV8Nxd/2XYIDntj3nJV4b5OUAQlWw62ujUKbO3hfHGWcJ1UoWn+JrhdSjuunIK\n" +
            "8OK+oSY6Yq4/gT53rvX5HTgVtgePkMZA93xEWDZ+5P4uKmq25hkFE7ZDJNEOQh0S\n" +
            "R9H6fPbKHURUoomR6muBMAp+fXcLkLsvwUzhKz7uf/CQdb8Tn3WiP9YGcGWXlz8o\n" +
            "rQIDAQAB\n" +
            "-----END PUBLIC KEY-----\n";

    private static final String TEST_STRING = "待签名内容";

    public static void main(String[] args) {
        // Test case1 普通场景
        String encodeResult = doEncode(KEY_PRIVATE, TEST_STRING);
        boolean verityResult = doVerify(KEY_PUBLIC, encodeResult, TEST_STRING);

        System.out.print("\n签名结果1 = " + encodeResult + "\n");
        System.out.print("\n验签结果1 = " + verityResult + "\n");

        // Test case2 签名内容被篡改
        String encodeResult2 = doEncode(KEY_PRIVATE, TEST_STRING);
        boolean verityResult2 = doVerify(KEY_PUBLIC, encodeResult2, TEST_STRING + "s");

        System.out.print("\n签名结果2 = " + encodeResult2 + "\n");
        System.out.print("\n验签结果2 = " + verityResult2 + "\n");
    }

    private static boolean doVerify(String publicKey, String encodeResult, String contentToVerify) {
        try {
            publicKey = publicKey.replaceAll("-----END PUBLIC KEY-----", "").
                    replaceAll("-----BEGIN PUBLIC KEY-----", "").
                    replaceAll("\n", "");
            byte[] b2 = Base64.getDecoder().decode(publicKey);
            X509EncodedKeySpec xspec = new X509EncodedKeySpec(b2);

            KeyFactory kf = KeyFactory.getInstance("RSA");
            java.security.Signature privateSignature = java.security.Signature.getInstance("SHA256withRSA");

            privateSignature.initVerify(kf.generatePublic(xspec));
            privateSignature.update(contentToVerify.getBytes("UTF-8"));

            byte[] verifyBytes = Base64.getDecoder().decode(encodeResult);

            return privateSignature.verify(verifyBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static String encode(String contentToEncode) {
        return doEncode(KEY_PRIVATE, contentToEncode);
    }

    public static String encode2(String contentToEncode) {

        byte[] bytes = null;
        try {
            bytes = SHACoder.encodeSHA256(contentToEncode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("SHACode.hex=="+SHACoder.encodeHexString(bytes));

        return doEncode2(KEY_PRIVATE, bytes);
    }

    private static String doEncode2(String privateKey, byte[] data) {
        privateKey = privateKey.replaceAll("-----END PRIVATE KEY-----", "").
                replaceAll("-----BEGIN PRIVATE KEY-----", "").
                replaceAll("\n", "");

        // 私钥需要进行Base64解密
        byte[] b1 = Base64.getDecoder().decode(privateKey);

        try {
            // 将字节数组转换成PrivateKey对象
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b1);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            java.security.Signature privateSignature = java.security.Signature.getInstance("SHA256withRSA");
            privateSignature.initSign(kf.generatePrivate(spec));

            // 输入需要签名的内容
            privateSignature.update(data);
            // 拿到签名后的字节数组
            byte[] s = privateSignature.sign();
            // 将签名后拿到的字节数组做一个Base64编码，以便以字符串的形式保存
            return Base64.getEncoder().encodeToString(s);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        }

        return "";
    }

    private static String doEncode(String privateKey, String contentToEncode) {
        privateKey = privateKey.replaceAll("-----END PRIVATE KEY-----", "").
                replaceAll("-----BEGIN PRIVATE KEY-----", "").
                replaceAll("\n", "");

        // 私钥需要进行Base64解密
        byte[] b1 = Base64.getDecoder().decode(privateKey);

        try {
            // 将字节数组转换成PrivateKey对象
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b1);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            java.security.Signature privateSignature = java.security.Signature.getInstance("SHA256withRSA");
            privateSignature.initSign(kf.generatePrivate(spec));

            // 输入需要签名的内容
            privateSignature.update(contentToEncode.getBytes("UTF-8"));
            // 拿到签名后的字节数组
            byte[] s = privateSignature.sign();
            // 将签名后拿到的字节数组做一个Base64编码，以便以字符串的形式保存
            return Base64.getEncoder().encodeToString(s);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "";
    }
}
