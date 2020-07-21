package br.sc.senai.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CodificaSenha {

    public static byte[] codificaSenha(String senhaUsuario){
        String algoritimo = "SHA-256";

        try {

            MessageDigest sha = MessageDigest.getInstance(algoritimo);

            sha.update(senhaUsuario.getBytes());

            return sha.digest();


        }catch (NoSuchAlgorithmException e){

            return null;

        }

    }
}
