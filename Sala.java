import java.util.Random;

public class Sala {
    Random ran =new Random();
    Probabilidades prob= new Probabilidades();
    int sala[][];
    int espacio[][];
    int largo;
    int ancho;
    int numEnemigos=prob.probEnemigos();
    int numParedes=ran.nextInt(3)+2;
    Sala arriba;
    Sala abajo;
    Sala der;
    Sala izq;
    int temp;
    int puertas=prob.probPuertas();
    int IdEnemigo=5;
    
    
    
    public Sala(){
        do{
            colocarParedes();
            colocarMuros();
        }
        while(!checkConnectividad());
            
        
        
        colocarEnemigos();
        colocarJugador();
        printSala();

        
    }
    
    private void colocarParedes(){
        largo =ran.nextInt(9)+8 ;
        ancho =ran.nextInt(9)+8 ;
        sala = new int[largo][ancho];
        espacio = new int[largo-1][ancho-1];
        for(int i = 0; i < largo; i++){
            for(int j = 0; j < ancho; j++){
                if(i == 0||i == largo-1||j == 0||j == ancho-1){
                    sala[i][j] = -1;
                }
            }
        }
    }

    private void colocarPuertas(){
        

        for(int i = 0; i < largo; i++){
            for(int j = 0; j < ancho; j++){
                if(i == 0||i == largo/2||j == 0||j == ancho-1){
                    sala[i][j] = 0;
                    break;
                }
            }
        }
    }
    
    private void colocarJugador(){
        int x=ran.nextInt(ancho-2)+1;
        int y=ran.nextInt(largo-2)+1;
        if (sala[x][y]==0){
            sala[x][y]=1;
        }else if (sala[x][y]!=0&&){}
    }
    
    private int  vaciosAdyacentes(int x, int y){
        if (sala[y+1][x]==0){return true;} //abajo
        else if (sala[y-1][x]==0){return true;} //arriba
        else if (sala[y][x+1]==0){return true;} //derecha
        else if (sala[y][x-1]==0){return true;} //izquierda
        else if (sala[y-1][x-1]==0){return true;} //izq arriba
        else if (sala[y+1][x-1]==0){return true;} //der abajo
        else if (sala[y][x-1]==0){return true;}
        else{return false;}
    }
    
    
    
    public void printSala()
    {
        for(int i = 0; i < largo; i++)
        {
            for(int j = 0; j < ancho; j++)
            {
                if(sala[i][j] == -1 || espacio[i][j]==-1) {
                    System.out.print("#");
                } else if(sala[i][j] == 0) {
                    System.out.print(" ");
                } else if(sala[i][j] == 1) {
                    System.out.print("@");
                } else if( sala[i][j]== 5) {
                    System.out.print("E");
                } else if(10 < sala[i][j] && sala[i][j] <= 20 && sala[i][j] % 3 == 0) {
                    System.out.print("I");
                }else if(sala[i][j] == 20 ) {
                    System.out.print("A");
                }else if(20 < sala[i][j] && sala[i][j] <= 25) {
                    System.out.print("+");
                }
            }
            System.out.println();
        }
    }


    public void colocarEnemigos(){
        
        int x=ran.nextInt(ancho-2)+1;
        int y=ran.nextInt(largo-2)+1;
        if (sala[y][x]==0 && numEnemigos>0){
            sala[y][x]=5;
            numEnemigos=numEnemigos-1;
        }else if (sala[y][x]!=0 && numEnemigos>0){
            colocarEnemigos();
        }
        if (numEnemigos>0){
            colocarEnemigos();
        }
    }
        
        
    

    public int recorrerSala(int ID){
        
        for (int i=1;i<(largo-1);i++){
            for (int j=1;j<(ancho-1);j++){
                if(sala[j][i]==ID){
                    return temp=sala[j][i];
                }
            }
        }
        return temp=-1;
    }



    public void colocarMuros(){
        int x=ran.nextInt(ancho-2)+1;
        int y=ran.nextInt(largo-2)+1;
        int dir=ran.nextInt(2);
        int muro=ran.nextInt(3)+2;

        if (dir==0){
            if (x+muro<ancho-1){
                for (int i=0;i<muro;i++){espacio[y][x+i]=-1;}
            }else if (y-muro>=0){
                for (int i=0;i<muro;i++){espacio[y-i][x]=-1;}
            }
        }else if (dir==1){
            if (x-muro>=0){
                for (int i=0;i<muro;i++){espacio[y][x-i]=-1;}
            }else if (y+muro<largo-1){
                for (int i=0;i<muro;i++){espacio[y+i][x]=-1;}
            }
        }


        if (numParedes>0){
            numParedes=numParedes-1;
            colocarMuros();
        }
    }
    private Boolean checkConnectividad()
    {
        int vacio = 0;
        for(int i = 0; i < largo; i++)
        {
            for(int j = 0; j < ancho; j++)
            {
                if(sala[i][j] == 0)
                {
                    vacio++;
                }
            }
        }
        int x, y;
        do
        {
            x = ran.nextInt(ancho-2)+1;
            y = ran.nextInt(largo-2)+1;
        } while(sala[y][x] != 0);
        boolean[][] verificado = new boolean[largo][ancho];
        int contador = floodFillContador(verificado, x, y);
        if(contador == vacio)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private int floodFillContador(boolean[][] verificado, int x, int y)
    {
        if (x < 0 || x >= sala.length || y < 0 || y >= sala[0].length || sala[x][y] != 0 || verificado[x][y]) {
            return 0;
        }
    
        verificado[x][y] = true;
        int contador = 1;

        contador += floodFillContador(verificado, x + 1, y);
        contador += floodFillContador(verificado, x - 1, y);
        contador += floodFillContador(verificado, x, y + 1);
        contador += floodFillContador(verificado, x, y - 1);
    
        return contador;
    }
    
}
