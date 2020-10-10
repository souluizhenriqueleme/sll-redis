package br.com.souluizleme.resultadoDaLoteria;

import redis.clients.jedis.Jedis;

import java.util.*;

public class FiltraHistorioNumerosSorteados {


    public Set<String> filtrarResultados(int mes, int ano) {
        String chave = "resultado:*-%02d-%04d:megasena";
        Jedis jedis = new Jedis("localhost");

        return jedis.keys(String.format(chave, mes, ano));
    }

    public Map<String, List<String>> filtrarNumerosSorteados(Set<String> chaves) {
        Jedis jedis = new Jedis("localhost");
        Map<String, List<String>> resultados = new HashMap<>();
        chaves.stream().forEach(chave -> {
            resultados.put(chave, jedis.mget(chave));
        });
        return resultados;
    }

    public static void main(String[] args) {
        int mes = Integer.valueOf("09");
        int ano = 2020;

        FiltraHistorioNumerosSorteados filtraHistorioNumerosSorteados = new FiltraHistorioNumerosSorteados();
        Set<String> sorteios = filtraHistorioNumerosSorteados.filtrarResultados(mes, ano);
        Map<String, List<String>> resultadoDosSorteios = filtraHistorioNumerosSorteados.filtrarNumerosSorteados(sorteios);

        resultadoDosSorteios.forEach((sorteio, resultado) ->{
            System.out.println("Sorteio: " + sorteio + " Números sorteados: " + resultado);
        });
    }
}
