public class ListaCircularPedidos {
    private Pedido ultimoPedido;

    public void agregarPedido(String nombreProducto, int cantidadProducto, Pedido pedidoSiguiente, Pedido pedidoAnterior) {
        Pedido nuevoPedido = new Pedido(nombreProducto, cantidadProducto, pedidoSiguiente, pedidoAnterior);
        if (ultimoPedido == null) {
            ultimoPedido = nuevoPedido;
            ultimoPedido.pedidoSiguiente = ultimoPedido;
        } else {
            nuevoPedido.pedidoSiguiente = ultimoPedido.pedidoSiguiente;
            ultimoPedido.pedidoSiguiente = nuevoPedido;
            ultimoPedido = nuevoPedido;
        }
    }

    public void mostrarPedidosCirculares() {
        if (ultimoPedido == null) { 
            System.out.println("La lista circular está vacía.");
            return;
        }

        Pedido pedidoActual = ultimoPedido.pedidoSiguiente;
        do {
            System.out.println("Producto: " + pedidoActual.nombreProducto + ", Cantidad: " + pedidoActual.cantidadProducto);
            pedidoActual = pedidoActual.pedidoSiguiente;
        } while (pedidoActual != ultimoPedido.pedidoSiguiente); 
    }
}

