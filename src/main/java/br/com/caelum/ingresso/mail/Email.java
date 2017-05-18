package br.com.caelum.ingresso.mail;

/**
 * Created by nando on 10/05/17.
 */
public interface Email {
    String getTo();
    String getBody();
    String getSubject();
}
