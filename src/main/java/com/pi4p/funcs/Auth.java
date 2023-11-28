package com.pi4p.funcs;

import com.pi4p.models.ModelSenha;
import com.pi4p.models.ModelUsuario;
import com.pi4p.repository.SenhaRepository;
import com.pi4p.repository.UsuarioRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;

@Component
public class Auth {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    SenhaRepository senhaRepository;

    public String cadastrarUsuario(ModelUsuario usuario, String senha) throws Exception {

        usuarioRepository.save(usuario);
        Optional<ModelUsuario>  usuarioBD = usuarioRepository.findByCPF(usuario.getCPF());
        ModelSenha senhaModel = new ModelSenha();
        senhaModel.setUserid(usuarioBD.get().getUserid().toString());
        senhaModel.setSalt(getRandomString());
        senhaModel.setSenha(criptografarSenha(senha, senhaModel.getSalt()));
        senhaRepository.save(senhaModel);
        String Jwt = getJWT(usuario);
        return Jwt;

    }

    public String autenticarUsuario(ModelUsuario usuario) throws Exception{
        return getJWT(usuario);
    }

    private String getRandomString(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();

        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < 64; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            randomString.append(characters.charAt(randomIndex));
        }

        return randomString.toString();
    }

    public String getJWT(ModelUsuario modelUsuario) throws Exception {
        return Jwts.builder()
                .subject(modelUsuario.getUserid().toString() +";"+ modelUsuario.getCargo() + ";" + modelUsuario.getNivel())
                .issuedAt(new Date(System.currentTimeMillis()))
                .signWith(Keys.hmacShaKeyFor("#j945BJCbi88*e$X33688&evU5!A*%ss&ak23AhEAPz9KhDWAi45GbGDSG$EtHAW!4$s8Qbz$b6BaujXbr53!2Y8oHCx&dC53hjVYgH$ukjM$NpDD@de@$o9U9ssmCMW89gN*rw2WHXH9C#sYR@H*T%A$!nf#S7G33Y4iELskMd6D7$TsN@p*mK^d9W7@d8s8hHDKhtp4wH3LxjtB#PX6ZxV9tJSc$zz5Fr4D@@QY9xpckfWWgp99ZuHm%vHZ$49".getBytes()))
                .compact();
    }

    public String criptografarSenha(String senha, String salt){
        return senha+salt;
    }

    public String[] validarToken(String tokenAValidar){
        Key key = Keys.hmacShaKeyFor("#j945BJCbi88*e$X33688&evU5!A*%ss&ak23AhEAPz9KhDWAi45GbGDSG$EtHAW!4$s8Qbz$b6BaujXbr53!2Y8oHCx&dC53hjVYgH$ukjM$NpDD@de@$o9U9ssmCMW89gN*rw2WHXH9C#sYR@H*T%A$!nf#S7G33Y4iELskMd6D7$TsN@p*mK^d9W7@d8s8hHDKhtp4wH3LxjtB#PX6ZxV9tJSc$zz5Fr4D@@QY9xpckfWWgp99ZuHm%vHZ$49".getBytes());

        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(tokenAValidar);

        Claims claims = claimsJws.getBody();
        String subject = claims.getSubject();

        String[] Infos = subject.split(";");
        return Infos;
    }


}
