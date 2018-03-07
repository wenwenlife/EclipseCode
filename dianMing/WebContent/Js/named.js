
var studentArr = ["李银生","柳志阳","李文文","李岗生","刘勇","井贝贝","李若旭","刘海龙"];

/*随机点名*/
function randomMake(){        
		var i = Math.floor(Math.random() * studentArr.length); 
		document.getElementById('uname').innerHTML = "<font size='7' color='blue' face='黑体'>"+studentArr[i]+"</font>";         
}//random   
 
var random =function(){
		var out;          
/*		window.onload=function (){   */          
		var btn = document.getElementById("btn");
		var mark=true;
		btn.onclick=function(){
			if(mark===true){
				out =setInterval(randomMake, 50);
				btn.value='停止';
				mark=false;
			}else{
				clearInterval(out);
				btn.value='随机点名';
				mark=true;
			}
		};//onclick
	/*		}//onload
		  */
  } 


/*顺序点名*/
var out;
var i=0;
var mark=true;
var btn2 = document.getElementById("btn2");
var order =function(){
	btn2.onclick=function(){
		if(mark===true){
			out =setInterval(orderName, 1000);
			btn2.value='停止';
			mark=false;
		}else{
			clearInterval(out);
			btn2.value='顺序点名';
			mark=true;
		}
	};
}

var orderName =function(){
	if(i<studentArr.length){
		document.getElementById('uname').innerHTML = "<font size='7' color='blue' face='黑体'>"+studentArr[i]+"</font>";
		i+=1;
	}else{
		clearInterval(out);
		document.getElementById('uname').innerHTML = "<font size='7' color='blue' face='黑体'>"+"点名结束"+"</font>";
		btn2.value='重新开始顺序点名';
		i=0;
		mark=true;
	}
	console.log(i);
}