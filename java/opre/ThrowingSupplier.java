package opre;

public interface ThrowingSupplier<T> {
   public T get() throws Throwable;
}
