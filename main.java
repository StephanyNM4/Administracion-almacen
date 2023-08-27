
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        /**
         * Instanciamos clases a utilizar
         */
        archivos a = new archivos();
        Cola clientes = new Cola("Clientes 1");
        Cola clientes2 = new Cola("Clientes 2");
        Pila productosInfo = new Pila("Informacion");
        Nodo efectivo = new Nodo("Efectivo");
        String[] posicion_cliente = {"primer", "segundo" , "tercer", "cuarto", "quinto", "sexto", "septimo", "octavo", "noveno", "decimo"};
        int i;
        /**
         * Leemos el archivo que contiene los datos del producto
         */
        a.leerTxt("C:\\Users\\Stephany\\Downloads\\ProyectoFinal_Grupo2_IS210_1900\\texto.txt");
         
        /**
         * Realizamos la cola de clientes
         */
        clientes.encolar();
        clientes2.encolar();

        /**
         * Mostramos la lista de productos iniciales (Almacen)
         */
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("***Lista de productos inciales***");
        a.posicion(); 

        
        int numerodeCliente = 0;
        System.out.println("");
        System.out.println("***Caja 1***");
        System.out.println("");

        /**
         * Mostramos la cantidad de clientes a atender en caja 1
         */
        System.out.println("La fila tiene un tamaño de " + clientes.largoCOla + " personas");
        System.out.println("");


        /**
         * Mostramos la lista de productos de cada cliente de la caja 1
         */
        System.out.println("***Listado de clientes con los productos a comprar***");
        System.out.println(" ");
        while (numerodeCliente < clientes.largoCOla) {
            int j = 0;
            /**
             * Asignamos efectivo inicial al cliente
             */
            double efectivoCliente = clientes.asignarSalario();
            double efectivoNuevo=0;
        
            System.out.println("---------La lista del " + posicion_cliente[numerodeCliente] + " cliente tiene un tamaño de " + clientes.tamañoListaCliente()+"---------");
            System.out.println("El efectivo inicial del cliente es de: "+efectivoCliente);
            System.out.println("");
            
            while (j <= clientes.tamañoListaCliente()) {
                if (j  < clientes.tamañoListaCliente()) {
                    /**
                     * Obtiene el producto y calcula efectivo actual del cliente
                     */
                    efectivoNuevo = a.efectivoFinalClientes(efectivoCliente, clientes.obtenerProd());
                    efectivoCliente = efectivoNuevo;
                    /**
                     * Elimina la lista del Cliente
                     */
                    a.eliminarProductoPila(clientes.obtenerProd());
                    productosInfo.totalVendido();
                    clientes.eliminarLista(); 
                    j++;
                }
                else{
                    break;
                }
            }   
            /**
             * Mostramos el efectivo final del cliente
             */
            System.out.println("");
            System.out.println("El efectivo final del " + posicion_cliente[numerodeCliente] + " cliente es: "+efectivoCliente);
            efectivoCliente = 0;
            System.out.println("");
            /**
             * Eliminamos al cliente atendido 
             */
            if (numerodeCliente < clientes.largoCOla) {
                clientes.desencolar();
            }
            else{
                break;
            }
            numerodeCliente++;
        }   
        System.out.println("");
        System.out.println("***Fin de la lista de clientes de la caja uno***");
        System.out.println(" ");


        
        System.out.println(" ");
        System.out.println("***Caja 2***");
        System.out.println("");

        /**
         * Mostramos la cantidad de clientes a atender en caja 2
         */
        System.out.println("La fila tiene un tamaño de " + clientes2.largoCOla + " personas");
        System.out.println("");
        numerodeCliente = 0;

        /**
         * Mostramos la lista de productos de cada cliente de la caja 2
         */
        System.out.println("***Listado de clientes con los productos a comprar***");
        System.out.println(" ");
        while (numerodeCliente < clientes2.largoCOla) {
            int j = 0;
            /**
             * Asignamos efectivo inicial al cliente
             */
            double efectivoCliente = clientes2.asignarSalario();
            double efectivoNuevo=0;
            System.out.println("");
            System.out.println("---------La lista del " + posicion_cliente[numerodeCliente] + " cliente tiene un tamaño de " + clientes2.tamañoListaCliente()+"---------");
            System.out.println("El efectivo inicial del cliente es de: "+efectivoCliente);
            System.out.println("");  

            while (j <= clientes2.tamañoListaCliente()) {
                if (j  < clientes2.tamañoListaCliente()) {
                     /**
                     * Obtiene el producto y calcula efectivo actual del cliente
                     */
                    efectivoNuevo = a.efectivoFinalClientes(efectivoCliente, clientes2.obtenerProd());
                    efectivoCliente = efectivoNuevo;
                    /**
                     * Elimina la lista del Cliente
                     */
                    a.eliminarProductoPila(clientes2.obtenerProd());
                    productosInfo.totalVendido();
                    clientes2.eliminarLista(); 
                    j++;
                }
                else{
                    break;
                }
            }
            /**
             * Eliminamos al cliente atendido 
             */
            if (numerodeCliente < clientes2.largoCOla) {
                clientes2.desencolar();
            }
            else{
                break;
            }
                /**
                 * Mostramos el efectivo final del cliente
                 */
                System.out.println("");
                System.out.println("El efectivo final del " + posicion_cliente[numerodeCliente] + " cliente es: "+efectivoCliente);
                efectivoCliente = 0;
                System.out.println("");
               
            numerodeCliente++;
        }   
        System.out.println("");
        System.out.println("***Fin de la lista de clientes de la caja dos***");
        System.out.println("");
        System.out.println("");

        /**
         * Mostramos la cantidad total de de productos vendidos
         */
        System.out.println("");
        System.out.println("***Productos vendidos en total***");
        System.out.println("");
        System.out.println("Se vendieron un total de " + productosInfo.productosvendido + " productos");
        System.out.println("");
        
        /**
         * Mostramos la cantidad de productos vendidos de cada categoria
         */
        System.out.println("***Productos vendidos por separados***");
        a.posicion(); 

        /**
         * Mostramos el reporte final 
         */
        System.out.println("");
        System.out.println("");
        System.out.println("            ***Reporte***");
        System.out.println("");
        /**
         * Cantidad de clientes obtenidos
         */
        System.out.println("Clientes atendidos: ");
        System.out.println("La caja 1 atendio una cantidad de: "+clientes.largoCOla);
        System.out.println("La caja 2 atendio una cantidad de: "+clientes2.largoCOla);
        System.out.println("");
        /**
         * Cantidad de productos vendidos
         */
        System.out.println("Cantidad de productos vendidos: ");
        System.out.println(productosInfo.productosvendido);
        System.out.println("");
        /**
         * Montos obtenidos de cada producto y monto final
         */
        System.out.println("Monto obtenido de cada producto: ");
        a.montoProductos();
        System.out.println("");
        
        
        




        



    }
    
}
