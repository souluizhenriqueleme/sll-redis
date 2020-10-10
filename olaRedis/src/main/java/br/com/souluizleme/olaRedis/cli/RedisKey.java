package br.com.souluizleme.olaRedis.cli;

import redis.clients.jedis.Jedis;

public class RedisKey {

    public static void main(String[] args) {
       Jedis jedis = new Jedis("localhost");
       String key = "ultimo_avanger";
       keyProducer(jedis, key);
       keyConsumer(jedis,key);
       keyDestoyer(jedis, key);
    }

    private static void keyProducer(Jedis jedis, String key) {
        String resultado = jedis.set(key, "Tony Stark");
        System.out.println(resultado);
    }

    private static void keyConsumer(Jedis jedis, String key) {
        String valor = jedis.get(key);
        System.out.println(valor);
    }

    private static void keyDestoyer(Jedis jedis, String key) {
        Long resultado = jedis.del(key);
        System.out.println(resultado);
    }
}
