# Aspect Oriented Programming-AOP面向切面编程---模拟用户行为统计
* 下载aspectj地址http://www.eclipse.org/aspectj/downloads.php
* 下载aspectj的adt地址http://www.eclipse.org/ajdt/downloads/#43zips
* build.gradle aspectJ写法http://fernandocejas.com/2014/08/03/aspect-oriented-programming-in-android/
### AspectJ原理剖析
* 1、Join Points(连接点)
Join Points，简称JPoints，是AspectJ的核心思想之一，它就像一把刀，把程序的整个执行过程切成了一段段不同的部分。例如，构造方法调用、调用方法、方法执行、异常等等，这些都是Join Points，实际上，也就是你想把新的代码插在程序的哪个地方，是插在构造方法中，还是插在某个方法调用前，或者是插在某个方法中，这个地方就是Join Points，当然，不是所有地方都能给你插的，只有能插的地方，才叫Join Points。
* 2、Pointcuts(切入点)
告诉代码注入工具，在何处注入一段特定代码的表达式。例如，在哪些 joint points 应用一个特定的 Advice。切入点可以选择唯一一个，比如执行某一个方法，也可以有多个选择,可简单理解为带条件的Join Points，作为我们需要的代码切入点。
* 3、Advice（通知）
如何注入到我的class文件中的代码。典型的 Advice 类型有 before、after 和 around，分别表示在目标方法执行之前、执行后和完全替代目标方法执行的代码。 上面的例子中用的就是最简单的Advice——Before。
* 4、Aspect（切面）
Pointcut 和 Advice 的组合看做切面。例如，我们在应用中通过定义一个 pointcut 和给定恰当的advice，添加一个日志切面。
* Weaving（织入）
注入代码（advices）到目标位置（joint points）的过程。
![](/screenshot/device-2018-01-06-152358.png)