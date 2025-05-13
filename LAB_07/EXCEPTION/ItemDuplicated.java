package LAB_07.EXCEPTION;

public class ItemDuplicated extends Exception {

    public ItemDuplicated(String msg) {
        super(msg);  // Corrección: era `message: m5g`, lo correcto es `msg`
    }

    public ItemDuplicated() {
        super("El elemento ya existe en la estructura de datos.");
    }
}

