var mainMenu=Vue.extend({
    name:'main-menu',
    props:{item:{}},
    data(){
        return {
            flag:''
        }
    },
    template:[
        '<li @click="this.flag=item.id;" :class="flag==item.id?\'active\':\'\'"   >' +
        '   <a href="#" @click="changemenu(item.id)">' +
        '       <i  v-if="item.icon != null" :class="item.icon"></i> {{item.name}}' +
        '   </a>' +
        '</li>'
    ].join(),
    methods: {
        changemenu(data){
            this.$emit("changemenu",data)
        }
    }
})


var subMenu=Vue.extend({
    name:'sub-menu',
    props:{item:{}},
    template: [
        '<ul class="list-unstyled" :data-link="item.id">' +
        '    <li v-for="sub in item.list">' +
        '           <a href="#" @click="changemenu(sub.src)">' +
        '             <i :class="sub.icon"></i> <span class="d-inline-block">{{sub.name}}</span>' +
        '          </a>' +
        '     </li>' +
        '</ul>'
    ].join(),
    methods:{
        changemenu(item){
            this.$emit("changemenu",item)
        }
    }
})


//注册菜单组件
Vue.component('main-menu',mainMenu);
Vue.component('sub-menu',subMenu);

var vm=new Vue({
    el:'#kapp',
    data(){
        return {
            menulist: [
                {id:'main',name:'首页',icon:'iconsminds-shop-4'},
                {id:'users',name:'用户',icon:'simple-icon-user-female'},
                {id:'siji',name:'司机',icon:'iconsminds-air-balloon-1'},
                {id:'buslines',name:'路线',icon:'iconsminds-roof'},
                {id:'bus',name:'车辆',icon:'iconsminds-bus-2'},
                {id:'losts',name:'失物招领',icon:'iconsminds-sunglasses-w-3'},
            ],
            submenus:[
                // {id:"dashboard",list:[{src:'Dashboard.Default.html',icon:'simple-icon-rocket',name:'default'}]}
                ],
            main:'main'
        }
    },
    methods:{
        changemenu(item){
            this.main=item;
        }

    },created(){
        localStorage.setItem("user",'admin')
    }
});


//iframe自适应
$(window).on('resize', function() {
    var $content = $('.content');
    $content.height($(this).height() );
    $content.find('iframe').each(function() {
        $(this).height($content.height());
    });
}).resize();
//main自适应
$(window).on('resize', function() {
    var $content = $('main');
    $content.height($(this).height() );
    $content.find('iframe').each(function() {
        $(this).height($content.height());
    });
}).resize();

