package br.com.caelum.ingresso.model;

import br.com.caelum.ingresso.model.descontos.Desconto;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * Created by nando on 07/03/17.
 */
public class Ingresso {

    @ManyToOne
    private Sessao sessao;
    private BigDecimal preco;

    public Ingresso(Sessao sessao, Desconto tipoDeDesconto) {
        this.sessao = sessao;
        this.preco = tipoDeDesconto.aplicarDescontoSobre(sessao.getPreco());
    }

    public Sessao getSessao() {
        return sessao;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
