package tp1;
import java.util.*;

public final class PointOperator {
    // TODO appliquer la translation sur le vecteur d'entree.
    public static Double[] translate(Double[] vector, Double[] translateVector) {
        Double[] vectEntree = new Double[vector.length];
        for (int i = 0; i < vector.length; i++)
        {
            vectEntree[i] = vector[i] + translateVector[i];
        }
        return vectEntree;
    }

    // TODO appliquer la rotation sur le vecteur d'entree.
    public static Double[] rotate(Double[] vector, Double[][] rotationMatrix)
    {
        Double[] vectEntree = new Double[vector.length];
        for (int i = 0; i < rotationMatrix.length; i++)
        {
            vectEntree[i] = 0.0;
            for (int j = 0; j < rotationMatrix[0].length; j++)
            {
                vectEntree[i] += vector[j]*rotationMatrix[i][j];
            }
        }
        return vectEntree;
    }

    // TODO appliquer le facteur de division sur le vecteur d'entree.
    public static Double[] divide(Double[] vector, Double divider)
    {
       return multiply(vector,1/divider);
    }

    // TODO appliquer le facteur de multiplication sur le vecteur d'entree.
    public static Double[] multiply(Double[] vector, Double multiplier)
    {
        Double[] vectEntree = new Double[vector.length];
        for (int i = 0; i < vector.length; i++)
        {
            vectEntree[i] = vector[i]*multiplier;
        }
        return vectEntree;
    }

    // TODO appliquer le facteur d'addition sur le vecteur d'entree.
    public static Double[] add(Double[] vector, Double adder)
    {
        Double[] vectEntree = new Double[vector.length];
        for (int i = 0; i < vector.length; i++)
        {
            vectEntree[i] = adder+vector[i];
        }
        return vectEntree;
    }

    // TODO retourne la coordonnee avec les plus grandes valeurs en X et en Y.
    public static Point2d getMaxCoord(Collection<Point2d> coords)
    {
        Double maxXValeur= 0.0;
        Double maxYValeur = 0.0;

        for (Point2d temp: coords) {
            if (temp.X() > maxXValeur) {
                maxXValeur = temp.X();
            }

            if (temp.Y() > maxYValeur) {
                maxYValeur = temp.Y();
            }
        }
        return new Point2d(maxXValeur, maxYValeur);
    }

    // TODO retourne la coordonnee avec les plus petites valeurs en X et en Y.
    public static Point2d getMinCoord(Collection<Point2d> coords) {
        Double valeurMaxX= 0.0;
        Double valeurMaxY = 0.0;

        for (Point2d temp: coords) {
            if (temp.X() < valeurMaxX) {
                valeurMaxX = temp.X();
            }

            if (temp.Y() < valeurMaxY) {
                valeurMaxY = temp.Y();
            }
        }
        return new Point2d(valeurMaxX, valeurMaxY);
    }
}
