public class Nodo {

    /**
     * Creamos los atributos y variables de la clase
     */
    private double efectivo_disponible;
    private Pila listaProductos;
    private String dato;
    private Nodo siguienteNodo;

    /**
     * Sobrecarga de constructores
     */
    public Nodo(String dato){
        this(dato, null);
    }

    public Nodo(double efectivo_disponible, Pila listaProductos){
        this.efectivo_disponible = efectivo_disponible;
        this.listaProductos = listaProductos;
    }

    public Nodo(double efectivo_disponible, Pila listaProductos, Nodo siguNododeCliente){
        this.efectivo_disponible = efectivo_disponible;
        this.listaProductos = listaProductos;
        this.siguienteNodo = siguNododeCliente;
    }

    public Nodo(String dato, Nodo siguienteNodo) {
        this.dato = dato;
        this.siguienteNodo = siguienteNodo;
    }

    /**
     * Getters y setters de la clase
     */
    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(Nodo siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }

    public double getEfectivo_disponible() {
        return efectivo_disponible;
    }

    public void setEfectivo_disponible(double efectivo_disponible) {
        this.efectivo_disponible = efectivo_disponible;
    }

    public Pila getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(Pila listaProductos) {
        this.listaProductos = listaProductos;
    }

    
}
