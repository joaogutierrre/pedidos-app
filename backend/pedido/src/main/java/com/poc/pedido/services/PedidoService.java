package com.poc.pedido.services;

import com.poc.pedido.entities.PedidoModel;
import com.poc.pedido.repositories.PedidoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PedidoService {
    final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<PedidoModel> findAllPedidoModels() {
        return pedidoRepository.findAll();
    }

    public Optional<PedidoModel> findPedidoById(UUID id) {
        return pedidoRepository.findById(id);
    }

    public boolean existsByCpf(String cpf) {
        return pedidoRepository.existsByCpf(cpf);
    }

    public boolean existsBydatapedido(LocalDateTime datapedido) {
        return pedidoRepository.existsBydatapedido(datapedido);
    }
    @Transactional
    public PedidoModel save(PedidoModel pedidoModel) {
        return pedidoRepository.save(pedidoModel);
    }
}
