package cn.edu.ncu.stephenhe.recruitment.utils;

import java.util.Random;

public class StringUtils {

    public static void main(String[] args) {
        String s = getStr();        // 调用String getStr()方法
        System.out.println(s);

    }


    public static String getStr(){

        String str = new String();  // 若使用StringBuffer效率高，不会产生碎片
        Random r = new Random();

        //随机生成一个五位的字符串 作为companyCode
        for (int i = 0; i < 5; i++) {

            int temp = r.nextInt(58) + 65;  // 随机生成 65—122 的数(A—z)

            if ((temp >= 'A' && temp <= 'Z') || (temp >= 'a' && temp <= 'z')) {   // 判断随机数是不是(A-Z)||(a-z)

                str += (char)temp;         // 将当前随机数强制转化为字符类型并和字符串相加

            } else {            // 不满足条件，将当前的i再执行一次
                i--;
            }
        }
        return str;     // 返回长度为5的随机字符串，字符串由随机的5个大小写字母组成
    }
}


