package com.sistema.projeto.dto;

import com.sistema.projeto.builder.RelatorioFinanceiroBuilder;

public class RelatorioFinanceiroDTO {
    private int mes;
    private int ano;
    private double gastoRealizado;
    private double gastoPrevisto;
    private double valorArrecadado;

    // Construtor com Builder
    public RelatorioFinanceiroDTO(RelatorioFinanceiroBuilder builder) {
        this.mes = builder.mes;
        this.ano = builder.ano;
        this.gastoRealizado = builder.gastoRealizado;
        this.gastoPrevisto = builder.gastoPrevisto;
        this.valorArrecadado = builder.valorArrecadado;
    }

    // Getters
    public int getMes() { return mes; }
    public int getAno() { return ano; }
    public double getGastoRealizado() { return gastoRealizado; }
    public double getGastoPrevisto() { return gastoPrevisto; }
    public double getValorArrecadado() { return valorArrecadado; }
}

