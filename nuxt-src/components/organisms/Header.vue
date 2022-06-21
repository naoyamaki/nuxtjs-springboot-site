<template>
  <header class="pure-menu pure-menu-horizontal">
    <NuxtLink to="/" class="pure-menu-heading logo">
      <img src="~assets/img/logo.webp" alt="ロゴ画像">レビュー倉庫
    </NuxtLink>
    <ul class="pure-menu-list">
      <li class="pure-menu-item">
        <NuxtLink  to="/" class="pure-menu-link">詳細検索
        </NuxtLink>
      </li>
      <li class="pure-menu-item">
        <NuxtLink  to="/mypage/" class="pure-menu-link">マイページ
        </NuxtLink>
      </li>
      <li class="pure-menu-item">
        <NuxtLink  to="/" class="pure-menu-link">ログアウト
        </NuxtLink>
      </li>
    </ul>
  </header>
</template>

<style scoped lang="scss">
header {
  a.logo {
    font-size: 24px;
    vertical-align: middle;
    img {
      height: 36px;
      vertical-align: middle;
    }
  }
  ul.pure-menu-list {
  position: absolute;
  left: 50%;
  transform: translate(-50%, 0%);
  }
}
</style>