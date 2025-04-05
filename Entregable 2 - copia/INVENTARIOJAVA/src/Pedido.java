public class Pedido {
    String nombreProducto;
    int cantidadProducto;
    Pedido pedidoSiguiente;
    Pedido pedidoAnterior;

    public Pedido(String nombreProducto, int cantidadProducto, Pedido pedidoSiguiente, Pedido pedidoAnterior) {
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.pedidoSiguiente = pedidoSiguiente;
        this.pedidoAnterior = pedidoAnterior;
    }
}




