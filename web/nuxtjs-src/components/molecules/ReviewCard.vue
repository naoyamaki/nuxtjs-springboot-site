<template>
  <a href="/#">
    <article>
      <p>{{ review.title }}</p>
      <p>{{ review.body }}</p>
    </article>
  </a>
</template>

<script>
export default {
  props: {
   review: {
     type: Object,
     required: true,
   },
 },
}
</script>

<style lang="scss" scoped>
a {
  article {
    margin: 16px;
    padding: 16px;
    background-color: #e0e0e0;
    border-radius: 8px;
  }
}
</style>