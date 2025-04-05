import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Inventatio inventario = new Inventatio();
        ListaPedidos listaPedidosSimple = new ListaPedidos();
        ListaCircularPedidos listaPedidosCircular = new ListaCircularPedidos();
        ListaDoblePedidos listaPedidosDoble = new ListaDoblePedidos();

        System.out.println("Bienvenido a la tienda de tecnología. Sistema de inventario.");
        System.out.println("Productos disponibles:");
        inventario.mostrarInventario();

        while (true) {
            System.out.println("1. Agregar pedido");
            System.out.println("2. Mostrar pedidos simple");
            System.out.println("3. Mostrar pedidos circular");
            System.out.println("4. Mostrar pedidos doble (adelante)");
            System.out.println("5. Mostrar pedidos doble (atrás)");
            System.out.println("6. Salir");
            System.out.println("Seleccione una opción:");
            int opcionSeleccionada = scanner.nextInt();
            scanner.nextLine();

            if (opcionSeleccionada == 6) {
                System.out.println("Saliendo del sistema...");
                break;
            }

            switch (opcionSeleccionada) {
                case 1:
                    System.out.println("Ingrese el nombre del producto:");
                    String nombreProducto = scanner.nextLine().trim();
                    System.out.println("Ingrese la cantidad:");
                    int cantidadProducto = scanner.nextInt();
                    scanner.nextLine();

                    int indiceProducto = inventario.buscarProducto(nombreProducto);
                    if (indiceProducto == -1) {
                        System.out.println("Producto no encontrado. Los productos disponibles son:");
                        inventario.mostrarInventario();
                        continue;
                    }

                    if (!inventario.verificarStock(indiceProducto, cantidadProducto)) {
                        System.out.println("No hay suficiente stock.");
                        continue;
                    }

                    inventario.actualizarStock(indiceProducto, cantidadProducto);
                    System.out.println("Seleccione la lista donde desea agregar el pedido:");
                    System.out.println("1. Lista simple");
                    System.out.println("2. Lista circular");
                    System.out.println("3. Lista doble");
                    int tipoListaSeleccionada = scanner.nextInt();
                    scanner.nextLine();

                    switch (tipoListaSeleccionada) {
                        case 1:
                            listaPedidosSimple.agregarPedido(nombreProducto, cantidadProducto, null, null);
                            break;
                        case 2:
                            listaPedidosCircular.agregarPedido(nombreProducto, cantidadProducto, null, null);
                            break;
                        case 3:
                            listaPedidosDoble.agregarPedido(nombreProducto, cantidadProducto, null, null);
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            continue;
                    }

                    System.out.println("Gracias por tu compra. Tu pedido ha sido agregado correctamente.");
                    break;

                case 2:
                    listaPedidosSimple.mostrarPedidos();
                    break;

                case 3:
                    listaPedidosCircular.mostrarPedidosCirculares();
                    break;

                case 4:
                    listaPedidosDoble.mostrarPedidosAdelante();
                    break;

                case 5:
                    listaPedidosDoble.mostrarPedidosAtras();
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
