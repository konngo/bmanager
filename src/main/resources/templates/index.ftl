<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script src="/lib/vue.js" ></script>
    <script src="/lib/antdesign/antd.min.js" ></script>
    <script src="/lib/axios.min.js" ></script>
    <script src="/lib/layui/layui.js" ></script>
    <link rel="stylesheet" href="/lib/antdesign/antd.min.css"></link>



    <script src="/lib/moment.min.js"></script>
    <script src="/lib/jquery.min.js"></script>
    <link rel="stylesheet" href="/css/index.css"></link>
    <link rel="stylesheet" href="/lib/layui/css/layui.css"></link>

    <style>
        html,body,div{
            margin: 0;
            padding: 0;
            height: 100%;
        }

        @media screen and (max-width: 1024px) {

            .menu-title{
                display: none;
            }

        }
    </style>
</head>
<body>
<div id="app">
    <a-layout id="main">


        <a-layout>
            <a-layout-header style="background: #fff; padding: 0">
                <a-menu @click="changePath" mode="horizontal" :defaultSelectedKeys="['1']">
                    <a-menu-item key="/users/page" >
                        <a-icon type="user" ></a-icon>
                        <span class="menu-title">用户管理</span>
                    </a-menu-item>
                    <a-menu-item key="/siji/page" >
                        <a-icon type="qrcode" ></a-icon>
                        <span class="menu-title">司机管理</span>
                    </a-menu-item>
                    <a-menu-item key="/buslines/page" >
                        <a-icon type="bulb" ></a-icon>
                        <span class="menu-title">路线管理</span>
                    </a-menu-item>
                    <a-menu-item key="/bus/page" >
                        <a-icon type="rocket" ></a-icon>
                        <span class="menu-title">车辆管理</span>
                    </a-menu-item>
                    <a-menu-item key="/losts/page" >
                        <a-icon type="message" ></a-icon>
                        <span class="menu-title">失物招领</span>
                    </a-menu-item>
                </a-menu>
            </a-layout-header>
            <a-layout-content
                    :style="{ margin: '24px 16px', padding: '24px', background: '#fff', minHeight: '680px'}"
            >
                <iframe scrolling="yes" frameborder="0" style="width:100%;min-height:600px;overflow:visible;background:#fff;" :src="main"></iframe>


                <#--  <div id="content">
                  </div>-->
            </a-layout-content>
        </a-layout>
    </a-layout>
</div>


<script>
    function changeDOM(html) {
        // $("#content").html(html);
        // $("#content").html("");
        // $("#content").append(html);
    }

    const  colorList=['#f56a00', '#7265e6', '#ffbf00', '#00a2ae'];
    new Vue({
        el:'#app',
        data:{
            avatarValue:'<#if Session["users"]?exists>${Session["users"].name?cap_first}</#if>',
            color: colorList[0],
            collapsed: false,
            content:'欢迎使用本系统。。。',
            main:'/toindex'
        },
        methods:{
            logout(){

            },
            changeValue(){
                let num=Math.round(Math.random()*3);
                this.color=this.colorList[num]
            },
            changePath({item,path,key}) {
                /*  axios.get(key).then(function (response) {
                      changeDOM(response.data);
                  }).catch(function (error) {
                      console.log(error)
                  });*/
                this.main=key;
            }
        },
        created(){
            // changeDOM(this.content);
        }
    });

</script>
</body>
</html>