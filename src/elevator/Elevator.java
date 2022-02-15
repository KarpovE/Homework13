package elevator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Elevator {

    private int lastFloor;
    private String routeOfTheLift;
    private Deque<Integer> floors;

    public Elevator(int lastFloor){
        this.lastFloor = lastFloor;
        routeOfTheLift = "";
        floors = new ArrayDeque<>(lastFloor);
    }

    public String getRouteOfTheLift(){
        return routeOfTheLift;
    }

    private void setRouteOfTheLift(){
        StringBuilder stringBuilder = new StringBuilder();
        int floor = 0;
        while (!floors.isEmpty()){
            stringBuilder.append("этаж " + Integer.toString(floors.pollFirst()) + " -> " );
        }
        stringBuilder.append("этаж 0");
        routeOfTheLift = stringBuilder.toString();
    }

    public void controlPanel(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try{
                System.out.println("Ожидаю ввода этажа: (для завершения введите 0)");
                int numberOfTheFloor = Integer.parseInt(reader.readLine());
                if(numberOfTheFloor > lastFloor || numberOfTheFloor < 0) throw new Exception();
                if(numberOfTheFloor == 0) {
                    setRouteOfTheLift();
                    System.out.println("Лифт проследовал по следующим этажам:");
                    System.out.println(routeOfTheLift);
                    break;
                } else{
                    floors.offer(numberOfTheFloor);
                }
            } catch (Exception e){
                System.out.println("Такого этажа нет в доме");
            }
        }
    }

}
