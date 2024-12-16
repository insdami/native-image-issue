# Native Image Issue

Throws an error when trying to execute a circe derivation

```shell
sbt nativeImage

./target/native-image/native-image-issue --model '{"name": "Damian", "last_name": "Albrun"}'

```

```
Exception in thread "io-compute-blocker-6" java.lang.BootstrapMethodError: java.lang.NoSuchMethodException: no such method: scala.Symbol.apply(String)Symbol/invokeStatic
	at example.Model$anon$lazy$macro$11$1.inst$macro$1$lzycompute(Model.scala:11)
	at example.Model$anon$lazy$macro$11$1.inst$macro$1(Model.scala:11)
	at example.Model$.<clinit>(Model.scala:11)
	at example.Greeting$.$anonfun$greet$1(Main.scala:21)
	at cats.effect.IOFiber.next$2(IOFiber.scala:375)
	at cats.effect.IOFiber.runLoop(IOFiber.scala:386)
	at cats.effect.IOFiber.execR(IOFiber.scala:1316)
	at cats.effect.IOFiber.run(IOFiber.scala:118)
	at cats.effect.unsafe.WorkerThread.run(WorkerThread.scala:555)
	at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:832)
	at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:808)
Caused by: java.lang.NoSuchMethodException: no such method: scala.Symbol.apply(String)Symbol/invokeStatic
	at java.base@23.0.1/java.lang.invoke.MemberName.makeAccessException(MemberName.java:910)
	at java.base@23.0.1/java.lang.invoke.MemberName$Factory.resolveOrFail(MemberName.java:989)
	at java.base@23.0.1/java.lang.invoke.MethodHandles$Lookup.resolveOrFail(MethodHandles.java:3762)
	at java.base@23.0.1/java.lang.invoke.MethodHandles$Lookup.findStatic(MethodHandles.java:2660)
	at scala.runtime.SymbolLiteral.bootstrap(SymbolLiteral.java:27)
	... 11 more
```
