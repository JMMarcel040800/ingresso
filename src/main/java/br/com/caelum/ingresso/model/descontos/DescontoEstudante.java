package br.com.caelum.ingresso.model.descontos;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by nando on 07/03/17.
 */
@Component
public class DescontoEstudante  implements Desconto {

    private BigDecimal metade = new BigDecimal("2.0");

    @Override
    public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
        return precoOriginal.divide(metade);
    }

    @Override
    public String getDescricao() {
        return "Estudante";
    }
}
