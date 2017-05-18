package br.com.caelum.ingresso.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nando on 31/03/17.
 */
@Entity
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;

    private String email;
    private String password;



    @ManyToMany(fetch = FetchType.EAGER )
    private Set<Permissao> permissoes = new HashSet<>();

    /**
     * @deprecated hibernate only
     */
    public Usuario() {
    }

    public Usuario(String email, String password, Set<Permissao> permissoes) {
        this.email = email;
        this.password = password;
        this.permissoes = permissoes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissoes;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }


    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", permissoes=" + permissoes +
                '}';
    }
}
