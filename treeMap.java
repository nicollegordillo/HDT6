import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class treeMap implements IMap{

    TreeMap<String, String> inventario = new TreeMap<String, String>();
    TreeMap<Integer, String> Coleccion = new TreeMap<Integer, String>();
    int i;

    @Override
    public void llenarMap(ArrayList<String[]> ProductList) {
        for (String[] product : ProductList) {
            inventario.put(product[1], product[0]);
        }
    }

    @Override
    public String agregar(String categoria, String producto) {
        String mensaje="";
        i++;
        if(inventario.containsKey(producto)){
            Coleccion.put(i, producto);
            mensaje="Se agrego el producto "+producto+" de la categoría "+ categoria+" a su colección";
        }
        else{
            mensaje= "El producto "+producto+" no se puede agregar, ya que no se encuentra en ninguna categoría";
        }
        return mensaje;
    }

    @Override
    public String MostrarCategoria(String producto) {
        String mensaje="";
        if(inventario.containsKey(producto)){
            for (Map.Entry<String, String> entrada : inventario.entrySet()) {
                if (entrada.getKey().equals(producto)) {
                    mensaje=entrada.getValue();
                }
            }

        }
        else{
            mensaje="Ese producto no se encuentra en el inventario";
        }
        return mensaje;
    }

    @Override
    public String MostrarProductos() {
        String mensaje="";
        Set<String> valoresVistos = new HashSet<>();
        if(Coleccion.size()>0){
            mensaje="-------Colección--------";
            Map<String, Integer> conteos = new TreeMap<>();
            for (String valor : Coleccion.values()) {
                if (conteos.containsKey(valor)) {
                    conteos.put(valor, conteos.get(valor) + 1);
                } else {
                    conteos.put(valor, 1);
                }
            }
            mensaje="-------Colección--------";
            for (Map.Entry<Integer, String> entrada : Coleccion.entrySet()) {
                if (!valoresVistos.contains(entrada.getValue())) {
                    String producto = entrada.getValue();
                    String categoria = inventario.get(producto);
                    int cantidad = conteos.get(producto);
                    mensaje+="\n---------------------------------";
                    mensaje+="\nCategoría: "+categoria+" \nProducto: "+producto+ "\nCantidad: "+ cantidad;
                    mensaje+="\n---------------------------------";
                    valoresVistos.add(entrada.getValue());
                }
            }
        }
        else{
            mensaje="Colección vacía";
        }
        return mensaje;
        
    }

    @Override
    public String MostrarProductosOrdenados() {
        String mensaje="";
        Set<String> valoresVistos = new HashSet<>();
        if(Coleccion.size()>0){
            mensaje="-------Colección--------";
            Map<String, Integer> conteos = new TreeMap<>();
            for (String valor : Coleccion.values()) {
                if (conteos.containsKey(valor)) {
                    conteos.put(valor, conteos.get(valor) + 1);
                } else {
                    conteos.put(valor, 1);
                }
            }
            for (String valor : Coleccion.values()) {
                if (!valoresVistos.contains(valor)) { 
                    String producto = valor;
                    String categoria = inventario.get(producto);
                    mensaje+="\n---------------------------------";
                    mensaje+="\n"+categoria+": ";
                    for (Map.Entry<Integer, String> entrada : Coleccion.entrySet()) { 
                        if (!valoresVistos.contains(entrada.getValue())) {
                            int cantidad = conteos.get(entrada.getValue());
                            if (categoria.equals(inventario.get(producto))) {
                                mensaje+="\n "+entrada.getValue()+" x "+cantidad;
                            }
                            valoresVistos.add(entrada.getValue());
                        }    
                    }
                    mensaje+="\n---------------------------------"; 
                }  
            }
        }
        else{
            mensaje="Colección vacía";
        }
        return mensaje;
    }

    @Override
    public String MostrarInventario() {
        String mensaje="";
        mensaje="-------Inventario--------";
        for (Map.Entry<String, String> entrada : inventario.entrySet()) {
            String clave = entrada.getValue();
            String valor = entrada.getKey();
            mensaje+="\n---------------------------------";
            mensaje+="\nCategoría: "+clave+" \nProducto: "+valor;
            mensaje+="\n---------------------------------";
        }
        return mensaje;
    }

    @Override
    public String MostrarInventarioOrdenado() {
        String mensaje="";
        Set<String> valoresVistos = new HashSet<>();
        mensaje="-------Inventario--------";
        for (String valor : inventario.values()) {
            if (!valoresVistos.contains(valor)) {
                mensaje+="\n---------------------------------";
                mensaje+="\n"+valor+": ";
                for (Map.Entry<String, String> entrada : inventario.entrySet()) {
                    if (entrada.getValue().equals(valor)) {
                        mensaje+="\n "+entrada.getKey();
                    }
                }
                valoresVistos.add(valor);
                mensaje+="\n---------------------------------";
            }
        }
        
        return mensaje;
    }
    
}
