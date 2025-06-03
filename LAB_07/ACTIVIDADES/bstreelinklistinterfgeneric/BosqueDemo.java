package LAB_07.ACTIVIDADES.bstreelinklistinterfgeneric;

public class BosqueDemo {
    public static void main(String[] args) {
        BosqueMágico<String> arbol = new BosqueMágico<>("Sales");
        var raiz = arbol.almaDelÁrbol();

        var dom = new BosqueMágico.Hojita<>("Domestic");
        var intl = new BosqueMágico.Hojita<>("International");

        var can = new BosqueMágico.Hojita<>("Canada");
        var sam = new BosqueMágico.Hojita<>("S. America");

        var over = new BosqueMágico.Hojita<>("Overseas");
        var afr = new BosqueMágico.Hojita<>("Africa");
        var eur = new BosqueMágico.Hojita<>("Europe");
        var asi = new BosqueMágico.Hojita<>("Asia");
        var aus = new BosqueMágico.Hojita<>("Australia");

        over.brotar(afr);
        over.brotar(eur);
        over.brotar(asi);
        over.brotar(aus);

        intl.brotar(can);
        intl.brotar(sam);
        intl.brotar(over);

        raiz.brotar(dom);
        raiz.brotar(intl);

        arbol.hechizoVisual();
    }
}
