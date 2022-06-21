<template>
  <main>
      <label for="email">メールアドレス</label>
      <input
        id="email"
        autocomplete="off"
        type="text"
        v-model="email"
      >
      <label for="password">パスワード</label>
      <input
        id="password"
        autocomplete="off"
        type="password"
        v-model="password"
      >
      <button type="submit" class="pure-button pure-button-primary">ログイン</button>
  </main>
</template>

<script>
export default {
  data() {
    return {
      email: '',
      password: '',
    }
  },
  methods: {
    execLogin: function () {
      // do request
      console.log("TODO dev");
    }
  }
}
</script>