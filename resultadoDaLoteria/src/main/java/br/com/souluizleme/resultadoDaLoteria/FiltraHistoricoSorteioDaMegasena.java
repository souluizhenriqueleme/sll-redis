package br.com.souluizleme.resultadoDaLoteria;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class FiltraHistoricoSorteioDaMegasena {

    public Set<String> filtrarResultados(int mes, int ano) {
        String chave = "resultado:*-%02d-%04d:megasena";
        Jedis jedis = new Jedis("localhost");

        return jedis.keys(String.format(chave, mes, ano));
    }

    public static void main(String[] args) {
        int mes = Integer.parseInt("09");
        int ano = 2020;
        Set<String> chaves = new FiltraHistoricoSorteioDaMegasena().filtrarResultados(mes, ano);
        System.out.println(chaves);
    }

}
