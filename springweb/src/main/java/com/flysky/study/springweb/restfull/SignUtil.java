package com.flysky.study.springweb.restfull;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class SignUtil {

    private static /*final*/ String KEY_PRIVATE = "-----BEGIN PRIVATE KEY-----\n" +
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

    private static /*final*/ String KEY_PUBLIC = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzmmwoofZx/a0T57t1lTK\n" +
            "gXdy/nM5BDz56saJne2TG9mHGCOfLHAcwolmfyiW+CpQjr8fsSjeQRdUjAfr4Tgs\n" +
            "fIICAffBqftBVyRD421sUB4BXMAHh0rXFDcnL6m3+XnvV/Dm7Ud+sSSWzLIYByQJ\n" +
            "n5oV8Nxd/2XYIDntj3nJV4b5OUAQlWw62ujUKbO3hfHGWcJ1UoWn+JrhdSjuunIK\n" +
            "8OK+oSY6Yq4/gT53rvX5HTgVtgePkMZA93xEWDZ+5P4uKmq25hkFE7ZDJNEOQh0S\n" +
            "R9H6fPbKHURUoomR6muBMAp+fXcLkLsvwUzhKz7uf/CQdb8Tn3WiP9YGcGWXlz8o\n" +
            "rQIDAQAB\n" +
            "-----END PUBLIC KEY-----\n";

//    static {
//        KEY_PRIVATE="-----BEGIN PRIVATE KEY-----\n" +
//                "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCTSaAkhiyQqxX3\n" +
//                "T2/P3+KazYL7e063TePzObVxjuiSTTaqqhJc0KDN4WBI+BRc/BcZmmDD5J2nPpYE\n" +
//                "7gRqkqQNNK1MgjWJ57UsomaSi1Sf8bjiVCxoRwp930chnOFxugESGEAwaL6yujnS\n" +
//                "CejOu12lCxxErol4MPXDT42a2qiNloB3k1kzDemMpo9ayQ2iSzxy+Pd76XLtLl6N\n" +
//                "w3xCgvtfoBXT5xje3GGQsxoHTtnwqz4/36sPIjFoIYOR6be7b9F2MjLjIDyww0hM\n" +
//                "5Do9ALUxNSNjKQ2nvHyC4G7LYsRewDhlR9Wwdw8rmnZuq/XtqwDqEc0Y7QkrEMtY\n" +
//                "G46UMP25AgMBAAECggEADDbv4/eInJrDoJXi5O9hQItIkIiCV6tK+zHO/VLnsLJc\n" +
//                "lTyzdyUKIOjO7l48ehWh6Mqnubcs5+DF2jTPAvOUTVAQCydFP2GK4d+59+88HmOS\n" +
//                "fJqUcDVsBlJM+NmkzKSrUA/Yyur03aeaAfQ2bWaWdoh8WKnM1r3gs8jWKoB1uAAi\n" +
//                "BAGi7xXemdhaqmFozos9MrgpkZWa9CmfcYjNA15s1YnRsGnJ/QS6NjCzTqP1fl2k\n" +
//                "dSmhGHQQiYDAXvOidcysYbSazYhNq1lD7cIFBTsXPgbLd0YIcndb+jce3/2tWZrx\n" +
//                "DPNkhrs5ciCAlRgpgGguAFa5FYsKfgXfAJhiHA3scQKBgQDDqjnCNTAecMDChE1w\n" +
//                "oSKgRCXNxNBie0kO/2I+B1btqJfAlWIykC5s5sHQ6SFTv6j6roRGOKUpOjprgBGn\n" +
//                "UzmJmalVt/7A5gtmrpBboudjc9aOq9BHUHqITce4ir4UV8smo324mhYNv+nmyHBa\n" +
//                "ltqRGVy8e/g/NwcJTgk0t/ZWLQKBgQDAtH8V/fhHkPLSyQIUvYSQyUF2aM5Vvjib\n" +
//                "Gb5Wky9vdB3lIVclAmMxnivPY9ROdE+1SA/ghiv4O2hNEtU389EArB1CPj/OzVvs\n" +
//                "x9O3EkxbD3d5iPmMJW7GNWvv5na/OlT8SJMrirufJiteuq/rw0IfPwiOmUa+sV8b\n" +
//                "FmTvV35pPQKBgCBelvOUDQPcL2d+r7kET1AoNgDWoIrKTonWohAU8sKac5B+piIr\n" +
//                "TCLkAghnqQXL3U6rdGKRmHE7mtKR+1mtIQWskCEIMXMEG7q/Ak7GonUHguVTcz95\n" +
//                "BuxpwbK78To4U/lubqwNgbyAlVeCrWOvNTVv9rGP6L+8gMN/T3KTRIN5AoGAWZjS\n" +
//                "aeA+es/bBsQssoX3R/Y6+Jn8LYOXAA41ID2o1XIwoCMjSHLWufAnwHJS+PM9SDUs\n" +
//                "JKFdejns4cD639v99gkQRYd51WZH8kxqlHjuhXwoeZqFJHMXERMvj0ghOAIgF3iK\n" +
//                "7LjBSVrO2WmFd+G+MZb2HI8JhIolhQuhfGK6xKUCgYAWM1GAil60rTIn/hrFIASW\n" +
//                "pF83ZAHZQDvVSv1q0tRw2mPRx7hpWg+IvH8rUXl/bE5ivKyOnvJXLrubG66oINME\n" +
//                "3+LRdT5I8e7fdv7Zzz7/PQ1SbhBbNlI3uIBTjHCewJ9enl4t97K1wtkIo3BiKDLI\n" +
//                "UDPx8xOnfeZM99/EfmFaZw==\n" +
//                "-----END PRIVATE KEY-----\n";
//
//        KEY_PUBLIC="-----BEGIN PUBLIC KEY-----\n" +
//                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk0mgJIYskKsV909vz9/i\n" +
//                "ms2C+3tOt03j8zm1cY7okk02qqoSXNCgzeFgSPgUXPwXGZpgw+Sdpz6WBO4EapKk\n" +
//                "DTStTII1iee1LKJmkotUn/G44lQsaEcKfd9HIZzhcboBEhhAMGi+sro50gnozrtd\n" +
//                "pQscRK6JeDD1w0+NmtqojZaAd5NZMw3pjKaPWskNoks8cvj3e+ly7S5ejcN8QoL7\n" +
//                "X6AV0+cY3txhkLMaB07Z8Ks+P9+rDyIxaCGDkem3u2/RdjIy4yA8sMNITOQ6PQC1\n" +
//                "MTUjYykNp7x8guBuy2LEXsA4ZUfVsHcPK5p2bqv17asA6hHNGO0JKxDLWBuOlDD9\n" +
//                "uQIDAQAB\n" +
//                "-----END PUBLIC KEY-----\n";
//    }

    private static final String TEST_STRING = "待签名内容";
    private static final String src = "action=direct_proivde&contract_no=Test-888-CCH-20190521-01&offer_id=1450016120&out_trade_no=ja201906195300220476180303948&product_id=txspvip_1month&provide_uin=358877431&sale_price=1000&sub_channel_id=other&ts=1564406112&user_id=default&user_id_type=default&user_name=default&version=1.0&UmiiIupjNEW4spK6sXH2pXzsDf3cidOl";

    public static void main(String[] args) throws Exception {

        byte[] datas=SHACoder.encodeSHA256(src);
        System.out.println("SHACoder.encodeHexString(datas) = " + SHACoder.encodeHexString(datas));
        // Test case1 普通场景
        String encodeResult = doEncode(KEY_PRIVATE, datas);
         encodeResult = doSign(src);
//        encodeResult="aCyCQ1+oPaYBIEXsC7raJgrK5H9YxBOp+TVzijH4ECe5Dti7db9/ofWlrV3TQIu4a/muMAhSu4f25i3mQOVpD+CcOVkFad2Wvloftx0wuFINhIDvEuJfqe7A/0htA72K9sfFYwO+lWyxNmikU6ZHhNmQlHTqSqL80v3nkvBzqlIsqjZdCM9U1BUrxIayr+zuIrt2ER6oH/jwKvlp4Sv+/zDjeISQzQ53qTNm4KzIE+wbQb9zvtVloNAMuQunyZCAup4Wa9x31U4Tpr3V9iCRjEWFXYdgpAoWn8UdpKtQThOfN0Vj98WtwdTlyTOzaELhF+m+4c7x6DX+IIRb49A0Ig==";
        boolean verityResult = doVerify(KEY_PUBLIC, encodeResult, datas);

        System.out.print("\n签名结果1 = " + encodeResult + "\n");
        System.out.print("\n验签结果1 = " + verityResult + "\n");

//        // Test case2 签名内容被篡改
//        String encodeResult2 = doEncode(KEY_PRIVATE, TEST_STRING);
//        boolean verityResult2 = doVerify(KEY_PUBLIC, encodeResult2, TEST_STRING + "s");
//
//        System.out.print("\n签名结果2 = " + encodeResult2 + "\n");
//        System.out.print("\n验签结果2 = " + verityResult2 + "\n");
    }

    private static boolean doVerify(String publicKey, String encodeResult, byte[] contentToVerify) {
        try {
            publicKey = publicKey.replaceAll("-----END PUBLIC KEY-----", "").
                    replaceAll("-----BEGIN PUBLIC KEY-----", "").
                    replaceAll("\n", "");
            byte[] b2 = Base64.getDecoder().decode(publicKey);
            X509EncodedKeySpec xspec = new X509EncodedKeySpec(b2);

            KeyFactory kf = KeyFactory.getInstance("RSA");
            java.security.Signature privateSignature = java.security.Signature.getInstance("SHA256withRSA");

            privateSignature.initVerify(kf.generatePublic(xspec));
            privateSignature.update(contentToVerify);

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
        }

        return false;
    }

    public static String doSign(String contentToEncode) {
        try {
            byte[] bytes = SHACoder.encodeSHA256(contentToEncode);
            System.out.println("SHACode.hex=="+SHACoder.encodeHexString(bytes));
            return doEncode(KEY_PRIVATE, bytes);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("加签异常");
        }
        return "";
    }

    public static String doEncode(String privateKey, byte[] data) {
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
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("签名异常");
        }

        return "";
    }
}
