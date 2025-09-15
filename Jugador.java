public class Jugador {
    private int salud;
    private int daño;
    private int defensa;
    private String estado;
    int[] jugador=new int[1];
    public Jugador(int ps, int dmg,int def ,String stat){
        this.salud=ps;
        this.daño=dmg;
        this.defensa=def;
        this.estado=stat;
    }

    public int getSalud(){
        return salud;
    }

    public int getDaño(){
        return daño;
    }    
    
    public int getDef(){
        return defensa;
    }
    
    public String getStat(){
        return estado;
    }

    public String PStoString(){
        return "PS: "+salud;
    }
    public String DMGtoString(){
        return "DMG: "+daño;
    }
    public String DEFtoString(){
        return "DEF: "+defensa;
    }
    public String STATtoString(){
        return "STATE: "+estado;
    }
}
