package com.me4502.cab402;

public class LambdasVsAnonymous {

    public static void main(String[] args) {
        anonymousClass();
        lambda();
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

    /*
      public static void anonymousClass();
        Code:
           0: new           #4                  // class java/lang/Thread
           3: dup
           4: new           #5                  // class com/me4502/cab402/LambdasVsAnonymous$1
           7: dup
           8: invokespecial #6                  // Method com/me4502/cab402/LambdasVsAnonymous$1."<init>":()V
          11: invokespecial #7                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;)V
          14: invokevirtual #8                  // Method java/lang/Thread.start:()V
          17: return

      public static void lambda();
        Code:
           0: new           #4                  // class java/lang/Thread
           3: dup
           4: invokedynamic #9,  0              // InvokeDynamic #0:run:()Ljava/lang/Runnable;
           9: invokespecial #7                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;)V
          12: invokevirtual #8                  // Method java/lang/Thread.start:()V
          15: return
     */
}
