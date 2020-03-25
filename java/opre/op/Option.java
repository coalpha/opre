package opre.op;

import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Rust's <code>std::Option</code> ported to Java
 * @see https://doc.rust-lang.org/std/option/enum.Option.html
 */
public interface Option<T> {
   public boolean is_some();
   public boolean is_none();
   public T expect(String msg);
   public T unwrap();
   public T unwrap_or(T def);
   public T unwrap_or_else(Supplier<T> fn);
   public <U> Option<U> map(Function<T, U> fn);

   // my methods
   public void consume(Consumer<T> scope);

   public <U> U fork(Function<T, U> some, Supplier<U> none);

   public static <some_t> Some<some_t> Some(some_t val) {
      return new Some<>(val);
   }

   public static <dummy_t> None<dummy_t> None() {
      return new None<>();
   }

   public static <T> Option<T> fromNullable(T val) {
      if (val == null) {
         return new None<>();
      }
      return new Some<>(val);
   }
}
