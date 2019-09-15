### 测试：Java越界会怎样
- 我用了一行代码来测试（如下）
```
public class Transgression {
	public static void main(String[] args) {
		int[] a = {1,2,3};
		System.out.println(a[3]);
	}
}

```
> 输入中eclipse没有提示我越界了；
###
> 结果报错：
```
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
	at Transgression.Transgression.main(Transgression.java:6)
```
- 修改代码后，如下
```
public class Transgression {
	public static void main(String[] args) {
		int[] a = {1,2,3};
		System.out.println(a.length);
	}
}

```
> 运行结果为3
- 总结：
> Java不会再你输入的时候检测是否越界，eclipse不会在你越界后像提示其他错误一样提醒你，而是会在最终运行时报错，他不会像C语言一样调取错误的内存里的东西，而是直接抛出一个异常。
###
> 一个数组名.length会返回它的长度；