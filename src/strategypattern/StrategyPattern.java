package strategypattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StrategyPattern {
    
    private static List<Double> inicilizarListaDeImpostos() {
        List<Double> listaDeImpostos = new ArrayList<Double>();
        listaDeImpostos.add(10.0);
        listaDeImpostos.add(20.0);
        listaDeImpostos.add(50.0);
        return listaDeImpostos;
    }

    public static void main(String[] args) {
        List<Double> listaDeImpostos = inicilizarListaDeImpostos();
        NotaFiscal notaFiscal = new NotaFiscal();
        
        System.out.println("Lista de valores iniciais: ");
        System.out.println(notaFiscal.getListaDeValores(listaDeImpostos).concat("\n"));
        
        System.out.println("Lista de valores com impostos de Rio de Janeiro: ");
        notaFiscal.setImpostoStrategy(new ImpostoRioDeJaneiro());
        System.out.println(notaFiscal.getRelatorioImpostos(listaDeImpostos).concat("\n"));
        
        System.out.println("Lista de valores com impostos de São Paulo: ");
        notaFiscal.setImpostoStrategy(new ImpostoSaoPaulo());
        System.out.println(notaFiscal.getRelatorioImpostos(listaDeImpostos).concat("\n"));
    }
}
