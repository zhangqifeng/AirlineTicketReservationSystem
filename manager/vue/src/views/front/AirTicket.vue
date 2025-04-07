<template>
  <div class="main-content">
    <div style="width: 70%;margin:30px auto">
      <div style="margin :20px 0">
        <el-input placeholder="请输入航班名称" style="width: 200px" v-model="name"></el-input>
        <el-input placeholder="请输入出发机场" style="width: 200px;margin-left: 5px" v-model="startAirport"></el-input>
        <el-input placeholder="请输入到达机场" style="width: 200px;margin-left: 5px" v-model="endAirport"></el-input>
        <el-button type="info" plain style="margin-left: 10px" @click="load()">查询</el-button>
        <el-button type="warning" plain style="margin-left: 10px" @click="reset">重置</el-button>
      </div>
      <div style="display: flex; background-color: #dbe3e2; margin-bottom: 20px">
        <div style="width: 200px; text-align: center; line-height: 40px">航班名称</div>
        <div style="width: 130px; text-align: center; line-height: 40px">起始机场</div>
        <div style="width: 130px; text-align: center; line-height: 40px">到达机场</div>
        <div style="width: 120px; text-align: center; line-height: 40px">航班时长</div>
        <div style="width: 120px; text-align: center; line-height: 40px">航班价格</div>
        <div style="width: 100px; text-align: center; line-height: 40px">剩余票数</div>
        <div style="flex: 1px; text-align: center; line-height: 40px">操作</div>
      </div>
      <div style="display:flex; margin-bottom: 20px" v-for="item in airticketData">
        <div style="width: 200px; align-items: center;display: flex">
          <img :src="item.img" alt="" style="width: 40px;height: 40px">
          <div style="margin-left: 10px">
            <div>{{ item.left }}</div>
            <div style="font-size: 13px;color: #666666">{{ item.right }}</div>
          </div>
        </div>
        <div style="width: 130px; text-align: center">
          <div style="font-size: 22px">{{item.startTime}}</div>
          <div style="font-size: 13px;color: #666666">{{item.startAirport}}</div>
        </div>
        <div style="width: 130px; text-align: center">
          <div style="font-size: 22px">{{item.endTime}}</div>
          <div style="font-size: 13px;color: #666666">{{item.endAirport}}</div>
        </div>
        <div style="width: 120px; text-align: center;line-height: 40px">{{item.time}}</div>
        <div style="width: 120px; text-align: center;line-height: 40px;font-size: 22px;color: red">￥{{item.price}}</div>
        <div style="width: 100px; text-align: center;line-height: 40px">{{item.num}}</div>
        <div style="flex: 1px; text-align: center; line-height: 40px">购买</div>
      </div>
    </div>
  </div>

</template>

<script>

export default {

  data() {
    return {
      name: null,
      startAirport: null,
      endAirport: null,
      airticketData: []

    }
  },
  mounted() {
    this.load()
  },
  // methods：本页面所有的点击事件或者其他函数定义区
  methods: {
    load() {
      this.$request.get('airticket/selectAll', {
        params:{
          name: this.name,
          startAirport: this.startAirport,
          endAirport: this.endAirport
        }

      }).then(res => {
        if (res.code === '200') {
          this.airticketData = res.data
        } else {
          this.$message.error(res.msg)
        }


      })

    },
    reset() {
      this.name = null
      this.startAirport = null
      this.endAirport = null
      this.load()
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
</style>