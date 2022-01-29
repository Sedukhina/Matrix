import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public final class ImmutableMatrix implements MatrixInterface{
    final int row;
    final int column;
    final Object[][] arr;

    ImmutableMatrix(int m, int n){
        row = m;
        column = n;
        arr = new Object[row][column];
    }

    ImmutableMatrix(Matrix mass){
        this.row = mass.getRow();
        this.column = mass.getColumn();
        arr = mass.getArr();
    }

    ImmutableMatrix(ImmutableMatrix mass){
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


    public void randomInt(int min, int max){
        for(int i = 0; i< row; i++){
            for (int o = 0; o< column; o++){
                Random randomizer = new Random();
                arr[i][o] = randomizer.nextInt(max - min) + min;
            }
        }
    }

    public void fillElem(int i, int o, Object n){
        arr[i][o] = n;
    }

    public Matrix transpose(){
        Object[][] array = new Object[column][row];
        for(int i=0; i<column; i++){
            for (int n = 0; n<row; n++){
                array[i][n] = arr[n][i];
            }
        }
        Matrix m = new Matrix(array);
        return m;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableMatrix that = (ImmutableMatrix) o;
        if (row != that.row) return false;
        if (column != that.column) return false;
        return Arrays.deepEquals(arr, that.arr);
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        result = 31 * result + Arrays.deepHashCode(arr);
        return result;
    }
}
