package br.com.souluizleme.resultadoDaLoteria.redis.hash;

import redis.clients.jedis.Jedis;

public class DeletandoUmCampoHash {
    public static void main(String[] args) {
        String chave = "resultado:14-10-2020:megasena";
        Jedis jedis = new Jedis("localhost");

        Long resultado = jedis.hdel(chave, "ganhadores");

        System.out.println(resultado);
    }
}
