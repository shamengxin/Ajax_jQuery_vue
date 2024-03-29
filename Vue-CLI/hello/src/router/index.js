import Vue from 'vue'
import Router from 'vue-router'
import Home from "../components/Home";
import User from "../components/User";
import Student from "../components/Student";

Vue.use(Router)

export default new Router({
  routes: [
    {path:'/',redirect:'/home'},
    {path:'/home',component:Home},
    {path:'/user',component:User},
    {path:'/student',component:Student},
  ]
})
