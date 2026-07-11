package tda;

public class Alumno implements Comparable<Alumno>{
    private String nom;
    private int cod;
    private float promedio;

    public Alumno() {
        nom = "";
        cod = 0;
        promedio = 0;
    }
    public Alumno(String nom, int cod, float promedio) {
        this.nom = nom;
        this.cod = cod;
        this.promedio = promedio;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getCod() {
        return cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }
    public float getPromedio() {
        return promedio;
    }
    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }
    @Override
    public int compareTo(Alumno otro) {
          return this.nom.compareTo(otro.nom);
    }
}
