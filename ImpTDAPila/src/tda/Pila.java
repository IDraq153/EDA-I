package tda;

public class Pila<T> {
    private Nodo<T> cima;

    public Pila() {
        cima = null;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    // apilar: agrega un item en la cima de la pila
    public void apilar(T item) {
        Nodo<T> nuevoNodo = new Nodo<>(item, null);
        if (estaVacia()) {
            cima = nuevoNodo;
        } else {
            nuevoNodo.setSgteNodo(cima);
            cima = nuevoNodo;
        }
    }

    // desapilar: extrae el item de la cima de la pila devuelve el item
    public T desapilar() {
        if (estaVacia())
            throw new RuntimeException("Error: Pila vacia!!");
        T item = cima.getItem();
        cima = cima.getSgteNodo();
        return item;
    }

    public void mostrar() {
        Pila<T> aux = new Pila<>();
        while (!this.estaVacia()) {
            T item = this.desapilar();
            System.out.println(item);
            aux.apilar(item);
        }
        while (!aux.estaVacia())
            this.apilar(aux.desapilar());
    }

    public int contarElementos() {
        Pila<T> aux = new Pila<>();
        int contador = 0;

        while (!this.estaVacia()) {
            aux.apilar(this.desapilar());
            contador++;
        }
        while (!aux.estaVacia())
            this.apilar(aux.desapilar());
        return contador;
    }

    public boolean encontrar(T item) {
        Pila<T> aux = new Pila<>();
        boolean flag = false;

        while (!this.estaVacia()) {
            T elem = this.desapilar();
            aux.apilar(elem);
            if (item == elem) {
                flag = true;
                break;
            }
        }
        while (!aux.estaVacia())
            this.apilar(aux.desapilar());
        return flag;
    }

    public void invertir() {
        Pila<T> aux1 = new Pila<>();
        Pila<T> aux2 = new Pila<>();

        while (!this.estaVacia())
            aux1.apilar(this.desapilar());
        while (!aux1.estaVacia())
            aux2.apilar(aux1.desapilar());
        while (!aux2.estaVacia())
            this.apilar(aux2.desapilar());
    }
}
