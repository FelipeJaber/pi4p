package com.pi4p.controller;

import com.pi4p.funcs.Auth;
import com.pi4p.models.ModelSenha;
import com.pi4p.models.ModelUsuario;
import com.pi4p.records.RecordUsuarioAutenticacao;
import com.pi4p.records.RecordUsuarioCadastro;
import com.pi4p.repository.SenhaRepository;
import com.pi4p.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;

@RestController
public class ControlUsuario {

    @Autowired
    Auth auth;

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    SenhaRepository senhaRepository;

    @PostMapping(value = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> autenticarUsuario(@RequestBody @Valid RecordUsuarioAutenticacao recordUsuario) throws Exception {

        Optional<ModelUsuario> usuarioBD = usuarioRepository.findByCPF(recordUsuario.cpf());

        if (usuarioBD.isPresent()) {
            // Cadastro existe
            String userId = usuarioBD.get().getUserid().toString();
            Optional<ModelSenha> modeloSenhaBanco = senhaRepository.findByuserid(userId);

            if (modeloSenhaBanco.isPresent() && modeloSenhaBanco.get().getSenha().equals(auth.criptografarSenha(recordUsuario.senha().toString(), modeloSenhaBanco.get().getSalt()))) {
                auth.validarToken(auth.autenticarUsuario(usuarioBD.orElseThrow()));
                return ResponseEntity.ok(auth.autenticarUsuario(usuarioBD.orElseThrow()));
            }

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha Incorreta");
            // Senha incorreta
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Cadastro não existe");
        // Cadastro não existe
    }


    @PostMapping(value = "/register" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> cadastrarUsuario(@RequestBody @Valid RecordUsuarioCadastro recordUsuario) throws Exception {
        ModelUsuario cadastroFornecido = new ModelUsuario();
        cadastroFornecido.setCargo(recordUsuario.cargo());
        cadastroFornecido.setCPF(recordUsuario.cpf());
        cadastroFornecido.setNivel(recordUsuario.nivel());
        cadastroFornecido.setNome(recordUsuario.nome());
        cadastroFornecido.setNivel(0);
        Optional<ModelUsuario> usuarioBD = usuarioRepository.findByCPF(cadastroFornecido.getCPF());

        if(!usuarioBD.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body("Cadastro já existe");
        }else{
            String token = auth.cadastrarUsuario(cadastroFornecido, recordUsuario.senha());
            return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro criado");
        }
    }
}
