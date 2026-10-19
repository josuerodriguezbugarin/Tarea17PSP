public class Contador { //comparte todos los hilos
    private int valor = 0;
    private final Object miLock = new Object(); //candado
    public synchronized void incrementar() {
        valor++;
    }
    public int getValor() {
        return valor;
    }
}