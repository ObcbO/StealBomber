package stealbomber.manage;

public class storage {
        public static boolean start = false;
        public static final String[] bfnum = {
                        "134", "135", "136", "137", "138", "139", "144", "147", "148", "150", "151", "152", "157",
                        "158", "159", "172", "178", "182", "183", "184", "187", "188", "195", "197", "198", "187",
                        "188", "178", "147", "172", "198", // 中国移动
                        "130", "131", "132", "145", "155", "156", "166", "167", "171", "175", "176", "185", "186",
                        "196", // 中国联通
                        "133", "149", "153", "173", "177", "180", "181", "189", "190", "191", "193", "199", // 中国电信
                        "192"// 中国广电
        };
        public static final String[] useragent = {
                        "Mozilla/5.0 (Linux; Android 11; SM-N9860 Build/RP1A.200720.012; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/86.0.4240.99 XWEB/3171 MMWEBSDK/20211202 Mobile Safari/537.36 MMWEBID/8157 MicroMessenger/8.0.18.2060(0x28001237) Process/toolsmp WeChat/arm64 Weixin NetType/WIFI Language/zh_CN ABI/arm64",
                        "Mozilla/5.0 (Linux; Android 10; EVR-AN00 Build/HUAWEIEVR-AN00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/86.0.4240.99 XWEB/3179 MMWEBSDK/20211001 Mobile Safari/537.36 MMWEBID/2013 MicroMessenger/8.0.16.2040(0x2800105F) Process/toolsmp WeChat/arm64 Weixin NetType/5G Language/zh_CN ABI/arm64",
                        "Mozilla/5.0 (Linux; Android 11; POCO F2 Pro Build/RKQ1.200826.002; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/74.0.3729.136 Mobile Safari/537.36 MMWEBID/1230 MicroMessenger/8.0.17.2040(0x28001133) Process/toolsmp WeChat/arm64 Weixin NetType/WIFI Language/zh_CN ABI/arm64",
                        "Mozilla/5.0 (Linux; Android 10; ASUS_I001DA Build/QKQ1.190825.002; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.72 MQQBrowser/6.2 TBS/045908 Mobile Safari/537.36 MMWEBID/3216 MicroMessenger/8.0.16.2040(0x28001056) Process/tools WeChat/arm64 Weixin NetType/4G Language/zh_CN ABI/arm64",
                        "Mozilla/5.0 (Linux; Android 10; Pixel 4 XL Build/QQ2A.200305.004.A1; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/86.0.4240.99 XWEB/3140 MMWEBSDK/20211001 Mobile Safari/537.36 MMWEBID/8391 MicroMessenger/8.0.16.2040(0x2800103A) Process/toolsmp WeChat/arm64 Weixin NetType/WIFI Language/zh_CN ABI/arm64",
                        "Mozilla/5.0 (Linux; Android 11; V2046A Build/RP1A.200720.012; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/86.0.4240.99 XWEB/3179 MMWEBSDK/20211202 Mobile Safari/537.36 MMWEBID/985 MicroMessenger/8.0.18.2060(0x28001237) Process/toolsmp WeChat/arm64 Weixin NetType/WIFI Language/zh_CN ABI/arm64",
                        "Mozilla/5.0 (iPhone; CPU iPhone OS 13_6_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 MicroMessenger/8.0.17(0x18001122) NetType/4G Language/zh_CN",
                        "Mozilla/5.0 (Linux; Android 11; RMX3161 Build/RKQ1.201217.002; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.72 MQQBrowser/6.2 TBS/045810 Mobile Safari/537.36 MMWEBID/5001 MicroMessenger/8.0.16.2040(0x28001052) Process/tools WeChat/arm64 Weixin NetType/4G Language/zh_CN ABI/arm64",
                        "Mozilla/5.0 (Linux; Android 10; Lenovo L78051 Build/QKQ1.190825.002; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/86.0.4240.99 XWEB/3171 MMWEBSDK/20210902 Mobile Safari/537.36 MMWEBID/4125 MicroMessenger/8.0.15.2020(0x28000F31) Process/toolsmp WeChat/arm64 Weixin NetType/5G Language/zh_CN ABI/arm64",
                        "Mozilla/5.0 (Linux; Android 11; CPH2159 Build/RKQ1.200903.002; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/74.0.3729.136 Mobile Safari/537.36 MMWEBID/3608 MicroMessenger/8.0.18.2060(0x28001237) Process/toolsmp WeChat/arm64 Weixin NetType/WIFI Language/zh_CN ABI/arm64",
                        "Mozilla/5.0 (Linux; Android 11; IN2010 Build/RP1A.201005.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/86.0.4240.99 XWEB/3171 MMWEBSDK/20211202 Mobile Safari/537.36 MMWEBID/7693 MicroMessenger/8.0.18.2060(0x28001237) Process/toolsmp WeChat/arm32 Weixin NetType/4G Language/zh_CN ABI/arm64",
                        "Mozilla/5.0 (Linux; Android 9; Nokia 7 plus Build/PPR1.180610.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/86.0.4240.99 XWEB/3170 MMWEBSDK/20211001 Mobile Safari/537.36 MMWEBID/973 MicroMessenger/8.0.16.2040(0x2800105C) Process/toolsmp WeChat/arm32 Weixin NetType/WIFI Language/zh_CN ABI/arm64",
                        "Mozilla/5.0 (Linux; Android 11; Redmi K30 Pro Build/RKQ1.200826.002; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/86.0.4240.99 XWEB/3179 MMWEBSDK/20211202 Mobile Safari/537.36 MMWEBID/7002 MicroMessenger/8.0.18.2060(0x28001237) Process/toolsmp WeChat/arm64 Weixin NetType/5G Language/zh_CN ABI/arm64",
                        "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3947.100 Safari/537.36 2345Explorer/10.24.0.21754",
                        "Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.80 Safari/605.1.15",
                        "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Safari/537.36 SLBrowser/8.0.0.2242 SLBChan/23",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:34.0) Gecko/20100101 Firefox/34.0",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36 Core/1.77.96.400 QQBrowser/10.9.4619.400",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36 OPR/26.0.1656.60",
                        "Opera/8.0 (Windows NT 5.1; U; en)",
                        "Mozilla/5.0 (Windows NT 5.1; U; en; rv:1.8.1) Gecko/20061208 Firefox/2.0.0 Opera 9.50",
                        "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; en) Opera 9.50",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:34.0) Gecko/20100101 Firefox/34.0",
                        "Mozilla/5.0 (X11; U; Linux x86_64; zh-CN; rv:1.9.2.10) Gecko/20100922 Ubuntu/10.10 (maverick) Firefox/3.6.10",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/534.57.2 (KHTML, like Gecko) Version/5.1.7 Safari/534.57.2",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36",
                        "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11",
                        "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.16 (KHTML, like Gecko) Chrome/10.0.648.133 Safari/534.16",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.101 Safari/537.36",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.11 (KHTML, like Gecko) Chrome/20.0.1132.11 TaoBrowser/2.0 Safari/536.11",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.71 Safari/537.1 LBBROWSER",
                        "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E; LBBROWSER)",
                        "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; QQDownload 732; .NET4.0C; .NET4.0E; LBBROWSER)",
                        "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E; QQBrowser/7.0.3698.400)",
                        "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; QQDownload 732; .NET4.0C; .NET4.0E)",
                        "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.84 Safari/535.11 SE 2.X MetaSr 1.0",
                        "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; SV1; QQDownload 732; .NET4.0C; .NET4.0E; SE 2.X MetaSr 1.0)",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Maxthon/4.4.3.4000 Chrome/30.0.1599.101 Safari/537.36",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.122 UBrowser/4.0.3214.0 Safari/537.36",
        };
        public static final String[] passwords = { 
                        "a123456",
                        "zz12369",
                        "123456aa",
                        "wmsxie123",
                        "q123456",
                        "qq66666",
                        "123456a",
                        "w2w2w2",
                        "a12369",
                        "aa123456",
                        "wolf8637",
                        "qq123456",
                        "qq123123",
                        "a321654",
                        "1qaz2wsx",
                        "asd123",
                        "wpc000821",
                        "sunliu66",
                        "js77777",
                        "a111111",
                        "13e4e5sd",
                        "qq666666",
                        "a520520",
                        "q1w2e3r4",
                        "zz123456",
                        "a123456789",
                        "qwe123",
                        "qqq111",
                        "112233abc",
                        "g227w212",
                        "woaini1314",
                        "a123123",
                        "abc123456",
                        "123qwe",
                        "a1234567",
                        "a636654",
                        "dircls128",
                        "123abc",
                        "1q2w3e4r",
                        "xiao801013",
                        "aili1314",
                        "123456789a",
                        "qq111111",
                        "yiyou2587",
                        "z123456",
                        "xy123456",
                        "a5201314",
                        "a000000",
                        "zeng1013",
                        "a42176488",
                        "123456abc",
                        "abc123",
                        "abcd1234",
                        "wangyut2",
                        "123456qq",
                        "qq83328",
                        "w123456",
                        "aa456789",
                        "asd123456",
                        "a11111",
                        "123456789k",
                        "woaini123",
                        "a25430071",
                        "123aa123",
                        "woaini520",
                        "a369258",
                        "hd3080550",
                        "789789aa",
                        "11111a",
                        "a258369",
                        "zxc123456",
                        "000763x",
                        "sxq330983",
                        "uni0728",
                        "111111a",
                        "0099466ok",
                        "a12345678",
                        "kuen4321",
                        "qw123123",
                        "123456z",
                        "wsw870815",
                        "ad123456",
                        "z19841130",
                        "woaini521",
                        "oo55663",
                        "1234wswxw",
                        "qaz123",
                        "wy123456",
                        "kpcjq25",
                        "123456q",
                        "zhang123",
                        "li222222",
                        "q111111",
                        "zxcv123",
                        "qq369369",
                        "wdl123",
                        "a12345",
                        "qwe123456",
                        "qqaa840605",
                        "q1q1q1q1",
                        "1234qwer",
                        "zxcvbnm123",
                        "zxc123",
                        "qw5555",
                        "a19771225",
                        "108208aa",
                        "lnb5552436",
                        "yuliang0599",
                        "a6201379",
                        "a100200",
                        "1q2w3e",
                        "asd2045461",
                        "zxcv00123",
                        "18n28n24a5",
                        "hb000000",
                        "tang520qin",
                        "qweqwe1",
                        "qq138238",
                        "xs0718",
                        "123123a",
                        "aini1314",
                        "541100abcd",
                        "aaa123456",
                        "peng456",
                        "qwer1234",
                        "as123456",
                        "15216827g",
                        "lcj830916",
                        "q123456789",
                        "wang123",
                        "141033sq",
                        "aa123123",
                        "qq11111",
                        "aa45656",
                        "123456aaa",
                        "tb8340646",
                        "asdf1234",
                        "5201314a",
                        "dd130612",
                        "1q2w3e4r5t",
                        "q66666666",
                        "171204jg",
                        "sd123456",
                        "li123456",
                        "jhx1980",
                        "123456asd",
                        "so123456",
                        "yuyang11",
                        "a8801618",
                        "cd831128",
                        "zliii0",
                        "21yuan",
                        "a1314520",
                        "lin7758991",
                        "800528sd",
                        "a321456",
                        "iverson1",
                        "123456as",
                        "wg99999",
                        "qq5201314",
                        "chang881",
                        "123qweasd",
                        "a147258",
                        "sybme7u",
                        "a824517",
                        "s123456",
                        "159753aa",
                        "liulian860420",
                        "1qazxsw2",
                        "q123123",
                        "a7758521",
                        "tuchunkun123",
                        "q1987910",
                        "qazwsx123",
                        "a00000",
                        "123456789q",
                        "kb9zc8uxtx",
                        "1111111a",
                        "l123456",
                        "a123654",
                        "x123456",
                        "000000a",
                        "zxc111",
                        "az123456",
                        "z123456789",
                        "qaz123456",
                        "nhmk123",
                        "kkusr66",
                        "1987517abc",
                        "l138071",
                        "jbdy311",
                        "qq1314520",
                        "1234abcd",
                        "aaa111",
                        "rs147258",
                        "chunyu233",
                        "tt123456",
                        "12345678a",
                        "qq12345",
                        "dd123456",
                        "123456qwe",
                        "a123456a",
                        "m198271",
                        "1234567ll",
                        "d54q7xjmhx",
                        "aa100200",
                        "123asd",
                        "ss123456",
                        "qa123456",
                        "i97wb6sxq7",
                        "hm9958123",
                        "12qwaszx",
                        "s8283330",
                        "b33m6yghef",
                        "huang123",
                        "wzj1016",
                        "q11111",
                        "dingding123",
                        "c123456",
                        "yuzhiyuan1",
                        "cyj720440",
                        "sa147258",
                        "d54p7xjkha",
                        "zx123456",
                        "aa8485",
                        "123321x",
                        "z1234567",
                        "a123321",
                        "7715099aaa",
                        "a13432",
                        "xiao0301",
                        "asd333",
                        "zh1314521",
                        "4235191a",
                        "aaa123",
                        "wgz850429",
                        "1234567a",
                        "tt520123",
                        "lj1234",
                        "e22222",
                        "ghost1",
                        "qqqq0000",
                        "love1314",
                        "z123123",
                        "g86ua5qsn5",
                        "qw123456",
                        "e65r82kni2",
                        "aa5201314",
                        "zsyg4482",
                        "wy1981813",
                        "pll880411",
                        "xx123456",
                        "a123000",
                        "woaini1",
                        "aa112233",
                        "c44n6vijgc",
                        "asdf123",
                        "l000000",
                        "aptx4869",
                        "654123zxc",
                        "wang123456",
                        "123456cc",
                        "w123456789",
                        "zhangyin11",
                        "yang001",
                        "tzdyj82",
                        "rr123456",
                        "7758521a",
                        "aa520410",
                        "58324914a",
                        "sdwl888",
                        "111111q",
                        "jianfei000",
                        "yang123",
                        "ja8yc8uxsx",
                        "woaini52",
                        "123456ab",
                        "y123456",
                        "2345986a",
                        "12345a",
                        "123456w",
                        "123123q",
                        "123456ww",
                        "zx88418610",
                        "q1w2e3",
                        "q1021905",
                        "123456789z",
                        "zz777777",
                        "aazz623",
                        "123456bb",
                        "b43m6xhiee",
                        "liu123456",
                        "xiaxin18",
                        "zhang520",
                        "a1b2c3d4",
                        "tl2009",
                        "woaimei1",
                        "qq1234",
                        "tiantian12",
                        "cxr1111",
                        "majiajun8888",
                        "1a2b3c4d",
                        "q14789",
                        "qq654123",
                        "yanwen1984",
                        "f76t93nqk3",
                        "qwe888555",
                        "q7775396",
                        "25114a",
                        "abcd123456",
                        "huifang702",
                        "aa147258",
                        "aaa111222",
                        "abcd123",
                        "123aaa",
                        "1zhang",
                        "rvflaji1",
                        "caonima123",
                        "woaini131",
                        "q1234567",
                        "q5201314",
                        "g76t94prm4",
                        "881linchang",
                        "qq000000",
                        "q000000",
                        "ab123456",
                        "q1w2e3r4t5",
                        "a1111111",
                        "ppp185037",
                        "woaini12",
                        "dracula456",
                        "wo123456",
                        "925808ok",
                        "lm6338923",
                        "yongshi123",
                        "love520",
                        "1999zgm",
                        "code8925",
                        "liu198420",
                        "laopo521",
                        "ms0083jxj",
                        "963852q",
                        "ja8yc7txs8",
                        "q999888",
                        "111qqq",
                        "ja8xb7txr8",
                        "111111qq",
                        "88325947z",
                        "zm123456",
                        "wu123456",
                        "1984723wjq",
                        "zxcvbn123",
                        "asdw12311",
                        "www123456",
                        "chen123",
                        "hao123",
                        "520123zj",
                        "zygzs001",
                        "qiqiansi1",
                        "xiaohu123",
                        "www2323",
                        "abc12345",
                        "e65r82mpj2",
                        "qwqwqw123",
                        "liu123",
                        "qq123456789",
                        "f75s83nqk3",
                        "lclc173174",
                        "e65r82mnj2",
                        "4158zh",
                        "h87va5rtp6",
                        "jiang123",
                        "i98xb7sxr7",
                        "as147258",
                        "nihao123",
                        "ww111111",
                        "q12345",
                        "js777777",
                        "ersa147258",
                        "qweasd123",
                        "laopo520",
                        "m123456",
                        "aaaa1111",
                        "zuihou00",
                        "yueguang01",
                        "12345qwert",
                        "g76u94prm4",
                        "h123456",
                        "asdasd123",
                        "qaz010203",
                        "cc28851770",
                        "qweqwe111",
                        "b43n6whifd",
                        "aa222222",
                        "a7758258",
                        "deng00da",
                        "luhy2000",
                        "g86u94psn5",
                        "ww123456",
                        "ch52013147",
                        "123456l",
                        "a112233",
                        "qqqq11",
                        "a123123123",
                        "taotao123",
                        "123123aa",
                        "1hxboqg2s",
                        "123654aa",
                        "plok123456",
                        "c44n6vijfc",
                        "a147258369",
                        "8258wang",
                        "19860330lj",
                        "a5211314",
                        "7758521ax",
                        "1314520a",
                        "weijinchi328",
                        "wz61216677",
                        "kp123456",
                        "123456zxc",
                        "111111111a",
                        "a11111111",
                        "123qwe123",
                        "ok989036",
                        "tanqingmei520",
                        "z5201314",
                        "g7j9a3g",
                        "jingling123",
                        "asd12345",
                        "327115aa",
                        "f76t94prm4",
                        "k87z9a3g",
                        "12345q",
                        "jz6x6k6l",
                        "qwert12345",
                        "m8z3jd6a",
                        "kz2x5z1x",
                        "deng1234",
                        "l8ud34ay",
                        "a123458",
                        "123123qq",
                        "wss522",
                        "chenyi18gb",
                        "aa369369",
                        "a082402",
                        "qw789456",
                        "wrh894013",
                        "a343478000",
                        "a666666",
                        "qxwzq1566",
                        "c54p7uikgb",
                        "zcy106",
                        "a8893523",
                        "5886958z",
                        "111111z",
                        "www123",
                        "zqq666600",
                        "zaq12wsx",
                        "123456qw",
                        "qq123321",
                        "b43m6xhife",
                        "abc123456789",
                        "fdsa123",
                        "mingming518",
                        "wu2235998",
                        "123456qaz",
                        "111222tianya",
                        "456789a",
                        "nw12345",
                        "du123456",
                        "aa1234",
                        "wt2401252",
                        "qwe123123",
                        "a4664000",
                        "w5201314",
                        "q1q1q1q",
                        "q12345678",
                        "ikmu789",
                        "123456b1910",
                        "kingcom5",
                        "1111111f",
                        "minghui1",
                        "wenwen123",
                        "h97wa6ruq6",
                        "df9090",
                        "2773869aa",
                        "24538aa",
                        "qq85236",
                        "z111111",
                        "qweqwe123",
                        "123456abcd",
                        "liang123",
                        "if5312586",
                        "chunkai55",
                        "zx6011",
                        "rui100",
                        "lkj123456",
                        "a1s2d3f4",
                        "xiao123",
                        "windows850307",
        };
}
