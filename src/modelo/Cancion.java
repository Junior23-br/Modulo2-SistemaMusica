package modelo;

public class Cancion extends Multimedia implements Reproducible {
   private String artista;
    public Cancion(String titulo, int duracion, String artista) {
        super(titulo, duracion);
        this.artista = artista;
    }
    @Override
    public String getInto() {
         return "Canción: " + this.titulo
                + ", Artista: " + this.artista
                + ", Duración: " + this.duracionSegundos + " segundos";
    }
    @Override
    public void reproducir() {
        System.out.println("Reproduciendo canción: " + this.titulo + " de " + this.artista);
    }

    @Override
    public void detener() {
        System.out.println("Deteniendo canción: " + this.titulo);
    }
    @Override
    public String toString() {
       return getInto();
    }
}
