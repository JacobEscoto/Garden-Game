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
    
    // Getters
    public String getUsuario () {
        return usuario;
    }
    public int getPlantsTotal () {
        return plantsTotal;
    }
    public int getSanas() {
        return sanas;
    }
    public int getMarchitas() {
        return marchitas;
    }
    public int getMuertas() {
        return muertas;
    }
}
