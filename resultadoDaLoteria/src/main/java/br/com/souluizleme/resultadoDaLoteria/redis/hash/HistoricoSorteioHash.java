package br.com.souluizleme.resultadoDaLoteria.redis.hash;

import redis.clients.jedis.Jedis;

public class HistoricoSorteioHash {

    public static void main(String[] args) {
        String chave = "resultado:14-10-2020:megasena";
        Jedis jedis = new Jedis("localhost");

        String ganhadores = jedis.hget(chave, "ganhadores");
        String numeros = jedis.hget(chave, "numeros");

        String mensagem = String.format(
                "Ganhadores = %s, Numeros = [%s]",
                ganhadores,
                numeros
        );

        System.out.println(mensagem);
    }
}
