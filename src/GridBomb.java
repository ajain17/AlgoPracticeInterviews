import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by ayushij on 1/4/17.For the given grid

 0 E 0 0
 E 0 E W
 0 E 0 0

 0 E 0 W

 return 3. (Placing a bomb at (1,1) kills 3 enemies)
 */
public class GridBomb {
    public static void main(String args[]) {
        char[][] field = {{'0','E', '0', 'W'}};
        GridBomb grid = new GridBomb();

        System.out.println(grid.countEnemies(field));
    }

    public int countEnemies(char[][] field) {
        if(field.length == 0 || field[0].length == 0)
            return 0;
        int rows = field.length - 1;
        int cols = field[0].length - 1;
        int total, count = 0;
        int finalResult = 0;
        ArrayList<int[]> indices = new ArrayList<>();
        int[] index;
        for(int i = 0; i<=rows; i++) {
            for(int j = 0; j<=cols; j++) {
                index = new int[2];
                index[0]=i;
                index[1]=j;
                indices.add(i+j,index);
            }
        }

        for(int[] arr : indices)
        {
            total = 0;
            count = 0;
            int row = arr[0];
            int col = arr[1];
            System.out.println("checking " + row + "," + col);
            if (field[row][col] != '0') {
                continue;
            }
            //calculate count of E's from top to this index
            for (int i = 0; i < row; i++) {
                if (field[i][col] == 'E')
                    count++;
                else if (field[i][col] == 'W')
                    count = 0;
            }
            System.out.println("count from top to i is" + count);
            total += count;
            count = 0;
            //calculate count of E's from this index to bottom
            for (int i = row + 1; i <= rows; i++) {
                if (field[i][col] == 'E') {
                    count++;
                } else if (field[i][col] == 'W')
                    break;
            }
            System.out.println("count from i to bottom is" + count);
            total += count;
            count = 0;
            for (int j = 0; j < col; j++) {
                if (field[row][j] == 'E')
                    count++;
                else if (field[row][j] == 'W')
                    count = 0;
            }
            System.out.println("count from left to j is" + count);
            total += count;
            count = 0;
            for (int j = col; j <= cols; j++) {
                if (field[row][j] == 'E')
                    count++;
                else if (field[row][j] == 'W')
                    break;
            }
            System.out.println("count from j to right is" + count);

            total += count;
            finalResult = Math.max(total, finalResult);
            System.out.println("total = " + total + " final " + finalResult);
        }
        return finalResult;
    }
}