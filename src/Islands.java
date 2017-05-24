import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ayushij on 12/24/16.
 */
public class Islands {
    public static void main(String args[]){
        Islands islands = new Islands();
        int m = 3;
        int n = 3;
        //int[][] positions = {{0,0}, {2,3}, {1,2}, {2,1}, {2,2}};
        //int[][] positions = {{0,0}};
        int[][] positions = {{0,1},{1,2},{2,1},{1,0},{0,2},{0,0},{1,1}};
        System.out.println(islands.numIslands2(m, n, positions));
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        int[][] ocean = new int[m][n];
        System.out.println(Arrays.deepToString(positions));
        int currentCount = 0;
        int row = -1;
        int col = -1;
        for(int[] position : positions ){
            row = position[0];
            col = position[1];
            System.out.println("Need to check for row " + row + " column " + col + "position " + Arrays.toString(position));
            int horizontalConnection = checkHorizontalPosition(position, ocean);
            System.out.println("horizontal connections = " + horizontalConnection);
            int verticalConnection = checkVerticalPosition(position, ocean);
            System.out.println("vertical connections = " + verticalConnection);
            if(horizontalConnection == 0 && verticalConnection == 0) {
                currentCount++;
            } else if (horizontalConnection > 0 && verticalConnection > 0) {
                currentCount = currentCount - horizontalConnection - verticalConnection + 1;
                if(currentCount<=0)
                    currentCount = 1;
            } else if ( horizontalConnection > 0) {
                //do something
                currentCount = currentCount - horizontalConnection + 1;
            } else if( verticalConnection >0 ) {
                // do something
                currentCount = currentCount - verticalConnection + 1;
            }
            result.add(currentCount);
            ocean[row][col]=1;
            System.out.println("now ocean is " + Arrays.deepToString(ocean));
        }
        System.out.println("final ocean is " + Arrays.deepToString(ocean));
        return result;
    }

    private int checkHorizontalPosition(int[] position, int[][] ocean){
        System.out.println("in horizontal position is " +  Arrays.toString(position));
        int row = position[0];
        int col = position[1];
        int maxCol = ocean[0].length-1;
        int result = 0;
        System.out.println("max col" + maxCol);
        if(col > 0 && col < maxCol){ //its not the first column
            System.out.println("checking hori col>0");
            if(ocean[row][col-1] == 1)
                result++;
            if(ocean[row][col+1] == 1)
                result++;
            System.out.println("result = " + result);

        } else if(col == 0 && col != maxCol){ //its the first column, dont try to reference col-1, null pointer exception
            System.out.println("checking hori col=0");
            if (ocean[row][col + 1] == 1)
            result++;
            System.out.println("result = " + result);
        } else if( col == maxCol && col != 0) {//last column
            System.out.println("checking hori col =end col" + ocean[0].length);
            if(ocean[row][col-1] == 1)
                result++;
            System.out.println("result = " + result);
        }
        return result;
    }

    private int checkVerticalPosition(int[] position, int[][] ocean){
        int row = position[0];
        int col = position[1];
        System.out.println("in vertical checking for row " + row + " column " + col + " position array" + Arrays.toString(position));
        int result = 0;
        int maxRow = ocean.length-1;
        if(row > 0 && row< maxRow){ //its not the first row
            System.out.println("checking vertical row>0");
            if(ocean[row-1][col] == 1)
                result++;
            if(ocean[row+1][col] == 1)
                result++;
            System.out.println("result = " + result);
        } else if(row==0 && row != maxRow){ //its the first row, dont try to reference row-1, null pointer exception
            System.out.println("checking ver row=0" + Arrays.deepToString(ocean));
            if (ocean[row+1][col] == 1)
                result++;
            System.out.println("result = " + result);
        } else if(row == maxRow && row!=0) { //last row, dont try to reference row+1
            System.out.println("checking ver row =end row" + ocean.length);
            if (ocean[row-1][col] == 1)
                result++;
            System.out.println("result = " + result);
        }
        return result;
    }
}
