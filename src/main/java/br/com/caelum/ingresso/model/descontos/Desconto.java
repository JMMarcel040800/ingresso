package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

/**
 * Created by nando on 07/03/17.
 */
public interface Desconto {

    BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal);

}
