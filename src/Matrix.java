import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

class Matrix implements MatrixInterface{
    private int row;
    private int column;
    private Object[][] arr;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Object[][] getArr() {
        return arr;
    }

    Matrix(int m, int n){
        row = m;
        column = n;
        arr = new Object[row][column];
    }

    Matrix(Object[][] m){
        row = m.length;
        column = m[1].length;
        arr = new Object[row][column];
        for(int i = 0; i< row; i++){
            for (int o = 0; o< column; o++){
                arr[i][o] = m[i][o];
            }
        }
    }

    Matrix(){
        row = 0;
        column = 0;
        arr = null;
    }

    Matrix(Matrix mass){
        this.row = mass.row;
        this.column = mass.column;
        arr = new Object[row][column];
        for(int i = 0; i< row; i++){
            for (int o = 0; o< column; o++){
                arr[i][o] = mass.arr[i][o];
            }
        }
    }

    Matrix(ImmutableMatrix mass){
        this.row = mass.row;
        this.column = mass.column;
        arr = mass.arr;
    }

    public void printMatrix(){
        for(int i = 0; i< row; i++){
            for (int o = 0; o< column; o++){
                System.out.print(arr[i][o] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void dims(){
        System.out.print("Your matrix size is "+ row + "x" + column);
    }

    public void transpose(){
       Object[][] array = new Object[column][row];
        for(int i=0; i<column; i++){
            for (int n = 0; n<row; n++){
                array[i][n] = arr[n][i];

            }
        }
        arr = null;
        arr = new Object[column][row];
        for(int i=0; i<column; i++){
            for (int n = 0; n<row; n++) {
                arr[i][n] = array[i][n];
            }
        }
        int i = row;
        row = column;
        column = i;
    }

    public Object elem(int i, int a){
        return arr[i][a];
    }

    public Object[] rowGet(int n){
        for(int i = 0; i<column; i++){
            System.out.print(arr[n-1][i] + " ");
        }
        return arr[n-1];
    }

    public Object[] columnGet(int m){
        Object[] col = new Object[row];
        for(int i = 0; i<row; i++){
            System.out.print(arr[i][m-1] + "\n");
            col[i] = arr[i][m];
        }
        return col;
    }

    public void fillMatrix(){
        Scanner in = new Scanner(System.in);
        for(int i = 0; i< row; i++){
            for (int o = 0; o< column; o++){
                System.out.print("Matrix[" + i +"][" + o + "] = ");
                Object n =in.nextLine();
                arr[i][o] = n;
            }
        }
    }

    public void fillElem(int i, int o, Object n){
        arr[i][o] = n;
    }


    public void randomInt(int min, int max){
        for(int i = 0; i< row; i++){
            for (int o = 0; o< column; o++){
                Random randomizer = new Random();
                arr[i][o] = randomizer.nextInt(max - min) + min;
            }
        }
    }

    public void randomDouble(int min, int max){
        for(int i = 0; i< row; i++){
            for (int o = 0; o< column; o++){
                Random randomizer = new Random();
                arr[i][o] = ((double)(randomizer.nextInt(max*100 - min*100) + min*100))/100;
            }
        }
    }

    public void randomBoolean(){
        for(int i = 0; i< row; i++){
            for (int o = 0; o< column; o++){
                Random randomizer = new Random();
                arr[i][o] = randomizer.nextBoolean();
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix = (Matrix) o;

        if (row != matrix.row) return false;
        if (column != matrix.column) return false;
        return Arrays.deepEquals(arr, matrix.arr);
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        result = 31 * result + Arrays.deepHashCode(arr);
        return result;
    }
}
