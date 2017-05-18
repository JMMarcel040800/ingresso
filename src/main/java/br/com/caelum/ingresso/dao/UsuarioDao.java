package br.com.caelum.ingresso.dao;

import br.com.caelum.ingresso.model.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

/**
 * Created by nando on 11/05/17.
 */
@Repository
public class UsuarioDao {

    @PersistenceContext
    private EntityManager manager;


    public Optional<Usuario> findByEmail(String email) {

        return manager
                .createQuery("select u from Usuario  u where u.email = :email", Usuario.class)
                    .setParameter("email", email)
                        .getResultList()
                            .stream()
                                .findFirst();
    }

    public void save(Usuario usuario) {

        if (usuario.getId() == null)
            manager.persist(usuario);
        else
            manager.merge(usuario);
    }
}
