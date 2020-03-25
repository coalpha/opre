package opre.re;

import opre.op.*;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.Consumer;

public class Ok<ok_t> implements Result<ok_t, Object> {
   private final ok_t val;

   public Ok(ok_t val) {
      this.val = val;
   }

   @Override
   public boolean is_ok() {
      return true;
   }

   @Override
   public boolean is_err() {
      return false;
   }

   @Override
   public Some<ok_t> ok() {
      return new Some<ok_t>(this.val);
   };

   @Override
   public Option<Object> err() {
      return new None<Object>();
   };

   @Override
   public ok_t expect(String drop) {
      return this.val;
   };

   @Override
   public ok_t unwrap() {
      return this.val;
   };

   @Override
   public ok_t unwrap_or(ok_t drop) {
      return this.val;
   };

   @Override
   public ok_t unwrap_or_else(Supplier<ok_t> drop) {
      return this.val;
   };

   @Override
   public <U> Result<U, Object> map(Function<ok_t, U> fn) {
      return new Ok<U>(fn.apply(this.val));
   };
}
