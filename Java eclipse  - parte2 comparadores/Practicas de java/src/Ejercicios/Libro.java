package Ejercicios;

public class Libro implements Comparable<Libro> {
    private String titulo;
    private String autor;
    private int a�o;

    // Constructor
    public Libro(String titulo, String autor, int a�o) {
        this.titulo = titulo;
        this.autor = autor;
        this.a�o = a�o;
    }

    // M�todos getter
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getA�o() {
        return a�o;
    }

    // Implementaci�n del m�todo compareTo para ordenar por t�tulo alfab�ticamente
    @Override
    public int compareTo(Libro otro) {
        return this.titulo.compareTo(otro.titulo);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", a�o=" + a�o +
                '}';
    }
}
