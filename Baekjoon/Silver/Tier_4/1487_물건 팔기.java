import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(br.readLine());

        int[][] costs = new int[N][2];
        for(int i = 0 ; i < N; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            costs[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            costs[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                int result = o1[0] - o2[0];
                if(result == 0)
                    result = o1[1] - o2[1];

                return result;
            }
        });

        int maxPrice = 0;
        int maxTotalPrice = 0;

        for(int i = 0 ; i < N ; i++){
            int total = 0;
            for(int j = i; j < N ;j++){
                int benefit = costs[i][0] - costs[j][1];
                if(benefit > 0)
                    total += benefit;
            }
            if(maxTotalPrice < total){
                maxTotalPrice = total;
                maxPrice = costs[i][0];
            }
        }

        System.out.println(maxPrice);
    }
}
