import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
})

export class PedidoService {
    API_URL = environment.API_URL;

    constructor(
        private http: HttpClient,
    ) { }

    getPedidos() {
        return this.http.get<Pedido[]>(this.API_URL + '/pedidos');
    }
    getPedido(id: string) {
        return this.http.get<Pedido>(this.API_URL + '/pedidos/' + id);
    }
    createPedido(pedido: Pedido) {
        return this.http.post<Pedido>(this.API_URL + '/pedidos/create', pedido);
    }
    updatePedido(id: string) {
        return this.http.put<Pedido>(this.API_URL + '/pedidos/edit' + id, pedido);
    }
    deletePedido(id: string) {
        return this.http.delete<Pedido>(this.API_URL + '/pedidos/delete' + id)
    }
}