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
      .get("http://localhost:8080/api/review/")
        .then((res) => {
          console.log(res);
          this.reviews = res.data.reviews;
        })
        .catch((err) => {
          console.log(err);
        });
  },
}
</script>
