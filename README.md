# Spring学习笔记

[Spring学习笔记 - What's Blog. - 程序猿，给社会主义造 Bug (whatsblog.site)](https://www.whatsblog.site/index.php/SSM/29.html) 

<img style="zoom:50%;border-radius:50%" src="http://q1.qlogo.cn/g?b=qq&amp;nk=305887669&amp;s=100" alt="circle">

[Core Technologies (spring.io)](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#spring-core) 

## 1、Spring

### 1.1、简介

Spring框架是一个[开放源代码](https://baike.baidu.com/item/%E5%BC%80%E6%94%BE%E6%BA%90%E4%BB%A3%E7%A0%81/114160)的[J2EE](https://baike.baidu.com/item/J2EE/110838)应用程序框架，由[Rod Johnson](https://baike.baidu.com/item/Rod%20Johnson/1423612)发起，是针对bean的生命周期进行管理的轻量级容器（lightweight container）。 Spring解决了开发者在J2EE开发中遇到的许多常见的问题，提供了功能强大IOC、[AOP](https://baike.baidu.com/item/AOP/1332219)及Web MVC等功能。Spring可以单独应用于构筑应用程序，也可以和Struts、Webwork、Tapestry等众多Web框架组合使用，并且可以与 Swing等[桌面应用程序](https://baike.baidu.com/item/%E6%A1%8C%E9%9D%A2%E5%BA%94%E7%94%A8%E7%A8%8B%E5%BA%8F/2331979)AP组合。因此， Spring不仅仅能应用于J2EE应用程序之中，也可以应用于桌面应用程序以及小应用程序之中。Spring框架主要由七部分组成，分别是 Spring Core、 Spring AOP、 Spring ORM、 Spring DAO、Spring Context、 Spring Web和 Spring Web MVC。 

* 2002年首次推出了Spring框架的雏形 [Interface21](https://interface21.io/) 
* 2004年3月24号诞生
* Spring框架是以interface21为基础，经过重新设计，于2004年3月24日发布1.0正式版。
* 理念：使现有的技术更加容易使用，本身是一个大杂烩，整合了现有的技术框架



* SSH：`Struct2`	+`Spring`+`Hibernate`
* SSM：`Spring MVC`+`Spring`+`MyBatis`

官网：[Spring Framework Overview](https://docs.spring.io/spring-framework/docs/current/reference/html/overview.html) 

官方下载地址：[repo.spring.io](https://repo.spring.io/ui/native/release/org/springframework/spring) 

GitHub：[spring-projects/spring-framework: Spring Framework (github.com)](https://github.com/spring-projects/spring-framework) 

~~~xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.3.16</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.3.16</version>
</dependency>

~~~

### 1.2、优点

* Spring是一个开源的免费的框架！
* Spring是一个轻量级的、非入侵式的框架！
* ==**控制反转(IOC)**==、==**面向切面编程(AOP)**==！
* 支持事务的处理，对框架整合的支持！

总结：Spring就是一个轻量级的控制反转和面向切面编程的框架

### 1.3、组成

![img](Spring.assets\1.png) 

### 1.4、扩展

现代化的Java开发，说白了就是基于Spring的开发！

* Spring Boot
  * 一个快速开发的脚手架
  * 基于SpringBoot可以开发单个微服务
  * 约定大于配置！
* Spring Cloud
  * SpringCloud是基于SpringBoot实现的

现在大多数公司都在使用SpringBoot进行快速开发，学习SpringBoot的前提是需要完全掌握Spring及SpringMVC！

**弊端：发展了太久，违背了原来的理念，配置十分繁琐，人称”配置地狱“**

## 2、IoC理论推导

1. UserDao接口
2. UserDaoImpl实现类
3. UserService接口
4. UserServiceImpl实现类

## 3、Spring的配置

### 3.1、别名

~~~xml
<!--别名，getbean的key-->
<alias name="user" alias="user2"/>
~~~

### 3.2、Bean的配置

~~~xml
<!--
	id：Bean的唯一标识符，也就是相当于我们学的对象名
	class:对象所对应的类全限定名
	name:别名,可以取多个，可以随便使用分隔符
-->
<bean class="site.whatsblog.pojo.User" id="user">
    <constructor-arg name="name" value="Suk"/>
</bean>
~~~

### 3.3、import

用于团队开发使用，可以将多个配置文件导入合并为一个

~~~xml
<import resource="beans.xml"/>
~~~

使用的时候直接使用总得配置就行

## 4、依赖注入（DI）

### 4.1、构造器注入

~~~xml
<!--
	id：Bean的唯一标识符，也就是相当于我们学的对象名
	class:对象所对应的类全限定名
	name:别名,可以取多个，可以随便使用分隔符
-->
<bean class="site.whatsblog.pojo.User" id="user">
    <constructor-arg name="name" value="Suk"/>
</bean>
~~~

### 4.2、set注入【:star:】

依赖注入就是set注入：

​	依赖：bean对象的创建依赖于容器

​	注入：bean对象中的所有属性由容器来注入

【环境搭建】

1. 复杂类型

   ~~~java
   package site.whatsblog.pojo;
   
   import lombok.Data;
   
   /**
    * <strong>
    * description :
    * </strong>
    * <br/>
    * <p>author : Suk-Lee</p>
    * <p>date : 2022/3/3 16:00</p>
    * <p>site : https://www.whatsblog.site/</p>
    */
   @Data
   public class Address {
       private String address;
   }
   
   ~~~

2. 真实测试对象

   ~~~java
   package site.whatsblog.pojo;
   
   import lombok.Data;
   import java.util.List;
   import java.util.Map;
   import java.util.Properties;
   import java.util.Set;
   
   /**
    * <strong>
    * description :
    * </strong>
    * <br/>
    * <p>author : Suk-Lee</p>
    * <p>date : 2022/3/3 16:00</p>
    * <p>site : https://www.whatsblog.site/</p>
    */
   @Data
   public class Student {
       private String name;
       private Address address;
       private String[] books;
       private List<String> hobbies;
       private Map<String, String> cards;
       private Set<String> games;
       private Properties info;
       private String wife;
   }
   
   ~~~

3. beans.xml

   ~~~xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
           https://www.springframework.org/schema/beans/spring-beans.xsd">
       <bean id="student" class="site.whatsblog.pojo.Student">
           <property name="name" value="Suk"/>
       </bean>
   </beans>
   ~~~

4. 测试类

   ~~~java
   package site.whatsblog.test;
   
   import org.junit.Test;
   import org.springframework.context.ApplicationContext;
   import org.springframework.context.support.ClassPathXmlApplicationContext;
   import site.whatsblog.pojo.Student;
   
   /**
    * <strong>
    * description :
    * </strong>
    * <br/>
    * <p>author : Suk-Lee</p>
    * <p>date : 2022/3/3 16:05</p>
    * <p>site : https://www.whatsblog.site/</p>
    */
   public class TestStudents {
       @Test
       public void name() {
           ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
           Student student = applicationContext.getBean("student", Student.class);
           System.out.println(student);
       }
   }
   
   ~~~

最终的赋值方式

~~~xml
<bean id="student" class="site.whatsblog.pojo.Student">
    <property name="name" value="Suk"/>
    <property name="books">
        <array>
            <value>Java</value>
            <value>Python</value>
            <value>C</value>
            <value>C++</value>
        </array>
    </property>
    <property name="hobbies">
        <list>
            <value>唱</value>
            <value>跳</value>
            <value>rap</value>
            <value>篮球</value>
        </list>
    </property>
    <property name="address" ref="address"/>
    <property name="cards">
        <map>
            <entry key="id" value="19200135"/>
            <entry key="name" value="Suk"/>
            <entry key="isAllowed" value="1"/>
        </map>
    </property>
    <property name="games">
        <set>
            <value>Red Alert</value>
            <value>QQ Speed</value>
            <value>King Of Glory</value>
        </set>
    </property>
    <property name="wife">
        <null>null</null>
    </property>
    <property name="info">
        <props>
            <prop key="addr">你瞎啊</prop>
            <prop key="name">你瞎啊</prop>
            <prop key="stuNo">你瞎啊</prop>
        </props>
    </property>
</bean>
<bean class="site.whatsblog.pojo.Address" id="address">
    <property name="address" value="JiangSu"/>
</bean>
~~~



### 4.3、其他方式

Spring基于XML的配置元数据支持其和元素中的子元素类型。`<property/>` `<constructor-arg/>` 

我们可以使用p或c进行注入

官方解释：

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--p命名空间注入,可以直接注入属性的值：property-->
    <bean class="site.whatsblog.pojo.User" id="user" p:age="16" p:name="Suk"/>
    <!--p命名空间注入,通过构造器注入：constructor-->
    <bean class="site.whatsblog.pojo.User" id="user2" c:age="162" c:name="Suk2"/>
</beans>
~~~

### 4.4、Bean的作用域

| Scope                                                        | Description                                                  |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| **[singleton](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-scopes-singleton)** | **创建的所有实例只有一个（默认）**（并发的情况下会产生延迟或者数据不一致） |
| **[prototype](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-scopes-prototype)** | **每次从容器中get，都会产生一个新对象**（浪费资源，多线程建议使用） |
| [request](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-scopes-request) | Scopes a single bean definition to the lifecycle of a single HTTP request. That is, each HTTP request has its own instance of a bean created off the back of a single bean definition. Only valid in the context of a web-aware Spring .`ApplicationContext` |
| [session](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-scopes-session) | Scopes a single bean definition to the lifecycle of an HTTP . Only valid in the context of a web-aware Spring .`Session``ApplicationContext` |
| [application](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-scopes-application) | Scopes a single bean definition to the lifecycle of a . Only valid in the context of a web-aware Spring .`ServletContext``ApplicationContext` |
| [websocket](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#websocket-stomp-websocket-scope) | Scopes a single bean definition to the lifecycle of a . Only valid in the context of a web-aware Spring .`WebSocket``ApplicationContext` |

## 5、Bean的自动装配

* 自动装配是Spring满足bean依赖的一种方式
* Spring会在上下文中自动寻找bean，并自动给bean装配属性

在Spring中有三种自动装配的方式

1. 在xml中显式的配置
2. 在java中显式的配置
3. 隐式的自动装配bean【:star:】

### 5.1、测试

环境搭建：每个人有两个宠物

### 5.2、使用名称自动装配

~~~xml
<!--
    byName:会自动在容器中上下文查找，和自己对象的set方法后面值对应的bean
        缺点：必须保证bean的id值唯一
        优点：灵活使用
    -->
<bean class="site.whatsblog.pojo.People" id="people" autowire="byName">
    <property name="name" value="小Suk呀"/>
</bean>
~~~

### 5.3、根据类型自动装配

~~~xml
<!--
    byType：会自动在容器中上下文查找，和自己对象属性类型相同的bean
        缺点：必须保证当前类型在bean中只有一个
        优点：id都不用写
    -->
<bean class="site.whatsblog.pojo.People" id="people" autowire="byType">
    <property name="name" value="小Suk呀"/>
</bean>
~~~

### 5.4、使用注解实现自动装配

The introduction of annotation-based configuration raised the question of whether this approach is “better” than XML.  

使用注解：

1. 导入context约束

2. 配置注解支持`<context:annotation-config/>`

   ~~~xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns:context="http://www.springframework.org/schema/context"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
           https://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context
           https://www.springframework.org/schema/context/spring-context.xsd">
       <context:annotation-config/>
   </beans>
   ~~~

3. 使用@Autowired

   直接在属性上使用即可，也可以在set上使用

   可以不用写set方法，前提是自动装配在ioc上存在，且符合byName

   > * @Nullable 说明这个字段可以为null
   >
   > ~~~java
   > public People(@Nullable String name) {
   >     this.name = name;
   > }
   > ~~~
   >
   > 如果显式定义了Autowired的属性为false，就说明这属性可以为null
   >
   > ~~~java
   > @Autowired(required = false)
   > private Cat cat;
   > ~~~
   >
   > @Autowired默认按照type装配，存在多个type，则使用name，如果和属性名相同的name不存在，可以组合@Qualifier来使用
   >
   > 例如：
   >
   > ~~~java
   > @Autowired
   > @Qualifier("cat1")
   > private Cat cat;
   > @Autowired
   > @Qualifier("dog1")
   > private Dog dog;
   > ~~~
   >
   > @Resource也可以实现自动装配，功能更强大（Java原生）
   >
   > ~~~java
   > @Resource
   > private Cat cat1;
   > @Resource(name = "dog2")
   > private Dog dog1;
   > private String name;
   > ~~~

## 6、使用注解开发

Spring4之后，要使用注解开发，必须要保证aop的包导入了

在使用注解需要导入context约束，增加注解支持

1. bean `@Conponent`

2. 属性注入`@Value`

3. 衍生`@Repository`、`@Service`、`@Controller`

4. 自动装配`@Autowired`

5. 作用域`@Scope("singleton")`

6. 小结

   xml与注解

   * xml更加万能，适用于任何场合！维护简单方便
   * 注解不是自己的类使用不了，维护相对复杂

   最佳实践

   * bean由xml管理
   * 注解使用属性的注入
   * 我们在使用的过程中只需要注意让注解生效！

## 7、使用java类的配置

完全脱离xml配置，全权交给Java

JavaConfig是Spring的一个子项目，在Spring4之后变为核心功能

## 8、代理模式

为什么要学习代理模式？因为这就是Spring AOP的底层！【Spring AOP 和 Spring MVC】

代理模式的分类：

* 静态代理
* 动态代理

### 8.1、静态代理

角色分析：

* 抽象角色：一般使用接口或者抽象类来解决
* 真实角色：被代理的角色
* 代理角色：代理真实角色，代理真实角色后，我们一般会做附属操作
* 客户：访问代理对象的人

步骤：

1. 接口

   ~~~java
   public interface Rent {
       public void rent();
   }
   ~~~

2. 真实角色

   ~~~java
   public class Host implements Rent{
   
       @Override
       public void rent() {
           System.out.println("我要出租房子！");
       }
   }
   ~~~

3. 代理角色

   ~~~java
   public class Proxy implements Rent{
       private Host host;
   
       public Proxy() {
       }
   
       public Proxy(Host host) {
           this.host = host;
       }
   
       @Override
       public void rent() {
           host.rent();
       }
       public void seeHouse(){
           System.out.println("帮你看房~");
       }
   
       public void contract(){
           System.out.println("帮你签合同~");
       }
   
       public void fee(){
           System.out.println("收你中介费~");
       }
   }
   ~~~

4. 客户端访问代理角色

   ~~~java
   public class Client {
       public static void main(String[] args) {
           // 房东要租房子
           Host host = new Host();
           // 代理，中介要帮房东租房子，但是一般代理角色会有一些附属操作！
           Proxy proxy = new Proxy(host);
           // 你不用找房东，直接找中介就可以了
           proxy.rent();
       }
   }
   ~~~

代理模式的好处：

* 可以使真实角色的操作更加纯粹！不用去关注公共业务
* 公共也就交给代理角色，实现了业务的分工
* 公共业务发生扩展的时候，方便集中管理

缺点：

* 一个真实角色就会产生一个代理角色；代码量会翻倍，开发效率低下！

### 8.2、动态代理

* 动态代理和静态代理角色一样
* 动态代理的代理类是动态生成的，不是我们直接写的！
* 动态代理分为两大类：
  * 基于接口的动态代理--JDK的代理
  * 基于类的动态代理：cglib
  * Java字节码：javassist

需要了解两个类：

Proxy：代理和InvocationHandler：调用处理程序

动态代理的好处:

* 可以使真实角色的操作更加纯粹！不用去关注公共业务
* 公共也就交给代理角色，实现了业务的分工
* 公共业务发生扩展的时候，方便集中管理
* 一个动态代理类代理的是一个接口，一般就是代理对应的一类业务
* 一个动态代理类可以代理多个类，只要是实现了同一个接口即可


## 9、AOP

### 9.1、什么是AOP？

在软件业，AOP为Aspect Oriented Programming的缩写，意为：[面向切面编程](https://baike.baidu.com/item/%E9%9D%A2%E5%90%91%E5%88%87%E9%9D%A2%E7%BC%96%E7%A8%8B/6016335)，通过[预编译](https://baike.baidu.com/item/%E9%A2%84%E7%BC%96%E8%AF%91/3191547)方式和运行期间动态代理实现程序功能的统一维护的一种技术。AOP是[OOP](https://baike.baidu.com/item/OOP)的延续，是软件开发中的一个热点，也是[Spring](https://baike.baidu.com/item/Spring)框架中的一个重要内容，是[函数式编程](https://baike.baidu.com/item/%E5%87%BD%E6%95%B0%E5%BC%8F%E7%BC%96%E7%A8%8B/4035031)的一种衍生范型。利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的[耦合度](https://baike.baidu.com/item/%E8%80%A6%E5%90%88%E5%BA%A6/2603938)降低，提高程序的可重用性，同时提高了开发的效率。 

### 9.2、AOP在Spring中的作用

**提供声明式事务；允许用户自定义切面**

* 横切关注点：跨越应用多个模块的方法或功能。就是我们与业务逻辑无关的，但是需要关注的部分就是横切关注点，如日志，安全，缓存，事务等等等等
* 切面（Aspect）：横切关注点被模块化的特殊对象。即，它是一个类
* 通知（Advice）：切面必须完成多个工作。它是类中的一个方法
* 目标（Target）：被通知对象
* 代理（Proxy）：向目标对象通知之后创建的对象
* 切入点（Pointcut）：切面通知执行的“地点”
* 连接点（Jointcut）：与切入点相匹配的执行点

### 9.3、使用Spring实现AOP

【:star:】使用Spring织入，需要导入一个依赖包

~~~xml
<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.7</version>
</dependency>
~~~

方式一：使用Spring的API接口【主要是Spring的api接口实现】

方式二：使用自定义类来实现AOP【主要是切面】

方式三：使用注解实现！


## 10、整合MyBatis

步骤：

1. 导入相关jar包
   * Junit
   * MyBatis
   * MySQL
   * Spring
   * AOP织入
   * mybatis-spring
2. 编写配置文件
3. 测试

### 10.1、回忆MyBatis

1. 编写实体类
2. 编写核心配置文件
3. 编写接口
4. 编写Mapper.xml

### 10.2、MyBatis-Spring

MyBatis-Spring 会帮助你将 MyBatis 代码无缝地整合到 Spring 中。它将允许 MyBatis 参与到 Spring 的事务管理之中，创建映射器 mapper 和 `SqlSession` 并注入到 bean 中，以及将 Mybatis 的异常转换为 Spring 的 `DataAccessException`。 最终，可以做到应用代码不依赖于 MyBatis，Spring 或 MyBatis-Spring。 

> `SqlSessionTemplate` 是 MyBatis-Spring 的核心。作为 `SqlSession` 的一个实现，这意味着可以使用它无缝代替你代码中已经在使用的 `SqlSession`。 `SqlSessionTemplate` 是线程安全的，可以被多个 DAO 或映射器所共享使用。
>
> 当调用 SQL 方法时（包括由 `getMapper()` 方法返回的映射器中的方法），`SqlSessionTemplate` 将会保证使用的 `SqlSession` 与当前 Spring 的事务相关。 此外，它管理 session 的生命周期，包含必要的关闭、提交或回滚操作。另外，它也负责将 MyBatis 的异常翻译成 Spring 中的 `DataAccessExceptions`。
>
> 由于模板可以参与到 Spring 的事务管理中，并且由于其是线程安全的，可以供多个映射器类使用，你应该**总是**用 `SqlSessionTemplate` 来替换 MyBatis 默认的 `DefaultSqlSession` 实现。在同一应用程序中的不同类之间混杂使用可能会引起数据一致性的问题。
>
> 可以使用 `SqlSessionFactory` 作为构造方法的参数来创建 `SqlSessionTemplate` 对象。
>
> ```xml
> <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
>   <constructor-arg index="0" ref="sqlSessionFactory" />
> </bean>
> ```

1. 编写数据源配置
2. SQLSessionFactory
3. SQLSessionTemplate
4. 给接口加实现类

## 11、声明式事务

1、回顾事务

* 要么都成功，要么都失败
* 事务在项目开发中十分重要，涉及数据的一致性问题
* 确保完整性和一致性

事务的ACID原则

* 原子性：确保要么都成功，要么都失败
* 一致性：一旦事务完成了，要么都提交，要么都不提交
* 隔离性：多个事务可能操作同一个资源，保证事务互相隔离，防止数据损坏
* 持久性：事务一旦完成了，系统无论发生什么问题，数据都不会受到影响，数据被持久化的写到存储器中

2、Spring中的事务管理

* 声明式事务：AOP

  ~~~xml
  <!--配置声明式事务-->
  <bean class="org.springframework.jdbc.datasource.DataSourceTransactionManager" id="manager">
      <property name="dataSource" ref="dataSource"/>
  </bean>
  <!--结合aop实现事务的织入-->
  <!--配置事务的类-->
  <!--配置事务的通知-->
  <tx:advice transaction-manager="manager" id="txAdvice">
      <!--给哪些方法配置事务-->
      <!--配置事务的传播特性 propagation-->
      <tx:attributes>
          <tx:method name="add" propagation="REQUIRED"/>
          <tx:method name="delete" propagation="REQUIRED"/>
          <tx:method name="update" propagation="REQUIRED"/>
          <tx:method name="find" read-only="true"/>
          <tx:method name="*"/>
      </tx:attributes>
  </tx:advice>
  
  <!--配置事务的切入-->
  <aop:config>
      <!--切入点-->
      <aop:pointcut id="pointCut" expression="execution(* site.whatsblog.dao.*.*(..))"/>
      <!--切入-->
      <aop:advisor advice-ref="txAdvice" pointcut-ref="pointCut"/>
  
  </aop:config>
  ~~~

* 编程式事务：需要在代码中进行事务的管理

思考：

为什么需要事务？

* 如果不配置事务，可能存在数据提交不一致的情况
* 如果我们不在Spring中配置声明式事务，我们就需要在代码中手动配置事务！
* 事务在项目开发中十分重要，涉及数据的一致性和完整性问题，不容马虎！

