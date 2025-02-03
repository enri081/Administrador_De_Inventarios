/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package administrador_de_inventarios;

import static administrador_de_inventarios.TipoCategoria.ALIMENTOSYBEBIDAS;
import static administrador_de_inventarios.TipoCategoria.CUIDADOPERSONAL;
import static administrador_de_inventarios.TipoCategoria.ELECTRONICA;
import static administrador_de_inventarios.TipoCategoria.ROPA;
import java.util.Scanner;

/** Proyecto 1 (POO y colecciones)
 *  Aplicación para gestionar inventarios en una tienda.
 *  El sistema permite agregar, eliminar, buscar y listar productos. 
 * @author enrim
 */
public class Administrador_De_Inventarios {

    public static void main(String[] args) {
        int numJuego = 1, eleccionCategoria, salirBucle=0;
        Scanner scanner = new Scanner (System.in);         
        Inventario inventario = new Inventario();
        
        //Bucle para interectuar con el usuario y permitir las diferentes acciones
        while(numJuego>0){       
            Producto producto = new Producto();
            System.out.println("Elige una opcion:");
            System.out.println("""
                               1. Agregar producto.
                               2. Eliminar producto.
                               3. Buscar producto por codigo.
                               4. Buscar producto por nombre.
                               5. Listar productos por categoria.
                               6. Listar todos los productos.
                               7. Salir.""");
            System.out.print("-");
            numJuego = scanner.nextInt();
            System.out.println(" ");
            switch(numJuego){                
                case 1:         
                    // Selección de categoría
                    System.out.println("""
                               Elige el tipo de categoria:
                               1. Electronica.
                               2. Ropa.
                               3. Alimentos y bebidas.
                               4. Cuidado personal.""");
                    System.out.print("-");
                    eleccionCategoria = scanner.nextInt();                    
                    while(salirBucle==0){
                        if(eleccionCategoria>0 && eleccionCategoria<5){
                            switch(eleccionCategoria){
                                case 1: 
                                    producto.setCategoria(TipoCategoria.ELECTRONICA);
                                    break;
                                case 2:
                                    producto.setCategoria(TipoCategoria.ROPA);
                                    break;
                                case 3:
                                    producto.setCategoria(TipoCategoria.ALIMENTOSYBEBIDAS);
                                    break;
                                case 4:
                                    producto.setCategoria(TipoCategoria.CUIDADOPERSONAL);
                                    break;
                            }
                            salirBucle = 1;
                        }
                        else{
                            System.out.println("No has elegido dentro del rango posible. Intentelo de nuevo.");
                            System.out.print("-");
                            eleccionCategoria = scanner.nextInt();
                        }
                    }
                    salirBucle=0;
                    scanner.nextLine(); //Limpiar buffer

                    // Introducir nombre del producto
                    System.out.println("Introduce el nombre del producto:");
                    System.out.print("-");
                    producto.setNombre(scanner.nextLine());
                    while(inventario.comprobarNombre(producto.getNombre())==true){
                        System.out.println("Nombre repetido. Intentalo de nuevo.");
                        System.out.print("-");
                        producto.setNombre(scanner.nextLine());
                    }
                    
                    // Generar código único
                    producto.setCodigo((int) ((Math.random()*90000000)+10000000));
                    while(inventario.comprobarCodigo(producto.getCodigo())==true){ 
                        producto.setCodigo((int) ((Math.random()*90000000)+10000000));
                    }
                    System.out.println("El codigo que se le ha asignado es: " + producto.getCodigo() + ".");                   
                    
                    // Introducir precio del producto
                    System.out.println("Introduce el precio del producto:");
                    System.out.print("-");
                    producto.setPrecio(scanner.nextInt());
                    inventario.agregarProducto(producto);                    
                    System.out.println(" ");
                    break;                                                                                
                case 2:
                    // Eliminar producto segun indice introducido.
                    Producto productoEliminar;
                    System.out.println("Introduce el numero del producto que quieres eliminar:");
                    System.out.print("-");
                    productoEliminar = inventario.getInventario().get(scanner.nextInt());                    
                    inventario.eliminarProducto(productoEliminar);
                    System.out.println(" ");
                    break;
                case 3:
                    // Buscar producto segun codigo introducido.
                    int codigoIntroducir; 
                    System.out.println("Introduce el codigo:");
                    System.out.print("-");
                    codigoIntroducir = scanner.nextInt();
                    System.out.println(" ");
                    System.out.println(inventario.buscarPorCodigo(codigoIntroducir));
                    System.out.println(" ");
                    break;
                case 4:
                    // Buscar producto segun nombre introducido.
                    String nombreIntroducir;
                    scanner.nextLine(); //Limpiar buffer 
                    System.out.println("Introduce el nombre:");
                    System.out.print("-");
                    nombreIntroducir = scanner.nextLine();
                    System.out.println(" ");
                    System.out.println(inventario.buscarPorNombre(nombreIntroducir));
                    System.out.println(" ");
                    break;
                case 5:
                    //Listar productos segun categoria elegida.
                    TipoCategoria categoria = null;
                    salirBucle=0;
                    System.out.println("""
                               Elige el tipo de categoria:
                               1. Electronica.
                               2. Ropa.
                               3. Alimentos y bebidas.
                               4. Cuidado personal.""");
                    System.out.print("-");
                    eleccionCategoria = scanner.nextInt();
                    while(salirBucle==0){
                        if(eleccionCategoria>0 && eleccionCategoria<5){
                            switch(eleccionCategoria){
                                case 1: 
                                    categoria = ELECTRONICA;
                                    break;
                                case 2:
                                    categoria = ROPA;
                                    break;
                                case 3:
                                    categoria = ALIMENTOSYBEBIDAS;
                                    break;
                                case 4:
                                    categoria = CUIDADOPERSONAL;
                                    break;
                            }
                            salirBucle=1;
                        }
                        else{
                            System.out.println("No has elegido dentro del rango posible. Intentelo de nuevo.");
                            System.out.print("-");
                            eleccionCategoria = scanner.nextInt();
                        }
                    }
                    salirBucle=0;                    
                    System.out.println(" ");
                    inventario.listarProductosCategoria(categoria);
                    System.out.println(" ");
                    break;
                case 6:
                    //Listar todos los productos.
                    inventario.listarProductos();                    
                    System.out.println(" ");
                    break;
                case 7:
                    //Finalizar juego.
                    numJuego = 0;
                    break;
            }            
        }
        scanner.close();
    }       
}
