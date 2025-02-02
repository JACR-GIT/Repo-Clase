public class Test {
    public static void main(String[] args) {
        Persona p = new PersonaImpl("Tira", "De esta", "1234567K", 98);
        Fecha f = new FechaImpl(14,07,2024);
        Vuelo v = new VueloImpl("IB2349","Madrid",10.31,200, 170, f, p);

        System.out.println(v);
    }
}
