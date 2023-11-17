package com.pi4p.controller;

import com.pi4p.models.ModelUsuario;
import com.pi4p.records.RecordUsuario;
import com.pi4p.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ControllUsuario {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping(value = "/authenticate" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> authenticarUsuario(@RequestBody @Valid RecordUsuario recordUsuario){

        ModelUsuario cadastroFornecido = new ModelUsuario();
        BeanUtils.copyProperties(recordUsuario, cadastroFornecido);
        Optional<ModelUsuario> usuarioBD = usuarioRepository.findByCPF(cadastroFornecido.getCpf());

        if(!usuarioBD.isEmpty()){
            //Cadastro existe
            if(cadastroFornecido.getSenha().equals(usuarioBD.get().getSenha())){
                return ResponseEntity.status(HttpStatus.OK).body("Validado");
                //Senha correta
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body("Senha Incorreta");
            //Senha incorreta
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body("Cadastro não existe");
        //Cadastro não existe

    }

    @PostMapping(value = "/register" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> cadastrarUsuario(@RequestBody @Valid RecordUsuario recordUsuario){
        ModelUsuario cadastroFornecido = new ModelUsuario();
        BeanUtils.copyProperties(recordUsuario, cadastroFornecido);
        Optional<ModelUsuario> usuarioBD = usuarioRepository.findByCPF(cadastroFornecido.getCpf());

        if(!usuarioBD.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body("Cadastro já existe");
        }else{
            usuarioRepository.save(cadastroFornecido);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro criado");
        }
    }
}
