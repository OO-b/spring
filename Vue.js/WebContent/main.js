 new Vue ({
    
    el : '#app',
    data : {
      count:0
    },
    methods: {
        increment:function() {
            this.count += 1
        }
    }
    
    /*
    methods:{
        handleClick:function(event){
            alert(event.target)
        },
        myMethod:function() {
            //처리
        }
    },
    created:function() {
        console.log('created')
    }
    */
})
