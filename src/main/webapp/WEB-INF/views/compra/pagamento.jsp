<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="ingresso" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ingresso:template>
    <jsp:body>
        <c:set var="bindingResult" value="${requestScope['org.springframework.validation.BindingResult.cartao']}"/>
        <div class=" col-md-6 col-md-offset-3">
                <table class="table table-hover ">
                    <thead>
                    <th>Sala</th>
                    <th>Lugar</th>
                    <th>Filme</th>
                    <th>Horario</th>
                    <th>Tipo do Ingresso</th>
                    <th>Preço Original</th>
                    <th>Desconto</th>
                    <th>Valor</th>
                    <th>Ações</th>
                    </thead>

                    <tbody>
                    <c:forEach items="${carrinho.ingressos}" var="ingresso" varStatus="status">
                        <tr>
                            <td>${ingresso.sessao.sala.nome}</td>
                            <td>${ingresso.lugar.fileira}${ingresso.lugar.posicao}</td>
                            <td>${ingresso.sessao.filme.nome }</td>
                            <td>${ingresso.sessao.horario}</td>
                            <td>${ingresso.tipoDeIngresso}</td>
                            <td>${ingresso.preco}</td>
                            <td>${ingresso.valorDeDesconto}</td>
                            <td>${ingresso.precoComDesconto}</td>
                            <td><a onclick="excluir(${status.index})" class="btn btn-danger">Excluir</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>

                    <tfoot>
                    <td colspan="7" class="text-right"><strong>TOTAL</strong></td>
                    <td><strong>${carrinho.total}</strong></td>
                    </tfoot>

                </table>

            <form action="/compra/comprar" method="post">
                <div class="col-md-8" style="margin: 2em 0">
                    <div style="display:inline-block;background-color: #6E2B77; border-radius: 0.6em; height: 20em; color: white">

                        <h3 style="margin: 1em">Cartão de Crédito</h3>

                        <div class="col-md-12" style="margin: 1em 0">
                            <span>FERNANDO WILLIAN DE SOUZA FURTADO</span>
                        </div>


                        <div class="form-group">
                            <div style="margin: 2em 0">
                                <div class="col-md-7">
                                    <label for="cartaoDeCredito">Numero</label>
                                    <input id="cartaoDeCredito" type="text" name="numero" class="form-control">
                                    <c:forEach items="${bindingResult.getFieldErrors('numero')}" var="error">
                                        <span class="text-danger">${error.defaultMessage}</span>
                                    </c:forEach>
                                </div>

                                <div class="col-md-3">
                                    <label for="cvv">CVV</label>
                                    <input id="cvv" type="text" name="cvv" class="form-control">
                                    <c:forEach items="${bindingResult.getFieldErrors('cvv')}" var="error">
                                        <span class="text-danger">${error.defaultMessage}</span>
                                    </c:forEach>
                                </div>
                            </div>

                        </div>

                        <div class="form-group" style="margin: 10em 0">
                            <div>
                                <div class="col-md-3">
                                    <label for="mesano">Mês/Ano</label>
                                    <input id="mesano" type="text" name="vencimento" class="form-control">
                                    <c:forEach items="${bindingResult.getFieldErrors('vencimento')}" var="error">
                                        <span class="text-danger">${error.defaultMessage}</span>
                                    </c:forEach>
                                </div>
                            </div>

                        </div>

                    </div>
                </div>


                <div class="form-group">
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-primary">Comprar</button>
                    </div>
                </div>

            </form>
        </div>

        <script>
            function excluir(id) {
                var url = window.location.href;
                $.ajax({
                    url: "/carrinho/" + id,
                    type: 'DELETE',
                    success: function (result) {
                        console.log(result);

                        window.location.href = url;
                    }
                });
            }
        </script>
    </jsp:body>
</ingresso:template>