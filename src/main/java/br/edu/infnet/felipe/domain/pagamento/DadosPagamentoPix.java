package br.edu.infnet.felipe.domain.pagamento;

import java.math.BigDecimal;

public class DadosPagamentoPix extends DadosPagamento {

    private String chavePix;

    public DadosPagamentoPix(BigDecimal valor, String chavePix) {
        super(valor);
        this.chavePix = chavePix;
    }

    @Override
    public boolean validar() {
        if (chavePix == null) {
            return false;
        }
        
        return true;
    }

}
