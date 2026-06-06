package tda;

public class Articulo {
    private int code;
    private int cant;
    private float precioU;

    public Articulo(int code, int cant, float precioU) {
        this.code = code;
        this.cant = cant;
        this.precioU = precioU;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public float getPrecioU() {
        return precioU;
    }

    public void setPrecioU(float precioU) {
        this.precioU = precioU;
    }

    @Override
    public String toString() {
        return "Articulo [code=" + code + ", cant=" + cant + ", precioU=" + precioU + "]";
    }
}
