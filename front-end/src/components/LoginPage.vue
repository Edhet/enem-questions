<template>
    <div class="min-h-screen py-40" style="background-image: linear-gradient(115deg, #D8BFD8, #B0E0E6);">
        <div class="container mx-auto">
            <div class="flex w-1/2 bg-white rounded-lg mx-auto shadow-xl overflow-hidden">
                <div class="w-full py-5 px-5">
                    <h2 class="text-3xl mb-4">
                        Acessar Conta
                    </h2>
                    <p class="mb-4">
                        Não possui uma conta? Crie uma conta
                        <!--a href="COLOCAR LINK PARA SIGN UP" class="font-semibold text-blue-800 underline">
                            AQUI.
                        </a-->
                        <RouterLink to="/signUp"  class="font-semibold text-blue-800 underline"> AQUI</RouterLink>
                    </p>
                    <form>
                        <div class="mt-5">
                            <input type="text" placeholder="E-mail" class="border border-gray-400 py-1 px-2 w-full">
                        </div>
                        <div class="mt-5 relative flex items-center">
                            <input v-model="senha" :type="mostrarSenha ? 'text' : 'password'" placeholder="Senha" class="border border-gray-400 py-1 px-2 w-full pr-10">
                            <button @click="mostrarSenha = !mostrarSenha; $event.preventDefault()" class="absolute right-0 px-1 h-6 rounded-l-lg rounded-r-lg" :class="{ 'bg-blue-600 text-white': mostrarSenha, 'bg-blue-800 text-white': !mostrarSenha }" style="font-size: 0.75rem; margin-right: 5px;">
                                {{ mostrarSenha ? 'Ocultar' : 'Mostrar' }}
                            </button>
                        </div>
                        <div class="mt-5">
                            <button class="w-full bg-blue-800 py-3 text-center text-white rounded-md">
                                Acessar Conta
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'LoginPage',
    data() {
        return {
            senha: '',
            mostrarSenha: false
        };
    }
};
</script>

<style lang="css" scoped>
</style>