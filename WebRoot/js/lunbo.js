// JavaScript Document



var NowFrame=1;
var MaxFrame=5;

function show(dl){
	if(Number(dl)){
		//clearTimeout(Timer);
		NowFrame=dl;
		}
		for(var i=1;i<(MaxFrame);i++){
		if(i==NowFrame){
			document.getElementById("lunbo").src="images01/bar0"+i+".jpg"; 
			document.getElementById("infon"+i).className="infon";  
         }
		 else{
		
		 }
	}
	if(NowFrame == MaxFrame){ 
		NowFrame = 1;
		}
	else{
		NowFrame++;
		}
	}

var Timer=setInterval("show()",4000);
window.onload=show;