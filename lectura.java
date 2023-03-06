import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//
//
//  @ Project : HDT6
//  @ File Name : lectura.java
//  @ Date : 05/03/2023
//  @ Author : Nicolle Gordillo  
//
//
public class lectura {
    public ArrayList<String[]> leer(){
        String filename = "ListadoProducto (2).txt"; // nombre del archivo de entrada
        ArrayList<String[]> productList = new ArrayList(); // ArrayList de arrays que contendrá los productos

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) { // leer cada línea del archivo
                String[] parts = line.split("\\|"); // separar cada línea en dos partes: Categoría y Producto
                String category = parts[0].trim(); // obtener la categoría y eliminar los espacios en blanco al principio y al final
                String product = parts[1].trim(); // obtener el producto y eliminar los espacios en blanco al principio y al final
                String[] productArray = {category, product}; // crear el array con Categoría y Producto
                productList.add(productArray); // añadir el array de Categoría y Producto al ArrayList
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return productList;

    }    
}
