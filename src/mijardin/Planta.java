package mijardin;

public class Planta {
    
    // Atributos
    private String nombre;
    private String especie;
    private int ultimoRiego;
    private int crecimiento;
    private String estado;
    
    // Constructor
    public Planta(String nombre, String especie, int ultimoRiego, int crecimiento, String estado) {
        this.nombre = nombre;
        this.especie = especie;
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
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
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
            this.crecimiento++;
        }
    }
    
    public void nextDay() {
        this.ultimoRiego++;
        if(ultimoRiego == 3) {
            this.estado = "Marchita";
        } else if (ultimoRiego > 3) {
            this.estado = "Muerta";
        } else {
            this.estado = "Sana";
        }
    }
    
    @Override
    public String toString() {
       return "Planta{"+
               "Nombre: " +nombre+ '\''+
               ", Especie: " + especie +
               ", Ultimo Dia de Riego: " + ultimoRiego + '\'' +
               ", Crecimiento: " + crecimiento + '\'' +
               ", Estado: " + estado + '\'' +
               '}';
    }
}
