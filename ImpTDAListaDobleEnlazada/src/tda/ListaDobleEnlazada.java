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
        if (estaVacia()) {
            insertarListaVacia(item);
            return;
        }
        NodoDoble<T> nuevoNodo = new NodoDoble<>(item, cabeza, null);
        cabeza.setAntNodo(nuevoNodo);   
        cabeza = nuevoNodo;
        cantidad++;
    }
    //insertarAlFinal: Inserta en una lista un elemento al final
    public void insertarAlFinal(T item) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(item, null, ultimo);
        if (estaVacia()) insertarListaVacia(item);
        else {
            ultimo.setSgtNodo(nuevoNodo);
            ultimo = nuevoNodo;
            cantidad++;
        }
    }
    //intertarMedio: Inserta en una poscion media
    public void insertar(T item, int posicion) {
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
            
            cantidad++;
        }
    }
    
    public T ultimo() {
        T item = ultimo.getItem();
        return item;
    }

    public void eliminarAlInicio() {
        if (estaVacia()) 
            throw new RuntimeException("Error, La lista esta vacia!");
        if (longitud()==1) {
            cabeza = null;
            ultimo = null;
            cantidad--;
            return;
        }
        
        NodoDoble<T> aux = cabeza.getSgtNodo();
        cabeza = aux;
        cabeza.setAntNodo(null);
        cantidad--;
    }
    
    public void eliminarAlFinal() {
        if (estaVacia()) 
            throw new RuntimeException("Error, La lista esta vacia!");
        if (longitud()==1) {
            eliminarAlInicio();
            return;
        }
        
        NodoDoble<T> aux = ultimo.getAntNodo();
        aux.setSgtNodo(null);
        ultimo = aux;
        cantidad--;
    }
    
    public void eliminar(T dato) {
        if (estaVacia()) 
            throw new RuntimeException("Error, La lista esta vacia!");
        if (cabeza.getItem().equals(dato)) {
            eliminarAlInicio();
            return;
        }
        if (ultimo.getItem().equals(dato)) {
            eliminarAlFinal();
            return;
        }
        
        NodoDoble<T> aux = cabeza;
        NodoDoble<T> aux2;
        boolean encontrado = false;

        while (aux!=null && !encontrado) {
            T item = aux.getItem();
            if (item.equals(dato)) {
                encontrado = true;
                break;
            }
            aux = aux.getSgtNodo();
        }
        if (encontrado) {
            aux2 = aux.getSgtNodo();
            aux = aux.getAntNodo();
            aux.setSgtNodo(aux2);
            aux2.setAntNodo(aux);
            cantidad--;
        } else {
            System.err.println("Elemento no encontrado");
        }
    }

    public void intercambioInicioFin() {
        T itemC = cabeza.getItem();
        T itemU = ultimo.getItem();

        cabeza.setItem(itemU);
        ultimo.setItem(itemC);
    }

    public void invertir() {
        if (estaVacia()) 
            throw new RuntimeException("Error, La lista esta vacia!");

        NodoDoble<T> actual = cabeza;
        NodoDoble<T> temp = null;

        while (actual != null) {
            temp = actual.getAntNodo();

            actual.setAntNodo(actual.getSgtNodo());
            actual.setSgtNodo(temp);

            actual = actual.getAntNodo();
        }
    }
}