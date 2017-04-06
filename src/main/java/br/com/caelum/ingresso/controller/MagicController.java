package br.com.caelum.ingresso.controller;

import br.com.caelum.ingresso.model.Permissao;
import br.com.caelum.ingresso.model.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nando on 03/04/17.
 */
@Controller
public class MagicController {

    @PersistenceContext
    private EntityManager manager;



    @GetMapping("/magic/eLBN7n")
    @Transactional
    @ResponseBody
    public String criaUsuarioAdmin(){
        gerarPermissoes();
        gerarAdmin();

        return "Usuario criado";
    }


    private void gerarPermissoes(){
        manager.persist(Permissao.ADMIN);
        manager.persist(Permissao.COMPRADOR);
    }

    private void gerarAdmin(){

        Usuario admin = new Usuario("admin", criptografar("123456"), true, comPermissoao(Permissao.ADMIN) );
        manager.persist(admin);

    }

    private String criptografar(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    private Set<Permissao> comPermissoao(Permissao... permissoes){

        Set<Permissao> resultado = new HashSet<>();

        resultado.addAll(Arrays.asList(permissoes));

        return resultado;
    }
}
