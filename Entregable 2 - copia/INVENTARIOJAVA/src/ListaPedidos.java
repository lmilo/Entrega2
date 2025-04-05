public class ListaPedidos {

    private Pedido primerPedido;  

    public void agregarPedido(String nombreProducto, int cantidadProducto, Pedido pedidoSiguiente, Pedido pedidoAnterior) {
        Pedido nuevoPedido = new Pedido(nombreProducto, cantidadProducto, pedidoSiguiente, pedidoAnterior);  

        if (primerPedido == null) {
            primerPedido = nuevoPedido; 
            Pedido temporal = primerPedido;
            while (temporal.pedidoSiguiente != null) {  
                temporal = temporal.pedidoSiguiente; 
            }
            temporal.pedidoSiguiente = nuevoPedido; 
        }
    }

    public void mostrarPedidos() {
        if (primerPedido == null) {
            System.out.println("La lista de pedidos está vacía.");
            return;
        }

        Pedido temporal = primerPedido;
        while (temporal != null) {
            System.out.println("Pedido: " + temporal.nombreProducto + " Cantidad: " + temporal.cantidadProducto);
            temporal = temporal.pedidoSiguiente;
        }
    }
}
