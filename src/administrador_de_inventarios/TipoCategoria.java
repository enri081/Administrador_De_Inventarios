/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package administrador_de_inventarios;

/**
 * Enumeración TipoCategoria
 * Define los diferentes tipos de categorías que puede tener un producto.
 * @author enrim
 */
public enum TipoCategoria {
    ELECTRONICA ("Electronica"),
    ROPA ("Ropa"),
    ALIMENTOSYBEBIDAS ("Alimentos y bebidas"),
    CUIDADOPERSONAL ("Cuidado personal");

    private final String nombreCategoria;
    
    /**
     * Constructor de la enumeración TipoCategoria
     * @param nombreCategoria Nombre legible de la categoría
     */
    TipoCategoria(String nombreCategoria){
        this.nombreCategoria=nombreCategoria;
    }
    
    /**
     * Obtiene el nombre legible de la categoría
     * @return Nombre de la categoría en formato String
     */
    public String getNombreCategoria() {
        return nombreCategoria;
    }  
}
