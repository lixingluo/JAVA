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

