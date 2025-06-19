package LAB_10.BTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BTree<E extends Comparable<E>> {
    private BNode<E> root;
    private int orden;
    private boolean up;
    private BNode<E> nDes;

    public BTree(int orden) {
        this.orden = orden;
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(E cl) {
        up = false;
        E mediana;
        BNode<E> pnew;

        mediana = push(this.root, cl);

        if (up) {
            pnew = new BNode<E>(this.orden);
            pnew.count = 1;
            pnew.addKey(mediana, 0);
            pnew.addChild(this.root, 0);
            pnew.addChild(nDes, 1);
            this.root = pnew;
        }
    }

    private E push(BNode<E> current, E cl) {
        if (current == null) {
            up = true;
            nDes = null;
            return cl;
        } else {
            BNode.SearchResult result = current.searchNode(cl);

            if (result.found()) {
                System.out.println("Item duplicado\n");
                up = false;
                return null;
            }

            E mediana = push(current.childs.get(result.position()), cl);

            if (up) {
                if (current.nodeFull(this.orden - 1)) {
                    mediana = dividedNode(current, mediana, result.position());
                } else {
                    up = false;
                    putNode(current, mediana, nDes, result.position());
                }
            }
            return mediana;
        }
    }

    private void putNode(BNode<E> current, E cl, BNode<E> rd, int k) {
        for (int i = current.count - 1; i >= k; i--) {
            current.keys.set(i + 1, current.keys.get(i));
            current.childs.set(i + 2, current.childs.get(i + 1));
        }

        current.keys.set(k, cl);
        current.childs.set(k + 1, rd);
        current.count++;
    }

    private E dividedNode(BNode<E> current, E cl, int k) {
        BNode<E> rd = nDes;
        int i, posMdna;
        posMdna = (k <= this.orden / 2) ? this.orden / 2 : (this.orden / 2 + 1);
        nDes = new BNode<>(this.orden);

        for (i = posMdna; i < this.orden - 1; i++) {
            nDes.keys.set(i - posMdna, current.keys.get(i));
            nDes.childs.set(i - posMdna + 1, current.childs.get(i + 1));
        }

        nDes.count = (this.orden - 1) - posMdna;
        current.count = posMdna;

        if (k <= this.orden / 2) {
            putNode(current, cl, rd, k);
        } else {
            putNode(nDes, cl, rd, k - posMdna);
        }

        E median = current.keys.get(current.count - 1);
        nDes.childs.set(0, current.childs.get(current.count));
        current.count--;

        return median;
    }
//ACTIVIDAD 03
    @Override
public String toString() {
    StringBuilder s = new StringBuilder();
    if (isEmpty()) {
        s.append("BTree is empty...\n");
    } else {
        writeTree(this.root, s);
    }
    return s.toString();
}

private void writeTree(BNode<E> current, StringBuilder sb) {
    if (current == null) return;

    // Mostrar claves del nodo
    sb.append("Id.Nodo: ").append(current.idNode).append(" | Claves: (");
    for (int i = 0; i < current.count; i++) {
        sb.append(current.keys.get(i));
        if (i < current.count - 1) sb.append(", ");
    }
    sb.append(")");

    // Mostrar hijos
    sb.append(" | Hijos: [");
    boolean hayHijos = false;
    for (int i = 0; i <= current.count; i++) {
        BNode<E> child = current.childs.get(i);
        if (child != null) {
            if (hayHijos) sb.append(", ");
            sb.append(child.idNode);
            hayHijos = true;
        }
    }
    sb.append("]\n");

    for (int i = 0; i <= current.count; i++) {
        writeTree(current.childs.get(i), sb);
    }
}


//EJERCICIO 01
public boolean search(E cl) {
    return searchRecursive(this.root, cl);
}

private boolean searchRecursive(BNode<E> current, E cl) {
    if (current == null) return false;

    BNode.SearchResult result = current.searchNode(cl);

    if (result.found()) {
        System.out.println(cl + " se encuentra en el nodo " + current.idNode + " en la posición " + result.position());
        return true;
    } else {
        return searchRecursive(current.childs.get(result.position()), cl);
    }
}

//EJERCICIO 02.
public void remove(E cl) {
    if (isEmpty()) {
        System.out.println("El árbol está vacío.");
        return;
    }

    removeRecursive(this.root, cl);

    // Si después de eliminar la raíz queda vacía y tiene un solo hijo, el hijo se convierte en la nueva raíz
    if (root.count == 0 && root.childs.get(0) != null) {
        root = root.childs.get(0);
    } else if (root.count == 0) {
        root = null; // árbol quedó vacío
    }
}

private void removeRecursive(BNode<E> node, E cl) {
    BNode.SearchResult result = node.searchNode(cl);

    if (result.found()) {
        // Caso 1: clave está en nodo hoja
        if (isLeaf(node)) {
            for (int i = result.position(); i < node.count - 1; i++) {
                node.keys.set(i, node.keys.get(i + 1));
            }
            node.keys.set(node.count - 1, null);
            node.count--;
        } else {
            // Caso 2: clave está en nodo interno
            BNode<E> predChild = node.childs.get(result.position());
            BNode<E> succChild = node.childs.get(result.position() + 1);

            // Preferir antecesor si tiene suficientes claves
            if (predChild.count >= orden / 2) {
                E predecessor = getMax(predChild);
                node.keys.set(result.position(), predecessor);
                removeRecursive(predChild, predecessor);
            } else if (succChild.count >= orden / 2) {
                E successor = getMin(succChild);
                node.keys.set(result.position(), successor);
                removeRecursive(succChild, successor);
            } else {
                // Fusión y eliminación
                merge(node, result.position());
                removeRecursive(predChild, cl);
            }
        }
    } else {
        // Descender al hijo apropiado
        int pos = result.position();
        BNode<E> child = node.childs.get(pos);

        if (child == null) {
            System.out.println("Clave no encontrada.");
            return;
        }

        // Si el hijo tiene menos de t claves, tratamos de arreglarlo antes de seguir
        if (child.count < orden / 2) {
            fixChild(node, pos);
        }

        // Es posible que el hijo haya cambiado tras la fusión
        removeRecursive(node.childs.get(pos), cl);
    }
}
private boolean isLeaf(BNode<E> node) {
    for (BNode<E> child : node.childs) {
        if (child != null) return false;
    }
    return true;
}

private E getMax(BNode<E> node) {
    while (!isLeaf(node)) {
        for (int i = node.count; i >= 0; i--) {
            if (node.childs.get(i) != null) {
                node = node.childs.get(i);
                break;
            }
        }
    }
    return node.keys.get(node.count - 1);
}

private E getMin(BNode<E> node) {
    while (!isLeaf(node)) {
        for (int i = 0; i <= node.count; i++) {
            if (node.childs.get(i) != null) {
                node = node.childs.get(i);
                break;
            }
        }
    }
    return node.keys.get(0);
}

private void merge(BNode<E> parent, int pos) {
    BNode<E> left = parent.childs.get(pos);
    BNode<E> right = parent.childs.get(pos + 1);

    // Mover la clave del padre al medio del nuevo nodo
    left.keys.set(left.count++, parent.keys.get(pos));

    // Copiar claves y hijos del nodo derecho al izquierdo
    for (int i = 0; i < right.count; i++) {
        left.keys.set(left.count + i, right.keys.get(i));
    }
    for (int i = 0; i <= right.count; i++) {
        left.childs.set(left.count + i, right.childs.get(i));
    }

    left.count += right.count;

    // Eliminar la clave del padre
    for (int i = pos; i < parent.count - 1; i++) {
        parent.keys.set(i, parent.keys.get(i + 1));
        parent.childs.set(i + 1, parent.childs.get(i + 2));
    }

    parent.keys.set(parent.count - 1, null);
    parent.childs.set(parent.count, null);
    parent.count--;
}

private void fixChild(BNode<E> parent, int pos) {
    BNode<E> child = parent.childs.get(pos);

    // Intentar prestar del hermano izquierdo
    if (pos > 0 && parent.childs.get(pos - 1).count >= orden / 2) {
        BNode<E> left = parent.childs.get(pos - 1);

        // Desplazar en el hijo actual
        for (int i = child.count; i > 0; i--) {
            child.keys.set(i, child.keys.get(i - 1));
            child.childs.set(i + 1, child.childs.get(i));
        }
        child.childs.set(1, child.childs.get(0));

        // Traer clave del padre
        child.keys.set(0, parent.keys.get(pos - 1));
        child.childs.set(0, left.childs.get(left.count));

        // Subir clave del hermano izquierdo al padre
        parent.keys.set(pos - 1, left.keys.get(left.count - 1));

        left.keys.set(left.count - 1, null);
        left.childs.set(left.count, null);
        left.count--;
        child.count++;
    }

    // Intentar prestar del hermano derecho
    else if (pos < parent.count && parent.childs.get(pos + 1).count >= orden / 2) {
        BNode<E> right = parent.childs.get(pos + 1);

        // Traer clave del padre
        child.keys.set(child.count++, parent.keys.get(pos));
        child.childs.set(child.count, right.childs.get(0));

        // Subir primera clave del hermano al padre
        parent.keys.set(pos, right.keys.get(0));

        // Desplazar el hermano derecho
        for (int i = 0; i < right.count - 1; i++) {
            right.keys.set(i, right.keys.get(i + 1));
            right.childs.set(i, right.childs.get(i + 1));
        }
        right.childs.set(right.count - 1, right.childs.get(right.count));
        right.keys.set(right.count - 1, null);
        right.childs.set(right.count, null);
        right.count--;
    }

    // Si no se puede prestar, fusionar
    else {
        if (pos < parent.count) {
            merge(parent, pos);
        } else {
            merge(parent, pos - 1);
        }
    }
}

//EJERCICIO 03
public static BTree<Integer> building_BTree(String path) {
    Map<Integer, BNode<Integer>> nodos = new HashMap<>();
    Map<Integer, Integer> niveles = new HashMap<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
        int orden = Integer.parseInt(reader.readLine().trim());
        BTree<Integer> tree = new BTree<>(orden);

        String line;
        while ((line = reader.readLine()) != null) {
            String[] partes = line.trim().split(",");
            if (partes.length < 3) {
                throw new ItemNoFound("Línea malformada: " + line);
            }

            int nivel = Integer.parseInt(partes[0]);
            int id = Integer.parseInt(partes[1]);

            BNode<Integer> nodo = new BNode<>(orden);
            nodo.idNode = id;
            nodo.count = partes.length - 2;

            for (int i = 2; i < partes.length; i++) {
                int clave = Integer.parseInt(partes[i]);
                nodo.keys.set(i - 2, clave);
            }

            nodos.put(id, nodo);
            niveles.put(id, nivel);
        }

        // Reconstruir jerarquía
        for (Map.Entry<Integer, BNode<Integer>> entry : nodos.entrySet()) {
            int id = entry.getKey();
            BNode<Integer> nodo = entry.getValue();
            int nivel = niveles.get(id);

            if (nivel == 0) {
                tree.root = nodo;
            } else {
                // Buscar el padre: tiene nivel - 1 y lo tiene como hijo esperado
                for (Map.Entry<Integer, BNode<Integer>> candidato : nodos.entrySet()) {
                    int nivelPadre = niveles.get(candidato.getKey());
                    if (nivelPadre == nivel - 1) {
                        BNode<Integer> padre = candidato.getValue();

                        // Verifica si este nodo puede ser hijo
                        for (int i = 0; i <= padre.count; i++) {
                            if (padre.childs.get(i) == null) {
                                padre.childs.set(i, nodo);
                                break;
                            }
                        }
                    }
                }
            }
        }

        // Validar estructura
        if (!validarBTree(tree)) {
            throw new ItemNoFound("El árbol cargado no cumple con las propiedades de BTree.");
        }

        return tree;

    } catch (IOException e) {
        throw new RuntimeException("Error al leer el archivo: " + e.getMessage());
    } catch (NumberFormatException e) {
        throw new ItemNoFound("Formato numérico incorrecto en archivo.");
    }
}

private static boolean validarBTree(BTree<Integer> tree) {
    return validarRecursivo(tree.root, tree.orden);
}

private static boolean validarRecursivo(BNode<Integer> nodo, int orden) {
    if (nodo == null) return true;

    if (nodo.count > orden - 1 || nodo.count < (nodo == nodo.childs.get(0) ? 1 : (orden / 2 - 1))) {
        return false;
    }

    for (int i = 0; i <= nodo.count; i++) {
        if (nodo.childs.get(i) != null) {
            if (!validarRecursivo(nodo.childs.get(i), orden)) return false;
        }
    }
    return true;
}

//EJERCICIO 04
public String buscarNombre(int codigo) {
    return buscarNombreRecursivo(this.root, codigo);
}

private String buscarNombreRecursivo(BNode<E> current, int codigo) {
    if (current == null) return "No encontrado";

    for (int i = 0; i < current.count; i++) {
        E elemento = current.keys.get(i);
        if (elemento != null) {
            RegistroEstudiante est = (RegistroEstudiante) elemento; // 🔁 CAST
            if (est.getCodigo() == codigo) return est.getNombre();
            if (codigo < est.getCodigo()) {
                return buscarNombreRecursivo(current.childs.get(i), codigo);
            }
        }
    }
    return buscarNombreRecursivo(current.childs.get(current.count), codigo);
}

public static void main(String[] args) {
    try {
        BTree<Integer> arbol = BTree.building_BTree("/Users/camilalizarazomares/Desktop/AED03/AED_03_FASE01_LIZARAZO/LAB_10/arbolB.txt");


        System.out.println("Árbol cargado correctamente:");
        System.out.println(arbol);
    } catch (ItemNoFound e) {
        System.err.println("Error: " + e.getMessage());
    }
}

}


    
