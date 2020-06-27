package strategypattern;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NotaFiscal {
    
    private ImpostoStrategy impostoStrategy = null;

    public void setImpostoStrategy(ImpostoStrategy impostoStrategy) {
        this.impostoStrategy = impostoStrategy;
    }
    
    public String getRelatorioImpostos(List<Double> impostos) {
        return getListaDeValores(aplicarImposto(impostos));
    }
    
    public Double aplicarImposto(Double imposto) {
        return impostoStrategy.calcularImposto(imposto);
    }
    
    public List<Double> aplicarImposto(List<Double> listaDeImpostos) {
        return listaDeImpostos.stream()
                .map(imposto -> aplicarImposto(imposto)).collect(Collectors.toList());
    }
    
    private String getListaDeValores(List<Double> list, String logParcial) {
        String novaParteDoLog = logParcial
                .concat("Valor: R$")
                .concat(String.valueOf(list.get(0)))
                .concat("; ");
        
        if (!list.isEmpty())list.remove(0);
        
        return !list.isEmpty()
                ? getListaDeValores(list, novaParteDoLog)
                : novaParteDoLog;
    }
    
    public String getListaDeValores(List<Double> list) {
        return getListaDeValores(new ArrayList(list), new String());
    }
}
