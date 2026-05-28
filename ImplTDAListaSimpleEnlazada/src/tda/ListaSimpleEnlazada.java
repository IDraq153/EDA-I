package tda;

public class ListaSimpleEnlazada<T> {
    // Atributos
    private Nodo<T> cabeza;
    
    // Metodos
    public ListaSimpleEnlazada(){
        cabeza = null;
    }
    /*
    * estaVacia: determina si la lista esta vacio o no
    */
    public boolean estaVacia(){
        /*if (cabeza==null)
            return true;
        else
            return false;
        */
        return cabeza==null;
    }
    /*
    * agregarAlFinal: agrega un item al final de la lista
    */
    public void agregarAlFinal(T item){
        Nodo<T> nuevoNodo = new Nodo<>(item,null);
        if (estaVacia())
            cabeza = nuevoNodo;
        else{
            Nodo<T> aux = cabeza;
            while(aux.getSgteNodo()!=null){
                aux = aux.getSgteNodo();
            }
            aux.setSgteNodo(nuevoNodo);
        }
    }
    /*
    *agregarAlInicio: agrega un item al inicio de la lista
    */
    public void agregarAlInicio(T item){
        Nodo<T> nuevNodo = new Nodo<>(item,null);
        if (estaVacia()) cabeza = nuevNodo;

        // 1, 2, 3 
        else {
            nuevNodo.setSgteNodo(cabeza);
            cabeza = nuevNodo;
        }
    }
    /*
    * Mostrar: imprime en pantalla todos los elementos de la lista
    */
    public void mostrar(){
        Nodo<T> aux = cabeza;
        while(aux!=null){
            System.out.print(aux.getItem()+"\t");
            aux = aux.getSgteNodo(); //
        }
        System.out.println();
    }
    /*
    * Longitud: devuelve la cantidad de elementos de la lista
    */
    public int longitud(){
        Nodo<T> aux = cabeza;
        int cont=0;
        while(aux!=null){
            // avanzamos nodo a nodo
            aux = aux.getSgteNodo();
            cont++;
        }
        return cont;
    }
    //iesimo: devuelve un item de la lista conociento su posicion
    public T iesimo(int pos){
        // Dias lluviosos situaciones excepcionales
        if(pos<1 || pos>longitud()){
            throw new RuntimeException("Error: La posicion no es valida!!");
        }        
        //Dias soleados - condiciones de normalidad
        int i=1;
        Nodo<T> aux = cabeza;
        while(i<pos){
            i++;
            aux = aux.getSgteNodo();
        }
        return aux.getItem();
    }
    /*
    * ubicacion: Similar a la busqueda la secuencial, y el metodo
    * devuelve la posicion de un item especifico.
    */
    public int ubicacion(T item){
        int pos = -1; // Cuando el elemento no esta en la lista
        int i = 1;
        boolean flag = false;
        Nodo<T> aux = cabeza;
        while(aux!=null && !flag){ // !flag el item aun no lo hemos encontrado
            if (aux.getItem().equals(item)){
                flag = true;
                pos = i;
            }
            i++;
            aux = aux.getSgteNodo();
        }
        return pos;
    }
    public void eliminar(int pos){
        if (pos<1 || pos>longitud())
            throw new RuntimeException("Error: posicion no valida!!");
        int i=1;
        
        if (pos == 1) cabeza = cabeza.getSgteNodo();
        
        else {
            Nodo<T> aux = cabeza;
            while(i<pos-1){
                i++;
                aux = aux.getSgteNodo();
            }
            Nodo<T> aux2 = aux;
            aux.setSgteNodo(aux2.getSgteNodo());
        }
    }
    /*
    * insertar: agrega un nuevo elemento en una posicion especifica
    */
    public void insertar(T item, int pos) {
        //1-> , 3-> , 5-> , 4-> , 6-> , __-> , 3->
        if (pos<1 || pos>longitud()+1)
            throw new RuntimeException("Error: posicion no valida!!");
        
        Nodo<T> nNodo = new Nodo<>(item,null);
        Nodo<T> aux = cabeza;
        Nodo<T> aux2;
        
        if (pos == 1) {
            nNodo.setSgteNodo(cabeza);
            cabeza = nNodo;
            return;
        } 
        
        int i = 1;
        while(i < pos - 1 ) {
            i++;
            aux = aux.getSgteNodo();
        } 
        aux2 = aux.getSgteNodo();
        aux.setSgteNodo(nNodo);
        
        nNodo.setSgteNodo(aux2);
    }
    /*
    *insertarDerecha: agrega un nodo y desplaza a la derecha
    */
    //1-> , 3-> , 5-> , 4-> , 6-> , __-> , 3->
    public void insertarDerecha(T item, int pos) {
        Nodo<T> nNodo = new Nodo<>(item,null);
        Nodo<T> aux = cabeza;
        Nodo<T> aux2;
        
        if (pos == 1) {
            nNodo.setSgteNodo(cabeza);
            cabeza = nNodo;
            return;
        } 
        
        int i = 1;
        while(i < pos) {
            i++;
            aux = aux.getSgteNodo();
        } 
        aux2 = aux.getSgteNodo();
        aux.setSgteNodo(nNodo);
        
        nNodo.setSgteNodo(aux2);
    }
    //sonIguales: verifica que 2 listas sean iguales en tamaño y elementos
    public boolean sonIguales(ListaSimpleEnlazada l1) {
        if (this.longitud() != l1.longitud()) return false;
        
        else {
            Nodo<T> aux = this.cabeza;
            Nodo<T> aux1 = l1.cabeza;
            
            while(aux!=null) {
                if (!aux.getItem().equals(aux1.getItem())) {
                    return false;
                }
                aux = aux.getSgteNodo();
                aux1 = aux1.getSgteNodo();
            }
            return true;
        }
    }
    public boolean sonIguales(ListaSimpleEnlazada l1, ListaSimpleEnlazada l2) {
        return l1.sonIguales(l2);
    }
    //invertirLista: invierte la lista de elementos
    public void invertir() {
        Nodo<T> anterior = null;
        Nodo<T> actual = cabeza;
        Nodo<T> siguiente;
        
        while (actual != null) {
            siguiente = actual.getSgteNodo();
            actual.setSgteNodo(anterior);
            
            anterior = actual;
            actual = siguiente;
        }
        cabeza = anterior;
    }
    //eliminarRepetidos: elimina items repetidos
    public void eliminarDuplicados() {
        Nodo<T> sel = cabeza;
        while (sel!=null) {
            Nodo<T> aux = sel.getSgteNodo();
            Nodo<T> ant = sel;
            
            while (aux!=null) {
                if (aux.getItem().equals(sel.getItem())) {
                    ant.setSgteNodo(aux.getSgteNodo());
                    aux = ant.getSgteNodo();
                } else {
                    ant = aux;
                    aux = aux.getSgteNodo();
                }
            }

            sel = sel.getSgteNodo();
        }
    }
    //concatena<rLista: une dos listas brindadas
    public void concatenarLista(ListaSimpleEnlazada lista) {
        // 1, 2, 3     4, 5, 6
        Nodo<T> aux = cabeza;
        while (aux.getSgteNodo()!=null) aux = aux.getSgteNodo();

        aux.setSgteNodo(lista.cabeza);
    }
} 
