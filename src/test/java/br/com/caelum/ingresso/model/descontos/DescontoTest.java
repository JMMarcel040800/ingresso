package br.com.caelum.ingresso.model.descontos;

import br.com.caelum.ingresso.model.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import static org.junit.Assert.*;

/**
 * Created by nando on 07/03/17.
 */
public class DescontoTest {

    @Test
    public void deveConcederDescontoDe30PorcentoParaIngressosDeClientesDeBancos(){

        Lugar lugar = new Lugar("A",1);
        Sala sala = new Sala("Eldorado - IMAX", new BigDecimal("20.5"));
        Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12"));
        Sessao sessao = new Sessao(LocalTime.now(), filme, sala);
        Ingresso ingresso = new Ingresso(sessao, new DescontoDeTrintaPorCentoParaBancos(), lugar);


        BigDecimal precoEsperado = new BigDecimal("22.75");

        assertEquals(precoEsperado, ingresso.getPreco());

    }


    @Test
    public void deveConcederDescontoDe50PorcentoParaIngressoDeEstudante(){

        Lugar lugar = new Lugar("A",1);
        Sala sala = new Sala("Eldorado - IMAX", new BigDecimal("20.5"));
        Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12"));
        Sessao sessao = new Sessao(LocalTime.now(), filme, sala);
        Ingresso ingresso = new Ingresso(sessao, new DescontoEstudante(), lugar);

        BigDecimal precoEsperado = new BigDecimal("16.25");


        assertEquals(precoEsperado, ingresso.getPreco());

    }

    @Test
    public void naoDeveConcederDescontoParaIngressoNormal(){
        Lugar lugar = new Lugar("A",1);
        Sala sala = new Sala("Eldorado - IMAX", new BigDecimal("20.5"));
        Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12"));
        Sessao sessao = new Sessao(LocalTime.now(), filme, sala);
        Ingresso ingresso = new Ingresso(sessao, new SemDesconto(),lugar);


        BigDecimal precoEsperado = new BigDecimal("32.5");


        assertEquals(precoEsperado, ingresso.getPreco());


    }

}