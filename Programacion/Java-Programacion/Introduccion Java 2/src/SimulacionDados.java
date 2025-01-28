public class SimulacionDados {
    public static void main(String[] args) {

        int Suma = 0;

        while ((Suma) != 7){
            int NumDado1 = (int) (Math.random() * 6) + 1;
            System.out.println("Dado numero 1: " + NumDado1);
            int NumDado2 = (int) (Math.random() * 6) + 1;
            System.out.println("Dado numero 2: " + NumDado2);

            Suma = NumDado1 + NumDado2;
            System.out.println(Suma);
        }
    }
}
