<template>
  <v-app id="inspire">
    <v-card>
      <v-app-bar
        absolute
        color="white"
      >
        <v-btn :to="'/subs'" icon>
          <v-icon large>mdi-chevron-left</v-icon>
        </v-btn>

        <v-toolbar-title>적금/청약</v-toolbar-title>

        <v-spacer></v-spacer>
        
        <v-btn :to="'/main'" icon large>
          <v-icon>mdi-home-outline</v-icon>
        </v-btn>

        <v-app-bar-nav-icon large></v-app-bar-nav-icon>

      </v-app-bar>
      <div style="margin:30px; margin-top: 70px;">
        <v-card-title>김하나님은<br>작년 소득금액이 60,000,000원 입니다.</v-card-title>
      </div>
      <div style="margin: 50px; ">
        <b>청년희망 적금 가입이 완료되었어요!</b>
      </div>
      <div style="text-align: center; margin-bottom: 15px;">
        <p>{{acctNo}} / {{acctStatus}} / {{balance}} / {{custNo}} / {{openDate}}</p>
        <v-btn :to="'/done'" color="#178c72">
          <b style="color: white;">청년희망적금 내역보기</b>
        </v-btn>
      </div>
    </v-card>

    

    <v-main>
    </v-main>
  </v-app>
</template>

<script>
 import axios from 'axios'

  export default {
    name:"Result",
    data: () => ({
      acctNo: null,
      acctStatus: null,
      balance: null,
      custNo: null,
      openDate: null, 
    }),
    created() {
      var me = this
        axios.get("/accountopen/1").then(function (result){
          var data = result.data[0];
          me.acctNo = data.acctNo;
          me.acctStatus = data.accountStatus;
          me.balance = data.accountBalance;
          me.custNo = data.custNo;
          me.openDate = data.openDate;
        })
    }
  }
</script>