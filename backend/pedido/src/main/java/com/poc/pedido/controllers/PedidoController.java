package com.poc.pedido.controllers;

import com.poc.pedido.dtos.PedidoDto;
import com.poc.pedido.entities.PedidoModel;
import com.poc.pedido.services.PedidoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<PedidoModel>> listaPedidos() {
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.findAllPedidoModels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listaUmPedido(@PathVariable(value = "id") UUID id) {
        Optional<PedidoModel> pedidoModelOptional = pedidoService.findPedidoById(id);
        if (!pedidoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado! Tente novamente!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pedidoModelOptional.get());
    }

    @PostMapping("/create")
    public ResponseEntity<Object> salvaPedido(@RequestBody PedidoDto pedidoDto) {
        if (pedidoService.existsByCpf(pedidoDto.getCpf())) {
            if (pedidoService.existsBydatapedido(pedidoDto.getDataPedido())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito de data: Um mesmo CPF não poderá realizar o mesmo pedido em uma mesma data!!! Tente novamente!!!");
            }
        }
        var pedidoModel = new PedidoModel();
        BeanUtils.copyProperties(pedidoDto, pedidoModel);
        pedidoModel.setDataPedido(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(pedidoModel));
    }
}
