import java.io.BufferedReader;
import java.io.FileReader;
import java.text.StringCharacterIterator;
import java.util.Scanner;

public class archivos {

    int vuelta = 0;
    Lista enviar = new Lista("");
    Pila almacenFinal = new Pila("");
    Pila[] almacen = almacenFinal.creacionPilas();
    
    /**
     * Realizamos metodo para leer el archivo
     */
    public void leerTxt(String direccion){

        String texto = "";
        

        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            int i=0;
            
            while ((bfRead = bf.readLine()) != null) {
                //Mientras el ciclo tiene datos
                temp = bfRead;
                enviar.insertarAlFinal(bfRead);
                almacen[i].insertarAlFinal(bfRead);
                i++;
            }

            texto = temp;
        } catch (Exception e) {

            System.err.println("No se encontro archivo");
            

        }   
    }

    /**
     * Metodo para saber el tamaño
     * @return tamaño
     */
    public int tama(){
        return enviar.tamaño();
    }

    /**
     * Metodo para buscar un producto en el archivo
     */
    public Lista buscar(){
        try {
            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\Stephany\\Downloads\\ProyectoFinal_Grupo2_IS210_1900\\texto.txt"));
            Scanner sc = new Scanner(System.in);
            String temp = "";
            String bfRead;
            System.out.println("Ingrese la palabra");
            String palabra = sc.nextLine();
            int i = 1;
            
            while ((bfRead = bf.readLine()) != null) {
                //Mientras el ciclo tiene datos
                temp = bfRead;

                if (temp.contains(palabra)) {
                    enviar.encontrarProducto(i);
                }
                i++;
            }

        } catch (Exception e) {

            System.err.println("No se encontro archivo");
            

        }
        return enviar;
        
    }

    /**
     * Metodo que nos permite comocer la cantidad de productos iniciales y productos vendidos
     */
    public void posicion(){
       // int k=0;
       // while (k != j) {
         //   k++;
        //}
        for (int i = 0; i < almacen.length; i++) {
            if (vuelta == 0 ) {
                System.out.println("La cantidad de " + almacen[i].dato + " son " + almacen[i].largoPila);
            }else{
                System.out.println("La cantidad de " + almacen[i].dato + " son " + almacen[i].largoPila + " y se vendio un total de " + almacen[i].cantidadvendidacu);
            }
        }
        vuelta++;
    }

    /**
     * Metodo que nos retorna el efectivo final del cliente
     * @param efectivo_disponible efectivo del cliente
     * @param producto producto a comprar
     * @return efectivo final
     */
    public double efectivoFinalClientes(double efectivo_disponible, String producto){
        Pila pila = new Pila("");
        for(int i=0; i<almacen.length; i++){
            if(almacen[i].dato.equalsIgnoreCase(producto)){
                efectivo_disponible -= pila.precio[i];
            }
        }
        return efectivo_disponible;
    }

    /**
     * Metodo que nos muestra el monto obtenido de cada producto y el monto total
     */
    public void montoProductos(){
        int suma=0;
        int montoFinal=0;
        Pila pila = new Pila("");
        System.out.println("El efectivo inicial del cliente fue: ");
        for(int i=0; i<almacen.length; i++){
            if(almacen[i].dato.equals(pila.productos[i])){
                suma = almacen[i].cantidadvendidacu*pila.precio[i];
            }
            if(suma==0){
                System.out.println("El monto obtenido de "+ almacen[i].dato + "= No se vendio este producto");
            }else{
            System.out.println("El monto obtenido de "+ almacen[i].dato + "= L"+suma);
            }
            montoFinal += suma;
        }
        System.out.println("");
        System.out.println("");
        System.out.println("El monto total obtenido es: ");
        System.out.println("L"+montoFinal);

    }

    /**
     * Metodo que nos permite eliminar el producto
     */
    public void eliminarProductoPila(String producto) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\Stephany\\Downloads\\ProyectoFinal_Grupo2_IS210_1900\\texto.txt"));
            String temp = "";
            String bfRead;
            String palabra = producto;
            int i = 1;
            
            while ((bfRead = bf.readLine()) != null) {
                //Mientras el ciclo tiene datos

                if (bfRead.contains(palabra)) {
                    almacen[i-1].eliminarAlFinal(enviar.encontrarProducto(i));
                }
                i++;
            }

        } catch (Exception e) {

            System.err.println("No se encontro archivo");
            

        }
    }
}
