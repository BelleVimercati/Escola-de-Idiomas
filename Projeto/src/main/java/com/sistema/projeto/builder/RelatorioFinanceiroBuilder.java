package com.sistema.projeto.builder;

import com.sistema.projeto.dto.RelatorioFinanceiroDTO;

public class RelatorioFinanceiroBuilder {
    public int mes;
    public int ano;
    public double gastoRealizado;
    public double gastoPrevisto;
    public double valorArrecadado;

    public RelatorioFinanceiroBuilder comMes(int mes) {
        this.mes = mes;
        return this;
    }

    public RelatorioFinanceiroBuilder comAno(int ano) {
        this.ano = ano;
        return this;
    }

    public RelatorioFinanceiroBuilder comGastoRealizado(double gastoRealizado) {
        this.gastoRealizado = gastoRealizado;
        return this;
    }

    public RelatorioFinanceiroBuilder comGastoPrevisto(double gastoPrevisto) {
        this.gastoPrevisto = gastoPrevisto;
        return this;
    }

    public RelatorioFinanceiroBuilder comValorArrecadado(double valorArrecadado) {
        this.valorArrecadado = valorArrecadado;
        return this;
    }

    public RelatorioFinanceiroDTO build() {
        return new RelatorioFinanceiroDTO(this);
    }
}

