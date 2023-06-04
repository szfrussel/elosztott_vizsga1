public class Harcos extends Karakter {
    public Harcos(String nev, int eletero, int pozicioX, int pozicioY) {
        super(nev, eletero, pozicioX, pozicioY);
    }

    @Override
    public void run() {
        while (eletero.get() > 0) {
            mozgas();
            try {
                int varakozasiIdo = Math.round((float)Math.random() * 100);
                Thread.sleep(varakozasiIdo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
