package modelo;

public class BibliotecaMusical {
    private Cancion[] catalogo;
    private int contadorCatalogo;
    private int maxCatalogo;

    public BibliotecaMusical(int maxCatalogo) {
        this.maxCatalogo = maxCatalogo;
        this.catalogo = new Cancion[maxCatalogo];
        this.contadorCatalogo = 0;
    }

    public boolean agregarCancion(Cancion cancion) { //respeta la relación de agregación entre modelo.Playlist y modelo.Cancion
        if (contadorCatalogo < maxCatalogo) {
            catalogo [contadorCatalogo] = cancion;
            contadorCatalogo++;
            return true; // vamos a mandar hacia afuera si se pudo agregar la canción a través de un true o false
        } else {
            return false; // No se pudo agregar la canción, playlist llena
        }
    }
    public Cancion buscarPorNombre(String nombre) {
        for(int i = 0; i < contadorCatalogo; i++) {
            if(catalogo[i].getTitulo().equalsIgnoreCase(nombre)) {
                System.out.println("Cancion encontrada");
                return catalogo[i];

            }
        }
        System.out.println("Cancion no encontrada");
        return null;
    }
    public Cancion[] listarCatalogo() {
        Cancion[] listaActual = new Cancion[contadorCatalogo];
        for (int i = 0; i < contadorCatalogo; i++) {
            listaActual[i] = catalogo[i];
        }
        return listaActual;
    }
}
