使用Maven私有仓库管理软件Sonatype Nexus，搭建私服。

    官网地址：https://my.sonatype.com/
    搜索：oss
    选择：Download Archives - Repository Manager OSS

Git版本控制

    官网地址：https://git-scm.com/downloads
    傻瓜式安装，一路next。

GitHub托管中心

    官网地址：https://github.com/
    账号密码：r**d*y**(r************y)

Git设置签名

    git config --list
    git config --global user.name "renxxx"
    git config --global user.email "280xxxxxx@qq.com"

Git生成密钥

    $ cd ~/.ssh
    $ ls
    id_rsa  id_rsa.pub
    $ cd ~
    $ ssh-keygen.exe

Git管理项目
    
    命令行操作：
        git init
        git remote add origin https://github.com/rendeyou/spring_aop_log.git
        git push -u origin master
    Idea中操作：
        git init
            VCS
            Import into Version Control
            Create Git Repository
            C:\Users\rendeyou\Desktop\aop-log\spring_aop_log
        git remote add origin https://github.com/rendeyou/spring_aop_log.git
            项目spring_aop_log右键,Git,Add
            项目spring_aop_log右键,Git,Commit Directory
            Git,Repository,Remotes,https://github.com/rendeyou/spring_aop_log.git
        git push -u origin master
            Git,Repository,Push
    解决Push慢的问题：
        获取global.ssl.fastly地址
            访问 http://github.global.ssl.fastly.net.ipaddress.com/#ipinfo 
        获取github地址
            访问 http://github.com.ipaddress.com/#ipinfo
        C:\Windows\System32\drivers\etc\hosts
            199.232.69.194 https://github.global.ssl.fastly.net
            140.82.113.3 https://github.com
        windows打开cmd刷新DNS缓存   
            ipconfig /flushdns      




