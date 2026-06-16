package tda;

public class ListaSimpleEnlazadaR<T> {
    // Atributos
    private Nodo<T> cabeza;
    private Nodo<T> ultimo;

    // Metodos
    public ListaSimpleEnlazadaR() {
        cabeza = null;
        ultimo = null;
    }

    /*
     * estaVacia: determina si la lista esta vacio o no
     */
    public boolean estaVacia() {
        /*
         * if (cabeza==null)
         * return true;
         * else
         * return false;
         */
        return cabeza == null;
    }

    /*
     * agregarAlFinal: agrega un item al final de la lista
     * modifique para abstraerme junto al code
     */
    public void agregarAlFinal(T item) {
        Nodo<T> nuevoNodo = new Nodo<>(item, null);

        if (estaVacia()) {
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
        }

        else {
            ultimo.setSgteNodo(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }

    /*
     * Longitud: devuelve la cantidad de elementos de la lista
     */
    public int longitud() {
        Nodo<T> aux = cabeza;
        int cont = 0;
        while (aux != null) {
            // avanzamos nodo a nodo
            aux = aux.getSgteNodo();
            cont++;
        }
        return cont;
    }

    // iesimo: devuelve un item de la lista conociento su posicion
    public T iesimo(int pos) {
        // Dias lluviosos situaciones excepcionales
        if (pos < 1 || pos > longitud()) {
            throw new RuntimeException("Error: La posicion no es valida!!");
        }
        // Dias soleados - condiciones de normalidad
        int i = 1;
        Nodo<T> aux = cabeza;
        while (i < pos) {
            i++;
            aux = aux.getSgteNodo();
        }
        return aux.getItem();
    }

    /*
     * ubicacion: Similar a la busqueda la secuencial, y el metodo
     * devuelve la posicion de un item especifico.
     */
    public int ubicacion(T item) {
        int pos = -1; // Cuando el elemento no esta en la lista
        int i = 1;
        boolean flag = false;
        Nodo<T> aux = cabeza;
        while (aux != null && !flag) { // !flag el item aun no lo hemos encontrado
            if (aux.getItem().equals(item)) {
                flag = true;
                pos = i;
            }
            i++;
            aux = aux.getSgteNodo();
        }
        return pos;
    }

    public void eliminar(int pos) {
        if (pos < 1 || pos > longitud())
            throw new RuntimeException("Error: posicion no valida!!");

        int i = 1;

        if (pos == 1)
            cabeza = cabeza.getSgteNodo();

        else {
            Nodo<T> aux = cabeza;
            while (i < pos - 1) {
                aux = aux.getSgteNodo();
                i++;
            }
            Nodo<T> aux2 = aux.getSgteNodo();
            aux.setSgteNodo(aux2.getSgteNodo());
            if (pos == longitud()) { // posicion del ultimo
                ultimo = aux;
            }
        }

    }

    /*
     * insertar: agrega un nuevo elemento en una posicion especifica
     */
    public void insertar(T item, int pos) {
        // 1-> , 3-> , 5-> , 4-> , 6-> , __-> , 3->
        if (pos < 1 || pos > longitud() + 1)
            throw new RuntimeException("Error: posicion no valida!!");

        Nodo<T> nNodo = new Nodo<>(item, null);
        Nodo<T> aux = cabeza;
        Nodo<T> aux2;

        if (pos == 1) {
            nNodo.setSgteNodo(cabeza);
            cabeza = nNodo;
            return;
        }

        int i = 1;
        while (i < pos - 1) {
            i++;
            aux = aux.getSgteNodo();
        }
        aux2 = aux.getSgteNodo();
        aux.setSgteNodo(nNodo);

        nNodo.setSgteNodo(aux2);
    }

    /*
     * insertarDerecha: agrega un nodo y desplaza a la derecha
     */
    // 1-> , 3-> , 5-> , 4-> , 6-> , __-> , 3->
    public void insertarDerecha(T item, int pos) {
        Nodo<T> nNodo = new Nodo<>(item, null);
        Nodo<T> aux = cabeza;
        Nodo<T> aux2;

        if (pos == 1) {
            nNodo.setSgteNodo(cabeza);
            cabeza = nNodo;
            return;
        }

        int i = 1;
        while (i < pos) {
            i++;
            aux = aux.getSgteNodo();
        }
        aux2 = aux.getSgteNodo();
        aux.setSgteNodo(nNodo);

        nNodo.setSgteNodo(aux2);
    }

    public int obtenerTamano() {
        return contadorRecursivo(cabeza);
    }
    private int contadorRecursivo(Nodo<T> actual) {
        if (actual == null) {
            return 0;
        } else {
            return 1 + contadorRecursivo(actual.getSgteNodo());
        }
    }

    public void mostrarRec() {
        mostrarRecursividad(cabeza);
    }
    private void mostrarRecursividad(Nodo<T> actual) {
        if (actual != null) {
            System.out.print(actual.getItem() + "\t");
            mostrarRecursividad(actual.getSgteNodo());
        }
    }

    public void mostrarIesimo(int indice) {
        System.out.println(recMostrarIesimo(indice, cabeza));
    }
    private String recMostrarIesimo(int indice, Nodo<T> actual) {
        if (actual == null)
            return "Null";
        if (indice == 0) 
            return actual.getItem().toString();
        else {
            return recMostrarIesimo(indice - 1, actual.getSgteNodo());
        }
    }   

    
}
