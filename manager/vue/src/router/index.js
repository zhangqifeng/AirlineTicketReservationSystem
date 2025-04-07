import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

// 解决导航栏或者底部导航tabBar中的vue-router在3.0版本以上频繁点击菜单报错的问题。
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push (location) {
  return originalPush.call(this, location).catch(err => err)
}

const routes = [
  {
    path: '/',
    name: 'Manager',
    component: () => import('../views/Manager.vue'),
    redirect: '/home',  // 重定向到主页
    children: [
      { path: '403', name: 'NoAuth', meta: { name: '无权限' }, component: () => import('../views/manager/403') },
      { path: 'home', name: 'Home', meta: { name: '系统首页' }, component: () => import('../views/manager/Home') },
      { path: 'admin', name: 'Admin', meta: { name: '管理员信息' }, component: () => import('../views/manager/Admin') },
      { path: 'adminPerson', name: 'AdminPerson', meta: { name: '个人信息' }, component: () => import('../views/manager/AdminPerson') },
      { path: 'password', name: 'Password', meta: { name: '修改密码' }, component: () => import('../views/manager/Password') },
      { path: 'notice', name: 'Notice', meta: { name: '公告信息' }, component: () => import('../views/manager/Notice') },
      { path: 'trainticket', name: 'Trainticket', meta: { name: '公告信息' }, component: () => import('../views/manager/Trainticket') },
      { path: 'airticket', name: 'Airticket', meta: { name: '公告信息' }, component: () => import('../views/manager/AirTicket') },
    ]
  },
  {
    path: '/front',
    name: 'Front',
    component: () => import('../views/Front.vue'),
    children: [
      { path: 'home', name: 'Home', meta: { name: '系统首页' }, component: () => import('../views/front/Home') },
      { path: 'person', name: 'Person', meta: { name: '个人信息' }, component: () => import('../views/front/Person') },
      { path: 'airTicket', name: 'AirTicket', meta: { name: 'air' }, component: () => import('../views/front/AirTicket') },
      { path: 'trainTicket', name: 'TrainTicket', meta: { name: 'train' }, component: () => import('../views/front/TrainTicket') },
      // { path: 'busTicket', name: 'BusTicket', meta: { name: 'Bus' }, component: () => import('../views/front/BusTicket') },
      // { path: 'airorders', name: 'airOrders', meta: { name: 'air' }, component: () => import('../views/front/airOrders') },
      // { path: 'trainorders', name: 'trainOrders', meta: { name: 'train' }, component: () => import('../views/front/trainOrders') },
      // { path: 'busorders', name: 'BusOrders', meta: { name: 'train' }, component: () => import('../views/front/BusOrders') },
      { path: 'myIntroduction', name: 'MyIntroduction', meta: { name: '我的攻略' }, component: () => import('../views/front/MyIntroduction') },
      { path: 'introduction', name: 'Introduction', meta: { name: '旅游攻略' }, component: () => import('../views/front/Introduction') },
      { path: 'introDetail', name: 'IntroDetail', meta: { name: '公告信息' }, component: () => import('../views/front/IntroDetail.vue') },
      { path: 'myCollect', name: 'MyCollect', meta: { name: '我的收藏' }, component: () => import('../views/front/MyCollect.vue') },

    ]
  },
  { path: '/login', name: 'Login', meta: { name: '登录' }, component: () => import('../views/Login.vue') },
  { path: '/register', name: 'Register', meta: { name: '注册' }, component: () => import('../views/Register.vue') },
  { path: '*', name: 'NotFound', meta: { name: '无法访问' }, component: () => import('../views/404.vue') },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// 注：不需要前台的项目，可以注释掉该路由守卫
// 路由守卫
// router.beforeEach((to ,from, next) => {
//   let user = JSON.parse(localStorage.getItem("xm-user") || '{}');
//   if (to.path === '/') {
//     if (user.role) {
//       if (user.role === 'USER') {
//         next('/front/home')
//       } else {
//         next('/home')
//       }
//     } else {
//       next('/login')
//     }
//   } else {
//     next()
//   }
// })

export default router
