package cn.edu.ncu.stephenhe.recruitment.utils;


import cn.edu.ncu.stephenhe.recruitment.entity.Admin;
import cn.edu.ncu.stephenhe.recruitment.entity.Hr;
import cn.edu.ncu.stephenhe.recruitment.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;


import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT工具类
 * 用于生成和校验token
 */

public class JwtUtil {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
    /**
     * 秘钥
     */
    private static final String SECRET = "my_secret";

    /**
     * 过期时间
     **/
    private static final long EXPIRATION = 1800L;//单位为秒

    /**
     * 生成用户token,设置token超时时间
     */
    public  static String createToken(User user){
        //过期时间
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRATION * 1000);
        //私钥加密算法
        Algorithm algorithm=Algorithm.HMAC256(SECRET);
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");
        String token= JWT.create()
                .withHeader(header)                //添加头部
                //可以把数据存在claim中
                .withClaim("id",user.getUserId())      //userId
                .withClaim("tel",user.getUserTel())
                .withExpiresAt(expireDate)          //超时设置,设置过期的日期
                .withIssuedAt(new Date()) //签发时间
                .sign(algorithm); //SECRET加密
        return token;
    }
    public  static String createToken(Hr hr){
        //过期时间
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRATION * 1000);
        //私钥加密算法
        Algorithm algorithm=Algorithm.HMAC256(SECRET);
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");
        String token= JWT.create()
                .withHeader(header)                //添加头部
                //可以把数据存在claim中
                .withClaim("id",hr.getHrId())      //userId
                .withClaim("tel",hr.getHrTel())
                .withExpiresAt(expireDate)          //超时设置,设置过期的日期
                .withIssuedAt(new Date()) //签发时间
                .sign(algorithm); //SECRET加密
        return token;
    }

    public  static String createToken(Admin admin){
        //过期时间
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRATION * 1000);

        //私钥加密算法
        Algorithm algorithm=Algorithm.HMAC256(SECRET);

        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");
        String token= JWT.create()
                .withHeader(header)                //添加头部
                //可以把数据存在claim中
                .withClaim("id",admin.getAdminId())      //userId
                .withClaim("tel",admin.getAdminTel())
                .withExpiresAt(expireDate)          //超时设置,设置过期的日期
                .withIssuedAt(new Date()) //签发时间
                .sign(algorithm); //SECRET加密
        return token;
    }

    /**
     * token解码,验证权限
     */
    public static boolean verify(String token){
        try{
            Algorithm algorithm=Algorithm.HMAC256(SECRET);
            JWTVerifier verifier=JWT.require(algorithm).build();
            DecodedJWT jwt=verifier.verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
