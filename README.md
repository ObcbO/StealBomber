<img src="logo.png" alt="logo" width="100" height="100" align="right" />

# Steal Bomber

> 这是一个用Java语言写的盗号网站轰炸机

## 启动软件

- 在终端执行 `java -jar stealbomber.jar`
- 程序将自动输出默认配置文件(如果没有)
- 输出将显示在**控制台**上

> 如果无法启动请使用 `java --enable-preview -jar stealbomber.jar`

### 启动参数

支持一个启动参数

| 参数 | 说明 | 例子 |
| --- | --- | --- |
| -Dfile= | 自定义配置名称(位置) | java -Dfile="example.properties" -jar stealbomber.jar |

## 文本编写

使用Java Properties写法

> 默认使用自动生成的 default.properties

> Tip: genoutput的值设为off可以显著降低占用

一行只能有 `键` 和 `值` ， 中间使用**等号**隔开

| 键 | 必填 | 默认值 | 说明 |
| --- | --- | --- | --- |
| genoutput | 否 | off | 输出类型开关, 可填的类型: suc, err, on, off(分别是: 只输出成功,只输出错误,全部输出,全部不输出) |
| restart-wait | 否 | 10000 | 重启等待时间(单位是毫秒) |
| threads | 否 | 16 | 并行攻击的线程数量 |
| URL | 是 | - | 发送账号密码的网址 |
| parameter | 是 | - | 向网站发送的参数([见下例](#parameter写法)) |
| proxyswitch | 否 | false | 是否使用代理攻击(真为true 选择系统代理为system) |
| proxyfile | 否 | - | 代理文件地址 |

### parameter写法

> 例: `username=$[account]&pass=$[password]`

| 变量名 | 说明 |
| --- | --- |
| $[account] | 随机生成QQ号,QQ邮箱,中国大陆手机号 |
| $[password] | 随机密码 |

### 代理文件

代理支持 `HTTP` `HTTPS` `SOCKS4` `SOCKS5` 类型

每一行一个代理，格式如下例

```
https://5.2.3.5:5235
socks4://1.1.1.1:1111
https://1.2.3.4:5678
socks5://6.6.6.6:2345
```

## TODO

- [ ] 重写Proxy连接(现在的代理逻辑太烂了)
- [ ] 添加GUI
  > 放弃使用Swing制作GUI 该TODO无限期搁置中
