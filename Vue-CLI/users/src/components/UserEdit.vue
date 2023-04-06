<template>
  <div>
    <h1>用户的修改信息</h1>
    <form action="">
      用户名：<input v-model="user.name" type="text"><br>
      年龄：<input v-model="user.age" type="text"><br>
      生日：<input v-model="user.bir" type="text"><br>
      <input type="submit" @click="editUserInfo" value="修改">
    </form>
  </div>
</template>

<script>
export default {
  name: "UserEdit",
  data() {
    return {
      user: {
        id: "",
      }
    }
  },
  methods: {
    findOne() {
      this.$http.get("http://localhost:8989/vue/user/findOne?id=" + this.user.id).then(res => {
        console.log(res.data);
        this.user = res.data;
      })
    },
    editUserInfo(){
      this.$http.post("http://localhost:8989/vue/user/update",this.user).then(res=>{
        console.log(res);
        if (res.data.success) {
          this.$router.push("/user");
        }
      })
    }
  },
  created() {
    console.log(this.$route.query.id);
    this.user.id = this.$route.query.id
    this.findOne()
  }
}
</script>

<style scoped>

</style>
