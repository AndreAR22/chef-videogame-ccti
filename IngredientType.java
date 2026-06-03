import greenfoot.*;

public enum IngredientType
{
    PAN(new Color(222, 184, 135), "Pan"),
    CARNE(new Color(139, 69, 19), "Carne"),
    LECHUGA(new Color(34, 139, 34), "Lechuga"),
    TOMATE(new Color(220, 20, 60), "Tomate"),
    QUESO(new Color(255, 215, 0), "Queso"),
    MASA(new Color(238, 203, 173), "Masa"),
    SALSA(new Color(178, 34, 34), "Salsa"),
    PEPPERONI(new Color(255, 69, 0), "Pepperoni"),
    CHAMPINONES(new Color(160, 82, 45), "Champinones"),
    TORTILLA(new Color(205, 133, 63), "Tortilla");

    private final Color color;
    private final String nombre;

    IngredientType(Color color, String nombre) {
        this.color = color;
        this.nombre = nombre;
    }

    public Color getColor() {
        return color;
    }

    public String getNombre() {
        return nombre;
    }

    public GreenfootImage crearImagen(int size) {
        GreenfootImage img = new GreenfootImage(size, size);
        img.setColor(color);
        img.fillOval(0, 0, size, size);
        img.setColor(Color.BLACK);
        img.drawOval(0, 0, size - 1, size - 1);
        return img;
    }
}
