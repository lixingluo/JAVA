# Polymorphism

## 没有修饰符的属性访问权限
|访问修饰符|本类|同包|子类|其他|
|:--:|:--:|:--:|:--:|:--:|
|private|accessible|not|not|not|
|(no modifiers)|accessible|accessible|not|not|
|protected|accessible|accessible|accessible|not|
|public|accessible|accessible|accessible|accessible|

## 函数的重载对比函数的重写(override && overload)
||出现位置|方法名|参数表(参数的类型,参数的个数,参数的顺序)|返回值|访问修饰符|
|:--:|:--:|:--:|:--:|:--:|:--:|
|重写|子类|相同|相同|同类或子类|不能比父类更严格(父类如果是protected,子类不可以是private但可以是protected或public)|
|重载|同类|相同|不相同|无所谓|无所谓|
函数的重载只跟以下几点有关：
- 传入参数的类型
- 参数的个数
- 参数的顺序
跟以下几点完全无关:
- 传入参数的名字
- 函数的返回值
