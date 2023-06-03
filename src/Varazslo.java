public class Varazslo extends Karakter {
    public Varazslo(String nev, int eletero, int pozicioX, int pozicioY) {
        super(nev, eletero, pozicioX, pozicioY);
    }

    @Override
    public void run() {
        while (eletero.get() > 0) {
            mozgas();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
