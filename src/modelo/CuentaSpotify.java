package modelo;

public class CuentaSpotify {
    private String usuario;
    private String password;
    private Playlist[] playlists;
    private BibliotecaMusical biblioteca;
    private boolean sesionIniciada;
    private int contadorPlaylists;

    public CuentaSpotify(String usuario, String password, int maxPlaylists, BibliotecaMusical biblioteca) {
        this.usuario = usuario;
        this.password = password;
        this.playlists = new Playlist[maxPlaylists];
        this.biblioteca = biblioteca;
        this.sesionIniciada = false;
        this.contadorPlaylists = 0;
    }
    public boolean inisiarSesion (String u, String p) {
        if(usuario.equals(u) && password.equals(p)) {
            sesionIniciada = true;
            System.out.println("Sesion inciiada correctamente");
            return true;
        }
        System.out.println("Sesion incorrecta");
        return false;
    }
    public boolean agregarPlaylist (Playlist p) {
        if(contadorPlaylists < playlists.length) {
            playlists[contadorPlaylists] = p;
            contadorPlaylists++;
            System.out.println("Playlist agregado correctamente");
            return true;
        }
        System.out.println("Playlist no agregada, limite excedido");
        return false;
    }
    public boolean agreegarCancionAPlaylist(String nombrePlayList, Cancion c) {
        for (int i = 0; i < contadorPlaylists; i++) {
            if (playlists[i].getNombre().equalsIgnoreCase(nombrePlayList)) {
                return playlists[i].agregarCancion(c);
            }
        }
        System.out.println("Playlist no encontrada");
        return false;
    }
    public boolean reproducir(String nombrePlaylist, int indexCancion) {
        for (int i = 0; i < contadorPlaylists; i++) {
            if (playlists[i].getNombre().equalsIgnoreCase(nombrePlaylist)) {
                return playlists[i].reproducirCancion(indexCancion);
            }
        }

        System.out.println("Playlist no encontrada");
        return false;
    }

    public void cerrarSesion() {
        sesionIniciada = false;
        System.out.println("Sesión cerrada");
    }
    public void listarPlaylists() {
        if (contadorPlaylists == 0) {
            System.out.println("No hay playlists creadas");
            return;
        }

        for (int i = 0; i < contadorPlaylists; i++) {
            System.out.println(i + " - " + playlists[i].getNombre());
        }
    }
    public void verCancionesDePlaylist(String nombrePlaylist) {
        for (int i = 0; i < contadorPlaylists; i++) {
            if (playlists[i].getNombre().equalsIgnoreCase(nombrePlaylist)) {

                Cancion[] canciones = playlists[i].listarCanciones();

                if (canciones.length == 0) {
                    System.out.println("La playlist está vacía");
                    return;
                }

                for (int j = 0; j < canciones.length; j++) {
                    System.out.println(j + " - " + canciones[j]);
                }
                return;
            }
        }
        System.out.println("Playlist no encontrada");
    }
    public boolean isSesionIniciada() {
        return sesionIniciada;
    }

}