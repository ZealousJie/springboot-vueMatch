<template>
      <div style="width: 100%;height: 100vh;background-color: darkslateblue; overflow: hidden">
        <div style="width: 400px; margin: 100px auto">
          <div style="font-size: 30px; text-align: center; padding: 30px 0; color: #333">欢迎注册</div>
          <el-form ref="form" :model="form" size="normal" :rules="rules">
            <el-form-item prop="account">
              <el-input prefix-icon="user" v-model="form.account" placeholder="请输入账号"></el-input>

            </el-form-item>
            <el-form-item prop="password">
              <el-input prefix-icon="Lock" v-model="form.password" show-password placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item prop="confirm">
              <el-input prefix-icon="Lock" v-model="form.confirm" show-password placeholder="确认密码"></el-input>
            </el-form-item>
            <el-form-item prop="identityNum">
              <el-input prefix-icon="Lock" v-model="form.identityNum" show-password placeholder="身份证号"></el-input>
            </el-form-item>
            <el-form-item prop="realName">
              <el-input prefix-icon="user" v-model="form.realName"  placeholder="真实姓名"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button style="width: 100%" type="primary" @click="register">注册</el-button>
            </el-form-item>
          </el-form>
        </div>
      </div>


</template>

<script>
import request from "../utils/request";
// import ValidCode from "@/components/ValidCode";
// import {activeRouter} from "@/utils/permission";

export default {
  name: "Register",
  components:{
  },
  data() {
    return {
      form: {},
      rules: {
        account: [
          {required: true, message: '请输入账号', trigger: 'blur'},
          {min:1, max: 10, message: '账号长度在10以内', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min:1, max: 32, message: '密码长度在32以内', trigger: 'blur'}
        ],
        confirm: [
          {required: true, message: '请输入确认密码', trigger: 'blur'},
        ],
        identityNum: [
          {required: true, message: '请输入身份证号', trigger: 'blur'},
          {min:1, max: 18, message: '身份证号长度必须为18', trigger: 'blur'}
        ],
        realName: [
          {required: true, message: '请输入真实姓名', trigger: 'blur'},
        ],
      },
    }
  },
  methods: {
    register(){
      if (this.form.password !== this.form.confirm) {
        this.$message({
          type: "error",
          message: '2次密码输入不一致！'
        })
        return
      }
      this.$refs['form'].validate((valid) => {
        if (valid){
          request.post("/user/register",this.form).then(res =>{
            console.log(res)
            if (res.code === '0'){
              //element ui 提供的提示框 别忘了这个美元符合
              this.$message({
                type: "success",
                message: "注册成功"
              })
              this.$router.push("/login") //页面跳转到 / 即主页
            }
            else {
              this.$message({
                type: "error",
                message: res.msg
              })
            }
          })
        }
      })

    }
  }
}
</script>

