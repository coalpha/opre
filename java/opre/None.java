package opre;

import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.function.Function;

public class None<dummy_t> implements Option<dummy_t> {
   @Override
   public boolean is_some() {
      return false;
   }

   @Override
   public boolean is_none() {
      return true;
   }

   @Override
   public dummy_t expect(String msg) {
      try {
         throw new RuntimeException(msg);
      } catch (RuntimeException e) {
         e.printStackTrace();
         System.exit(1);
      }
      return null;
   }

   @Override
   public dummy_t unwrap() {
      this.expect("Called Option.unwrap on None");
      return null;
   }
   
   @Override
   public dummy_t unwrap_or(dummy_t def) {
      return def;
   }

   @Override
   public dummy_t unwrap_or_else(Supplier<dummy_t> fn) {
      return fn.get();
   }

   @Override
   @SuppressWarnings("unchecked")
   public <U> Option<U> map(Function<dummy_t, U> drop) {
      return (Option<U>) this;
   }

   @Override
   public void consume(Consumer<dummy_t> drop) {}

   @Override
   public <U> U fork(Function<dummy_t, U> drop, Supplier<U> fn) {
      return fn.get();
   };
}