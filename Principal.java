import java.util.Scanner;
//
//
//  @ Project : HDT6
//  @ File Name : Principal.java
//  @ Date : 05/03/2023
//  @ Author : Nicolle Gordillo  
//
//
public class Principal {
    public static void main(String[] args) {
        lectura l=new lectura();
        String Producto="";
        String Categoria="";
        int op1=0;
        MapCreator mapTipo = new MapCreator();
        IMap map;
        int op2=0;
        int tipo=0;
        int op3=0;
        Scanner teclado = new Scanner(System.in);
        Boolean continuar=true;
        Boolean continuar2=true;
        System.out.println("Bienvenido a la tienda en linea");
        while(continuar){
            continuar2=true;
            System.out.println("1. Empezar a comprar \n2. Salir");
            op1= teclado.nextInt();
            teclado.nextLine();
            if(op1==1){
                System.out.println("¿Qué quiere usar?");
                System.out.println("1. HashMap \n2. TreeMap \n3. LinkedHashMap");
                op2=teclado.nextInt();
                teclado.nextLine();
                if(op2==1){
                    tipo=1;
                }
                else if(op2==2){
                    tipo=2;
                }
                else if(op2==3){
                    tipo=3;
                }
                else{
                    System.out.println("Ingrese algo válido");
                }
                map= mapTipo.createMap(tipo);
                map.llenarMap(l.leer());
                while(continuar2){
                    System.out.println("¿Qué quiere hacer?");
                    System.out.println("1. Agregar un producto \n2. Mostrar la categoría de un producto \n3. Mostrar los datos de los productos en mi colección \n4. Mostrar los datos de los productos en mi colección ordenado por categoría \n5. Mostrar el inventario \n6. Mostrar el inventario ordenado por categoría \n7. Salir");
                    op3= teclado.nextInt();
                    teclado.nextLine();
                    if(op3==1){
                        System.out.println("Ingrese la categoría");
                        Categoria=teclado.nextLine();
                        System.out.println("Ingrese el producto");
                        Producto=teclado.nextLine();
                        System.out.println(map.agregar(Categoria, Producto));
                    }
                    else if(op3==2){
                        System.out.println("Ingrese el producto");
                        Producto=teclado.nextLine();
                        System.out.println(map.MostrarCategoria(Producto));
                    }
                    else if(op3==3){
                        System.out.println(map.MostrarProductos());

                    }
                    else if(op3==4){
                        System.out.println(map.MostrarProductosOrdenados());

                    }
                    else if(op3==5){
                        System.out.println(map.MostrarInventario());
                    }
                    else if(op3==6){
                        System.out.println(map.MostrarInventarioOrdenado());
                    }
                    else if(op3==7){
                        continuar2=false;
                    }
                    else{
                        System.out.println("Ingrese algo válido");
                    }
                }
            }
            else if(op1==2){
                continuar=false;
            }
            else{
                System.out.println("Ingrese algo válido");
            }
            

        }
    }
    
}
