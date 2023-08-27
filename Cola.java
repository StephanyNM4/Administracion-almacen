

import java.util.Random;



public class Cola extends Lista{
    /**
     * Creamos los atributos y variables de la clase
     */
    private Nodo primerNodo;
    private Nodo ultimoNodo;
    Object dato;
    Random nRandom = new Random();
    int aleatorio;
    int largoCOla;
    int i;  
    int largoLista;

    /**
     * Constructor de la clase
     * @param nombreCola
     */
    public Cola(String nombreCola) {
        super(nombreCola);
    }

   
    /**
     * Encolamos (creamos nodos)
     */
    public void encolar(){
        int k;
        k = tama();
        for (int j = 0; j < k; j++) {
            double efectivo_disponible = asignarSalario();
            if(estaVacia()){
                Pila a = new Pila("");
                this.primerNodo = this.ultimoNodo = new Nodo(efectivo_disponible, a.listaProductos());
            }else{
                Pila a = new Pila("");
                Nodo nvoNodo = new Nodo(efectivo_disponible, a.listaProductos());
                largoLista = a.largoPilaLista;
                this.ultimoNodo.setSiguienteNodo(nvoNodo);
                this.ultimoNodo = nvoNodo;
            }
        }
    }
    
    /**
     * Desencolamos (eliminamos nodo)
     * @return
     */
    public Object desencolar(){
        if(estaVacia())
        System.out.println("Ec");
    
    Object dato = this.primerNodo.getEfectivo_disponible();
    if(this.primerNodo == this.ultimoNodo)
        this.primerNodo = this.ultimoNodo = null;
    else
        this.primerNodo = this.primerNodo.getSiguienteNodo();

    return dato;
    }

    /**
     * Metodo que nos permite retornar el tamaño de la cola
     * @return tamaño de la cola
     */
    public int tamañoListaCliente(){

        return this.primerNodo.getListaProductos().largoPilaLista;
    }
    /**
     * Metodo que nos permite retornar los productos de la lista del cliente
     * @return
     */
    public String obtenerProd(){
       return this.primerNodo.getListaProductos().primerProducto.getDato();
    }

    /**
     * Metodo que elimina lista del cliente
     */
    public void eliminarLista(){
        this.primerNodo.getListaProductos().eliminarAlFinalListaCliente();
    }

    /**
     * Metodo para imprimir la cola de clientes
     */
     public void imprimirCola(){
        if(estaVacia())
            System.out.println("Vacia");
        else{
            Nodo temporal = this.primerNodo;
            while(temporal.getSiguienteNodo() != null){
                System.out.println(temporal.getEfectivo_disponible() + ", ");
                temporal.getListaProductos().imprimirPilaProducto();
                temporal = temporal.getSiguienteNodo();
            }

            System.out.println(temporal.getEfectivo_disponible() + ", ");
            temporal.getListaProductos().imprimirPilaProducto();

        }
    }
     
    
    /**
     * Metodo que genera el tamaño aleatorio de la cola
     * @return tamaño
     */
    public int tama(){
        int i;
        do {
            i = nRandom.nextInt(10);
        } while (i < 5);
        tamañoactual(i);
        return i;
    }
    /**
     * Actualiza el tamaño de la cola
     * @param tamaño
     */
    public void tamañoactual(int tamaño){
        largoCOla = tamaño;
    }

    /**
     * Retorna largo de la cola 
     * @return
     */
    public int largoCOla(){
        return largoCOla;
    }

    /**
     * Asigna efectivo al cliente
     * @return efectivo
     */
    public double asignarSalario() {
        int salario;
        do {
            salario = 400 + nRandom.nextInt(400);
        } while (salario < 50);
        return salario;
    }

    /**
     * Utilizamos para verificar si la cola esta vacia
     */
    public boolean estaVacia(){
        return (this.primerNodo == null);
    }
}