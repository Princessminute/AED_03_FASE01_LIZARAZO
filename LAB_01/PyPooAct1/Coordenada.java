package LAB_01.PyPooAct1;
import java.util.*;

public class Coordenada {
    
    private double x;
    private double y;

    public Coordenada(){
        this.x = 0;
        this.y = 0;
    }

    public Coordenada(Coordenada c) {
        this.x = c.x;
        this.y = c.y;
    }

    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }

    public double getX(){
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double distancia(Coordenada c){
        return Math.sqrt(Math.pow(c.x - this.x, 2)+ Math.pow(c.y-this.y, 2));
    } 

    public double distancia(Coordenada c1, Coordenada c2){

        return Math.sqrt(Math.pow(c2.x - c1.x, 2) + Math.pow(c2.y - c1.y, 2)); 
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";

    }    

}
