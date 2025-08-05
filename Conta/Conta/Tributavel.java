package conta;

public interface Tributavel {

    default double calcularTributo() {
        return 0.0;
    }
}
