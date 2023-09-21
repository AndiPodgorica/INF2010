package tp1;

public class Point2d extends AbstractPoint {
    private final Integer X = 0;
    private final Integer Y = 1;

    // TODO creer un point en 2d avec 2 donnees
    public Point2d(Double x, Double y)
    {
        super(new Double[] {x,y});
    }

    // TODO creer un point a partir d'un vecteur de donnees
    public Point2d(Double[] vector)
    {
        super(vector.clone());
    }

    public Double X() { return vector[X];}
    public Double Y() { return vector[Y];}

    // TODO prendre un vecteur de donnees et appliquer la translation.
    @Override
    public Point2d translate(Double[] translateVector)
    {
        return new Point2d(PointOperator.translate(vector, translateVector));
    }

    // TODO prendre un point et appliquer la translation.
    public Point2d translate(Point2d translateVector)
    {
       return new Point2d(PointOperator.translate(vector, translateVector.vector));
    }

    // TODO prendre un vecteur de donnees et appliquer la translation.
    @Override
    public Point2d rotate(Double[][] rotationMatrix) {
        return new Point2d(PointOperator.rotate(vector, rotationMatrix));
    }

    // TODO prendre un angle de rotation, creer une matrice et appliquer la rotation.
    public Point2d rotate(Double angle)
    {
        Double[][] matriceRoration =
                {
                {Math.cos(angle), -Math.sin(angle)},
                {Math.sin(angle), Math.cos(angle)}
        };
        return new Point2d(PointOperator.rotate(vector, matriceRoration));
    }

    // TODO prendre un facteur de division et l'appliquer.
    @Override
    public Point2d divide(Double divider) {
        return new Point2d(PointOperator.divide(vector, divider));
    }

    // TODO prendre un facteur de multiplication et l'appliquer.
    @Override
    public Point2d multiply(Double multiplier) {
        return new Point2d(PointOperator.multiply(vector,multiplier));
    }

    // TODO prendre un facteur d'addition et l'appliquer.
    @Override
    public Point2d add(Double adder) {
        return new Point2d(PointOperator.add(vector, adder));
    }

    // TODO creer un nouveau point.
    @Override
    public Point2d clone() {
        return new Point2d(vector);
    }
}
