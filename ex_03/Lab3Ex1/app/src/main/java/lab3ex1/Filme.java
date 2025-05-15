package lab3ex1;
import java.util.List;

public class Filme {
    private String titulo;
    private double nota;
    private String genero;

    public Filme(String titulo, double nota, String genero) {
        this.titulo = titulo;
        this.nota = nota;
        this.genero = genero;

    }

    /**
     * @return O título do filme
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @return A nota do filme
     */
    public double getNota() {
        return nota;
    } 
    
    /**
     * @return O gênero do filme
     */
    public String getGenero() {
        return genero;
    }
}
