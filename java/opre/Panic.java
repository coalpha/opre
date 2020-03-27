package opre;

@SuppressWarnings("serial")
public class Panic extends Error implements Runnable {
   public Panic(String msg) {
      super(msg == null ? "" : msg);
   }

   @Override
   public void run() {
      System.out.println("Panic: " + super.getMessage());
      var stackTrace = super.getStackTrace();
      for (var element : stackTrace) {
         System.err.println("   at " + element.toString());
      }
      System.exit(1);
   }
}
