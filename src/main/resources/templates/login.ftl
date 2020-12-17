<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理 - 登录</title>
    <script src="/lib/vue.js" ></script>
    <script src="/lib/antdesign/antd.min.js" ></script>
    <link rel="stylesheet" href="/lib/layui/css/layui.css"></link>
    <link rel="stylesheet" href="/lib/antdesign/antd.min.css"></link>

    <script src="/lib/moment.min.js"></script>
    <script src="/lib/layui/layui.js"></script>
    <script src="/lib/jquery.min.js"></script>
</head>
<body>
<div id="app" class="layui-container">
    <video class="video-player" preload="auto" autoplay="autoplay" loop="loop" >
        <source src="/video/login.mp4" type="video/mp4">
    </video>
    <div class="login"  class="layui-container">
        <h1>后台管理登录</h1>
        <form class="layui-form" method="post" action="/users/login">
            <div class="layui-form-item">
                <input class="layui-input" name="username" placeholder="用户名" lay-verify="required" type="text" autocomplete="off">
            </div>
            <div class="layui-form-item">
                <input class="layui-input" name="password" placeholder="密码" lay-verify="required" type="password" autocomplete="off">
            </div>
            <input class="layui-btn login_btn" type="submit">登录</input>
        </form>
    </div>
</div>

<script>
    var vue=new Vue({
        el:'#app',
        data:{
            status:<#if status?if_exists>
                false
                   <#else>
                true
                   </#if>
        },
        methods:{
            showLoginFailed(){
                if (this.status==false){
                    this.$message.error('用户名或者密码错误');
                }
            }
        },
        created(){
            this.showLoginFailed();
        }
    });
</script>

</body>
</html>