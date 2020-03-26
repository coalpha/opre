package opre;

interface SupplierCanThrow<T> {
   public T get() throws Throwable;
}
