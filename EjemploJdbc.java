package org.example;

import org.example.modelo.Categoria;
import org.example.modelo.Producto;
import org.example.repositorio.ProductoRepositorioImpl;
import org.example.repositorio.Repocitorio;
import org.example.util.ConexionBaseDatos;

import java.sql.*;

import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {

        try(Connection conn = ConexionBaseDatos.getInstance()) {

            Repocitorio<Producto> repocitorio = new ProductoRepositorioImpl();
            System.out.println("============== listar ============");
            repocitorio.listar().forEach(System.out::println);

            System.out.println("============== obtener por id ============");
            System.out.println(repocitorio.porId(2L));

            System.out.println("============== insertar nuevo producto ============");
            Producto producto = new Producto();
            producto.setNombre("Teclado red pirulin mecanico");
            producto.setPrecio(450);
            producto.setFechaRegistro( new Date());
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);
            repocitorio.guardar(producto);
            System.out.println("Producto guardado con exito");
            repocitorio.listar().forEach(System.out::println);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
