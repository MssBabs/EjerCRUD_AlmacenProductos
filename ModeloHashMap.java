import java.util.HashMap;
import java.util.Map;

/**
 * Class ModeloHasMap
 */
public class ModeloHashMap extends ModeloAbs {
    private HashMap <Integer, Producto> lista;
    
    public ModeloHashMap() {
       lista=new HashMap  <Integer,Producto>();
    }

    @Override
    public boolean insertarProducto(Producto p) {
        this.lista.put(p.getCodigo(), p);
        return true;
    }

    @Override
    boolean borrarProducto(int codigo) {
        if (this.lista.get(codigo) != null){
            this.lista.remove(codigo);
            System.out.println("Producto eliminado");
            return true;
        } else {
            System.out.println("No existe producto con codigo: "+ codigo);
            return false;
        }
    }

    @Override
    public Producto buscarProducto(int codigo) {
        if (this.lista.get(codigo) != null){
            return this.lista.get(codigo);
        } else {
            System.out.println("No existe producto con codigo: "+ codigo);
            return null;
        }
    }

    @Override
    void listarProductosTodos() {
        for (Map.Entry<Integer, Producto> entry : lista.entrySet()) {
            Integer clave = entry.getKey();
            Producto valor = entry.getValue();
            System.out.println(valor.toString());
        }
    }

    @Override
    void listarProductosStockMin() {
        for (Map.Entry<Integer, Producto> entry : lista.entrySet()) {
            Integer clave = entry.getKey();
            Producto valor = entry.getValue();
            if (valor.getStock() < valor.getStock_min()){
                System.out.println(valor.toString());
            }
        }
    }

    @Override
    boolean modificarProducto(Producto nuevo) {
        if (this.lista.get(nuevo.getCodigo()) != null){
            this.lista.replace(nuevo.getCodigo(), nuevo);

            System.out.println("Producto modificado");
            return true;
        }
        System.out.println("No existe producto a modificar");
        return false;
    }
}
