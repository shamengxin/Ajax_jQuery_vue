<template>
  <div id="app">

    <a href="#/home">主页模块</a>
    <a href="#/user">用户模块</a>
    <a href="#/student">学生模块</a>

    <!--用来展示路由组件-->
    <router-view/>
  </div>
</template>

<script>
export default {  //暴露当前组件对象
  name: 'App',
}
</script>

<style>
</style>
