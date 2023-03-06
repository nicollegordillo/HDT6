import java.util.ArrayList;
//
//
//  @ Project : HDT6
//  @ File Name : IMap.java
//  @ Date : 05/03/2023
//  @ Author : Nicolle Gordillo  
//
//
public interface IMap {
    public void llenarMap(ArrayList<String[]> inventario);
    public String agregar(String categoria, String producto);
    public String MostrarCategoria(String producto);
    public String MostrarProductos();
    public String MostrarProductosOrdenados();
    public String MostrarInventario();
    public String MostrarInventarioOrdenado();
}
