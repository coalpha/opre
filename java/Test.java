import op.*;
import static op.Option.*;

public class Test {
   public static void main(String[] args) {
      Option<Integer> a = None();
      Some<Integer> b = Some(3);
      a.inside(i -> {
         System.out.println(i);
      });
      b.unwrap();
   }
}
