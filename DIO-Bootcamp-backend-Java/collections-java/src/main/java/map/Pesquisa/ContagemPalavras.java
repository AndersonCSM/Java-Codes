package main.java.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> palavras;

    public ContagemPalavras() {
        this.palavras = new HashMap<>();
    }

    public void addPalavra(String palavra, int contagem){
        palavras.put(palavra, contagem);
    }

    public void removerPalavra(String palavra){
        if (palavras.get(palavra) != null){
            palavras.remove(palavra);
        }
    }

    public void exibirPalavra(){
        System.out.println(palavras);
    }

    public void maisFrequente(){
        String frequente = null;
        int maiorContagem = 0;
        for (Map.Entry<String, Integer> entry: palavras.entrySet()){
            if (entry.getValue() > maiorContagem){

            }
        }
    }
}
