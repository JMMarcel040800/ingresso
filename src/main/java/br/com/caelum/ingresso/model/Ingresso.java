package br.com.caelum.ingresso.model;

import br.com.caelum.ingresso.model.descontos.Desconto;
import br.com.caelum.ingresso.model.descontos.SemDesconto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * Created by nando on 07/03/17.
 */
@Entity
public class Ingresso {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Sessao sessao;

    @ManyToOne
    private Lugar lugar;

    private BigDecimal preco;

    /**
     * @deprecated hibernate only
     */
    public Ingresso(){}

    public Ingresso(Sessao sessao, Desconto tipoDeDesconto, Lugar lugar) {
        this.sessao = sessao;
        this.preco = tipoDeDesconto.aplicarDescontoSobre(sessao.getPreco());
        this.lugar = lugar;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Lugar getLugar() {
        return lugar;
    }
}
