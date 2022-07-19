<template>
  <main>
    <p>toppu</p>
    <template 
      v-for="review in reviews"
      :key="review.id"
    >
      <molecules-review-card
        :review="review"
      />
    </template>
  </main>
</template>

<script>
export default {
  data() {
    return {
      reviews: [
        {id:1,title:"sample"},
        {id:2,title:"sa2mple"},
        {id:3,title:"samp3le"}
      ],
    }
  }
}
</script>
