package test;

import tda.Alumno;
import tda.ArbolBinario;
import tda.NodoA;

public class pruebaArbol3 {
    public static void main(String[] args) {
        Alumno a = new Alumno("Juan", 1, 12.3f);
        Alumno b = new Alumno("Pepe", 2, 13.3f);
        Alumno c = new Alumno("Manolo", 3, 15.3f);
        Alumno d = new Alumno("Dario", 4, 19.3f);
        Alumno mayor;
        ArbolBinario<Alumno> ab = new ArbolBinario<>();
        NodoA<Alumno> r = ab.creaRaiz(a);
        NodoA<Alumno> primD = ab.agregarHijoDer(r, b);
        NodoA<Alumno> secD = ab.agregarHijoDer(primD, d);
        NodoA<Alumno> primI = ab.agregarHijoIzq(r, c);
        
        ab.remplazoProm("Dario", 2f);
        System.out.println(d.getPromedio());
        mayor = ab.promMasAlto();
        System.out.println("Nombre: " + mayor.getNom() + " / Prom: " + mayor.getPromedio());
    }
}
