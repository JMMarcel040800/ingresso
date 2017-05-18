package br.com.caelum.ingresso.dao;

import br.com.caelum.ingresso.model.Token;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

/**
 * Created by nando on 10/05/17.
 */
@Repository
public class TokenDao {

    @PersistenceContext
    private EntityManager manager;

    public void save(Token token) {
        manager.persist(token);
    }

    public Optional<Token> findByUuid(String uuid) {
        return manager.createQuery("select t from Token t where t.uuid = :uuid", Token.class)
                .setParameter("uuid", uuid)
                    .getResultList()
                        .stream()
                            .findFirst();
    }
}
