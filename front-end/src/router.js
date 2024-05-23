import { createMemoryHistory, createRouter } from 'vue-router'

import SingUpPage from './components/SingUpPage.vue'
import LoginPage from './components/LoginPage.vue'

const routes = [
  { path: '/', component: LoginPage},
  { path: '/signUp', component: SingUpPage },
]

const router = createRouter({
  history: createMemoryHistory(),
  routes,
})

export default router