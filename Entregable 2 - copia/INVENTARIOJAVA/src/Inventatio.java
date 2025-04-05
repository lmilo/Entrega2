public class Inventatio {
    private String[] listaProductos = {"pc", "laptop", "tablet", "celular", "impresora", "monitor", "teclado", "mouse", "bocinas", "audifonos"};
    private double[][] inventarioStockPrecios = {
        {10, 1000},
        {20, 2000},
        {30, 3000},
        {40, 4000},
        {50, 5000},
        {60, 6000},
        {70, 7000},
        {80, 8000},
        {90, 9000},
        {100, 10000}
    };

    public void mostrarInventario() { 
        System.out.println("Inventario de productos");
        for (int indiceProducto = 0; indiceProducto < listaProductos.length; indiceProducto++) {
            System.out.println("Producto: " + listaProductos[indiceProducto] + 
                               " Stock: " + inventarioStockPrecios[indiceProducto][0] + 
                               " Precio: " + inventarioStockPrecios[indiceProducto][1]);
        }
    }

    public int buscarProducto(String nombreProducto) {
        for (int indiceProducto = 0; indiceProducto < listaProductos.length; indiceProducto++) {
            if (listaProductos[indiceProducto].equalsIgnoreCase(nombreProducto)) {
                return indiceProducto;
            }
        }
        return -1;
    }

    public boolean verificarStock(int indiceProducto, int cantidadSolicitada) {
        return inventarioStockPrecios[indiceProducto][0] >= cantidadSolicitada;
    }

    public void actualizarStock(int indiceProducto, int cantidadVendida) {
        inventarioStockPrecios[indiceProducto][0] -= cantidadVendida;
    }
}