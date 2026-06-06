package ejercicios;
import tda.Articulo;
import tda.ListaSimpleEnlazada2;
import tda.Registro;

public class Ejercicio17 {
    public static void main(String[] args) {
        ListaSimpleEnlazada2<Registro> listaAlumno = new ListaSimpleEnlazada2<>();
        Registro r1 = new Registro("A123", "H5", 15);
        Registro r2 = new Registro("A123", "C1", 18);
        
        listaAlumno.agregarAlFinal(r1);
        listaAlumno.agregarAlFinal(r2);
        listaAlumno.insertarNotaEs("A123", "I2", 20);
        
        listaAlumno.mostrar();
        System.out.println(listaAlumno.calcularPromedio("A123"));
        
        System.out.println("---------------------------------------------------");
        ListaSimpleEnlazada2<Articulo> listaArticulo = new ListaSimpleEnlazada2<>();
        Articulo a1 = new Articulo(2, 12, 12.5f);
        Articulo a2 = new Articulo(5, 100, 12.5f);

        listaArticulo.agregarAlFinal(a1);
        listaArticulo.agregarAlFinal(a2);

        listaArticulo.insertarArticulo(3, 120, 2f);
        listaArticulo.insertarArticulo(1, 11, 2f);
        listaArticulo.insertarArticulo(11, 15, 2f);
        
        listaArticulo.mostrar();
        listaArticulo.eliminarMenorVenta();
        listaArticulo.mostrar();
        System.out.println(listaArticulo.mayorVenta().getCode());
    }    
}
