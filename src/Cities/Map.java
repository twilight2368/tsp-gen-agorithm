package Cities;

public class Map {
    public static int number_of_city;
    private static int[][] my_map;

    public Map(int number_of_cities, int[][] map) {
        number_of_city = number_of_cities;

        for (int i = 0; i < number_of_cities; i++) {
            for (int j = 0; j < number_of_cities; j++) {
                my_map[i][j] = map[i][j];
            }
        }
    }

    

    public static int getDistance(int a, int b) {
        return my_map[a][b];
    }
}
