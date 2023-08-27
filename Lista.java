
public class Lista {
    /**
     * Creamos los atributos y variables de la clase
     */
    private Nodo primerNodo;

    private Nodo ultimoNodo;

    private String nombreLista;

    private int tamaño = 0;

    private int i;

    /**
     * Constructor de la clase
     * @param nombreLista
     */
    public Lista(String nombreLista){
        this.nombreLista = nombreLista;

    }

    /**
     * Metodo para rellenar lista
     * @param dato
     */
    public void insertarAlFinal(String dato){
        if(estaVacia()){
            this.primerNodo = this.ultimoNodo = new Nodo(dato);
        }else{
            Nodo nvoNodo = new Nodo(dato);
            this.ultimoNodo.setSiguienteNodo(nvoNodo);
            this.ultimoNodo = nvoNodo;
        }
        tamaño++;
    }

    /**
     * Metodo para eliminar nodo de la lista
     */
    public Object eliminarDelFinal(){
        if(estaVacia())
            System.out.println("Vacia");

        Object dato = this.ultimoNodo.getDato();
        if(this.primerNodo == this.ultimoNodo)
            this.primerNodo = this.ultimoNodo = null;
        else{
            Nodo temporal = this.primerNodo;
            while(temporal.getSiguienteNodo() != this.ultimoNodo){
                temporal = temporal.getSiguienteNodo();
            }
            temporal.setSiguienteNodo(null);
            this.ultimoNodo = temporal;
        }

        return dato;
    }

    /**
     * Imprime la lista
     */
    public void imprimirLista(){
        if(estaVacia())
            System.out.println("Vacia");
        else{
            Nodo temporal = this.primerNodo;
            while(temporal.getSiguienteNodo() != null){
                System.out.println(temporal.getDato() + " ");
                temporal = temporal.getSiguienteNodo();
            }
            System.out.println(temporal.getDato() + " ");
        }
    }

    /**
     * Metodo que nos permite encontrar producto en la lista
     * @param posicion
     * @return dato encontrado
     */
    public Object encontrarProducto(int posicion){
        Nodo temporal = this.primerNodo;
        if (estaVacia()) {
            System.out.println("Vacia");
        }else{
            int j = 1;
            while (j < posicion) {
                temporal = temporal.getSiguienteNodo();
                j++;
            }
            System.out.println(temporal.getDato());
        }
        return temporal.getDato();
    }

    /**
     * Tamaño de la lista
     * @return
     */
    public int tamaño(){
        return tamaño;
    }

    /**
     * Utilizamos para verificar si la lista esta vacia
     */
    public boolean estaVacia(){
        return (this.primerNodo == null);
    }

}
