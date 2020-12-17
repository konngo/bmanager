const  colorList=['#f56a00', '#7265e6', '#ffbf00', '#00a2ae'];
new Vue({
    el:'#app',
    data:{
        avatarValue:'<#if Session["users"]?exists>${Session["users"].name?cap_first}</#if>',
        color: colorList[0],
        collapsed: false,
        content:'欢迎使用本系统。。。</br> ..'
    },
    methods:{
        logout(){

        },
        changeValue(){
            let num=Math.round(Math.random()*3);
            this.color=this.colorList[num]
        },
        changePath({item,path,key}) {
            console.log(key)
            axios.get(key).then(function (response) {
                this.content=response;
            }).catch(function (error) {
                console.log(error)
            });
        }
    }
});