import java.util.Random;

public class Solucion23_SimuladorDados {
    static int d1=0, d2=0, d3=0; static volatile boolean corriendo=true;
    static synchronized void verificar(int id, int valor) {
        if(id==1) d1=valor; else if(id==2) d2=valor; else d3=valor;
        System.out.printf("Dado%d: %d%n",id,valor);
        if(d1>0 && d1==d2 && d2==d3) { System.out.println("TRES IGUALES! "+d1); corriendo=false; }
    }
    public static void main(String[] args) throws InterruptedException {
        Random r=new Random();
        Thread t1=new Thread(()->{ while(corriendo){ verificar(1,r.nextInt(6)+1); try{Thread.sleep(1000);}catch(Exception e){} } });
        Thread t2=new Thread(()->{ while(corriendo){ verificar(2,r.nextInt(6)+1); try{Thread.sleep(1000);}catch(Exception e){} } });
        Thread t3=new Thread(()->{ while(corriendo){ verificar(3,r.nextInt(6)+1); try{Thread.sleep(1000);}catch(Exception e){} } });
        t1.start(); t2.start(); t3.start(); t1.join(); t2.join(); t3.join();
    }
}
