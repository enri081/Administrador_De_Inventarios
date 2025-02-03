/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrador_de_inventarios;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Clase Inventario
 * Maneja una colección de productos en una tienda.
 * Permite agregar, eliminar, buscar y listar productos.
 * @author enrim
 */
public class Inventario extends Producto{
    private Producto producto;
    private final LinkedList<Producto> inventario = new LinkedList<>();
    
    /**
     * Constructor de la clase Inventario
     */
    public Inventario(){
        
    }
    
    /**
     * Obtiene la lista de productos del inventario
     * @return Lista de productos en el inventario
     */
    public LinkedList<Producto> getInventario() {
        return inventario;
    }
    
    /**
     * Agrega un producto al inventario
     * @param producto Producto a agregar
     */
    public void agregarProducto(Producto producto){
        inventario.add(producto);
        System.out.println("Producto " + producto.getNombre() + " agregado.");
    }
    
    /**
     * Elimina un producto del inventario
     * @param producto Producto a eliminar
     */
    public void eliminarProducto(Producto producto){
        inventario.remove(producto);
        System.out.println("Producto " + producto.getNombre() + " eliminado.");
    }
    
    /**
     * Busca un producto por su código
     * @param codigoaintroducir Código del producto a buscar
     * @return Representación en cadena del producto encontrado o mensaje de error
     */
    public String buscarPorCodigo(int codigoaintroducir){
        Iterator<Producto> iterador = inventario.iterator();
        int salirBucle=0;
        String productoString = null;
        while(iterador.hasNext() && salirBucle==0){
            producto = iterador.next();            
            if (codigoaintroducir == producto.getCodigo()){
                salirBucle++;
                System.out.println("Producto " + inventario.indexOf(producto) + ".");
                productoString = producto.toString();
            }                        
        }
        if (salirBucle==0){
            productoString = "Codigo erroneo";
        }
        return productoString;
    }
    
    /**
     * Busca un producto por su nombre
     * @param nombreaintroducir Nombre del producto a buscar
     * @return Representación en cadena del producto encontrado o mensaje de error
     */
    public String buscarPorNombre(String nombreaintroducir){
        Iterator<Producto> iterador = inventario.iterator();
        int salirBucle=0;
        String productoString = null;
        while(iterador.hasNext() && salirBucle==0){
            producto = iterador.next();
            if (nombreaintroducir.equalsIgnoreCase(producto.getNombre())){
                salirBucle++;
                System.out.println("Producto " + inventario.indexOf(producto) + ".");
                productoString = producto.toString();
            }                       
        }
        if (salirBucle==0){
            productoString = "Nombre erroneo";
        } 
        return productoString;
    }
    
    
    /**
     * Lista todos los productos en el inventario
     */
    public void listarProductos(){        
        Iterator<Producto> iterador = inventario.iterator();
        while(iterador.hasNext()){
            producto = iterador.next();
            System.out.println("Producto " + inventario.indexOf(producto) + ".");
            System.out.println(producto.toString());
            if(iterador.hasNext()==true){
                System.out.println(" ");
            }                                        
        }
    }
    
    /**
     * Lista productos de una categoría específica
     * @param categoriaaintroducir Categoría de productos a listar
     */
    public void listarProductosCategoria(TipoCategoria categoriaaintroducir){        
        Iterator<Producto> iterador = inventario.iterator();
        int salirBucle=0;
        while(iterador.hasNext() && salirBucle==0){
            producto = iterador.next();
            if(categoriaaintroducir.equals(producto.getCategoria())){
                salirBucle++;
                System.out.println("Producto " + inventario.indexOf(producto) + ".");
                System.out.println(producto.toString());
                if(iterador.hasNext()==true){
                    System.out.println(" ");
                }
            }            
        }
        if(salirBucle==0){
                System.out.println("Categoria vacia.");
        }
    }
    
     /**
     * Comprueba si un nombre de producto ya existe en el inventario
     * @param nombre Nombre del producto a verificar
     * @return true si el nombre ya existe, false si no
     */
    public boolean comprobarNombre(String nombre){
        Iterator<Producto> iterador = inventario.iterator();
        boolean nombreRepetido=false;
        while(iterador.hasNext()){
            producto = iterador.next();
            nombreRepetido = nombre.equalsIgnoreCase(producto.getNombre());
        }
        return nombreRepetido;
    }
    
     /**
     * Comprueba si un código de producto ya existe en el inventario
     * @param codigo Código del producto a verificar
     * @return true si el código ya existe, false si no
     */
    public boolean comprobarCodigo(int codigo){
        Iterator<Producto> iterador = inventario.iterator();
        boolean codigoRepetido=false;
        while(iterador.hasNext()){
            producto = iterador.next();
            if(codigo==producto.getCodigo()){
                codigoRepetido=true;
            }
        }
        return codigoRepetido;
    }        
}
