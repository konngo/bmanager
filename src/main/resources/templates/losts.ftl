<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>失物招领管理</title>
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
    <script src="/lib/jquery.min.js"></script>
    <link rel="stylesheet" href="/css/index.css"></link>
    <link rel="stylesheet" href="/lib/layui/css/layui.css"></link>
    <link rel="stylesheet" href="/lib/jqgrid/ui.jqgrid-bootstrap.css">


    <script src="/lib/jqgrid/grid.locale-cn.js"></script>
    <script src="/lib/jqgrid/jquery.jqGrid.min.js"></script></head>
<body>
<div id="app">
    <div v-show="show">

        <div class="demoTable">
            <div class="layui-inline">
                司机：
                <input class="layui-input" name="siji" id="siji" autocomplete="off">
                线路：
                <input class="layui-input" name="buslines" id="buslines" autocomplete="off">
                遗失物品：
                <input class="layui-input" name="losts" id="losts" autocomplete="off">
            </div>
            <button class="layui-btn" data-type="reload">搜索</button>
        </div>


        <table class="layui-hide" id="demo" lay-filter="demo"></table>

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
            </div>
        </script>

        <script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </script>
    </div>

    <div v-show="!show">



        <form class="layui-form" action="/losts/addOrUpdate">

                <div class="layui-form-item">
                    <label class="layui-form-label">编号</label>
                    <div class="layui-input-block">
                        <input type="text" name="id"  :value="losts. id" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">名称</label>
                    <div class="layui-input-block">
                        <input type="text" name="name"  :value="losts. name" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">内容</label>
                    <div class="layui-input-block">
                        <input type="text" name="content"  :value="losts. content" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">线路</label>
                    <div class="layui-input-block">
                        <select name="buslines" v-model="losts.buslines">
                            <option v-for="item in lines" :value="item.id" >{{item.id}}</option>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">司机</label>
                    <div class="layui-input-block">
                        <select name="siji" v-model="losts.siji">
                            <option v-for="item in siji"  :value="item.id"  >{{item.name}}</option>
                        </select>
                    </div>
                </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                </div>
            </div>
        </form>
    </div>

</div>

<script >
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#demo'
            ,url:'/losts/list'
            ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'exports', 'print']
            ,title: '失物招领数据表'
            ,id:'testReload'
            ,cols: [[
                {field:'id', title:'编号'},
                {field:'name', title:'名称'},
                {field:'content', title:'内容'},
                {field:'buslines', title:'线路'},
                {field:'siji', title:'司机'},
                {fixed:'right',title:'操作',toolbar:'#barDemo'}
            ]]
            ,page: true
        });


        //头工具栏事件
        table.on('toolbar(demo)', function(obj){
            switch(obj.event){
                case 'add':
                    vue.handleAdd();
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    vue.handleDelete(data.id);
                    obj.del();
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                vue.handleEdit(data);
            } else if(obj.event === 'add'){
                vue.handleAdd();
            }
        });



        // 重载表格
        var $ = layui.$, active = {
            reload: function(){

                var siji = $('#siji');
                var buslines = $('#buslines');
                var losts = $('#losts');

                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        siji: siji.val(),
                        buslines: buslines.val(),
                        losts: losts.val()
                    }
                }, 'data');
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });


    })



    var vue=new Vue({
        el:'#app',
        data:{
            show:true,
            losts :{},
            siji:{},
            lines:{}
        },
        methods:{
            async initData(){
                var that=this;
                await axios.get('/siji/list').then(function (response) {
                    that.siji= response.data.data
                }).catch(function (error) {
                    console.log(error)
                });

                await axios.get('/buslines/list').then(function (response) {
                    that.lines= response.data.data
                }).catch(function (error) {
                    console.log(error)
                });

                await that.update();
            },
            handleAdd(){
                this.show=false;
                this.losts={};
            },
            handleEdit(losts){
                this.show=false;
                this.losts=losts;
            },
            handleDelete(id){
                axios.get("/losts/delete?id="+id).then(function (response) {
                    this.$message.error('删除成功！');
                }).catch(function (error) {
                    console.log(error)
                });
            },
            returnMain(){
                this.show=true;
            },
            update(){
                layui.use(['form'], function(){
                    var form = layui.form;
                    form.render();
                })
            }
        },
        mounted(){
            this.initData();

        }
    })
</script>


</body>
</html>