public class Main {
    public static void main(String[] args) {
        Matrix mat = new Matrix(3, 5);
        mat.randomInt(1, 100);
        Matrix mat1 = new Matrix(mat);
        ImmutableMatrix mat2 = new ImmutableMatrix(mat);
        mat.printMatrix();
        mat1.printMatrix();
        mat2.printMatrix();
        System.out.print(mat.equals(mat1));
        System.out.print(mat2.equals(mat1));
        mat1.fillElem(mat1.getRow()-1, mat1.getColumn()-1, -100);
        mat1.printMatrix();
        mat.printMatrix();
        Matrix m = mat2.transpose();
        m.printMatrix();
        m.fillElem(0, 0, 0);
        m.printMatrix();
        System.exit(0);
    }

    static Matrix randomColumn(int n){
        Matrix mat = new Matrix(n, 1);
        mat.randomDouble(-5, 100);
        return mat;
    }
}
