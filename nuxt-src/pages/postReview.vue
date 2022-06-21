<template>
  <main>
    <p>投稿ページ</p>
    <form action="" method="post">
      <input
        type="text"
        id="title"
        name="title"
        required
        minlength="1" maxlength="256">
      <input
        type="text"
        id="contents"
        name="contents"
        required
        minlength="1" maxlength="1024">

      <div>ここに画像をドロップしてください</div>
    </form>
  </main>
</template>
