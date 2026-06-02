package tda;

public class ColaPrioridad<T> {
    private NodoPrioridad<T> frente; // apunta al primer nodo
    private NodoPrioridad<T> ultimo;
    // Operacion para crear una cola
    public ColaPrioridad(){
        frente = null;
        ultimo = null;
    }
    public boolean estaVacia(){
        return frente == null;
    }
    // Encolar: agrega un item al final de la cola
    public void encolar(T item, int prioridad){
        NodoPrioridad<T> nuevoNodo = new NodoPrioridad(item,prioridad,null);
        if (estaVacia()){
            frente = nuevoNodo;
            ultimo = nuevoNodo;
        }else if(prioridad>frente.getPrioridad()){
            nuevoNodo.setSgteNodo(frente);
            frente = nuevoNodo;
        }else{
            NodoPrioridad<T> aux = frente;
            NodoPrioridad<T> ant = frente;
            while( aux!=null && aux.getPrioridad()>=prioridad){
                ant = aux;
                aux = aux.getSgteNodo();
            }
            nuevoNodo.setSgteNodo(aux);
            ant.setSgteNodo(nuevoNodo);
        }
    }
    // Desencolar: elimina el item que esta al frente de la cola y devuelve ese item
    public NodoPrioridad<T> desencolar(){
        if (estaVacia()){
            throw new RuntimeException("Error: la cola esta vacia!!!");
        }else{
            NodoPrioridad<T> aux = frente;
            frente = frente.getSgteNodo();
            return aux;            
        }
    }
            
}
