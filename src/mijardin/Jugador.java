package mijardin;

public class Jugador {

    // Atributos
    private String usuario;
    private int plantsTotal;
    private int sanas;
    private int marchitas;
    private int muertas;

    // Constructor
    public Jugador(String usuario, int plantsTotal, int sanas, int marchitas, int muertas) {
        this.usuario = usuario;
        this.plantsTotal = plantsTotal;
        this.sanas = sanas;
        this.marchitas = marchitas;
        this.muertas = muertas;
    }

    // Getters y Setters
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public int getPlantsTotal() {
        return plantsTotal;
    }
    
    public void setPlantsTotal(int plantsTotal) {
        this.plantsTotal = plantsTotal;
    }
    
    public int getSanas() {
        return sanas;
    }
    
    public void setSanas(int sanas) {
        this.sanas = sanas;
    }
    
    public int getMarchitas() {
        return marchitas;
    }
    
    public void setMarchitas(int marchitas) {
        this.marchitas = marchitas;
    }
    
    public int getMuertas() {
        return muertas;
    }
    
    public void setMuertas(int muertas) {
        this.muertas = muertas;
    }

    // Metodos Propios
    public void estadoPlantas(Planta[] jardin, int plantsTotal) {
        int contSanas = 0;
        int contMarchitas = 0;
        int contMuertas = 0;
        for (int i = 0; i < plantsTotal; i++) {
            String estadoActual = jardin[i].getEstado();
            if (estadoActual.equalsIgnoreCase("sana")) {
                contSanas++;
            } else if (estadoActual.equalsIgnoreCase("marchita")) {
                contMarchitas++;
            } else if (estadoActual.equalsIgnoreCase("muerta")) {
                contMuertas++;
            }
        }
        this.sanas = contSanas;
        this.marchitas = contMarchitas;
        this.muertas = contMuertas;
    }
    
    public int saludJardin(Planta[] jardin, int plantsTotal) {
        int puntosSana = 0;
        int puntosMarchita = 0;
        int puntosMuerta = 0;
        
        for (int i = 0; i < plantsTotal; i++) {
            String estadoActual = jardin[i].getEstado();
            
            if (estadoActual.equalsIgnoreCase("sana")) {
                puntosSana += 10;
            } else if (estadoActual.equalsIgnoreCase("marchita")) {
                puntosMarchita += 6;
            } else {
                puntosMuerta -= 5;
            }
        }
        int porcentaje = ((puntosSana + puntosMarchita + puntosMuerta)*10) / plantsTotal;
        return porcentaje;
    }
    
    @Override
    public String toString() {
        return "- Jugador: " + usuario
                + "\n- Plantas Totales: " + plantsTotal
                + "\n- Plantas Sanas: " + sanas
                + "\n- Plantas Marchitas: " + marchitas
                + "\n- Plantas Muertas: " + muertas;
    }
}
