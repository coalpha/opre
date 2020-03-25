package opre.re;

import opre.op.*;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.Consumer;

public class Err<err_t> implements Result<Object, err_t> {
   private final err_t val;

   public Err(err_t val) {
      this.val = val;
   }

   @Override
   public boolean is_ok() {
      return false;
   }

   @Override
   public boolean is_err() {
      return true;
   }

   @Override
   public None<Object> ok() {
      return new None<Object>();
   };

   @Override
   public Option<err_t> err() {
      return new Some<err_t>(this.val);
   };

   @Override
   public err_t expect(String msg) {
      try {
         throw new RuntimeException(msg);
      } catch (RuntimeException e) {
         e.printStackTrace();
         System.exit(1);
      }
      return null;
   };

   @Override
   public err_t unwrap() {
      this.expect("Called Result.unwrap on Err");
      return null;
   };

   @Override
   public Object unwrap_or(Object def) {
      return def;
   };

   @Override
   public Object unwrap_or_else(Supplier<Object> fn) {
      return fn.get();
   };

   @Override
   @SuppressWarnings("unchecked")
   public <U> Result<U, err_t> map(Function<Object, U> drop) {
      return (Result<U, err_t>) this;
   };
}
