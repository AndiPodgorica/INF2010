package tp1;

import java.util.Set;

public class Ellipse extends BaseShape {
    // TODO creer une ellipse avec une largeur et une longueur.
    public Ellipse(Double widthRadius, Double heightRadius)
    {
        for (Double x = -widthRadius; x < widthRadius; x++)
        {
            for (Double y = 0.0; y < (heightRadius*Math.sqrt(widthRadius*widthRadius- x*x))/widthRadius; y++)
            {
                add(new Point2d(x, y));
                add(new Point2d(x, -y));
            }
        }
    }

    private Ellipse(Set<Point2d> coords)
    {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Ellipse translate(Point2d point)
    {
        return new Ellipse(translateAll(point));
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Ellipse rotate(Double angle)
    {
        return new Ellipse(rotateAll(angle));
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Ellipse clone()
    {
        return new Ellipse(getCoords());
    }
}
