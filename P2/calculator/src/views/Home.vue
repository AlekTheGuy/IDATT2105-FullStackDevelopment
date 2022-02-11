<template>
  <div class="home">
    <Calculator input="test2"/>
  </div>
</template>

<script>
import Calculator from "@/components/Calculator.vue";

export default {  components: {
    Calculator
  },
};
</script>

<style scoped>
.home {
  background-color: rgb(221, 221, 221);
  min-height: 100vh;
}
</style>