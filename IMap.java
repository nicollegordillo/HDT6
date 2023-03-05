import java.util.ArrayList;

public interface IMap {
    public void llenarMap(ArrayList<String[]> inventario);
    public String agregar(String categoria, String producto);
    public String MostrarCategoria(String producto);
    public String MostrarProductos();
    public String MostrarProductosOrdenados();
    public String MostrarInventario();
    public String MostrarInventarioOrdenado();
}
