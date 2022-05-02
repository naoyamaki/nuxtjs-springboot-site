<template>
  <main>
    <template
      v-for="review in reviews"
    >
      <molecules-review-card
        :review="review"
        :key="review.id"
      />
    </template>
  </main>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      reviews: [],
    }
  },
  mounted: function () {
    axios
      .get("/api/review/")
        .then((res) => {
          this.reviews = res.data;
        })
        .catch((err) => {
          console.log(err);
        });
  },
}
</script>
