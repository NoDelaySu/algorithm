package xiaomi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//3,2
//1,2,5
//2,1,7
//3,1,9

/**
 * @ClassName: Main01
 * @Package: xiaomi
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/23 15:47
 * @Version: 1.0
 */
public class Main01 {

    static class Station{
        int x;
        int y;
        int q;

        public Station(int x, int y, int q) {
            this.x = x;
            this.y = y;
            this.q = q;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        int stationCount = Integer.parseInt(split[0]);
        int maxDistance = Integer.parseInt(split[1]);

        List<Station> stations = new ArrayList<>();

        for (int i = 0; i < stationCount; i++) {
            String s1 = scanner.nextLine();
            String[] split1 = s1.split(",");
            int x = Integer.parseInt(split1[0]);
            int y = Integer.parseInt(split1[1]);
            int q = Integer.parseInt(split1[2]);
            Station station = new Station(x, y, q);
            stations.add(station);

        }

        double maxSignalStrength = Double.MIN_VALUE;
        String bestCoordinate = "";


        for (int x = 0; x <= 100; x++) {
            for (int y = 0; y <= 100; y++) {
                double currPointSignalStrength = 0;
                for (Station station : stations) {
                    int dx = station.x - x;
                    int dy = station.y - y;
                    double distance = Math.sqrt(dx*dx+dy*dy);
                    if(distance <= maxDistance){
                        // 手机最大接受距离对于该点与基站距离
                        double stationAndPointSignalStrength = Math.floor(station.q / (1.0 + distance));
                        //stationAndPointSignalStrength = Math.max(currPointSignalStrength, stationSignalStrength);
                        currPointSignalStrength += stationAndPointSignalStrength;

                    }
                }
                if(currPointSignalStrength > maxSignalStrength){
                    maxSignalStrength = currPointSignalStrength;
                    bestCoordinate = x+","+y;
                }

            }
        }

        System.out.println(bestCoordinate);
    }
}
