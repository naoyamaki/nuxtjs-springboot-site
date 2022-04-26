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
import axios from 'axios';
export default {
  data() {
    return {
      email: '',
      password: '',
    }
  },
  methods: {
    test: function () {
      axios
        .post("/api/login/")
          .then((res) => {
            // do something
          })
          .catch((err) => {
            console.log(err);
          });
    },
  },
}
</script>