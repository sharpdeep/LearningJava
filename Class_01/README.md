##Java环境变量配置

**安装完Java后要设置好环境变量才能使用，要配置的环境变量有三个：`JAVA_HOME`，`CLASSPATH`，`PATH`。配置环境变量是为了系统能够找到Java**

###JAVA_HOME

*设置`JAVA_HOME`是为了方便后面的环境配置，也可不配*  
我的`JAVA_HOME`是`D:\Java\jdk7`

###PATH
系统原来就有一个`PATH`环境变量，在后面添加即可，不同路径是用`;`分割的。  
我的`PATH`添加了`;%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;`

###CLASSPATH
`CLASSPATH`主要是为了提供Java类的执行路径，  
我的`CLASSPATH`是`.;%JAVA_HOME%\lib;%JAVA_HOME%\lib\tools.jar;`