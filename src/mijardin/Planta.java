package mijardin;

public class Planta {

    // Atributos
    private String nombre;
    private String tipo;
    private int ultimoRiego;
    private int crecimiento;
    private String estado;

    // Constructor
    public Planta(String nombre, String tipo, int ultimoRiego, int crecimiento, String estado) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ultimoRiego = ultimoRiego;
        this.crecimiento = crecimiento;
        this.estado = "Sana";
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setEspecie(String tipo) {
        this.tipo = tipo;
    }

    public int getUltimoRiego() {
        return ultimoRiego;
    }

    public void setUltimoRiego(int ultimoRiego) {
        this.ultimoRiego = ultimoRiego;
    }

    public int getCrecimiento() {
        return crecimiento;
    }

    public void setCrecimiento(int crecimiento) {
        this.crecimiento = crecimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Metodos
    public void regar() {
        this.ultimoRiego = 0;
        if (!estado.equalsIgnoreCase("muerta")) {
            if (this.crecimiento <= 100) {
                this.crecimiento++;
            } else {
                System.out.println("El crecimiento de la planta ha alcanzado su maximo!");
            }
            this.estado = "Sana";
        }
    }

    public void nextDay() {
        this.ultimoRiego++;
        if (ultimoRiego == 3) {
            this.estado = "Marchita";
        } else if (ultimoRiego > 3) {
            this.estado = "Muerta";
        } else {
            this.estado = "Sana";
        }
    }

    @Override
    public String toString() {
        return "- Nombre: " + nombre
                + "\n- Tipo: " + tipo
                + "\n- Ultimo Dia de Riego: " + ultimoRiego
                + "\n- Crecimiento: " + crecimiento
                + "\n- Estado: " + estado;
    }
}
