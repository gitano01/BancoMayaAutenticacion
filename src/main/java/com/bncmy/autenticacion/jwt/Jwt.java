package com.bncmy.autenticacion.jwt;



import com.bncmy.autenticacion.model.ExtraClaims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.fusionauth.jwt.Signer;
import io.fusionauth.jwt.Verifier;
import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.hmac.HMACSigner;
import io.fusionauth.jwt.hmac.HMACVerifier;

import java.time.ZonedDateTime;
import java.util.TimeZone;

@Component
public class Jwt {
    @Value("${secretKey}")
    private  String secretKey;

    String timeZone = "America/Mexico_City";
    private  String TIMEZONE;
    private  int EXPIRE_IN;
    private  String ISSUER;


    public  String generateToken(ExtraClaims claims) throws Exception{

        try {
            System.out.println("ExtraClaims ________" +  claims.toString());
            TIMEZONE =  timeZone;
            EXPIRE_IN = 30;
            ISSUER = "IMSS";
        }catch(Exception e) {

            throw new Exception(e.getMessage());
        }
        //Construye el HMAC usando SHA256
        Signer signer = HMACSigner.newSHA256Signer(secretKey);
        TimeZone tz = TimeZone.getTimeZone(TIMEZONE);
        ZonedDateTime zdt = ZonedDateTime.now(tz.toZoneId()).plusSeconds(EXPIRE_IN);
        JWT jwt = new JWT().setIssuer(ISSUER)
                .setIssuedAt(ZonedDateTime.now(tz.toZoneId()))
                .setExpiration(zdt)
                .addClaim("dataClaims",claims.getData().toString());


        return JWT.getEncoder().encode(jwt, signer);
    }

    public boolean validateToken(String encode,String secretKey) throws Exception{
        JWT jwt = jwt(encode,secretKey);
        return jwt.isExpired();
    }

    private  JWT jwt(String encodedJWT,String secretKey) throws Exception {
        Verifier verifier = HMACVerifier.newVerifier(secretKey);
        JWT jwt = JWT.getDecoder().decode(encodedJWT, verifier);
        return jwt;
    }

}
