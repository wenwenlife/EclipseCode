var studentArr = ["李银生","刘志阳","李文文","李岗生","刘勇","井贝贝","李若旭","刘海龙"];

/*随机点名*/
var name1;
function randomMake(){        
		var i = Math.floor(Math.random() * studentArr.length); 
		document.getElementById('h11').innerHTML = studentArr[i]; 
		name1=studentArr[i]
}//random   

var mark=true;
var out1; 
var j=1;
var random =function(){
		var btn1 = document.getElementById("btn1");
		if(mark===true){
			out1 =setInterval(randomMake, 50);
			btn1.innerHTML="停止";
			mark=false;
		}else{
			document.getElementById('h31').innerHTML +="第"+j+"次被点到的是"+name1+"<br>" ;
			j+=1;
			clearInterval(out1);
			btn1.innerHTML="随机点名";
			mark=true;
		}
  } 


/*顺序点名*/
var out2;
var i=0;
var marks=true;
var name2;
var btn2 = document.getElementById("btn2");
var orders =function(){
		if(marks===true){
			out2 =setInterval(orderName, 1000);
			btn2.innerHTML="停止";
			marks=false;
		}else{
			clearInterval(out2);
			btn2.innerHTML="顺序点名";
			marks=true;
		}
}

var orderName =function(){
	if(i<studentArr.length){
		document.getElementById('h12').innerHTML =studentArr[i];
		name2=studentArr[i];
		document.getElementById('h32').innerHTML +=name2+"已点"+"<br>";
		i+=1;
	}else{
		document.getElementById('h12').innerHTML = "点名结束";
		clearInterval(out2);
		btn2.innerHTML="重新开始顺序点名";
		i=0;
		mark=true;
	}
	console.log(i);
}