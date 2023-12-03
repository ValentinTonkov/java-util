import java.util.Collection;
import java.util.List;

public class Printer<T> {

    public void print(Collection<T> c){
        c.forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    public void print(T[] arr){
        for (T t :
                arr) {
            System.out.println(t);
        }
    }

}
