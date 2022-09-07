package com.poc.pedido.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "pedidos", schema = "public")
public class PedidoModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;
    @Column(nullable = false, length = 500)
    private String descricao;
    @Column(nullable = false)
    private int qtditens;
    @Column(nullable = false)
    private LocalDateTime datapedido;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
        return qtditens;
    }

    public void setQtdItens(int qtdItens) {
        this.qtditens = qtdItens;
    }

    public LocalDateTime getDataPedido() {
        return datapedido;
    }

    public void setDataPedido(LocalDateTime datapedido) {
        this.datapedido = datapedido;
    }
}
