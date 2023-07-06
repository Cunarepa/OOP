import java.util.HashMap;
import java.util.Iterator;
public class DZ6 {
    private static HashMap<Integer, Object> map = new HashMap<>();
    private static final Object o = new Object();
    public static void main(String[] args) {
        addToHMap(23);
        addToHMap(8);
        addToHMap(17);
        addToHMap(11);
        addToHMap(9);
        addToHMap(6);
        addToHMap(13);
        addToHMap(42);
        addToHMap(44);
        addToHMap(15);
        System.out.println(isEmpty());

        printConsole();
        System.out.println();
        try {
            System.out.println(printOneEl(20));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addToHMap(Integer number){
        map.put(number, o);
    }


    private static boolean isEmpty(){
        return map.isEmpty();
    }


    private static void printConsole(){
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }


    private static int printOneEl(int index){
        return (Integer)map.keySet().toArray()[index];
    }
}
