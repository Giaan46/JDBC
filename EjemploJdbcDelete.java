package org.example;

import org.example.modelo.Producto;
import org.example.repositorio.ProductoRepositorioImpl;
import org.example.repositorio.Repocitorio;
import org.example.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcDelete {
    public static void main(String[] args) {

        try(Connection conn = ConexionBaseDatos.getInstance()) {

            Repocitorio<Producto> repocitorio = new ProductoRepositorioImpl();
            System.out.println("============== listar ============");
            repocitorio.listar().forEach(System.out::println);

            System.out.println("============== obtener por id ============");
            System.out.println(repocitorio.porId(1L));

            System.out.println("============== eliminar producto ============");
            Producto producto = new Producto();
            repocitorio.eliminar(10L);

            System.out.println("Producto eliminado con exito");
            repocitorio.listar().forEach(System.out::println);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
