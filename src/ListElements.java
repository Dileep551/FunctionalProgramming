import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListElements {


    public static void main(String[] args) {


        List<Integer> listElements = new ArrayList<>(List.of(1, 23, 54, 11, 42));

        for (Integer value : listElements){
            System.out.println(value);
        }

        Iterator iterator = listElements.iterator();

        while (iterator.hasNext()){

            System.out.println(iterator.next());
        }

    }


}
