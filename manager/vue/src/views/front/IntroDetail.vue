<template xmlns:display="http://www.w3.org/1999/xhtml">
  <div class="main-content">
    <div style="width: 90%; margin: 20px auto">
      <div style="front-size: 18px; font-weight: bold; color:#333333">{{introductionData.name}}}</div>
        <div style="margin-top: 20px; display: flex; color:#666666; align-items: center;">
          <div style="margin-right: 30px">作者：{{introductionData.userName}}</div>
          <div><i class="el-icon-view"></i>{{introductionData.view}}</div>
          <div style="margin: 0 30px"><i class="el-icon-star-off"></i> {{introductionData.collect}}</div>
          <div><i class="el-icon-chat-line-square"></i>{{introductionData.comment}}</div>
      <div style="margin-left: 30px"><el-button size="mini" type="primary">收藏</el-button></div>
        </div>
      <div style="margin-top: 30px" v-html = introductionData.content class="w-e-text-container"></div>
      </div>
  </div>
</template>

<script>
import E from 'wangeditor'

export default {

  data() {
    return {

      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),
      introductionId: this.$route.query.id,
      introductionData:{}
    }
  },
  mounted() {
    this.loadIntroduction()

  },
  // methods：本页面所有的点击事件或者其他函数定义区
  methods: {
    loadIntroduction(){
        this.request('/introduction/selectById/' + this.introductionId).then(res => {
          if (res.code === '200'){
            this.introductionData = res.data
            this.addViews()
          } else {
            this.$message.error(res.msg)
          }
        })
    },
    addViews(){
      this.introductionData.views = this.introductionData.views + 1
      this.request.put('/introduction/update', this.introductionData).then(res => {
        if(res.code !== '200'){
          this.$message.error(res.msg)
        }
      })
    },
    collect(){
      let data = {
        introductionId: this.introductionId,
        userId: this.user.id
      }
      this.$request.post('/collect/add',data).then(res => {
        if(res.code ===200) {
          this.$message.success('收藏成功')
        } else {
          this.$message.error(res.msg)
        }
      })
    }
  }
}
</script>
<style>
.overflowShow {
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
p,ol{
  color: #666666;
}
</style>