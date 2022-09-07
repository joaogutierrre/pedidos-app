package com.poc.pedido.repositories;

import com.poc.pedido.entities.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, UUID> {
    boolean existsByCpf(String cpf);

    boolean existsBydatapedido(LocalDateTime datapedido);
}
