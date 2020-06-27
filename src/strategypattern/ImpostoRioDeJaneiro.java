package strategypattern;

public class ImpostoRioDeJaneiro implements ImpostoStrategy {
    
    private final Double coeficiente = 1.1;
    
    @Override
    public Double calcularImposto(Double valor) {
        return valor * coeficiente;
    }
}
