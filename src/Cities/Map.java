package Cities;

public class Map {
    private int number_of_cities;
    private int[][] my_map;


    public Map(int number_of_cities, int[][] map) {
        this.number_of_cities = number_of_cities;
        for(int i = 0; i < number_of_cities; i++){
            for(int j = 0; j < number_of_cities; j++){
                my_map[i][j] = map[i][j];
            }
        }
    }

    public int getNumberofCities(){
        return this.number_of_cities;
    }

    public int getDistance(int a, int b){
        return my_map[a][b];
    }
}
