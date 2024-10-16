package br.edu.infnet.felipe.domain.pagamento;

import java.math.BigDecimal;

public abstract class DadosPagamento {
    protected BigDecimal valor;

    public DadosPagamento(BigDecimal valor) {
        this.valor = valor;
    }

    public abstract boolean validar();
}