package com.poc.pedido.dtos;

import java.time.LocalDateTime;

public class PedidoDto {
    private String cpf;
    private String descricao;
    private int qtdItens;
    private LocalDateTime datapedido;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(int qtdItens) {
        this.qtdItens = qtdItens;
    }

    public LocalDateTime getDataPedido() {
        return datapedido;
    }

    public void setDataPedido(LocalDateTime datapedido) {
        this.datapedido = datapedido;
    }
}
