//加载事件
window.onload=function(){
//获取所有top下的div
	var head_divs=document.getElementById("top").getElementsByTagName("div");
//保存当前焦点出的索引
	var index=0;
//	设置定时器
	var timer=window.setInterval(autoChange,1000);
//	遍历元素
	for(var i=o;i<head_divs.length;i++){
//		添加鼠标滑过事件
		head_divs[i].onmouseover=function(){
			clearInterval(timer);
			if(i!=index){
				head_divs[index].style.backgroundColor='';
				head_divs[index].style.borderBottom='';
			}
//			获取所有ul
			var body_uls =document.getElementById("buttom").getElementsByTagName("ul");
//			遍历元素
			for(var i=0;i<body_uls.length;i++){
//				将所有元素设置为隐藏
				head_divs[i].className =head_divs[i].className.replace("first", "");
				body_uls[i].className =body_uls[i].className.replace("first", "");
//				将当前元素设置为显示
				if(head_divs[i]==this){
					this.className+="first";
					body_uls[i].className+="first";
				}
			}
		}
		
		//鼠标移出事件
		head_divs[i].onmouseout =function(){
//			启动定时器
			timer = setInterval(autoChange,1000);
		}
		
	}
	
/*	for(var i = 0; i < head_divs.length; i++) {
		index = i;
		head_divs[i].onmouseover = function() {
			clearInterval(timer);
            for(var i = 0; i < head_divs.length; i++) {
            	head_divs[i].className = "";
            }
            this.className = "first";
            var body_uls =document.getElementById("buttom").getElementsByTagName("ul");
            for(var j = 0; j < body_uls.length; j++) {
            	body_uls[j].className = "";
            }
            body_uls[index].className = "first";
        }     */   
	
//	定时器周期函数Tab栏自动切换
	function autoChange(){
//		自增索引
		++index;
//		当索引达到上限时，索引归0
		if(index==head_divs.length){
			index=0;
		}
//		当前的背景颜色和边框颜色
		for(var i=0;i<head_divs.length;i++){
			if(i==index){
				head_divs[i].style.backgroundColor='#fff';
				head_divs[i].style.borderBottom='1px solid #fff';
			}else{
				head_divs[i].style.backgroundColor='';
				head_divs[i].style.borderBottom='';
			}
		}
//		获取所有ul
		var body_uls =document.getElementById("buttom").getElementsByTagName("ul");
//		遍历元素
		for(var i=0;i<body_uls.length;i++){
//			将所有元素设置为隐藏
			body_uls[i].className =body_uls[i].className.replace("first", "");
			head_divs[i].className =head_divs[i].className.replace("first", "");
			
//			将当前元素设置为显示
			if(head_divs[i]==head_divs[index]){
				this.className+="first";
				body_uls[i].className+="first";
			}
			
		}
	}
}