package Ejercicios;

public class Libro implements Comparable<Libro> {
    private String titulo;
    private String autor;
    private int año;

    // Constructor
    public Libro(String titulo, String autor, int año) {
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
    }

    // Métodos getter
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAño() {
        return año;
    }

    // Implementación del método compareTo para ordenar por título alfabéticamente
    @Override
    public int compareTo(Libro otro) {
        return this.titulo.compareTo(otro.titulo);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", año=" + año +
                '}';
    }
}
