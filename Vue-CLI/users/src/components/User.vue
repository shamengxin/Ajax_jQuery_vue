<template>
<div>
  <h1>用户列表</h1>
  <table border="1">
    <tr>
      <td>编号</td>
      <td>姓名</td>
      <td>年龄</td>
      <td>生日</td>
      <td>操作</td>
    </tr>
    <tr v-for="user in users">
      <td>{{user.id}}</td>
      <td>{{user.name}}</td>
      <td>{{user.age}}</td>
      <td>{{user.bir}}</td>
      <td><a href="">删除</a><a href="">修改</a></td>
    </tr>
  </table>
  <a href="#/user/add">添加</a>
  <router-view></router-view>
</div>
</template>

<script>
export default {
  name: "User",
  data(){
    return {
      users:[]
    }
  },
  methods:{
    findAll(){
      this.$http.get("http://rap2api.taobao.org/app/mock/310649/user/findAll").then((res)=>{
        this.users=res.data.results;
      });
    }
  },
  components:{},
  created() {
    this.findAll();
  },
  watch:{
    $route:{
      handler:function (val,oldVal){
        console.log(val);
        if (val.path == '/user') {
          this.findAll();
        }
      },
      deep:true
    }
  }
}
</script>

<style scoped>

</style>
