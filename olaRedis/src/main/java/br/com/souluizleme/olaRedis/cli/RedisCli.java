package br.com.souluizleme.olaRedis.cli;

import redis.clients.jedis.Jedis;

public class RedisCli {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        String resultado = jedis.echo("Cid Moreira: Jabulani");
        System.out.println(resultado);
    }
}
