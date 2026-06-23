
package tdaBi;

public class Nodo<T> {
    // Atributos
    private T item;
    private Nodo<T> sgteNodo;
    // Metodos
    public Nodo(){
        // inicializar atributos
        item = null;
        sgteNodo = null;
    }
    public Nodo(T item, Nodo<T> sgteNodo){
        this.item = item;
        this.sgteNodo = sgteNodo;
    }
    // Getter and Setter --> Accesadores // Modificadores
    public void setItem(T item){
        this.item = item;
    }
    public T getItem(){
        return item;
    }
    public Nodo<T> getSgteNodo(){
        return sgteNodo;
    }
    public void setSgteNodo(Nodo<T> sgteNodo){
        this.sgteNodo = sgteNodo;
    }
    
}