import greenfoot.*;
import java.util.*;

public class MyWorld extends World
{
    private Score marcador;
    private Vidas vidas;
    private int instrucciones = 250;
    private Recipe receta;
    private Map<IngredientType, Integer> recolectados;
    private boolean completo = false;
    private int contadorCompleto = 0;
    private boolean gameOver = false;
    private int contadorGameOver = 0;
    private static boolean terminado = false;

    public static boolean juegoTerminado() {
        return terminado;
    }

    public MyWorld(Recipe receta)
    {
        super(1100, 750, 1);
        terminado = false;
        Chef.desbloquearMovimiento();
        this.receta = receta;

        recolectados = new HashMap<>();
        for (IngredientType tipo : receta.ingredientes.keySet()) {
            recolectados.put(tipo, 0);
        }

        marcador = new Score();

        vidas = new Vidas();
        addObject(vidas, 70, 30);

        prepare();
    }

    public Score getMarcador()
    {
        return marcador;
    }

    public Vidas getVidas()
    {
        return vidas;
    }

    public boolean recolectarIngrediente(IngredientType tipo)
    {
        if (completo) return false;
        if (!receta.ingredientes.containsKey(tipo)) return false;

        int actual = recolectados.get(tipo);
        int necesario = receta.ingredientes.get(tipo);

        if (actual < necesario) {
            recolectados.put(tipo, actual + 1);
            marcador.sumarPunto();
            verificarCompleto();
            return true;
        }
        return false;
    }

    private void verificarCompleto()
    {
        for (IngredientType tipo : receta.ingredientes.keySet()) {
            if (recolectados.get(tipo) < receta.ingredientes.get(tipo)) {
                return;
            }
        }
        completo = true;
    }

    private void prepare()
    {
        Chef chef = new Chef();
        addObject(chef, 548, 331);
    }

    public void act()
    {
        if (gameOver) {
            contadorGameOver++;
            showText("GAME OVER", getWidth() / 2, getHeight() / 2);
            if (contadorGameOver == 1) { terminado = true; Chef.bloquearMovimiento(); }
            if (contadorGameOver > 120) {
                Chef.detenerMusica();
                Greenfoot.setWorld(new MenuWorld());
            }
            return;
        }

        if (completo) {
            contadorCompleto++;
            showText("PLATO COMPLETO!", getWidth() / 2, getHeight() / 2);
            if (contadorCompleto == 1) { terminado = true; Chef.bloquearMovimiento(); }
            if (contadorCompleto > 90) {
                Chef.detenerMusica();
                Greenfoot.setWorld(new MenuWorld());
            }
            return;
        }

        if (instrucciones > 0)
        {
            showText("Click IZQUIERDO: Rodillo | ESPACIO: Repelente", getWidth() / 2, getHeight() / 2 + 300);
            instrucciones--;
            if (instrucciones == 0) {
                showText("", getWidth() / 2, getHeight() / 2 + 300);
            }
        }

        if (vidas.getVidas() <= 0)
        {
            gameOver = true;
            return;
        }

        mostrarProgreso();
    }

    private void mostrarProgreso()
    {
        showText("Receta: " + receta.nombre, getWidth() / 2, 80);

        int y = 110;
        for (IngredientType tipo : receta.ingredientes.keySet()) {
            int actual = recolectados.get(tipo);
            int necesario = receta.ingredientes.get(tipo);
            String colorName = tipo.getNombre();
            showText(colorName + ": " + actual + "/" + necesario, getWidth() / 2, y);
            y += 25;
        }
    }
}
