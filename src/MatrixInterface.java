public interface MatrixInterface {
    void printMatrix();

    void dims();

    Object elem(int i, int a);

    Object[] rowGet(int n);

    Object[] columnGet(int m);

    void fillMatrix();

    void fillElem(int i, int o, Object n);

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();
}
