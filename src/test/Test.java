package test;

import modelo.*;
import java.util.*;
import java.time.*;
public class Test {

    public static void main(String[] args) {

       
        List<Propiedad> propiedades = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<Publicacion> publicaciones = new ArrayList<>();
        List<OperacionInmobiliaria> operaciones = new ArrayList<>();

        
        Sistema sistema = new Sistema(
                propiedades,
                clientes,
                publicaciones,
                operaciones
        );

        // 1) Agregar clientes
        sistema.agregarCliente(11111111L, "Cliente", "Uno");
        sistema.agregarCliente(22222222L, "Cliente", "Dos");
        sistema.agregarCliente(33333333L, "Cliente", "Tres");

        // Imprimir clientes
        System.out.println("LISTA DE CLIENTES");
        for (Cliente c : sistema.getLstClientes()) {
            System.out.println(c);
        }
        
        
     // 2) Agregar propiedades
        sistema.agregarCasa(
                101,
                "Calle AA",
                "Temperley",
                150.0f,
                2,
                true
        );

        sistema.agregarCasa(
                102,
                "Calle BB",
                "Lomas de Zamora",
                250.0f,
                4,
                false
        );

        sistema.agregarDepartamento(
                201,
                "Calle AB",
                "Temperley",
                80.0f,
                2,
                8,
                true
        );

        sistema.agregarDepartamento(
                202,
                "Calle BA",
                "Lomas de Zamora",
                65.0f,
                7,
                3,
                false
        );

        // Imprimir propiedades
        System.out.println("\nLISTA DE PROPIEDADES");
        for (Propiedad p : sistema.getLstPropiedades()) {
            System.out.println(p);
        }
        
     // 3) Agregar publicaciones
        sistema.agregarPublicacion(
                sistema.traerPropiedad(101),
                LocalDate.of(2025, 11, 25),
                "Alquiler",
                600f
        );

        sistema.agregarPublicacion(
                sistema.traerPropiedad(102),
                LocalDate.of(2025, 11, 26),
                "Venta",
                270000f
        );

        sistema.agregarPublicacion(
                sistema.traerPropiedad(201),
                LocalDate.of(2025, 11, 26),
                "Alquiler",
                500f
        );

        sistema.agregarPublicacion(
                sistema.traerPropiedad(202),
                LocalDate.of(2025, 11, 26),
                "Venta",
                100000f
        );

        sistema.agregarPublicacion(
                sistema.traerPropiedad(102),
                LocalDate.of(2025, 11, 27),
                "Alquiler",
                800f
        );

        // Imprimir publicaciones
        System.out.println("\nLISTA DE PUBLICACIONES");
        for (Publicacion p : sistema.getLstPublicaciones()) {
            System.out.println(p);
        }
        
        
     // 4) Agregar operaciones inmobiliarias
        sistema.agregarOperacionInmobiliaria(
                LocalDate.of(2025, 11, 28),
                sistema.traerPublicacion(
                        sistema.traerPropiedad(101),
                        "Alquiler"
                ),
                sistema.traerCliente(11111111L)
        );

        sistema.agregarOperacionInmobiliaria(
                LocalDate.of(2025, 12, 5),
                sistema.traerPublicacion(
                        sistema.traerPropiedad(102),
                        "Alquiler"
                ),
                sistema.traerCliente(22222222L)
        );

        sistema.agregarOperacionInmobiliaria(
                LocalDate.of(2025, 12, 12),
                sistema.traerPublicacion(
                        sistema.traerPropiedad(202),
                        "Venta"
                ),
                sistema.traerCliente(33333333L)
        );

        // Imprimir operaciones inmobiliarias
        System.out.println("\nLISTA DE OPERACIONES INMOBILIARIAS");
        for (OperacionInmobiliaria op : sistema.getLstOperacionesInmobiliarias()) {
            System.out.println(op);
        }
        //5
        System.out.println("\nPUBLICACIONES ENTRE 2025-11-25 Y 2025-11-26");

        List<Publicacion> publicacionesPorFecha =
                sistema.traerPublicacionesPorFecha(
                        LocalDate.of(2025, 11, 25),
                        LocalDate.of(2025, 11, 26)
                );

        for (Publicacion p : publicacionesPorFecha) {
            System.out.println(p);
        }
        
       //6
        System.out.println("\nPUBLICACIONES DE CASAS (3 HABITACIONES MINIMO) ENTRE 2025-11-26 Y 2025-11-27");

        List<Publicacion> publicacionesCasas =
                sistema.traerPublicacionesDeCasas(
                        LocalDate.of(2025, 11, 26),
                        LocalDate.of(2025, 11, 27),
                        3
                );

        for (Publicacion p : publicacionesCasas) {
            System.out.println(p);
        }
        
        //7
        System.out.println("\nCLIENTES CON OPERACIONES INMOBILIARIAS DE TIPO VENTA");

        List<Cliente> clientesVenta =
                sistema.traerClientesConOperacionesInmobiliarias("Venta");

        for (Cliente c : clientesVenta) {
            System.out.println(c);
        }
        
        //8
        System.out.println("\nINTENTAR AGREGAR CLIENTE");

        try {
            sistema.agregarCliente(22222222, "Cliente", "Dos");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        
        //9
        System.out.println("\nINTENTAR AGREGAR PUBLICACION ");

        try {
            sistema.agregarPublicacion(
                sistema.traerPropiedad(202),
                LocalDate.of(2025, 11, 29),
                "Alquiler",
                0
            );
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        
    }
}
