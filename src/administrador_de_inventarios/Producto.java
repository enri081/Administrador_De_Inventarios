/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrador_de_inventarios;

/**
 * Clase Producto
 * Representa un producto en el inventario.
 * Contiene atributos para el nombre, código, categoría y precio.
 * @author enrim
 */
public class Producto {
    private String nombre; //Nombre producto
    private int codigo; //Codigo unico del producto
    private TipoCategoria categoria; //Categoria del producto
    private double precio; //Precio del producto
    
     /**
     * Constructor por defecto
     */
    public Producto(){
        
    }
    
    /**
     * Constructor con parámetros
     * @param nombre Nombre del producto
     * @param codigo Código único del producto
     * @param categoria Categoría del producto
     * @param precio Precio del producto
     */
    public Producto(String nombre, int codigo, TipoCategoria categoria, double precio){
        this.nombre=nombre;
        this.codigo=codigo;
        this.categoria=categoria;
        this.precio=precio;
    }
    
    /**
     * Obtiene el nombre del producto
     * @return nombre del producto
     */
    public String getNombre() {
        return nombre;
    }
    
     /**
     * Establece el nombre del producto
     * @param nombre Nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
     /**
     * Obtiene el código del producto
     * @return código del producto
     */
    public int getCodigo() {
        return codigo;
    }
    
    /**
     * Establece el código del producto
     * @param codigo Código único del producto
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    /**
     * Obtiene la categoría del producto
     * @return categoría del producto
     */
    public TipoCategoria getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría del producto
     * @param categoria Categoría del producto
     */
    public void setCategoria(TipoCategoria categoria) {
        this.categoria = categoria;
    }
    
    /**
     * Obtiene el precio del producto
     * @return precio del producto
     */
    public double getPrecio() {
        return precio;
    }
    
    /**
     * Establece el precio del producto
     * @param precio Precio del producto
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    /**
     * Representación en cadena del producto
     * @return Información del producto en formato String
     */    
    @Override
    public String toString(){
        return "Nombre: " + nombre + "\n" +
               "Codigo: " + codigo + "\n" +
               "Categoria: " + categoria.getNombreCategoria() + "\n" +
               "Precio: " + precio + " euros";
    }
}    