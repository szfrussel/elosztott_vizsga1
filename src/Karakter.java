import java.util.concurrent.atomic.AtomicInteger;

public abstract class Karakter implements Runnable {
    protected String nev;
    protected AtomicInteger eletero;
    protected AtomicInteger pozicioX;
    protected AtomicInteger pozicioY;

    public Karakter(String nev, int eletero, int pozicioX, int pozicioY) {
        this.nev = nev;
        this.eletero = new AtomicInteger(eletero);
        this.pozicioX = new AtomicInteger(pozicioX);
        this.pozicioY = new AtomicInteger(pozicioY);
    }

    public void mozgas() {
        // Véletlenszerű mozgás, a pozíció -1, 0, vagy +1-gyel változik
        pozicioX.getAndAdd((int) (Math.random() * 3) - 1);
        pozicioY.getAndAdd((int) (Math.random() * 3) - 1);

        // ha kilépne a pályáról "körbe megy"
        if(pozicioX.get() == 3) {pozicioX.set(0);}
        if(pozicioY.get() == 3) {pozicioY.set(0);}
        if(pozicioX.get() == -1) {pozicioX.set(2);}
        if(pozicioY.get() == -1) {pozicioY.set(2);}

        System.out.println(nev + " mozog, új pozíció: (" + pozicioX + ", " + pozicioY + ")");
    }

    public void harcol(Karakter ellenfel) {
        if (pozicioX.get() == ellenfel.pozicioX.get() && pozicioY.get() == ellenfel.pozicioY.get()) {
            int sebzes = (int) (Math.random() * 4);
            eletero.addAndGet(-sebzes);
            System.out.println(nev + " harcol " + ellenfel.nev + "-val, sebzés: " + sebzes);
            System.out.println((nev + " életerő: " + eletero + " " + ellenfel.nev + " életerő: " + ellenfel.eletero));
        }
    }
}
