import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorProducto gestor = new GestorProducto();
        Venta ventaActual = null;
        int opcion = 0;

        do {
            System.out.println("TIENDA DE BELLEZA MENU V1");
            System.out.println("1. REGISTRAR PRODUCTO");
            System.out.println("2. LISTAR PRODUCTOS");
            System.out.println("3. BUSCAR PRODUCTO");
            System.out.println("4. MODIFICAR PRODUCTO");
            System.out.println("5. AUMENTAR STOCK");
            System.out.println("6. DISMINUIR STOCK");
            System.out.println("7. ELIMINAR PRODUCTO");
            System.out.println("8. CONSULTAR PRODUCTOS CON STOCK BAJO");
            System.out.println("9. CREAR VENTA");
            System.out.println("10. AGREGAR DETALLE A LA VENTA");
            System.out.println("11. MOSTRAR DETALLES DE LA VENTA");
            System.out.println("12. CALCULAR TOTAL DE LA VENTA");
            System.out.println("13. SALIR");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("INGRESA UN NUMERO VALIDO :)");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("REGISTRAR PRODUCTO");
                    System.out.println("TIPO [VENTA - INSUMO - MIXTO]: ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("ID PRODUCTO: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("NOMBRE: ");
                    String nombre = scanner.nextLine();
                    System.out.println("PRECIO DE COMPRA: ");
                    int precioCompra = scanner.nextInt();
                    System.out.println("STOCK ACTUAL: ");
                    int stockActual = scanner.nextInt();
                    System.out.println("STOCK MINIMO: ");
                    int stockMinimo = scanner.nextInt();

                    if (tipo == 1 || tipo == 3) {
                        System.out.println("PRECIO DE VENTA:");
                        float precioVenta = scanner.nextFloat();
                        if (tipo == 1) {
                            ProductoVenta pv = new ProductoVenta(id,nombre,precioCompra,stockActual,stockMinimo,precioVenta);
                            gestor.registrarProducto(pv);
                        } else {
                            ProductoMixto pm = new ProductoMixto(id,nombre,precioCompra,stockActual,stockMinimo,precioVenta);
                            gestor.registrarProducto(pm);
                        }
                    } else if (tipo == 2) {
                        Insumo insumo = new Insumo(id,nombre,precioCompra,stockActual,stockMinimo);
                        gestor.registrarProducto(insumo);
                    } else {
                        System.out.println("ESTO NO ES VALIDO");
                    }
                    break;

                case 2:
                    System.out.println("LISTA DE PRODUCTOS");
                    gestor.listarProductos();
                    break;

                case 3:
                    System.out.println("BUSCAR PRODUCTO");
                    System.out.println("INGRESA EL ID DEL PRODUCTO A BUSCAR: ");
                    int idBusqueda = scanner.nextInt();
                    Producto pEncontrado = gestor.buscarProducto(idBusqueda);
                    if (pEncontrado != null) {
                        pEncontrado.imprimirInformacion();
                    }
                    break;

                case 4:
                    System.out.println("MODIFICAR PRODUCTO");
                    System.out.println("INGRESE ID DEL PRODUCTO A MODIFICAR: ");
                    int idMod = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("NUEVO NOMBRE");
                    String nuevoNombre = scanner.nextLine();
                    if (gestor.modificarNombre(idMod, nuevoNombre)) {
                        System.out.println("NOMBRE MODIFICADO EXITOSAMENTE ");
                    }
                    break;

                case 5:
                    System.out.println("AUMENTAR STOCK");
                    System.out.println("INGRESA EL ID DEL PRODUCTO");
                    int idAum = scanner.nextInt();
                    System.out.println("CANTIDAD A AUMENTAR");
                    int cantAum = scanner.nextInt();
                    if (gestor.aumentarStock(idAum, cantAum)) {
                        System.out.println("STOCK AUMENTANDO CORRECTAMENTE");
                    }
                    break;

                case 6:
                    System.out.println("DISMINUIR STOCK");
                    System.out.println("INGRESE ID DEL PRODUCTO");
                    int idDis = scanner.nextInt();
                    System.out.println("CANTIDAD A DISMINUIR");
                    int cantDis = scanner.nextInt();
                    if (gestor.disminuirStock(idDis, cantDis)) {
                        System.out.println("STOCK DISMINUIDO CORRECTAMENTE");
                    }
                    break;

                case 7:
                    System.out.println("ELIMINAR PRODUCTO");
                    System.out.println("INGRESA ID DEL PRODUCTO QUE QUIERAS ELIMINAR");
                    int idElim = scanner.nextInt();
                    if (gestor.eliminarProducto(idElim)) {
                        System.out.println("PRODUCTO ELIMINADO CON EXITO");
                    }
                    break;

                case 8:
                    System.out.println("PRODUCTOS CON STOCK BAJO");
                    gestor.listarProductosStockBajo();
                    break;

                case 9:
                    System.out.println("CREAR VENTA");
                    ventaActual = new Venta();
                    System.out.println("VENTA INICIADA DE MANERA CORRECTA");
                    break;

                case 10:
                    if (ventaActual == null) {
                        System.out.println("PRIMERO DEBERIAS CREAR UNA VENTA");
                    } else {
                        System.out.println("AGREGAR DETALLES");
                        System.out.println("FUNCIONALIDAD EN DESARROLLO");
                    }
                    break;

                case 11:
                    if (ventaActual == null) {
                        System.out.println("NO HAY VENTA ACTIVA");
                    } else {
                        ventaActual.mostrarDetalles();
                    }
                    break;

                case 12:
                    if (ventaActual == null) {
                        System.out.println("NO HAY NINGNA VENTA ACTIVA");
                    } else {
                        double total = ventaActual.calcularTotal();
                        System.out.println("EL TOTAL DE LA VENTA ES: " + total);
                    }
                    break;

                case 13:
                    System.out.println("SALIENDO DEL SISTEMA ");
                    break;

                default:
                    System.out.println("OPCION NO VALIDA");
            }
        } while (opcion != 13);

        scanner.close();
    }
}
