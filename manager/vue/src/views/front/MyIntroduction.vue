<template>
  <div>
  <div class="main-content">
    <div style="width: 90%; margin: 20px auto">
      <div class="operation">
        <el-button type="primary" plain @click="handleAdd">发布素材</el-button>
      </div>
    </div>

    <div class="table">
      <el-table :data="tableData" stripe @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center"></el-table-column>
        <el-table-column prop="id" label="序号" width="80" align="center" sortable></el-table-column>
        <el-table-column prop="name" label="名称" show-overflow-tooltip></el-table-column>
        <el-table-column prop="img" label="图片" show-overflow-tooltip></el-table-column>
        <el-table-column prop="content" label="内容" show-overflow-tooltip></el-table-column>
        <el-table-column prop="collect" label="收藏数"></el-table-column>
        <el-table-column prop="views" label="浏览量"></el-table-column>
        <el-table-column prop="time" label="发布时间"></el-table-column>
        <el-table-column  label="操作" width="180" align="center">
          <template v-slot="scope">
            <el-button plain type="primary" @click="handleEdit(scope.row)" size="mini">编辑</el-button>
            <el-button plain type="danger" size="mini" @click=del(scope.row.id)>删除</el-button>
          </template>
        </el-table-column>
      </el-table>

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
  <el-dialog title="信息" :visible.sync="fromVisible" width="40%" :close-on-click-modal="false" destroy-on-close>
    <el-form label-width="100px" style="padding-right: 50px" :model="form">
      <el-form-item label="攻略主图">
        <el-upload
            class="avatar-uploader"
            :action="$baseUrl + '/files/upload'"
            :headers="{ token: user.token }"
            list-type="picture"
            :on-success="handleImgSuccess">
          <el-button type="primary">上传攻略主图</el-button>
        </el-upload>
      </el-form-item>
      <el-form-item label="攻略标题" prop="name">
        <el-input v-model="form.name" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="攻略详情" prop="content">
       <div id="editor"></div>
      </el-form-item>
    </el-form>

    <div slot="footer" class="dialog-footer">
      <el-button @click="fromVisible = false">取 消</el-button>
      <el-button type="primary" @click="save">确 定</el-button>
    </div>
  </el-dialog>
  </div>
</template>
<script>
import E from 'wangeditor';
import { Transition } from 'vue'



export default {
  name: 'Home',
  computed: {
    form() {
      return form
    }
  },
  data() {
    return {
      tableData: [],
      pageNum: 1,
      pageSize: 10,
      total: 0,
      fromVisible: false,
      form: {},
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),
      editor: null,
    }
  },
  mounted() {
    this.load(1)
  },
  methods: {
    load(pageNum){
      if(pageNum)this.pageNum = pageNum
      this.$request.get('/introduction/selectpage',{
        params: {
          pageNum: this.pageNum,
          pageSizes: this.pageSize,
          userId: this.user.id,
        }
      }).then(res => {
        this.tableData = res.data?.list
        this.total = res.data?.total
          }
      )
    },
    initWangEditor(content) {
      this.$nextTick(() => {
        this.editor = new E('#editor')
        this.editor.config.placeholder = '请输入内容'
        this.editor.config.uploadFileName = 'file'
        this.editor.config.uploadImgServer = 'http://localhost:9090/files/wang/upload'
        this.editor.create()
        setTimeout(() => {
          this.editor.txt.html(content)
        })
      })
    },
    save() {   // 保存按钮触发的逻辑  它会触发新增或者更新
      this.$refs.formRef.validate((valid) => {
        if (valid) {
          this.$request({
            url: this.form.id ? '/introduction/update' : '/introduction/add',
            method: this.form.id ? 'PUT' : 'POST',
            data: this.form
          }).then(res => {
            if (res.code === '200') {  // 表示成功保存
              this.$message.success('保存成功')
              // this.load(1)
              this.fromVisible = false
            } else {
              this.$message.error(res.msg)  // 弹出错误的信息
            }
          })
        }
      })
    },
    handleAdd(){
      this.form = {}
      this.initWangEditor('')
      this.fromVisible = true
    },
    handleImgSuccess(res){
      this.form.img = res.data
    }
  },
  created() {
    this.$request.get('/notice/selectAll').then(res => {
      this.notices = res.data || []
    })
  }
}
</script>
