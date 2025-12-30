package com.yuuuki.util;

import cn.hutool.crypto.digest.DigestUtil;

//加密算法 参数srcpass为原文密码
// return 返回值为密文密码
// 选取随机数作为加密盐值
public class PasswordUtil {
    private static char[] arr={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public static String encodePassword(String srcpass) {
        int count_index=(int)(Math.random()*arr.length);
        int salt_index=(int)(Math.random()*arr.length);
        String result = srcpass+arr[salt_index];
        for(int i=0;i<arr[count_index];i++){
            result += DigestUtil.md5Hex(result);
        }
        return arr[count_index]+result+arr[salt_index];
    }
    //    原文密码和密文密码比较的方法
//    srcpass 原文密码
//    enpass 密文密码
//    return 比较的结果
    public static boolean equalsPassword(String srcpass, String enpass) {
        char count = enpass.charAt(0);
        char salt = enpass.charAt(enpass.length()-1);
        srcpass = srcpass+salt;
        for(int i=0;i<count;i++){
            srcpass = DigestUtil.md5Hex(srcpass);
        }
        return enpass.equals(count+srcpass+salt);
    }
}
