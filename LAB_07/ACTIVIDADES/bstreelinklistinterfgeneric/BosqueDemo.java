package LAB_07.ACTIVIDADES.bstreelinklistinterfgeneric;

public class BosqueDemo {
    public static void main(String[] args) {
        System.out.println("Creando el árbol principal con raíz: \"Sales\"");
        BosqueMágico<String> arbol = new BosqueMágico<>("Sales");
        var raiz = arbol.almaDelÁrbol();

        System.out.println("Creando hojas hijas: \"Domestic\" y \"International\"");
        var dom = new BosqueMágico.Hojita<>("Domestic");
        var intl = new BosqueMágico.Hojita<>("International");

        System.out.println("Creando hojas hijas para 'International': \"Canada\" y \"S. America\"");
        var can = new BosqueMágico.Hojita<>("Canada");
        var sam = new BosqueMágico.Hojita<>("S. America");

        System.out.println("Creando hoja \"Overseas\" y sus retoños: \"Africa\", \"Europe\", \"Asia\", \"Australia\"");
        var over = new BosqueMágico.Hojita<>("Overseas");
        var afr = new BosqueMágico.Hojita<>("Africa");
        var eur = new BosqueMágico.Hojita<>("Europe");
        var asi = new BosqueMágico.Hojita<>("Asia");
        var aus = new BosqueMágico.Hojita<>("Australia");

        System.out.println("Añadiendo retoños a \"Overseas\":");
        System.out.println("  - Añadiendo \"Africa\"");
        over.brotar(afr);
        System.out.println("  - Añadiendo \"Europe\"");
        over.brotar(eur);
        System.out.println("  - Añadiendo \"Asia\"");
        over.brotar(asi);
        System.out.println("  - Añadiendo \"Australia\"");
        over.brotar(aus);

        System.out.println("Añadiendo retoños a \"International\":");
        System.out.println("  - Añadiendo \"Canada\"");
        intl.brotar(can);
        System.out.println("  - Añadiendo \"S. America\"");
        intl.brotar(sam);
        System.out.println("  - Añadiendo \"Overseas\"");
        intl.brotar(over);

        System.out.println("Añadiendo retoños a raíz \"Sales\":");
        System.out.println("  - Añadiendo \"Domestic\"");
        raiz.brotar(dom);
        System.out.println("  - Añadiendo \"International\"");
        raiz.brotar(intl);

        System.out.println("\n--- Hechizo visual: mostrando árbol completo ---\n");
        arbol.hechizoVisual();
    }
}
