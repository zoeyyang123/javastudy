## **JAVA TIPS**

- **@注释**

 Java从1.5版本以后默认内置三个标注：

 @Override:只能用在方法之上的，用来告诉别人这一个方法是改写父类的。
 @Deprecated:建议别人不要使用旧的API的时候用的,编译的时候会用产生警告信息,可以设定在程序里的所有的元素上. 
 @SuppressWarnings:这一个类型可以来暂时把一些警告信息消息关闭.

- **extends与implements的不同**

  1、在类的声明中，通过关键字extends来创建一个类的子类。
  一个类通过关键字implements声明自己使用一个或者多个接口。 
  extends 是继承某个类, 继承之后可以使用父类的方法, 也可以重写父类的方法; 
  implements 是实现多个接口, 接口的方法一般为空的, 必须重写才能使用 
  2、extends是继承父类，只要那个类不是声明为final或者那个类定义为abstract的就能继承
  Java中不支持多重继承，但是可以用接口 来实现，这样就要用到implements，继承只能继承一个类，
  但implements可以实现多个接口，用逗号分开就行了 比如 ：
  class A extends B implements C,D,E
  接口实现的注意点：  
  a.实现一个接口就是要实现该接口的所有的方法(抽象类除外)。 
  b.接口中的方法都是抽象的。  
  c.多个无关的类可以实现同一个接口，一个类可以实现多个无关的接口。

与Extends的不同 
  extends， 可以实现父类，也可以调用父类初始化 this.parent()。而且会覆盖父类定义的变量或者函数。这样的好处是：架构师定义好接口，让工程师实现就可以了。整个项目开发效率和开发成本大大降低。    implements，实现父类，子类不可以覆盖父类的方法或者变量。即使子类定义与父类相同的变量或者函数，也会被父类取代掉。  
  这两种实现的具体使用，是要看项目的实际情况，需要实现，不可以修改implements，只定义接口需要具体实现，或者可以被修改扩展性好，用extends。

- **JUnit**

用于断言

```JavaScript
import junit.framework.Assert;
import org.junit.After;
import org.junit.Test;
```

- **shiro**

1.登录

```JavaScript
try {
            //登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            //身份验证失败
        }
Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
subject.logout();
```

> 如果身份验证失败请捕获AuthenticationException或其子类，常见的如： DisabledAccountException（禁用的帐号）、LockedAccountException（锁定的帐号）、UnknownAccountException（错误的帐号）、ExcessiveAttemptsException（登录失败次数过多）、IncorrectCredentialsException （错误的凭证）、ExpiredCredentialsException（过期的凭证）等，具体请查看其继承关系；对于页面的错误消息展示，最好使用如“用户名/密码错误”而不是“用户名错误”/“密码错误”，防止一些恶意用户非法扫描帐号库；

