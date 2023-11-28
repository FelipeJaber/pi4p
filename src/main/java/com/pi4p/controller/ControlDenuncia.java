package com.pi4p.controller;

import com.pi4p.funcs.Auth;
import com.pi4p.models.ModelDenuncia;
import com.pi4p.models.ModelSenha;
import com.pi4p.models.ModelUsuario;
import com.pi4p.records.RecordCriarDenuncia;
import com.pi4p.records.RecordUsuarioAutenticacao;
import com.pi4p.records.RecordUsuarioAutenticado;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ControlDenuncia {

    @Autowired
    Auth auth;

    @PostMapping(value = "/minhasdenuncias", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> autenticarUsuario(@RequestBody @Valid RecordUsuarioAutenticado recordUsuarioAutenticado) throws Exception {

        try{

            String[] info = auth.validarToken(recordUsuarioAutenticado.token());
            System.out.println(info[0]);
            System.out.println(info[1]);
            System.out.println(info[2]);
            return ResponseEntity.status(HttpStatus.OK).body("Acesso autorizado");


        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token não autorizado");
        }

    }
    @PostMapping(value = "/criardenuncia", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> criarDenuncia(@RequestBody @Valid RecordCriarDenuncia recordCriarDenuncia) throws Exception {
    String resposta = "";
        try{
            String[] infos = auth.validarToken(recordCriarDenuncia.token());
            if(!infos[1].equalsIgnoreCase("usuario")) throw new Exception(resposta = "Perfil invalido");
            ModelDenuncia modelDenuncia = new ModelDenuncia();
            modelDenuncia.setDenunciante_id(infos[0]);
            modelDenuncia.setBairro(recordCriarDenuncia.bairro());
            modelDenuncia.setCategoria(recordCriarDenuncia.categoria());
            modelDenuncia.setCEP(recordCriarDenuncia.cep());
            modelDenuncia.setComplemento(recordCriarDenuncia.complemento());
            modelDenuncia.setBairro(recordCriarDenuncia.bairro());
            modelDenuncia.setDescricao(recordCriarDenuncia.descricao());
            modelDenuncia.setLatitude(recordCriarDenuncia.latitude());
            modelDenuncia.setLogitude(recordCriarDenuncia.longitude());
            modelDenuncia.setMunicipio(recordCriarDenuncia.municipio());
            modelDenuncia.setProvavelAutor(recordCriarDenuncia.provavelautor());
        }catch (Exception e){
            ModelDenuncia modelDenuncia = new ModelDenuncia();
            modelDenuncia.setDenunciante_id(null);
            modelDenuncia.setBairro(recordCriarDenuncia.bairro());
            modelDenuncia.setCategoria(recordCriarDenuncia.categoria());
            modelDenuncia.setCEP(recordCriarDenuncia.cep());
            modelDenuncia.setComplemento(recordCriarDenuncia.complemento());
            modelDenuncia.setBairro(recordCriarDenuncia.bairro());
            modelDenuncia.setDescricao(recordCriarDenuncia.descricao());
            modelDenuncia.setLatitude(recordCriarDenuncia.latitude());
            modelDenuncia.setLogitude(recordCriarDenuncia.longitude());
            modelDenuncia.setMunicipio(recordCriarDenuncia.municipio());
            modelDenuncia.setProvavelAutor(recordCriarDenuncia.provavelautor());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resposta);
    }

}
