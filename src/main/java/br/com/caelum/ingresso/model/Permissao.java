package br.com.caelum.ingresso.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by nando on 31/03/17.
 */
@Entity
public class Permissao implements GrantedAuthority {

    @Id
    private String nome;

    public static Permissao ADMIN = new Permissao("ROLE_ADMIN");
    public static Permissao COMPRADOR = new Permissao("ROLE_COMPRADOR");

    /**
     * @deprecated hibernate only
     */
    public Permissao() {
    }

    public Permissao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getAuthority() {
        return nome;
    }

    @Override
    public String toString() {
        return "Permissao{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
