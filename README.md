# BaseUI

封装各种 UI 模板



## BaseApplication

使用此模板的 App 必须继承此类，不然会报错

### 方法

| protected void setUM(String key, String channel) | 设置友盟统计                |
| ------------------------------------------------ | --------------------------- |
| public boolean isUMEnable()                      | 友盟统计是否被设置          |
| exitAllActivities()                              | 退出目前栈内所有的 Activity |

## Activity

### BaseActivity

#### 全局变量

| BaseApplication mApplication | 此App的 Application  |
| :--------------------------- | :------------------- |
| BaseActivity mActivity       | 当前 Activity 的实例 |

### 方法

| public void onBack(View view)              | 如果此 Activity 有返回键，一律使用android:onClick="onBack" |
| ------------------------------------------ | ---------------------------------------------------------- |
| protected void toast(String message)       | 弹出 Toast                                                 |
| protected void toast(int id)               | 弹出 Toast                                                 |
| protected void debug()                     | 弹出文案为 debug 的 Toast                                  |
| protected void startActivity(Class<?> cls) | 无需传参直接启动另一个 Activity 时使用此方法               |

