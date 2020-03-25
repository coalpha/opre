package opre.re;

import opre.op.Option;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.Consumer;

/**
 * Rust's <code>std::Result</code> ported to Java
 * @see https://doc.rust-lang.org/std/result/enum.Result.html
 */
public interface Result<ok_t, err_t> {
   public boolean is_ok();
   public boolean is_err();
   public Option<ok_t> ok();
   public Option<err_t> err();
   public ok_t expect(String msg);
   public ok_t unwrap();
   public ok_t unwrap_or(ok_t def);
   public ok_t unwrap_or_else(Supplier<ok_t> fn);
   public <U> Result<U, err_t> map(Function<ok_t, U> fn);

   // my methods
   public void consume(Consumer<ok_t> scope);

   public <U> U fork(Function<ok_t, U> some, Function<err_t, U> none);

   public static <ok_t> Ok<ok_t> Ok(ok_t val) {
      return new Ok<>(val);
   }

   public static <err_t> Err<err_t> Err(err_t val) {
      return new Err<>(val);
   };
}
