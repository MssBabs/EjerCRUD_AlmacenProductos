
import java.util.ArrayList;

/**
 * Class ModeloArrayList
 */
public class ModeloArrayList extends ModeloAbs {
    private ArrayList <Producto> lista;
    
    public ModeloArrayList() {
       lista=new ArrayList <Producto>();
    }

    /**
     * Implementar los metodos abstractos de ModeloAbs
     * @param p ->producto
     * @return ->producto con los metodos implementados
     */
    public boolean insertarProducto ( Producto p){
      return lista.add(p);
    }

    /**
     * Borrar Producto por codigo
     * @param codigo ->codigo del producto a borrar
     * @return ->true(si se ha borrado) o false(si no existe o no se encuentra producto a borrar)
     */
    public boolean borrarProducto ( int codigo ){
        boolean auxBorrarProducto= lista.removeIf( producto -> producto.getCodigo() == codigo );
        return auxBorrarProducto;
    }

    /**
     * Buscar Producto por codigo
     * @param codigo ->codigo de producto a buscar
     * @return ->Producto
     */
    public Producto buscarProducto ( int codigo) {
        for (int i=0; i<this.lista.size(); i++){
            if (this.lista.get(i).getCodigo() == codigo){
                return this.lista.get(i);
            }
        }
        System.out.println("No existe producto con codigo: "+ codigo);
        return null;
    }

    /**
     * Listar TODOS los Productos
     */
    public void listarProductosTodos (){
        for (int i=0; i<this.lista.size(); i++){
            if (this.lista.get(i) != null){
                System.out.println(this.lista.get(i).toString());
            }
        }
    }

    /**
     * Listar productos con stock inferior a stock minimo recomendado
     */
    public void listarProductosStockMin(){
        for (int i=0; i<this.lista.size(); i++){
            if (this.lista.get(i).getStock() < this.lista.get(i).getStock_min()){
                System.out.println(this.lista.get(i).toString());
            }
        }
    }

    /**
     * Modificar Producto
     * @param nuevo ->Producto Nuevo
     * @return ->Producto Modificado
     */
    public boolean modificarProducto (Producto nuevo){
        for (int i=0; i<this.lista.size(); i++){
            if (this.lista.get(i).getCodigo() == nuevo.getCodigo()){
                this.lista.set(i, nuevo);
                System.out.println("Producto Modificado");
                return true;
            }
        }
        System.out.println("No existe producto a modifica");
        return false;
    }
}    
