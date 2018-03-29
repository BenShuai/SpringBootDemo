## 框架中加入进去的包：

	mysql-connector-java		连接mysql的驱动

	spring-boot-starter-data-mongodb	连接MongoDb的驱动

	spring-boot-starter-data-redis	连接redis的驱动
	spring-session-data-redis
	spring-boot-starter-redis

	springfox-swagger2		一套API管理和展示的插件
	springfox-swagger-ui

在pom.xml文件中，不需要的包请注释或删掉。

## 配置文件：
配置文件的入口在：`\demoOne\src\main\resources\application.properties`

直接修改里面的`spring.profiles.active`的值来配置使用的是哪一个配置文件,比如值为`dev`的时候:使用的就是：`application-dev.properties`文件的配置。

`logback-spring.xml`是日志处理和输出相关的配置。

## 定时器：
在`\demoOne\src\main\java\com\example\demo\DemoApplication.java`中添加了`@EnableScheduling`注解，即开始定时器功能，不需要的可以去掉这个注解。

在`\demoOne\src\main\java\com\example\demo\task\ScheduledTasks.java`文件中有定时器的使用案例。

## 异步方法调用：
在`\demoOne\src\main\java\com\example\demo\DemoApplication.java`中添加了`@EnableAsync`注解，即开启了异步调用的功能，不需要的可以注释掉。（一般用在多任务且不相关的多个方法的调用上）

在`\demoOne\src\main\java\com\example\demo\task\AnsyncTask.java`文件中定义了异步方法。
在`\demoOne\src\main\java\com\example\demo\controller\SampleController.java`中的`AnsyncPlay()`方法中有调用异步方法的案例。