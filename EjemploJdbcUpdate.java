package org.example;

import org.example.modelo.Categoria;
import org.example.modelo.Producto;
import org.example.repositorio.ProductoRepositorioImpl;
import org.example.repositorio.Repocitorio;
import org.example.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;



public class EjemploJdbcUpdate {
    public static void main(String[] args) {

        try(Connection conn = ConexionBaseDatos.getInstance()) {

            Repocitorio<Producto> repocitorio = new ProductoRepositorioImpl();
            System.out.println("============== listar ============");
            repocitorio.listar().forEach(System.out::println);

            System.out.println("============== obtener por id ============");
            System.out.println(repocitorio.porId(1L));

            System.out.println("============== editar producto ============");
            Producto producto = new Producto();
            producto.setId(12L);
            producto.setNombre("Teclado pirulo mecanico");
            producto.setPrecio(700);
            Categoria categoria = new Categoria();
            categoria.setId(2L);
            producto.setCategoria(categoria);
            repocitorio.guardar(producto);
            System.out.println("Producto actualizado con exito");
            repocitorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
