<template>
  <SingUpPage />
  <LoginPage />
</template>

<script>
import SingUpPage from './components/SingUpPage.vue'
import LoginPage from './components/LoginPage.vue'

export default {
  name: 'App',
  components: {
    SingUpPage,
    LoginPage,
  }
};
</script>

<style src="./assets/tailwind.css"/>
