package app;


import modelo.*;

import java.util.Scanner;

public class SpotifyApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // A. Preparación antes del menú

// Biblioteca principal
        BibliotecaMusical biblioteca = new BibliotecaMusical(20);

// Biblioteca secundaria (ej: biblioteca mensual)
        BibliotecaMusical bibliotecaMensual = new BibliotecaMusical(10);

// Cuenta
        CuentaSpotify cuenta = new CuentaSpotify("admin", "1234", 10, biblioteca);

// ===== Canciones de prueba =====
        Cancion c1 = new Cancion("Numb", 210, "Linkin Park");
        Cancion c2 = new Cancion("Believer", 204, "Imagine Dragons");
        Cancion c3 = new Cancion("Fix You", 295, "Coldplay");
        Cancion c4 = new Cancion("Counting Stars", 257, "OneRepublic");
        Cancion c5 = new Cancion("Demons", 177, "Imagine Dragons");
        Cancion c6 = new Cancion("Viva La Vida", 242, "Coldplay");
        Cancion c7 = new Cancion("In The End", 216, "Linkin Park");

// Agregar canciones a biblioteca principal
        biblioteca.agregarCancion(c1);
        biblioteca.agregarCancion(c2);
        biblioteca.agregarCancion(c3);
        biblioteca.agregarCancion(c4);
        biblioteca.agregarCancion(c5);

// Agregar canciones a biblioteca mensual
        bibliotecaMensual.agregarCancion(c6);
        bibliotecaMensual.agregarCancion(c7);

// ===== Playlists =====
        Playlist rock = new Playlist("Rock", 10);
        Playlist chill = new Playlist("Chill", 10);
        Playlist favoritos = new Playlist("Favoritos", 15);

// Agregar playlists a la cuenta (cuando se inicie sesión)
        cuenta.agregarPlaylist(rock);
        cuenta.agregarPlaylist(chill);
        cuenta.agregarPlaylist(favoritos);

// ===== Canciones dentro de playlists =====
        rock.agregarCancion(c1);
        rock.agregarCancion(c7);

        chill.agregarCancion(c3);
        chill.agregarCancion(c6);

        favoritos.agregarCancion(c2);
        favoritos.agregarCancion(c4);
        favoritos.agregarCancion(c5);

// ===== Reproducción (polimorfismo) =====
        Reproducible actual = null;


        // Control del programa
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MINI-SPOTIFY ===");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Gestionar Biblioteca Musical");
            System.out.println("3. Gestionar Playlists");
            System.out.println("4. Reproducir Canciones");
            System.out.println("5. Cerrar sesión");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1: // Iniciar sesión
                    System.out.print("Usuario: ");
                    String u = sc.nextLine();
                    System.out.print("Password: ");
                    String p = sc.nextLine();
                    cuenta.inisiarSesion(u, p);
                    break;

                case 2: // Biblioteca Musical
                    int opBib;
                    do {
                        System.out.println("\n--- Biblioteca Musical ---");
                        System.out.println("1. Listar canciones");
                        System.out.println("2. Agregar canción");
                        System.out.println("3. Buscar por nombre");
                        System.out.println("4. Volver");
                        System.out.print("Opción: ");

                        opBib = sc.nextInt();
                        sc.nextLine();

                        switch (opBib) {
                            case 1:
                                Cancion[] lista = biblioteca.listarCatalogo();
                                for (int i = 0; i < lista.length; i++) {
                                    System.out.println(i + " - " + lista[i]);
                                }
                                break;

                            case 2:
                                System.out.print("Título: ");
                                String t = sc.nextLine();
                                System.out.print("Duración (segundos): ");
                                int d = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Artista: ");
                                String a = sc.nextLine();
                                biblioteca.agregarCancion(new Cancion(t, d, a));
                                break;

                            case 3:
                                System.out.print("Nombre a buscar: ");
                                biblioteca.buscarPorNombre(sc.nextLine());
                                break;
                        }
                    } while (opBib != 4);
                    break;

                case 3: // Playlists
                    int opPl;
                    do {
                        System.out.println("\n--- Playlists ---");
                        System.out.println("1. Crear playlist");
                        System.out.println("2. Listar playlists");
                        System.out.println("3. Agregar canción a playlist");
                        System.out.println("4. Ver canciones");
                        System.out.println("5. Volver");
                        System.out.print("Opción: ");

                        opPl = sc.nextInt();
                        sc.nextLine();

                        switch (opPl) {
                            case 1:
                                System.out.print("Nombre playlist: ");
                                cuenta.agregarPlaylist(new Playlist(sc.nextLine(), 10));
                                break;

                            case 2:
                                cuenta.listarPlaylists();
                                break;

                            case 3:
                                System.out.print("Playlist: ");
                                String pl = sc.nextLine();
                                System.out.print("Canción: ");
                                Cancion can = biblioteca.buscarPorNombre(sc.nextLine());
                                if (can != null) {
                                    cuenta.agreegarCancionAPlaylist(pl, can);
                                }
                                break;

                            case 4:
                                System.out.print("Nombre de la playlist: ");
                                cuenta.verCancionesDePlaylist(sc.nextLine());
                                break;
                        }
                    } while (opPl != 5);
                    break;

                case 4: // Reproducción
                    int opRep;
                    do {
                        System.out.println("\n--- Reproducción ---");
                        System.out.println("1. Reproducir canción desde playlist");
                        System.out.println("2. Detener reproducción");
                        System.out.println("3. Volver");
                        System.out.print("Opción: ");

                        opRep = sc.nextInt();
                        sc.nextLine();

                        switch (opRep) {
                            case 1:
                                System.out.print("Playlist: ");
                                String rp = sc.nextLine();
                                System.out.print("Índice canción: ");
                                int idx = sc.nextInt();
                                sc.nextLine();
                                cuenta.reproducir(rp, idx);
                                break;

                            case 2:
                                if (actual != null) {
                                    actual.detener();
                                    actual = null;
                                } else {
                                    System.out.println("No hay reproducción activa");
                                }
                                break;
                        }
                    } while (opRep != 3);
                    break;

                case 5:
                    cuenta.cerrarSesion();
                    break;

                case 6:
                    salir = true;
                    System.out.println("Programa finalizado");
                    break;
            }
        }

        sc.close();
    }
}