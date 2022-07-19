import { defineNuxtConfig } from 'nuxt'

// https://v3.nuxtjs.org/api/configuration/nuxt.config
export default defineNuxtConfig({
  app: {
    head: {
      title: 'sample',
      meta: [
        { name: 'viewport', content: 'width=device-width, initial-scale=1' }
      ],
      link: [
        { rel: 'stylesheet', href: 'https://unpkg.com/purecss@2.1.0/build/pure-min.css' },
        { rel: 'icon', type: 'image/x-icon', href: '/static/favicon.ico' },
      ]
    }
  }
})
