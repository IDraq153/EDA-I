package ejercicios;
import tda.ListaSimpleEnlazada2;
import tda.Registro;

public class Ejercicio17 {
    public static void main(String[] args) {
        ListaSimpleEnlazada2<Registro> listaAlumno = new ListaSimpleEnlazada2<>();
        Registro r1 = new Registro("A123", "H5", 15);
        Registro r2 = new Registro("A123", "C1", 18);

        listaAlumno.agregarAlFinal(r1);
        listaAlumno.agregarAlFinal(r2);
        listaAlumno.mostrar();
        System.out.println(listaAlumno.calcularPromedio("A123"));
    }    
}
