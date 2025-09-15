import java.util.Random;

public class Probabilidades {
    Random ran=new Random();
    
   
    int numEnemigos=0;
    int numPuertas=1;
    int numParedes;
    public boolean prob1(){
        int prob = ran.nextInt(100);
        if (prob>50){
            return false;
        }else{
            return true;
        }
    }

    public int probEnemigos(){
        
        int prob = ran.nextInt(100);
        if (prob<75){numEnemigos=1;}
        if(prob<25){numEnemigos=2;}
        if(prob<10){numEnemigos=3;}
        if(prob<2){numEnemigos=4;}
        return numEnemigos;
    }
    public int probMuros(){
        int prob = ran.nextInt(100);
        if (prob<75){numParedes=1;}
        if(prob<25){numParedes=2;}
        if(prob<10){numParedes=3;}
        if(prob<2){numParedes=4;}
        return numParedes;
    }


    public int probPuertas(){
        int prob = ran.nextInt(100);
        if(prob<60){numPuertas=1;}
        else if(prob<40){numPuertas=2;}
        else if(prob<20){numPuertas=3;}
        return numPuertas;
    }
}
