# Polymorphism

## 没有修饰符的属性访问权限
|访问修饰符|本类|同包|子类|其他|
|:--:|:--:|:--:|:--:|:--:|
|private|accessible|not|not|not|
|(no modifiers)|accessible|accessible|not|not|
|protected|accessible|accessible|accessible|not|
|public|accessible|accessible|accessible|accessible|

## 函数的重载对比函数的重写(override && overload)
||出现位置|方法名|参数表(参数的类型,参数的个数,参数的顺序)|返回值|访问修饰符|构造函数|
|:--:|:--:|:--:|:--:|:--:|:--:|
|重写|子类|相同|相同|同类或子类|不能比父类更严格(父类如果是protected,子类不可以是private但可以是protected或public)|不可以|
|重载|同类|相同|不相同|无所谓|无所谓|可以|
### 函数的重载只跟以下几点有关：
- 传入参数的类型
- 参数的个数
- 参数的顺序
### 跟以下几点完全无关:
- 传入参数的名字
- 函数的返回值
## 构造函数不可以被重写，因为override的前提是继承，而构造函数不能被继承

## final修饰的特点(final意味着最终，即是不能再改了)
- 类: 不能被继承
- 方法: 不能被重写
- 属性: 不能被修改

## interface修饰的特点
- 函数: 全部是public abstract函数，最好只写函数名，默认添加修饰符
- 属性: 全部是final属性

## 几个要注意的点
- 所有类都有构造函数，包括普通类和抽象类，而接口没有构造函数，因为构造方法存在的必要是创建实例，而接口是不会创建实例的
- 构造函数不是方法(method)，因为构造函数没有返回值，而方法都有返回值，void的返回值是null
- 如果父类没有无参构造函数(父类有显示声明带参数的构造函数)，子类必须显示声明构造函数(子类不可能有无参构造函数)
- 构造函数不能添加这些修饰符: abstract, final, static, synchronized
- Java是单继承，Java的类只能单继承;Java是多继承，Java的接口，当继承的目标也是接口时，可以继承多个接口
