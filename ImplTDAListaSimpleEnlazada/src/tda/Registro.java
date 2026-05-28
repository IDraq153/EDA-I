package tda;

public class Registro {
    // atributos
    private String CodEstudiante;
    private String CodCurso;
    private double NotaF;
    
    // constructor
    public Registro(String CodEstudiante, String CodCurso, double NotaF) {
        this.CodEstudiante = CodEstudiante;
        this.CodCurso = CodCurso;
        this.NotaF = NotaF;
    }
    
    // getters and setters
    public String getCodEstudiante() {
        return CodEstudiante;
    }
    public String getCodCurso() {
        return CodCurso;
    }
    public double getNotaF() {
        return NotaF;
    }

    // operaciones
    // este metodo permite mostrar todos los datos de cada registro que se encuentro en un Nodo
    @Override
    public String toString() {
        return "[ " + CodEstudiante + ", " + NotaF + ", " + CodCurso + " ]";
    }
    
}
