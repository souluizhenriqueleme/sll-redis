package br.com.souluizleme.resultadoDaLoteria.model;

import com.google.gson.Gson;

import java.util.List;

public class Sorteio {

    private String dataDoSorteio;
    private String numerosSorteados;
    private Integer ganhadores;
    private String chaveDoSorteio;

    public Sorteio(String dataDoSorteio, String numerosSorteados, Integer ganhadores) {
        this.chaveDoSorteio = "resultado:megasena";
        this.dataDoSorteio = dataDoSorteio;
        this.numerosSorteados = numerosSorteados;
        this.ganhadores = ganhadores;
    }

    public Sorteio(String chaveDoSorteio, String dataDoSorteio, String numerosSorteados, Integer ganhadores) {
        this.chaveDoSorteio = chaveDoSorteio;
        this.dataDoSorteio = dataDoSorteio;
        this.numerosSorteados = numerosSorteados;
        this.ganhadores = ganhadores;
    }

    public String getDataDoSorteio() {
        return dataDoSorteio;
    }

    public String getNumerosSorteados() {
        return numerosSorteados;
    }

    public Integer getGanhadores() {
        return ganhadores;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public String getChaveDoSorteio() {
        return chaveDoSorteio;
    }

    public static Sorteio fromJson(String json) {
        return new Gson().fromJson(json, Sorteio.class);
    }

    public static Sorteio gerarSorteio(String dataDoSorteio, List<String> numerosSorteados, Integer numGanhadores) {
        return new Sorteio(dataDoSorteio, numerosSorteados.toString()
                .replace("[","").replace("]",""), numGanhadores);
    }

    public static Sorteio gerarSorteioComChave(String chaveDoSorteio, String dataDoSorteio, List<String> numerosSorteados, Integer numGanhadores) {
        String chave = String.format(chaveDoSorteio, dataDoSorteio);
        return new Sorteio(chave, dataDoSorteio,numerosSorteados.toString()
                .replace("[","").replace("]",""), numGanhadores);
    }
}
