package tda;

public class BiCola<T> {
    private Nodo<T> frente; // apunta al primer nodo
    private Nodo<T> ultimo;
    // Operacion para crear una cola
    public BiCola(){
        frente = null;
        ultimo = null;
    }
    public boolean estaVacia(){
        return frente == null;
    }
    // Encolar: agrega un item al final de la cola
    public void encolar(T item){
        Nodo<T> nuevoNodo = new Nodo(item,null);
        if (estaVacia()){
            frente = nuevoNodo;
            ultimo = nuevoNodo;
        }else{
            ultimo.setSgteNodo(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }
    
    // Encolar: agrega un item al frente de la cola
    public void encolarFrente(T item){
        Nodo<T> nuevoNodo = new Nodo(item,null);
        if (estaVacia()){
            frente = nuevoNodo;
            ultimo = nuevoNodo;
        }else{
            nuevoNodo.setSgteNodo(frente);
            frente = nuevoNodo;
        }
    }
    // Desencolar: elimina el item que esta al frente de la cola y devuelve ese item
    public T desencolar(){
        if (estaVacia()){
            throw new RuntimeException("Error: la cola esta vacia!!!");
        }else{
            T itemAux = frente.getItem();
            frente = frente.getSgteNodo();
            return itemAux;            
        }
    }
    // Desencolar: elimina el item que esta al frente de la cola y devuelve ese item
    public T desencolar_final(){
        if (estaVacia()){
            throw new RuntimeException("Error: la cola esta vacia!!!");
        }else{
            Nodo<T> aux = frente;
            while (aux.getSgteNodo()!=ultimo){
                aux = aux.getSgteNodo();
            }
            T itemAux = ultimo.getItem();
            aux.setSgteNodo(null);
            ultimo = aux;
            return itemAux;            
        }
    }        
}
