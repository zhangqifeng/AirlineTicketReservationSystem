<template>
  <div class="main-content">
    <div style="width: 70%; margin: 20px auto">
      <div class="search">
        我收藏的攻略（}{collectData.length}}）
      </div>
      <div style="margin-top: 30px">
        <el-row :gutter="20" v-for="item in collectData" style="margin-bottom: 20px">
          <el-col :span="7">
            <img :src="item.img" alt="" stye="width: 100%;height: 200px; border-radius: 10px; cursor: pointer" @click="$router.push('/front/introDetail?id=' + item.introductionId )">
          </el-col>
          <el-col :span="17">
            <div style="color:#333333;font-size:18px; line-height: 30px" class="overflowShow">{{item.introName}}</div>
            <div style="display: flex; align-items: center; line-height: 40px; height: 40px">
              <img :src="item.userAvatar" alt="" style="width: 30px; height: 30px; border-radius: 50%">
              <div style="margin-left: 10px; color: #333333">{{item.username}}</div>
            </div>
            <div style="margin-top: 10px; line-height: 30px; color: #666666" class="multi-overflowShow">{{item.description}}
            </div>
            <div style="height: 30px; line-height: 30px">
              <div><i class="el-icon-view"></i>{{item.view}}</div>
              <div style="margin: 0 30px"><i class="el-icon-star-off"></i> {{item.collect}}</div>
              <div><i class="el-icon-chat-line-square"></i>{{item.comment}}</div>
              <div style="margin-left: 30px; color:red" @click="del(item.id)"><i class="el-icon-delete"></i></div>
            </div>
          </el-col>
        </el-row>
      </div>
      <div class="pagination" style="margin-top: 20px">
        <el-pagination
            background
            @current-change="handleCurrentChange"
            :current-page="pageNum"
            :page-sizes="[5, 10, 20]"
            :page-size="pageSize"
            layout="total, prev, pager, next"
            :total="total">
        </el-pagination>
      </div>
    </div>
  </div>
</template>
<script>

export default {

  data() {
    return {
      pageNum: 1,
      pageSize: 5,
      total: 0,
      collectData:[],
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),


    }
  },
  mounted() {
    this.loadCollect(1)
  },
  methods: {
    loadCollect(pageNum){
      if(pageNum)this.pageNum = pageNum
      this.$request.get('/collect/selectpage',{
        params: {
          pageNum: this.pageNum,
          pageSizes: this.pageSize,
          userId: this.user.id,

        }
      }).then(res => {
            this.collectData = res.data?.list
            this.total = res.data?.total
          }
      )
    },
    reset() {
      this.name = null
      this.startAirport = null
      this.endAirport = null
      this.load()
    },
    handleCurrentChange(pageNum){
      this.pageNum = pageNum
      this.loadCollect(pageNum)
    },
    del(id) {   // 单个删除
      this.$confirm('您确定取消收藏吗？', '确认取消收藏 ', {type: "warning"}).then(response => {
        this.$request.delete('/collect/delete/' + id).then(res => {
          if (res.code === '200') {   // 表示操作成功
            this.$message.success('操作成功')
            this.loadCollect(1)
          } else {
            this.$message.error(res.msg)  // 弹出错误的信息
          }
        })
      }).catch(() => {
      })
    },
  }
}
</script>
<style>
.overflowShow{
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
.multi-overflowShow {
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 3;
}
</style>