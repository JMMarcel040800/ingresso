package br.com.caelum.ingresso.helper;

import br.com.caelum.ingresso.dao.TokenDao;
import br.com.caelum.ingresso.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by nando on 10/05/17.
 */
@Component
public class TokenHelper {

    @Autowired
    private TokenDao dao;

    public Token generateFrom(String email) {

        Token token = new Token(email);

        dao.save(token);

        return token;
    }

    public Optional<Token> getTokenFrom(String uuid) {
        return dao.findByUuid(uuid);
    }
}
