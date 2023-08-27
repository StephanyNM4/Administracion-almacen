

import java.util.Random;



public class Pila {
    /**
     * Creamos los atributos y variables de la clase
     */
    Nodo primerNodo;
    Nodo ultimoNodo;
    Nodo primerProducto;
    Nodo ultimoProducto;
    String dato;
    Random nRandom = new Random();
    int aleatorio;
    int largoPila;
    int i;  
    int largoPilaLista; 
    int cantidadvendidacu;
    int productosvendido = 0; 
    String[] productos = {"Agua", "Papel" , "Ace", "Manzana(unidad)", "Harina", "Jabon", "Tortillas", "Leche", 
                            "Mostaza", "Pollo entero", "Gaseosa", "Dulce", "Cereal", "Queso Libra", "Mantequilla"}; 
    int[] precio = {20,100,50,25,40,10,12,25,43,100,22,2,30,60,18};

    /**
     * Metodo que crea las pilas (productos)
     * @return arreglo de pilas (productos)
     */
    public Pila[] creacionPilas(){
    Pila nvaPila1 = new Pila("Agua");
    Pila nvaPila2 = new Pila("Papel");
    Pila nvaPila3 = new Pila("Ace");
    Pila nvaPila4 = new Pila("Manzana(unidad)");
    Pila nvaPila5 = new Pila("Harina");
    Pila nvaPila6 = new Pila("Jabon");
    Pila nvaPila7 = new Pila("Tortillas");
    Pila nvaPila8 = new Pila("Leche");
    Pila nvaPila9 = new Pila("Mostaza");
    Pila nvaPila10 = new Pila("Pollo entero");
    Pila nvaPila11 = new Pila("Gaseosa");
    Pila nvaPila12 = new Pila("Dulce");
    Pila nvaPila13 = new Pila("Cereal");
    Pila nvaPila14 = new Pila("Queso libra");
    Pila nvaPila15 = new Pila("Mantequilla");                                  
    Pila[] almacen =  {nvaPila1, nvaPila2, nvaPila3, nvaPila4, nvaPila5, nvaPila6, nvaPila7, nvaPila8, nvaPila9, nvaPila10,
    nvaPila11,nvaPila12,nvaPila13,nvaPila14,nvaPila15};
                        
     return almacen;
    }

    public Pila(String Dato){
        this.dato = Dato;
    }

    /**
     * Creamos el tamaño de la pila
     */
    public int tama(){
        int i;
        do {
            i = nRandom.nextInt(25);
        } while (i < 15);
        tamañoActual(i);
        return i;
    }
    /**
     * Actualizamos el tamaño
     * @param tamaño
     */
    public void tamañoActual(int tamaño){
        largoPila = tamaño;
    }

    public void tamañoActualLista(int tamaño){
        largoPilaLista = tamaño;
    }

    /**
     * Metodo que nos permite conocer el tamaño de la pila
     * @return tamaño de la pila
     */
    public int largoPila(){
        return largoPila;
    }

    /**
     * Rellenamos pila 
     * @param dato
     */
    public void insertarAlFinal(String dato){
        int k;
        k = tama();
        for (int j = 0; j < k; j++) {
            if(estaVacia()){
                this.primerNodo = this.ultimoNodo = new Nodo(dato);
            }else{
                Nodo nvoNodo = new Nodo(dato);
                this.ultimoNodo.setSiguienteNodo(nvoNodo);
                this.ultimoNodo = nvoNodo;
            }
        }
    }

    /**
     * Eliminamos nodo de la pila
     * @param valor
     * @return
     */
    public Object eliminarAlFinal(Object valor){
        if(estaVacia())
            System.out.println("vacia");
        
        Object dato = this.primerNodo.getDato();
        if(this.primerNodo == this.ultimoNodo)
            this.primerNodo = this.ultimoNodo = null;
        else
            this.primerNodo = this.primerNodo.getSiguienteNodo();

        largoPila--;
        productosvendido++;
        cantidadvendidacu++;
        return dato;
    }

    public Object eliminarAlFinalListaCliente(){
        if(estaVaciaListaProducto())
            System.out.println("vacia");
        
        Object dato = this.primerProducto.getDato();
        if(this.primerProducto == this.ultimoProducto)
            this.primerProducto = this.ultimoProducto = null;
        else
            this.primerProducto = this.primerProducto.getSiguienteNodo();

        largoPila--;
        return dato;
    }

    /**
     * Metodo que imprime la pila
     */
     public void imprimirPila(){
        if(estaVacia())
            System.out.println("Vacia");
        else{
            Nodo temporal = this.primerNodo;
            while(temporal.getSiguienteNodo() != null){
                System.out.println(temporal.getDato());
                temporal = temporal.getSiguienteNodo();
            }

            System.out.println(temporal.getDato());
        }
    }
     
    /**
     * Metodo que aumenta la cantidad de productos vendidos
     */
    public void totalVendido(){
        productosvendido++;
    }

    /**
     * Metodo que genera el tamaño de la lista de productos del cliente
     * @return
     */
    public int tamaListaProductos(){
        int p;
        do {
            p = nRandom.nextInt(6);
        } while (p < 3 || p > 5);
        tamañoActualLista(p);
        return p;
    }

    /**
     * Metodo que rellena la lista de productos del cliente
     */
    public void insertarAlFinalListaProducto(){
        int k;
        k = tamaListaProductos();
        int t;
        for (int j = 0; j < k; j++) {
            if(estaVaciaListaProducto()){
                do {
                    t = nRandom.nextInt(15);
                } while (t > 15);
                dato = productos[t];
                this.primerProducto = this.ultimoProducto = new Nodo(dato);
            }else{
                do {
                    t = nRandom.nextInt(15);
                } while (t > 15);
                dato = productos[t];
                Nodo nvoNodo = new Nodo(dato);
                this.ultimoProducto.setSiguienteNodo(nvoNodo);
                this.ultimoProducto = nvoNodo;
            }
        }
    }

    /**
     * Metodo que imprime la lista de productos del cliente
     */
    public void imprimirPilaProducto(){
        if(estaVaciaListaProducto())
            System.out.println("Vacia");
        else{
            Nodo temporal = this.primerProducto;
            while(temporal.getSiguienteNodo() != null){
                System.out.println(temporal.getDato());
                temporal = temporal.getSiguienteNodo();
            }

            System.out.println(temporal.getDato());
        }
    } 
    /**
     * Crea la lista final del cliente
     * @return lista del cliente
     */
    public Pila listaProductos(){
        Pila listaProductos = new Pila("");
        listaProductos.insertarAlFinalListaProducto();
        return listaProductos; 
    }

    /**
     * Utilizamos para verificar si la pila esta vacia
     */
    public boolean estaVacia(){
        return (this.primerNodo == null);
    }
    /**
     * Utilizamos para verificar si la pila del cliente esta vacia
     */
    public boolean estaVaciaListaProducto(){
        return (this.primerProducto == null);
    }

    /**
     * Metodo que elimina el producto del cliente en el almacen
     * @param almacen
     * @param listaProductos
     */
    public void eliminarProducto(Pila[] almacen,String listaProductos){
        for (int i = 0; i < almacen.length; i++) {
            if (almacen[i].primerNodo.getDato().equals(listaProductos)) {
                almacen[i].eliminarAlFinal(listaProductos);
                //almacen[i].imprimirPila();
                //listaProductos.imprimirPila();
                //System.out.println(almacen[i].largoPila);
            }
        }
    }

    /**
     * Metodo que busca el producto
     * @param almacen
     * @param listaProductos
     */
    public void buscarProducto(Pila[] almacen,String listaProductos){
        Pila a = new Pila("");
        for (int i = 0; i < almacen.length; i++) {
            if (almacen[i].primerNodo.getDato().equals(listaProductos)) {
                //almacen[i].imprimirPila();
                //System.out.println(almacen[i].largoPila());
            }
        }
    }

    
}
