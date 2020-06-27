package strategypattern;

public class ImpostoSaoPaulo implements ImpostoStrategy {
    
    private final Double coeficiente = 1.2;
    
    @Override
    public Double calcularImposto(Double valor) {
        return valor * coeficiente;
    }
}
