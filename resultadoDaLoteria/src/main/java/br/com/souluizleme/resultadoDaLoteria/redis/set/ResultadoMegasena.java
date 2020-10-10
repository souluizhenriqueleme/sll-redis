package br.com.souluizleme.resultadoDaLoteria.redis.set;

import br.com.souluizleme.resultadoDaLoteria.model.Sorteio;
import redis.clients.jedis.Jedis;

import java.util.Arrays;

public class ResultadoMegasena {

    /*
    Megasena tem 2 sorteios semanais (quarta e sábado) armazenaremos o resultado de um sorteio ate o proximo ocorrer
    para armazenar o valor usaremos o SET que aceita um único conjunto de chave-valor
     */

    public static void main(String[] args) {
        String chave = "resultado:megasena";
        Sorteio sorteio = new ResultadoMegasena().obtemUmSorteio();
        Jedis jedis = new Jedis("localhost");
        String resultado = jedis.set(chave, sorteio.getNumerosSorteados());
        System.out.println(resultado);

    }

    public Sorteio obtemUmSorteio() {
        return Sorteio
                .gerarSorteio("10-10-2020",
                        Arrays.asList("2", "13", "24", "41", "42", "44"), 2);
    }
}
