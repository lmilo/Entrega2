public class ListaDoblePedidos {
    private Pedido primerPedido;
    private Pedido ultimoPedido;

    public void agregarPedido(String nombreProducto, int cantidadProducto, Pedido pedidoSiguiente, Pedido pedidoAnterior) {
        Pedido nuevoPedido = new Pedido(nombreProducto, cantidadProducto, null, null);

        if (primerPedido == null) {
            primerPedido = ultimoPedido = nuevoPedido; 
            ultimoPedido.pedidoSiguiente = nuevoPedido; 
            nuevoPedido.pedidoAnterior = ultimoPedido; 
            ultimoPedido = nuevoPedido; 
        }
    }

    public void mostrarPedidosAdelante() {
        if (primerPedido == null) {
            System.out.println("La lista doble está vacía.");
            return;
        }

        Pedido pedidoActual = primerPedido;
        System.out.println("Pedidos en la lista doble (adelante):");
        while (pedidoActual != null) {
            System.out.println("Producto: " + pedidoActual.nombreProducto + ", Cantidad: " + pedidoActual.cantidadProducto);
            pedidoActual = pedidoActual.pedidoSiguiente; 
        }
    }

    public void mostrarPedidosAtras() {
        if (ultimoPedido == null) {
            System.out.println("La lista doble está vacía.");
            return;
        }

        Pedido pedidoActual = ultimoPedido;
        System.out.println("Pedidos en la lista doble (atrás):");
        while (pedidoActual != null) {
            System.out.println("Producto: " + pedidoActual.nombreProducto + ", Cantidad: " + pedidoActual.cantidadProducto);
            pedidoActual = pedidoActual.pedidoAnterior; 
        }
    }
}


