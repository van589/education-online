/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : education

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 15/03/2020 23:23:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员ID',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员名称',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员昵称',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员密码',
  `sex` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '性别',
  `phone` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '电话号码',
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员邮箱',
  `firsttime` datetime(0) NOT NULL COMMENT '创建日期',
  `updatetime` datetime(0) NOT NULL COMMENT '修改时间',
  `lasttime` datetime(0) NOT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1000', 'admin', 'admin', 'admin', 'Male', '13377211793', '1273647531@qq.com', '2020-02-18 15:03:15', '2020-02-18 15:03:15', '2020-02-18 15:03:18');
INSERT INTO `admin` VALUES ('1001', 'admin01', 'admin11', 'admin', 'Female', '133xxxxxxxx', 'c4f3132@163.com', '2020-02-18 15:03:15', '2020-02-18 15:04:28', '2020-02-18 15:04:30');

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章id',
  `author_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章作者id',
  `article_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章标题',
  `article_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章内容',
  `firsttime` datetime(0) NOT NULL COMMENT '创建日期',
  `updatetime` datetime(0) NOT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('2b1ac16c08ca4484a488e01d7c0b6904', '1001', 'C语言究竟是一门怎样的语言？', '<p>对于大部分程序员，C语言是学习编程的第一门语言，很少有不了解C的程序员。<br><br>C语言除了能让你了解编程的相关概念，带你走进编程的大门，还能让你明白程序的运行原理，比如，计算机的各个部件是如何交互的，程序在内存中是一种怎样的状态，操作系统和用户程序之间有着怎样的“爱恨情仇”，这些底层知识决定了你的发展高度，也决定了你的职业生涯。<br><br>如果你希望成为出类拔萃的人才，而不仅仅是码农，这么这些知识就是不可逾越的。也只有学习C语言，才能更好地了解它们。有了足够的基础，以后学习其他语言，会触类旁通，很快上手，7 天了解一门新语言不是神话。<br><br>C语言概念少，词汇少，包含了基本的编程元素，后来的很多语言（<a href=\"http://c.biancheng.net/cplus/\" target=\"_blank\">C++</a>、<a href=\"http://c.biancheng.net/java/\" target=\"_blank\">Java</a>等）都参考了C语言，说C语言是现代编程语言的开山鼻祖毫不夸张，它改变了编程世界。<br><br>正是由于C语言的简单，对初学者来说，学习成本小，时间短，结合本教程，能够快速掌握编程技术。<br><br>在世界编程语言排行榜中，C语言、Java 和 C++ 霸占了前三名，拥有绝对优势，如下表所示：<br></p><table><tbody><tr><th colspan=\"3\" rowspan=\"1\">2015年01月榜单</th></tr><tr><th>排名</th><th>语言</th><th>占有率</th></tr><tr><td>1</td><td>C</td><td>16.703%</td></tr><tr><td>2</td><td>Java</td><td>15.528%</td></tr><tr><td>3</td><td>Objective-C</td><td>6.953%</td></tr><tr><td>4</td><td>C++</td><td>6.705%</td></tr><tr><td>5</td><td><a href=\"http://c.biancheng.net/csharp/\" target=\"_blank\">C#</a></td><td>5.045%</td></tr><tr><td>6</td><td><a href=\"http://c.biancheng.net/php/\" target=\"_blank\">PHP</a></td><td>3.784%</td></tr><tr><td>7</td><td><a href=\"http://c.biancheng.net/js/\" target=\"_blank\">JavaScript</a></td><td>3.274%</td></tr><tr><td>8</td><td><a href=\"http://c.biancheng.net/python/\" target=\"_blank\">Python</a></td><td>2.613%</td></tr><tr><td>9</td><td>Perl</td><td>2.256%</td></tr><tr><td>10</td><td>PL/SQL</td><td>2.014%</td></tr><tr><th colspan=\"3\" rowspan=\"1\">2015年06月榜单</th></tr><tr><th>排名</th><th>语言</th><th>占有率</th></tr><tr><td>1</td><td>Java</td><td>17.822%</td></tr><tr><td>2</td><td>C</td><td>16.788%</td></tr><tr><td>3</td><td>C++</td><td>7.756%</td></tr><tr><td>4</td><td>C#</td><td>5.056%</td></tr><tr><td>5</td><td>Objective-C</td><td>4.339%</td></tr><tr><td>6</td><td>Python</td><td>3.999%</td></tr><tr><td>7</td><td>Visual Basic .NET</td><td>3.168%</td></tr><tr><td>8</td><td>PHP</td><td>2.868%</td></tr><tr><td>9</td><td>JavaScript</td><td>2.295%</td></tr><tr><td>10</td><td>Delphi/Object Pascal</td><td>1.869%</td></tr><tr><th colspan=\"3\" rowspan=\"1\">2018年01月榜单</th></tr><tr><th>排名</th><th>语言</th><th>占有率</th></tr><tr><td>1</td><td>Java</td><td>14.215%</td></tr><tr><td>2</td><td>C</td><td>11.037%</td></tr><tr><td>3</td><td>C++</td><td>5.603%</td></tr><tr><td>4</td><td>Python</td><td>4.678%</td></tr><tr><td>5</td><td>C#</td><td>3.754%</td></tr><tr><td>6</td><td>JavaScript</td><td>3.465%</td></tr><tr><td>7</td><td>Visual Basic .NET</td><td>3.261%</td></tr><tr><td>8</td><td>R</td><td>2.549%</td></tr><tr><td>9</td><td>PHP</td><td>2.532%</td></tr><tr><td>10</td><td>Perl</td><td>2.419%</td></tr></tbody></table><p><br>2017年，由于小型软件设备的蓬勃发展以及汽车行业底层软件的增加，C语言还拿下了「年度编程语言」的桂冠，成为 2017 年全球增长最快的编程语言。下表列出了最近 10 年的“年度编程语言”：<br></p><table><tbody><tr><th>年份</th><th>优胜者</th></tr><tr><th>2017</th><td><img alt=\"\" src=\"http://c.biancheng.net/uploads/allimg/181221/1343464435-0.png\">C</td></tr><tr><th>2016</th><td><img alt=\"\" src=\"http://c.biancheng.net/uploads/allimg/181221/1343464435-0.png\">Go</td></tr><tr><th>2015</th><td><img alt=\"\" src=\"http://c.biancheng.net/uploads/allimg/181221/1343464435-0.png\">Java</td></tr><tr><th>2014</th><td><img alt=\"\" src=\"http://c.biancheng.net/uploads/allimg/181221/1343464435-0.png\">JavaScript</td></tr><tr><th>2013</th><td><img alt=\"\" src=\"http://c.biancheng.net/uploads/allimg/181221/1343464435-0.png\">Transact-SQL</td></tr><tr><th>2012</th><td><img alt=\"\" src=\"http://c.biancheng.net/uploads/allimg/181221/1343464435-0.png\">Objective-C</td></tr><tr><th>2011</th><td><img alt=\"\" src=\"http://c.biancheng.net/uploads/allimg/181221/1343464435-0.png\">Objective-C</td></tr><tr><th>2010</th><td><img alt=\"\" src=\"http://c.biancheng.net/uploads/allimg/181221/1343464435-0.png\">Python</td></tr><tr><th>2009</th><td><img alt=\"\" src=\"http://c.biancheng.net/uploads/allimg/181221/1343464435-0.png\">Go</td></tr><tr><th>2008</th><td><img alt=\"\" src=\"http://c.biancheng.net/uploads/allimg/181221/1343464435-0.png\">C</td></tr></tbody></table><p><br>C语言诞生于20世纪70年代，年龄比我们都要大，我们将在《<a href=\"http://c.biancheng.net/view/vip_1742.html\" target=\"_blank\">C语言的三套标准：C89、C99和C11</a>》一节中讲解更多关于C语言的历史。<br><br>当然，C语言也不是没有缺点，毕竟是70后老人，有点落后时代，开发效率较低，后来人们又在C语言的基础上增加了面向对象的机制，形成了一门新的语言，称为C++，我们将在《<a href=\"http://c.biancheng.net/view/vip_1722.html\" target=\"_blank\">C语言和C++到底有什么关系</a>》中讲解。</p><h2>C语言难吗？</h2><p>和 Java、C++、Python、C#、JavaScript 等高级编程语言相比，C语言涉及到的编程概念少，附带的标准库小，所以整体比较简洁，容易学习，非常适合初学者入门。<br><br></p><div><img alt=\"C语言非常简单\" src=\"http://c.biancheng.net/uploads/allimg/181221/1332154T9-0.jpg\"></div><p><br>编程语言的发展大概经历了以下几个阶段：</p><p><a href=\"http://c.biancheng.net/asm/\" target=\"_blank\">汇编语言</a>&nbsp;--&gt; 面向过程编程 --&gt; 面向对象编程</p><ul><li>汇编语言是编程语言的拓荒年代，它非常底层，直接和计算机硬件打交道，开发效率低，学习成本高；</li><li>C语言是面向过程的编程语言，已经脱离了计算机硬件，可以设计中等规模的程序了；</li><li>Java、C++、Python、C#、PHP 等是面向对象的编程语言，它们在面向过程的基础上又增加了很多概念。</li></ul><p><br>C语言出现的时候，已经度过了编程语言的拓荒年代，具备了现代编程语言的特性，但是这个时候还没有出现“<a href=\"https://baike.baidu.com/item/%E8%BD%AF%E4%BB%B6%E5%8D%B1%E6%9C%BA/564526\" target=\"_blank\">软件危机</a>”，人们没有动力去开发更加高级的语言，所以也没有太复杂的编程思想。<br><br>也就是说，C语言虽然是现代编程语言，但是它涉及到的概念少，词汇少，思想也简单。C语言学习成本小，初学者能够在短时间内掌握编程技能，非常适合入门。</p><h2>C语言是计算机产业的核心语言</h2><p>也许是机缘巧合，C语言出现后不久，计算机产业开始爆发，计算机硬件越来越小型化，越来越便宜，逐渐进入政府机构，进入普通家庭，C语言成了编程的主力军，获得了前所未有的成功，操作系统、常用软件、硬件驱动、底层组件、核心算法、数据库、小游戏等都使用C语言开发。<br><br>雷军说过，站在风口上，猪都能飞起来；C语言就是那头猪，不管它好不好，反正它飞起来了。<br><br></p><div><img alt=\"C语言飞起来了\" src=\"http://c.biancheng.net/uploads/allimg/181221/1332154556-1.jpg\"></div><p><br>C语言在计算机产业大爆发阶段被万人膜拜，无疑会成为整个软件产业的基础，拥有核心地位。<br><br>软件行业的很多细分学科都是基于C语言的，学习<a href=\"http://c.biancheng.net/data_structure/\" target=\"_blank\">数据结构</a>、算法、操作系统、编译原理等都离不开C语言，所以大学将C语言作为一门公共课程，计算机相关专业的同学都要学习。<br><br>C语言被誉为“上帝语言”，它不但奠定了软件产业的基础，还创造了很多其它语言，例如：</p><ul><li>PHP、Python 等都是用C语言开发出来的，虽然平时做项目的时候看不到C语言的影子，但是如果想深入学习 PHP 和 Python，那就要有C语言基础了。</li><li>C++ 和 Objective-C 干脆在C语言的基础上直接进行扩展，增加一些新功能后变成了新的语言，所以学习 C++ 和 Objective-C 之前也要先学习C语言。</li></ul><p><br>C语言是有史以来最为重要的编程语言：要进入编程行业高手级别必学C语言，要挣大钱必学C语言，要做黑客、红客必学C语言，要面试名企、外企、高薪职位必学C语言。&nbsp;&nbsp;<br></p>', '2020-03-15 17:27:16', '2020-03-15 19:02:10');
INSERT INTO `article` VALUES ('3b69f109b8b6486b9db0c501abe1e1ba', '1000', '通俗地理解什么是编程语言', '<p>学习编程语言之前，首先要搞清楚「编程语言」这个概念。<br><br>很小的时候，父母就教我们开口说话，也教我们如何理解别人讲话的意思。经过长时间的熏陶和自我学习，我们竟然在不知不觉中学会了说话，同时也能听懂其他小朋友说话的意思了，我们开始向父母要零花钱买零食和玩具、被欺负了向父母倾诉……<br><br>我们说的是汉语，是“中国语言”，只要把我们的需求告诉父母，父母就会满足，我们用“中国语言”来控制父母，让父母做我们喜欢的事情。<br><br>“中国语言”有固定的格式，每个汉字代表的意思不同，我们必须正确的表达，父母才能理解我们的意思。例如让父母给我们10元零花钱，我们会说“妈妈给我10块钱吧，我要买小汽车”。如果我们说“10元给我汽车小零花钱妈妈”，或者“妈妈给我10亿人民币，我要买F-22”，妈妈就会觉得奇怪，听不懂我们的意思，或者理解错误，责备我们。<br><br>我们通过有固定格式和固定词汇的“语言”来控制他人，让他人为我们做事情。语言有很多种，包括汉语、英语、法语、韩语等，虽然他们的词汇和格式都不一样，但是可以达到同样的目的，我们可以选择任意一种语言去控制他人。<br><br>同样，我们也可以通过”语言“来控制计算机，让计算机为我们做事情，这样的语言就叫做编程语言（Programming Language）。<br><br>编程语言也有固定的格式和词汇，我们必须经过学习才会使用，才能控制计算机。<br><br>编程语言有很多种，常用的有C语言、<a href=\"http://c.biancheng.net/cplus/\" target=\"_blank\">C++</a>、<a href=\"http://c.biancheng.net/java/\" target=\"_blank\">Java</a>、<a href=\"http://c.biancheng.net/csharp/\" target=\"_blank\">C#</a>、<a href=\"http://c.biancheng.net/python/\" target=\"_blank\">Python</a>、<a href=\"http://c.biancheng.net/php/\" target=\"_blank\">PHP</a>、<a href=\"http://c.biancheng.net/js/\" target=\"_blank\">JavaScript</a>、Go语言、Objective-C、Swift、<a href=\"http://c.biancheng.net/asm/\" target=\"_blank\">汇编语言</a>等，每种语言都有自己擅长的方面，例如：<br></p><table><tbody><tr><th width=\"90\">编程语言</th><th>主要用途</th></tr><tr><td>C/C++</td><td>C++ 是在C语言的基础上发展起来的，C++ 包含了C语言的所有内容，C语言是C++的一个部分，它们往往混合在一起使用，所以统称为 C/C++。C/C++主要用于PC软件开发、Linux开发、游戏开发、单片机和嵌入式系统。</td></tr><tr><td>Java</td><td>Java 是一门通用型的语言，可以用于网站后台开发、<a href=\"http://c.biancheng.net/android/\" target=\"_blank\">Android</a>&nbsp;开发、PC软件开发，近年来又涉足了<a href=\"http://c.biancheng.net/big_data/\" target=\"_blank\">大数据</a>领域（归功于 Hadoop 框架的流行）。</td></tr><tr><td>C#</td><td>C# 是微软开发的用来对抗 Java 的一门语言，实现机制和 Java 类似，不过 C# 显然失败了，目前主要用于 Windows 平台的软件开发，以及少量的网站后台开发。</td></tr><tr><td>Python</td><td>Python 也是一门通用型的语言，主要用于系统运维、网站后台开发、数据分析、人工智能、<a href=\"http://c.biancheng.net/cloud_computing/\" target=\"_blank\">云计算</a>等领域，近年来势头强劲，增长非常快。</td></tr><tr><td>PHP</td><td>PHP 是一门专用型的语言，主要用来开发网站后台程序。</td></tr><tr><td>JavaScript</td><td>JavaScript 最初只能用于网站前端开发，而且是前端开发的唯一语言，没有可替代性。近年来由于 Node.js 的流行，JavaScript 在网站后台开发中也占有了一席之地，并且在迅速增长。</td></tr><tr><td>Go语言</td><td>Go语言是 2009 年由 Google 发布的一款编程语言，成长非常迅速，在国内外已经有大量的应用。Go 语言主要用于服务器端的编程，对 C/C++、Java 都形成了不小的挑战。</td></tr><tr><td>Objective-C<br>Swift</td><td>Objective-C 和 Swift 都只能用于苹果产品的开发，包括 Mac、MacBook、iPhone、iPad、iWatch 等。</td></tr><tr><td>汇编语言</td><td>汇编语言是计算机发展初期的一门语言，它的执行效率非常高，但是开发效率非常低，所以在常见的应用程序开发中不会使用汇编语言，只有在对效率和实时性要求极高的关键模块才会考虑汇编语言，例如操作系统内核、驱动、仪器仪表、工业控制等。</td></tr></tbody></table><p><br>可以将不同的编程语言比喻成各国语言，为了表达同一个意思，可能使用不同的语句。例如，表达“世界你好”的意思：</p><ul><li>汉语：世界你好；</li><li>英语：Hello World</li><li>法语：Bonjour tout le monde</li></ul><p><br>在编程语言中，同样的操作也可能使用不同的语句。例如，在屏幕上显示“C语言中文网”：</p><ul><li>C语言：puts(\"C语言中文网\");</li><li>PHP：echo \"C语言中文网\";</li><li>Java：System.out.println(\"C语言中文网\");</li></ul><p><br>编程语言类似于人类语言，由直观的词汇组成，我们很容易就能理解它的意思，例如在C语言中，我们使用&nbsp;<code>puts</code>&nbsp;这个词让计算机在屏幕上显示出文字；puts 是 output string（输出字符串）的缩写。<br><br>使用 puts 在屏幕上显示“C语言中文网”：</p><pre>puts(\"C语言中文网\");</pre><p>我们把要显示的内容放在<code>(\"</code>和<code>\")</code>之间，并且在最后要有<code>;</code>。你必须要这样写，这是固定的格式。<br><br>总结：编程语言是用来控制计算机的一系列指令（Instruction），它有固定的格式和词汇（不同编程语言的格式和词汇不一样），必须遵守，否则就会出错，达不到我们的目的。<br><br>C语言（C Language）是编程语言的一种，学习C语言，主要是学习它的格式和词汇。下面是一个C语言的完整例子，它会让计算机在屏幕上显示”C语言中文网“。</p><blockquote><p>这个例子主要演示C语言的一些固有格式和词汇，看不懂的读者不必深究，也不必问为什么是这样，后续我们会逐步给大家讲解。</p></blockquote><pre>#include &lt;stdio.h&gt;\r\nint main(){\r\n    puts(\"C语言中文网\");\r\n    return 0;\r\n}</pre><p>这些具有特定含义的词汇、语句，按照特定的格式组织在一起，就构成了源代码（Source Code），也称源码或代码（Code）。<br><br>那么，C语言肯定规定了源代码中每个词汇、语句的含义，也规定了它们该如何组织在一起，这就是语法（Syntax）。它与我们学习英语时所说的“语法”类似，都规定了如何将特定的词汇和句子组织成能听懂的语言。<br><br>编写源代码的过程就叫做编程（Program）。从事编程工作的人叫程序员（Programmer）。程序员也很幽默，喜欢自嘲，经常说自己的工作辛苦，地位低，像农民一样，所以称自己是”码农“，就是写代码的农民。也有人自嘲称是”程序猿“。&nbsp;&nbsp;<br></p>', '2020-03-15 17:25:14', '2020-03-15 17:25:14');
INSERT INTO `article` VALUES ('84f7d0576c1b468dbab19a717ad27acd', '1000', 'C语言是菜鸟和大神的分水岭', '<p>作为一门古老的编程语言，C语言已经坚挺了好几十年了，初学者从C语言入门，大学将C语言视为基础课程。不管别人如何抨击，如何唱衰，C语言就是屹立不倒；<a href=\"http://c.biancheng.net/java/\" target=\"_blank\">Java</a>、<a href=\"http://c.biancheng.net/csharp/\" target=\"_blank\">C#</a>、<a href=\"http://c.biancheng.net/python/\" target=\"_blank\">Python</a>、<a href=\"http://c.biancheng.net/php/\" target=\"_blank\">PHP</a>、Perl 等都有替代方案，它们都可以倒下，唯独C语言不行。<br><br>程序是在内存中运行的（我们将在《<a href=\"http://c.biancheng.net/view/1727.html\" target=\"_blank\">载入内存，让程序运行起来</a>》一节中详细说明），一名合格的程序员必须了解内存，学习C语言是了解内存布局的最简单、最直接、最有效的途径，C语言简直是为内存而生的，它比任何一门编程语言都贴近内存。<br><br>所谓内存，就是我们常说的内存条，就是下图这个玩意，相信你肯定见过。<br></p><div><img alt=\"内存条\" src=\"http://c.biancheng.net/uploads/allimg/181221/134I32557-0.jpg\"><br>图：内存条</div><p><br>所有的程序都在拼尽全力节省内存，都在不遗余力提高内存使用效率，计算机的整个发展过程都在围绕内存打转，不断地优化内存布局，以保证可以同时运行多个程序。<br><br>不了解内存，就学不会进程和线程，就没有资格玩中大型项目，没有资格开发底层组件，没有资格架构一个系统，命中注定你就是一个菜鸟，成不了什么气候。<br><br>以上这点我有深刻的体会！工作期间我曾专注于网站开发，虽然能够设计出界面漂亮、体验良好的网页，但是对内存泄漏、多线程、共享内存等底层概念一窍不通，感觉和周围同事的差距很大，这让我非常郁闷，不知道如何突破。我曾多次尝试学习内存和线程，也找了很多资料，但是无论如何都啃不懂，到头来还是一头雾水。<br><br>离职后我全职运营C语言中文网，于是决定再次系统、深入、全面地学习C语言，并结合C语言去了解一些内存知识，这个时候我才发现，原来C语言就是为内存而生的，C语言的设计和内存的布局是严密贴合的，我因为学习C语言而吃透了内存，了解了计算机内存是如何分布和组织的。<br></p><blockquote>C语言无时无刻不在谈内存，内存简直就是如影随形，你不得不去研究它。</blockquote><p>至关重要的一点是，我能够把内存和具体的编程知识以及程序的运行过程结合起来，真正做到了学以致用，让概念落地，而不是空谈，这才是最难得的。<br><br>另外一个惊喜是，攻克内存后我竟然也能够理解进程和线程了，原来进程和线程也是围绕内存打转的，从一定程度上讲，它们的存在也是为了更加高效地利用内存。<br><br>从C语言到内存，从内存到进程和线程，环环相扣：不学C语言就吃不透内存，不学内存就吃不透进程和线程。<br><br>我感觉自己瞬间升华了，达到了一个新的高度，之前的很多谜团都解开了，和大神交流也没有障碍了。<br><br>「内存 + 进程 + 线程」这几个最基本的计算机概念是菜鸟和大神的分水岭，也只有学习C语言才能透彻地理解它们。Java、C#、PHP、Python、<a href=\"http://c.biancheng.net/js/\" target=\"_blank\">JavaScript</a>&nbsp;程序员工作几年后会遇到瓶颈，有很多人会回来学习C语言，重拾底层概念，让自己再次突破。&nbsp;&nbsp;<br></p>', '2020-03-15 19:43:07', '2020-03-15 19:43:07');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程表主键',
  `file_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '视频表id',
  `name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程名称',
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '视频简介',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '视频类型',
  `price` int(10) UNSIGNED ZEROFILL NOT NULL COMMENT '视频价格',
  `label` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '视频评价',
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '视频封面图片',
  `firsttime` datetime(0) NOT NULL COMMENT '视频创建日期',
  `updatetime` datetime(0) NOT NULL COMMENT '视频修改日期',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `课程名称`(`name`) USING BTREE COMMENT '课程名称的索引',
  UNIQUE INDEX `视频表id`(`file_id`) USING BTREE COMMENT '视频表的id',
  UNIQUE INDEX `课程封面`(`image_url`) USING BTREE COMMENT '课程封面的索引',
  CONSTRAINT `视频表的id` FOREIGN KEY (`file_id`) REFERENCES `course_file` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('5087872237004a79b7c0ff75552f2afd', NULL, 'C#', 'C#', 'vip', 0000000010, '无', '9648e291d9ec4fdbbdb7be2a3ba41ec3.jpg', '2020-03-03 01:46:47', '2020-03-15 14:15:59');
INSERT INTO `course` VALUES ('935c2ad41320495fbdd8d12cd603550f', NULL, 'Java', 'JavaSE基础', 'vip', 0000000010, '良好', 'afc986cb31f14a18aeb2999a684d73d4.jpg', '2020-03-05 17:49:12', '2020-03-15 20:11:14');
INSERT INTO `course` VALUES ('9cddda0b8f1e4af7a57314ea15fa56cc', NULL, 'c++', 'c++', 'free', 0000000000, '无', 'e1fcc8ec3d8942b8905215d03e9afdfc.jpg', '2020-03-03 01:46:47', '2020-03-15 20:11:32');
INSERT INTO `course` VALUES ('f3f10feed195498cb13b674ed388bc81', NULL, 'c', 'c', 'free', 0000000000, '一般', '09422fd9ab3a4903b160896c3c042f93.jpg', '2020-03-03 01:46:47', '2020-03-15 20:11:26');

-- ----------------------------
-- Table structure for course_file
-- ----------------------------
DROP TABLE IF EXISTS `course_file`;
CREATE TABLE `course_file`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '视频文件id',
  `filename` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '视频文件名',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '视频文件路径',
  `firsttime` datetime(0) NOT NULL COMMENT '视频创建日期',
  `updatetime` datetime(0) NOT NULL COMMENT '视频修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_file
-- ----------------------------
INSERT INTO `course_file` VALUES ('165f54797a58489fa47dd7fdee749a36', '33', 'F:/javaWeb/education/upload/33.Ogg', '2020-03-05 20:35:52', '2020-03-05 20:35:52');
INSERT INTO `course_file` VALUES ('21a51000ef2444e4b06adda8bdfd2dec', '44', 'F:/javaWeb/education/upload/44.Ogg', '2020-03-05 20:35:59', '2020-03-05 20:35:59');
INSERT INTO `course_file` VALUES ('3a5cd8cd838a4a9bb7eb90909cdbe7ee', '22', 'F:/javaWeb/education/upload/22.Ogg', '2020-03-05 18:50:19', '2020-03-05 18:50:19');
INSERT INTO `course_file` VALUES ('5f5f81f50ea64dec9bf61a50c53a8f2b', '11', 'F:/javaWeb/education/upload/11.Ogg', '2020-03-05 18:50:12', '2020-03-05 18:50:12');

-- ----------------------------
-- Table structure for ipset
-- ----------------------------
DROP TABLE IF EXISTS `ipset`;
CREATE TABLE `ipset`  (
  `ip` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作者ip',
  `isban` tinyint(1) NOT NULL COMMENT '是否封禁',
  `flag` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作类型',
  `bantime` datetime(0) NULL DEFAULT NULL COMMENT '封禁日期',
  `firsttime` datetime(0) NOT NULL COMMENT '创建日期',
  `lasttime` datetime(0) NOT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`ip`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ipset
-- ----------------------------
INSERT INTO `ipset` VALUES ('127.0.0.1', 0, NULL, NULL, '2020-02-18 15:06:31', '2020-02-18 15:06:31');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '日志id',
  `userid` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作动作',
  `operationtime` datetime(0) NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('1', '1000', '管理员注册', '2020-02-18 15:07:03');
INSERT INTO `log` VALUES ('2', '1001', '管理员注册', '2020-02-18 15:07:13');
INSERT INTO `log` VALUES ('3', '2000', '管理员注册', '2020-02-18 15:07:26');
INSERT INTO `log` VALUES ('4', '2000', '管理员注册', '2020-02-18 15:07:34');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户账户',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户昵称',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `sex` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户性别',
  `phone` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户手机号码',
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱地址',
  `wechar` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '微信号',
  `collect` int(10) UNSIGNED ZEROFILL NULL DEFAULT 0000000000 COMMENT '用户余额',
  `education` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '教育程度',
  `vip` datetime(0) NULL DEFAULT NULL COMMENT 'vip日期',
  `firsttime` datetime(0) NOT NULL COMMENT '创建日期',
  `updatetime` datetime(0) NOT NULL COMMENT '修改时间',
  `lasttime` datetime(0) NOT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `User_name_nickname`(`name`, `nickname`) USING BTREE COMMENT '用户账号或昵称的索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0637a7ee1b6a4c72a0cc23a1146db917', 'yz772095101 ', '1234', 'adm123', 'Male', '13377211793', 'admin@163.com', '无', 0000000200, '高中', '2020-04-25 04:02:17', '2020-02-23 22:08:26', '2020-03-15 19:00:16', '2020-02-23 22:08:26');
INSERT INTO `user` VALUES ('16b3d9f0d8c84ea7a0ffcc4b32a72b88', 'admin', 'aa', 'admin1234', 'Male', '13377211793', 'admin@funtl.com', '无', 0000000100, '无', '2020-04-25 04:02:17', '2020-02-23 22:08:26', '2020-02-23 22:02:26', '2020-02-27 20:47:17');
INSERT INTO `user` VALUES ('2001', 'user', 'user', 'user321', 'Female', '13313231654', 'djefnehfdnqmh651651@163.com', 'NMTNERN51', 0000000100, '本科', '2020-04-25 04:02:17', '2020-02-23 22:08:26', '2020-03-02 21:13:01', '2020-02-19 19:06:14');
INSERT INTO `user` VALUES ('981f874919ca49d3b0bcb065fcf7e898', '123asd', 'qsdasd ', 'admin123', 'Male', '13377211754', 'admin@163.com', '无', 0000000000, '无', NULL, '2020-02-23 22:08:26', '2020-03-03 02:02:02', '2020-03-03 02:02:02');
INSERT INTO `user` VALUES ('9da45930d937447ebe955018bcf75c45', 'admin123', '124123', 'admin123', 'Male', '13377211793', 'admin@163.com', '无', 0000000000, '无', NULL, '2020-02-23 22:08:26', '2020-03-03 02:12:01', '2020-03-03 02:12:01');
INSERT INTO `user` VALUES ('ae46604ba2d441aa9ccc674a289de6c2', '334', 'c\'c', 'admin12', 'Male', '13377211792', 'admin1111@163.com', '无', 0000000100, '无', '2020-04-25 04:02:17', '2020-02-23 22:08:26', '2020-02-24 22:06:23', '2020-02-24 02:46:24');

SET FOREIGN_KEY_CHECKS = 1;
