<template>
    <div class="login-container">
        <div class="login-box">
            <!--头像盒子-->
            <div class="avatar-box">
                <img src="../assets/images/hualoon.jpg">
            </div>
            <!--表单 model 数据  rules 校验规则-->
            <el-form ref="loginFormRef" :model="formData" :rules="formDataRules" class="login-form">
                <!--用户名-->
                <el-form-item prop="userName">
                    <el-input v-model="formData.userName" prefix-icon="el-icon-user"></el-input>
                </el-form-item>
                <!--密码-->
                <el-form-item prop="passWord">
                    <el-input v-model="formData.passWord" prefix-icon="el-icon-goods" type="password"></el-input>
                </el-form-item>
                <!--按钮-->
                <el-form-item class="btns">
                    <el-button type="primary" @click="login">登录</el-button>
                    <el-button type="info" @click="resetForm">重置</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data(){
            return{
                formData:{
                    userName : '1111',
                    passWord : '1111'
                },
                formDataRules:{
                    userName: [
                        {required: true, message: '请输入用户名', trigger: 'blur'},
                        {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
                    ],
                    passWord: [
                        {required: true, message: '请输入密码', trigger: 'blur'},
                        {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
                    ]
                }
            }
        },
        methods:{
            resetForm (){
                this.$refs.loginFormRef.resetFields();
            },
            login (){
                this.$refs.loginFormRef.validate(async valid=>{
                    if (!valid) return;
                     const result = this.$http.post('api/login',this.formData)
                     console.log(result)

                    this.$router.push('index')
                    window.sessionStorage.setItem("token","31415926535")
                });

            }
        }

    }
</script>

<!--scoped代表样式只生效于当前组件-->
<style lang="less" scoped>
    .btns{
        display: flex;
        justify-content: space-between;
    }
    .login-form{
        position: absolute;
        bottom: 0;
        width: 100%;
        padding: 0 40px;
        box-sizing: border-box;
    }
    .login-container {
        background-color: #2b4b6b;
        height: 100%;
    }

    .login-box {
        width: 450px;
        height: 300px;
        background-color: #fff;
        border-radius: 3px;
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
    }

    .avatar-box {
        height: 130px;
        width: 130px;
        border: 1px solid #eeeeee;
        border-radius: 50%;
        padding: 10px;
        box-shadow: 0 0 10px #dddddd;
        position: absolute;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: #fff;


    }
    .avatar-box /deep/ img {
        width: 100%;
        height: 100%;
        border-radius: 50%;
        background-color: #eeeeee;
    }
</style>
