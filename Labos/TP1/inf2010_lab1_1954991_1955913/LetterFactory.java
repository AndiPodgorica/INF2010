package tp1;

public final class LetterFactory {
    final static Double maxHeight = 200.0;
    final static Double maxWidth = maxHeight / 2;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 10;

    // TODO
    public static BaseShape create_H()
    {
        BaseShape ligneBase = new Rectangle(stripeThickness, maxHeight);

        BaseShape ligneDroite = ligneBase.translate(new Point2d(halfMaxWidth, 0.0));
        BaseShape ligneGauche = ligneBase.translate(new Point2d(-halfMaxWidth, 0.0));
        BaseShape ligneMilieu = new Rectangle(maxWidth, stripeThickness);

        ligneGauche.add(ligneMilieu);
        ligneGauche.add(ligneDroite);
        return ligneGauche;
    }

    // TODO
    public static BaseShape create_e()
    {
        BaseShape ligneMilieu = new Rectangle(maxWidth, stripeThickness);
        BaseShape cercleComplet = new Ellipse(halfMaxWidth, halfMaxHeight);
        BaseShape cercleInterieur = new Ellipse(halfMaxWidth - stripeThickness, halfMaxHeight - stripeThickness);

        cercleComplet.remove(new Rectangle(halfMaxWidth, stripeThickness).translate(new Point2d(maxWidth/2, stripeThickness)));
        cercleComplet.remove(cercleInterieur);
        cercleComplet.add(ligneMilieu);
        return cercleComplet;
    }

    // TODO
    public static BaseShape create_l()
    {
        BaseShape ligneBase = new Rectangle(stripeThickness, maxHeight);
        return ligneBase;
    }

    // TODO
    public static BaseShape create_o()
    {
        BaseShape cercleComplet = new Ellipse(halfMaxWidth, halfMaxHeight);
        BaseShape cercleInterieur = new Ellipse(halfMaxWidth - stripeThickness, halfMaxHeight - stripeThickness);
        cercleComplet.remove(cercleInterieur);
        return cercleComplet;
    }

    // On vous donne la lettre W comme exemple.
    public static BaseShape create_W()
    {
        Double espacement = stripeThickness * 2;
        Double degres15 = Math.toRadians(8);
        BaseShape ligneBase = new Rectangle(stripeThickness, maxHeight);
        BaseShape ligneDroite = ligneBase.rotate(degres15).translate(new Point2d(espacement, 0.0));
        BaseShape ligneDroiteMilieu = ligneBase.rotate(-degres15).translate(new Point2d(espacement / 3, 0.0));
        BaseShape ligneGauche = ligneBase.rotate(-degres15).translate(new Point2d(-espacement, 0.0));
        BaseShape ligneGaucheMilieu = ligneBase.rotate(degres15).translate(new Point2d(-espacement / 3, 0.0));
        ligneGauche.add(ligneDroite);
        ligneGauche.add(ligneGaucheMilieu);
        ligneGauche.add(ligneDroiteMilieu);

        return ligneGauche;
    }

    // TODO
    public static BaseShape create_r()
    {
        Double espacement = stripeThickness * 2;
        BaseShape carre = new Square(maxWidth).translate(new Point2d(0.0, maxWidth/10-1));
        BaseShape ligneBase = new Rectangle(stripeThickness, maxHeight).translate(new Point2d(-espacement, 0.0));
        BaseShape cercleInterieur = new Circle(halfMaxWidth-stripeThickness).translate(new Point2d(0.0, -espacement-1));
        BaseShape cercleExterieur = new Circle(halfMaxWidth).translate(new Point2d(0.0, -espacement-1));

        cercleExterieur.remove(carre);
        cercleExterieur.remove(cercleInterieur);
        ligneBase.add(cercleExterieur);
        return ligneBase;
    }

    // TODO
    public static BaseShape create_d()
    {
        Double espacement = stripeThickness * 2;
        BaseShape ligneBase = new Rectangle(stripeThickness, maxHeight).translate(new Point2d(espacement, 0.0));
        BaseShape cercleInterieur = new Circle(halfMaxWidth-stripeThickness).translate(new Point2d(0.0, espacement+5));
        BaseShape cercleExterieur = new Circle(halfMaxWidth).translate(new Point2d(0.0, espacement+5));
        ligneBase.remove(cercleInterieur);
        ligneBase.add(cercleExterieur);

        return ligneBase;
    }
}
