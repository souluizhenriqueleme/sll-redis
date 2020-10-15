package br.com.souluizleme.resultadoDaLoteria.redis.hash;

import redis.clients.jedis.Jedis;

import java.sql.SQLOutput;

public class ResultadoMegasenaHashMore {

    public static void main(String[] args) {
        String chave = "resultado:14-10-2020:megasena";
        Jedis jedis = new Jedis("localhost");

        System.out.println("Campo Ganhadores Existe: " +
                jedis.hexists(chave, "ganhadores"));

        System.out.println(String.format("Quantidade de campos da chave [%s]: %d", chave,
                jedis.hlen(chave)));

        System.out.println(String.format("Os numeros sorteados no sorteio [%s] são: %s", chave,
                jedis.hmget(chave, "numeros")));
    }
}
