package br.com.caelum.ingresso.model.descontos;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by nando on 07/03/17.
 */
@Component
public class SemDesconto implements Desconto {

    @Override
    public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
        return precoOriginal;
    }

    @Override
    public String getDescricao() {
        return "Normal";
    }
}
