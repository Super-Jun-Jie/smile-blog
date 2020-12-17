<template>
  <div>
    <svg :width='width' :height='height' @mousemove='listener($event)'>
      <a @click="setKeyWord(tag.tagName)" v-for='(tag,index) in tags' :key="index">
        <text :x='tag.x' :y='tag.y' :font-size='20 * (600/(600-tag.z))' :fill-opacity='((400+tag.z)/600)'>{{tag.tagName}}</text>
      </a>
    </svg>
  </div>
</template>

<script>
export default {
  data(){
    return{
      width:300,
      height:300,
      tagsNum:20,
      RADIUS:200,
      speedX:Math.PI/360,
      speedY:Math.PI/360,
      tags: []
    }
  },
  computed:{
    CX(){
      return this.width/2;
    },
    CY(){
      return this.height/2;
    }
  },
  created(){//初始化标签位置
    this.getTagsList()
  },
  mounted(){//使球开始旋转
    setInterval(() => {
      this.rotateX(this.speedX);
      this.rotateY(this.speedY);
    }, 17)
  },
  methods: {


    setKeyWord(tagName){
      this.$emit('setKeyWord',tagName)
    },

    async getTagsList() {
      const {data: res} = await this.$http.get('getTagList')
      let tags=[];

      for (let i = 0; i < res.data.length; i++) {
        let tag = {};
        let k = -1 + (2 * (i + 1) - 1) / res.data.length;
        let a = Math.acos(k);
        let b = a * Math.sqrt(res.data.length * Math.PI)//计算标签相对于球心的角度
        tag.tagName = res.data[i];
        tag.x = this.CX +  this.RADIUS * Math.sin(a) * Math.cos(b);//根据标签角度求出标签的x,y,z坐标
        tag.y = this.CY +  this.RADIUS * Math.sin(a) * Math.sin(b);
        tag.z = this.RADIUS * Math.cos(a);
        tags.push(tag);
      }



      this.tags = tags

    },
    rotateX(angleX){
      var cos = Math.cos(angleX);
      var sin = Math.sin(angleX);
      for(let tag of this.tags){
        var y1 = (tag.y- this.CY) * cos - tag.z * sin  + this.CY;
        var z1 = tag.z * cos + (tag.y- this.CY) * sin;
        tag.y = y1;
        tag.z = z1;
      }
    },
    rotateY(angleY){
      var cos = Math.cos(angleY);
      var sin = Math.sin(angleY);
      for(let tag of this.tags){
        var x1 = (tag.x - this.CX) * cos - tag.z * sin + this.CX;
        var z1 = tag.z * cos + (tag.x-this.CX) * sin;
        tag.x = x1;
        tag.z = z1;
      }
    },
    listener(event){//响应鼠标移动
      var x = event.clientX - this.CX;
      var y = event.clientY - this.CY;
      this.speedX = x*0.0001>0 ? Math.min(this.RADIUS*0.00002, x*0.0001) : Math.max(-this.RADIUS*0.00002, x*0.0001);
      this.speedY = y*0.0001>0 ? Math.min(this.RADIUS*0.00002, y*0.0001) : Math.max(-this.RADIUS*0.00002, y*0.0001);
    }
  }
}
</script>

<style lang="less" scoped>

</style>
