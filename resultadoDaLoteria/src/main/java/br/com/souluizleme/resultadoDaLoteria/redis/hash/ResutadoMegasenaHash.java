package br.com.souluizleme.resultadoDaLoteria.redis.hash;

import br.com.souluizleme.resultadoDaLoteria.model.Sorteio;
import redis.clients.jedis.Jedis;

import java.util.Arrays;

public class ResutadoMegasenaHash {

    public static void main(String[] args) {
        String chave = "resultado:%s:megasena";
        Sorteio sorteio = Sorteio.gerarSorteioComChave(chave, "14-10-2020", Arrays.asList("7", "15", "20", "23", "30", "41"), 3);

        Jedis jedis = new Jedis("localhost");
        Long resultado1 = jedis.hset(sorteio.getChaveDoSorteio(), "ganhadores", sorteio.getNumGanhadores());
        Long resultado2 = jedis.hset(sorteio.getChaveDoSorteio(), "numeros", sorteio.getNumerosSorteados());

        String mensagem = String.format("Resultado 1 = %d, Resultado 2 = %d",
                resultado1,
                resultado2);
        System.out.println(mensagem);
    }
}
