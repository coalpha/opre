import opre.*;
import static opre.Option.*;

public class Test {
   public static void main(String[] args) {
      Test.throwInLambda();
      Test.pointerComparison();
   }

   static void throwInLambda() {
      var res = Result.trycatch(() -> {
         if (Math.random() > .5) {
            return "oh yes!";
         } else {
            throw new Throwable("oh no!");
         }
      });
      System.out.println(res);
   }

   static void pointerComparison() {
      Integer i = 10;
      Option<Integer> o0 = Some(i);
      Option<Integer> o1 = Some(i);
      System.out.println(o0.val_ptr() == o1.val_ptr());
   }
}
