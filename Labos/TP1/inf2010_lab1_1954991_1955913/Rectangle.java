package tp1;

import java.util.Set;

public class Rectangle extends BaseShape {
    // TODO creer un rectangle avec une largeur et une longueur.
    public Rectangle(Double width, Double height)
    {
        for (Double i=-width/2; i<width/2; i++)
        {
            for (Double j=-height/2; j<height/2; j++)
            {
                add(new Point2d(i, j));
            }
        }
    }

    // TODO creer un rectangle avec un point contenant la largeur et longueur.
    public Rectangle(Point2d dimensions)
    {
        for (Double i=-dimensions.X()/2; i<dimensions.X()/2; i++)
        {
            for (Double j=-dimensions.Y()/2; j<dimensions.Y()/2; j++)
            {
                add(new Point2d(i, j));
            }
        }
    }

    private Rectangle(Set<Point2d> coords)
    {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Rectangle translate(Point2d point)
    {
        return new Rectangle(translateAll(point));
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Rectangle rotate(Double angle)
    {
        return new Rectangle(rotateAll(angle));
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Rectangle clone()
    {
        return new Rectangle(getCoords());
    }
}
