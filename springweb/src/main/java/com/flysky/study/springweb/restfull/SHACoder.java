package com.flysky.study.springweb.restfull;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

public abstract class SHACoder {

    /**
     * SHA256加密
     *
     * @param data 待加密数据
     * @return byte[] 消息摘要
     * @throws Exception
     */
    public static byte[] encodeSHA256(String data) throws Exception {

        // 执行消息摘要
        return DigestUtils.sha256(data);
    }

    /**
     * SHA256Hex加密
     *
     * @param data 待加密数据
     * @return String 消息摘要
     * @throws Exception
     */
    public static String encodeSHA256Hex(String data) {

        // 执行消息摘要
        return DigestUtils.sha256Hex(data);
    }

    public static String encodeHexString(byte[] data) {
        return Hex.encodeHexString(data);
    }

}
