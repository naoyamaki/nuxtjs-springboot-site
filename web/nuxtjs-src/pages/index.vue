<template>
  <v-row justify="center" align="center">
    <v-col cols="12" sm="8" md="6">
    <p>結果：{{ result }}</p>
      <v-text-field
        label="PATH"
        v-model="path"
      ></v-text-field>
      <v-text-field
        label="No."
        v-model="num"
      ></v-text-field>
      <v-btn
        color="primary"
        rounded
        v-on:click="click()"
      >検索</v-btn>
    </v-col>
  </v-row>
</template>

<script>
  export default {
    data() {
      return {
        result: 0,
        num: null,
        path: null
      }
    },
    methods: {
      click() {
        this.result = this.$axios.$get("http://localhost/api/"+this.path+"/")
          .then( response => {
            console.log('response data', response)
          })
          .catch( error => {
            console.log("response error", error)
          })
      }
    }
  }
</script>
