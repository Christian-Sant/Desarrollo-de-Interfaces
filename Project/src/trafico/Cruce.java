package trafico;

public class Cruce {

    public static void main(String[] args) {

        Semaforo semaforo = new Semaforo();

        Coche c1 = new Coche("1111AAA", semaforo);
        Coche c2 = new Coche("2222BBB", semaforo);
        Coche c3 = new Coche("3333CCC", semaforo);

        Persona p1 = new Persona("Ana", semaforo);
        Persona p2 = new Persona("Luis", semaforo);
        Persona p3 = new Persona("Eva", semaforo);

        c1.start();
        c2.start();
        c3.start();

        p1.start();
        p2.start();
        p3.start();
    }
}
