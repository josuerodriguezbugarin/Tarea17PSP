public class Consonantes extends Thread {

    private char consonante;
    private String texto;
    private Contador contadorCompartido;
    private int conteoPropio = 0;

    public Consonantes(char consonante, String texto, Contador contadorCompartido) {
        this.consonante = consonante;
        this.texto = texto;
        this.contadorCompartido = contadorCompartido;
    }
    public char getConsonante() {
        return consonante;
    }
    public int getConteoPropio() {
        return conteoPropio;
    }

    @Override
    public void run() {
        char letraBuscar = Character.toLowerCase(consonante);
        for (int i = 0; i < texto.length(); i++) {
            if (Character.toLowerCase(texto.charAt(i)) == letraBuscar) {
                conteoPropio++; //incrementar
                contadorCompartido.incrementar();
            }
        }
    }
}