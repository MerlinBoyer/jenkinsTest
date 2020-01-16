
var button = document.querySelector('#formButton');
var form = document.getElementById('registerSubmit');
function loadDoc() {
		  var data =  $("#registerSubmit").serialize();
		  console.log(data);
		  var xhttp = new XMLHttpRequest();
		  
		  button.disabled = true;
		  var text = button.textContent;
		  button.textContent = '...Chargement';
		  
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		     document.getElementById("demo").innerHTML = this.responseText;
		     d = new Date();
		 	 document.getElementById("mytext").innerText += d.toString();
		 	 button.disabled = false;
		 	 button.textContent = text;
		    }
		  };
		  
		  xhttp.open("POST", form.getAttribute('action'), true);
		  xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		  xhttp.send(data);
		}