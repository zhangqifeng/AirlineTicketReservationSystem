<template>
  <div class="main-content">
    <div style="width: 75%; margin: 20px auto">
      <div style="font-size: 18px; font-weight: bold; color: #333333">{{introductionData.name}}</div>
      <div style="margin-top: 20px; display: flex; color: #666666; align-items: center">
        <div style="margin-right: 30px">作者：{{introductionData.username}}</div>
        <div><i class="el-icon-view"></i>{{introductionData.views}}</div>
        <div><i class="el-icon-star-off"></i>{{introductionData.collect}}</div>
        <div><i class="el-icon-chat-line-square"></i>{{introductionData.comment}}</div>
        <div style="margin-right: 30px"><el-button size="mini" type="primary">收藏</el-button></div>
      </div>
    </div>

  </div>
</template>

<script>

export default {

  data() {
    return {
    }
  },
  mounted() {

  },
  // methods：本页面所有的点击事件或者其他函数定义区
  methods: {

  }
}
</script>
<style>
.overflowShow {
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>
