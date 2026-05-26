package tda;

public class ListaDobleEnlazada<T> {
    //ATRIBUTOS
    private NodoDoble<T> cabeza;
    private NodoDoble<T> ultimo;
    private int cantidad;
    
    //CONSTRUCTOR
    public ListaDobleEnlazada() {
        cabeza = null;
        ultimo = null;
        cantidad = 0;
    }
    
    //OPERACIONES
    //estaVacia: comprueba si la lista contiene elementos
    public boolean estaVacia() {
        return cabeza == null;
    }
    //agregarAlFinal: agrega elemento al final de la lista
    public void agregarAlFinal(T item) {
        NodoDoble<T> nuevoNodo = new NodoDoble(item, null, null);
        cantidad++;

        if (estaVacia()) {
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
            return;
        } else {
            ultimo.setSgtNodo(nuevoNodo);
            nuevoNodo.setAntNodo(ultimo);
            ultimo =  nuevoNodo;
        }
    }
    //mostrar: muestra los elementos de la lista en pantalla
    public void mostrar() {
        NodoDoble<T> aux = cabeza;

        while (aux!=null) {
            System.out.print(aux.getItem()+"\t");
            aux = aux.getSgtNodo();
        }
    }
    //mostrarInvertir: muestra los elementos de forma invertida en pantalla
    public void mostrarInvertido() {
        NodoDoble<T> aux = ultimo;

        while (aux!=null) {
            System.out.print(aux.getItem()+"\t");
            aux = aux.getAntNodo();
        }
    }
    //longitud: muestra la cantidad de elementos del arreglo
    public int longitud() {
        return cantidad;
    }
    //insertarListaVacia
    public void insertarListaVacia(T item) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(item, null, null);
        if (estaVacia()) {
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
            cantidad++;
        } else {
            System.err.println("La lista no se encuentra vacia");
        }
    }
    //insertarAlInicio: Inserta en una lista un elemento al inicio
    public void insertarAlInicio(T item) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(item, cabeza, null);
        cantidad++;
        if (estaVacia()) insertarListaVacia(item);
        else {
            cabeza.setAntNodo(nuevoNodo);   
            cabeza = nuevoNodo;
        }
    }
    //insertarAlFinal: Inserta en una lista un elemento al final
    public void insertarAlFinal(T item) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(item, null, ultimo);
        cantidad++;
        if (estaVacia()) insertarListaVacia(item);
        else {
            ultimo.setSgtNodo(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }
    //intertarMedio: Inserta en una poscion media
    public void insertar(T item, int posicion) {
        cantidad++;
        if (estaVacia() || posicion <= 0) insertarAlInicio(item);
        else {
            //Posicionar puntero en la posicion anterior indicada
            NodoDoble<T> aux = cabeza;
            int indice = 1;
            while (indice < posicion - 1 && aux.getSgtNodo()!=null) {
                aux = aux.getSgtNodo();
                indice++;
            }
            //Si se encuenra en el ultimo nodo
            if (aux == ultimo) {
                insertarAlFinal(item);
                return;
            }

            //1,2,3,___,4,5,6,7
            NodoDoble<T> nuevoNodo = new NodoDoble<>(item, aux.getSgtNodo(), aux);
            aux.getSgtNodo().setAntNodo(nuevoNodo);
            aux.setSgtNodo(nuevoNodo);
        }
    }
}