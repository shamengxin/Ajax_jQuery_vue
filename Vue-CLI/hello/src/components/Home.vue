<template>
  <div>
    <h1>主页组件</h1>
    <div style="width:100%;height:300px;background: red">
      内容
    </div>
    <!--使用组件-->
    <Footer></Footer>
  </div>
</template>

<script>
import Footer from "./Footer";
export default {
  name: "Home",
  components:{
    Footer,
  }
}
</script>

<style scoped>

</style>
