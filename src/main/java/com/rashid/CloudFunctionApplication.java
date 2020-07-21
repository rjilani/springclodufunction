package com.rashid;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.function.Function;

@SpringBootApplication
public class CloudFunctionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudFunctionApplication.class, args);

        LoadStore l = new LoadStore();
        l.loadStor();


    }

    @Bean
    public Function<String, String> reverseString() {
        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance("JKS");
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        InputStream stream=this.getClass().getResourceAsStream("/keystore.jks") ;
        char[] pwdArray = "password".toCharArray();
        try {
            keyStore.load(stream,pwdArray);
            System.out.println(keyStore.containsAlias("tomcat"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return value -> new StringBuilder("ABBA").reverse().toString();
    }
}