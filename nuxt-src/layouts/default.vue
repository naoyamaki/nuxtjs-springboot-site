<template>
<div>
  <organisms-header />
  <Nuxt />
  <organisms-footer />
</div>
</template>

<script>
import Footer from '~/components/organisms/Footer'
import Header from '~/components/organisms/Header'

export default {
  components: {
    Footer,
    Header
  }
}
</script>
