public class Main {
    public static void main(String[] args) {
        Harcos harcos = new Harcos("Harcos", 10, 0, 0);
        Varazslo varazslo = new Varazslo("Varázsló", 10, 2, 2);

        Thread harcosSzal = new Thread(() -> {
            while (harcos.eletero.get() > 0 && varazslo.eletero.get() > 0) {
                harcos.mozgas();
                harcos.harcol(varazslo);
                try {
                    int varakozasiIdo = Math.round((float)Math.random() * 1000);
                    Thread.sleep(varakozasiIdo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread varazsloSzal = new Thread(() -> {
            while (harcos.eletero.get() > 0 && varazslo.eletero.get() > 0) {
                varazslo.mozgas();
                varazslo.harcol(harcos);
                try {
                    int varakozasiIdo = Math.round((float)Math.random() * 1000);
                    Thread.sleep(varakozasiIdo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        harcosSzal.start();
        varazsloSzal.start();
    }
}
