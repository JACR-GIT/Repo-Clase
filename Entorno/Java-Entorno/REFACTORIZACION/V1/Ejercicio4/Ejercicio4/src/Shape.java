//En muchas ocasiones que aparecen enum o constantes se pueden refactorizar en subclases.
// Se crean las clases Square, Circle y RightTriangle que extienden de Shape que se ha modificado para que sea abstracta
//eliminandose la variable typeShape y creando un metodo abstracto area() que se implementa en cada una de las clases hijas,
//de esta forma podemos seguir implementado clases hijas sin tener que modificar la clase padre haciendolo facil de mantener y escalable.

public abstract class Shape {
    protected double size;

    public Shape(double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    abstract double area();
}
    //Clases hijas

    class SQUARE extends Shape{
        public SQUARE(double size) {
            super(size);
        }

        @Override
        public double area() {
            return size * size;
        }
    }

    class CIRCLE extends Shape{
        public CIRCLE(double size) {
            super(size);
        }

        @Override
        public double area() {
            return Math.PI * size * size;
        }
    }

    class RIGHT_TRIANGLE extends Shape{
        public RIGHT_TRIANGLE(double size) {
            super(size);
        }

        @Override
        public double area() {
            return size * size / 2.0;
        }

    }
