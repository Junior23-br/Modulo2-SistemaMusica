package modelo;

public abstract class Multimedia {
    protected String titulo;
    protected int duracionSegundos;
    public Multimedia(String titulo, int duracion) {
        this.titulo = titulo;
        this.duracionSegundos = duracion;
    }
    public Multimedia () {
        this.titulo = "Desconocido";
        this.duracionSegundos = 0;
    }
    public Multimedia(String titulo) {
        this.titulo = titulo;
        this.duracionSegundos = 0;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getDuracion() {
        return duracionSegundos;
    }
    public void setDuracion(int duracion) {
        this.duracionSegundos = duracion;
    }
    public abstract String getInto(); //Metodo para implementar en las clases hijas
}
