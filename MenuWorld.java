import greenfoot.*;

public class MenuWorld extends World
{
    private Recipe[] recetas;
    private int selectedIndex = -1;

    public MenuWorld()
    {
        super(1100, 750, 1);
        recetas = Recipe.todas();
        mostrarMenu();
    }

    private void mostrarMenu()
    {
        showText("SELECCIONA UN PLATO", getWidth() / 2, 80);
        showText("CLICK IZQUIERDO PARA ELEGIR", getWidth() / 2, 120);

        int startY = 230;
        int spacing = 100;

        for (int i = 0; i < recetas.length; i++) {
            String info = recetas[i].nombre + " (" + recetas[i].totalIngredientes() + " ingredientes)";
            showText(info, getWidth() / 2, startY + i * spacing);
        }
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse == null) return;

            int y = mouse.getY();
            int startY = 230;
            int spacing = 100;

            for (int i = 0; i < recetas.length; i++) {
                int centroY = startY + i * spacing;
                if (Math.abs(y - centroY) < 40) {
                    selectedIndex = i;
                    break;
                }
            }

            if (selectedIndex >= 0) {
                Greenfoot.setWorld(new MyWorld(recetas[selectedIndex]));
            }
        }
    }
}
