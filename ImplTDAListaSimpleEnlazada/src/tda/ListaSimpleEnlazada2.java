package tda;

public class ListaSimpleEnlazada2<T> {
    // Atributos
    private Nodo<T> cabeza;
    private Nodo<T> ultimo;
    
    // Metodos
    public ListaSimpleEnlazada2(){
        cabeza = null;
        ultimo = null;
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
    * modifique para abstraerme junto al code
    */
    public void agregarAlFinal(T item){
        Nodo<T> nuevoNodo = new Nodo<>(item,null);

        if (estaVacia()){
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
        }
        
        else{
            ultimo.setSgteNodo(nuevoNodo);
            ultimo = nuevoNodo;
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
        
        Nodo<T> aux2 = cabeza;
        while(aux2!=null){
            // System.out.println("Dir de nuevo nodo:" + aux2 + " contiene:" + aux2.getItem() );
            // System.out.println("Dir de lo que apunta:" + aux2.getSgteNodo());


            aux2 = aux2.getSgteNodo(); //
        } System.out.println();

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
    public boolean sonIguales(ListaSimpleEnlazada2 l1) {
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
    public boolean sonIguales(ListaSimpleEnlazada2 l1, ListaSimpleEnlazada2 l2) {
        return l1.sonIguales(l2);
    }
    
    public double calcularPromedio(String x) {
        if (estaVacia()) return 0.0;

        Nodo<T> aux = cabeza;
        double suma = 0;
        int contador = 0;

        while (aux!=null) {
            Registro r = (Registro)aux.getItem(); // Casteo registro 
            if (r.getCodEstudiante().equals(x)) {
                suma += r.getNotaF();
                contador++;
            }
            aux = aux.getSgteNodo(); 
        }
        if (contador < 0) return 0.0; 

        double promedio = suma / contador;
        return promedio;
    }

    public void insertarNotaEs(String codEs, String codCur, double nota) {
        if (estaVacia()) agregarAlFinal((T) new Registro(codEs, codCur, nota));

        Nodo<T> aux = cabeza;
        while (aux!=null) {
            Registro r = (Registro) aux.getItem();

            // Caso alumno ya tiene nota en ese curso
            if (r.getCodEstudiante().equals(codEs) && r.getCodCurso().equals(codCur)) return;
            
            aux = aux.getSgteNodo();
        }

        agregarAlFinal((T) new Registro(codEs, codCur, nota));
        System.out.println("Ingresado con exito" + codEs + ", cod curso: " + codCur);
    }

    public void insertarArticulo(int code, int cant, float precioU) {
        Nodo<T> nuevo = (Nodo<T>) new Nodo<>(
                new Articulo(code, cant, precioU), null);

        if (estaVacia()) {
            cabeza = nuevo;
            return;
        }

        Articulo a = (Articulo) cabeza.getItem();
        if (a.getCode() == code) return;

        if (code < a.getCode()) {
            nuevo.setSgteNodo(cabeza);
            cabeza = nuevo;
            return;
        }

        Nodo<T> aux = cabeza;
        while (aux.getSgteNodo() != null) {

            Articulo sig = (Articulo) aux.getSgteNodo().getItem();
            if (sig.getCode() == code) return;
            if (code < sig.getCode()) break;
            aux = aux.getSgteNodo();
        }

        nuevo.setSgteNodo(aux.getSgteNodo());
        aux.setSgteNodo(nuevo);
    }

    public Articulo mayorVenta() {
        Nodo<Articulo> aux = (Nodo<Articulo>) cabeza;
        Articulo mayor = aux.getItem(); // el primero
        Articulo a;

        while (aux.getSgteNodo()!=null) {
            a = (Articulo) aux.getSgteNodo().getItem();

            if (mayor.getCant() < a.getCant()) {
                mayor = a;
            }
            aux = aux.getSgteNodo();
        }

        return mayor;
    } 

    public void eliminarMenorVenta() {

        if (estaVacia()) return;

        Nodo<Articulo> menor = (Nodo<Articulo>) cabeza;
        Nodo<Articulo> antMenor = null;
        Nodo<Articulo> ant = null;
        Nodo<Articulo> aux = (Nodo<Articulo>) cabeza;

        while (aux != null) {

            if (aux.getItem().getCant() < menor.getItem().getCant()) {
                menor = aux;
                antMenor = ant;
            }

            ant = aux;
            aux = aux.getSgteNodo();
        }

        if (antMenor == null)
            cabeza = cabeza.getSgteNodo();
        else
            antMenor.setSgteNodo(menor.getSgteNodo());
    }
}
