package br.com.souluizleme.resultadoDaLoteria.redis.mset;

import br.com.souluizleme.resultadoDaLoteria.model.Sorteio;
import redis.clients.jedis.Jedis;

import java.util.Arrays;

/*
Neste exemplo usarei o MSET que aceita varios conjuntos de chave-valor como parametro
 */
public class HistoricoSorteios {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        String chave = "resultado:%s:megasena";
        Sorteio sorteio1 = Sorteio.gerarSorteioComChave(chave, "02-09-2020", Arrays.asList("10", "11", "18", "42", "55", "56"), 3);
        Sorteio sorteio2 = Sorteio.gerarSorteioComChave(chave, "05-09-2020", Arrays.asList("2", "21", "30", "35", "45", "50"), 0);
        Sorteio sorteio3 = Sorteio.gerarSorteioComChave(chave, "09-09-2020", Arrays.asList("2", "13", "24", "41", "42", "44"), 0);
        Sorteio sorteio4 = Sorteio.gerarSorteioComChave(chave, "12-09-2020", Arrays.asList("7", "15", "20", "23", "30", "41"), 1);

        String resultado = jedis.mset(
                sorteio1.getChaveDoSorteio(), sorteio1.getNumerosSorteados(),
                sorteio2.getChaveDoSorteio(), sorteio2.getNumerosSorteados(),
                sorteio3.getChaveDoSorteio(), sorteio3.getNumerosSorteados(),
                sorteio4.getChaveDoSorteio(), sorteio4.getNumerosSorteados()
        );

        System.out.println(resultado);
    }



}
