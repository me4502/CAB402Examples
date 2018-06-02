package com.me4502.cab402;

public class LambdasVsAnonymous {

    public static void main(String[] args) {
        anonymousClass();
        lambda();
        methodReference();
    }

    public static void anonymousClass() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Class");
            }
        }).start();
    }

    public static void lambda() {
        new Thread(() -> System.out.println("Lambda")).start();
    }

    private static void runnableFunction() {
        System.out.println("Method Reference");
    }

    public static void methodReference() {
        new Thread(LambdasVsAnonymous::runnableFunction).start();
    }

    /*
      public static void anonymousClass();
        Code:
           0: new           #5                  // class java/lang/Thread
           3: dup
           4: new           #6                  // class com/me4502/cab402/LambdasVsAnonymous$1
           7: dup
           8: invokespecial #7                  // Method com/me4502/cab402/LambdasVsAnonymous$1."<init>":()V
          11: invokespecial #8                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;)V
          14: invokevirtual #9                  // Method java/lang/Thread.start:()V
          17: return

      public static void lambda();
        Code:
           0: new           #5                  // class java/lang/Thread
           3: dup
           4: invokedynamic #10,  0             // InvokeDynamic #0:run:()Ljava/lang/Runnable;
           9: invokespecial #8                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;)V
          12: invokevirtual #9                  // Method java/lang/Thread.start:()V
          15: return

      private static void lambda$lambda$0();
        Code:
           0: getstatic     #11                 // Field java/lang/System.out:Ljava/io/PrintStream;
           3: ldc           #15                 // String Lambda
           5: invokevirtual #13                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
           8: return

      public static void methodReference();
        Code:
           0: new           #5                  // class java/lang/Thread
           3: dup
           4: invokedynamic #14,  0             // InvokeDynamic #1:run:()Ljava/lang/Runnable;
           9: invokespecial #8                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;)V
          12: invokevirtual #9                  // Method java/lang/Thread.start:()V
          15: return

      private static void runnableFunction();
        Code:
           0: getstatic     #11                 // Field java/lang/System.out:Ljava/io/PrintStream;
           3: ldc           #12                 // String Method Reference
           5: invokevirtual #13                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
           8: return

    BootstrapMethods:
      0: #46 REF_invokeStatic java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
        Method arguments:
          #47 ()V
          #48 REF_invokeStatic com/me4502/cab402/LambdasVsAnonymous.lambda$lambda$0:()V
          #47 ()V
      1: #46 REF_invokeStatic java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
        Method arguments:
          #47 ()V
          #55 REF_invokeStatic com/me4502/cab402/LambdasVsAnonymous.runnableFunction:()V
          #47 ()V

     */
}
