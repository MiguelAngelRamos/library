//* vamos a implemetar Jquery

$(document).ready(function() {
	
  $("#form-login").submit(function(event) {
    event.preventDefault();
    authUser();
  });
  
  $("#form-register").submit(function(event) {
    event.preventDefault();
    registerUser()
  });
  
});

//* la funcion Auth() 
function authUser() {

  let userName = $("#user").val();
  let passWord = $("#password").val();

  $.ajax({
    type: "POST",
    dataType: "html",
    url: "./ServletAuth",
    data: $.param({
      username: userName,
      password: passWord
    }),
    success: function(result) {
      let parsedResult = JSON.parse(result);
      console.log(parsedResult)
      //* retornar un false
      if(parsedResult != false) {
        let username = parsedResult['username'];
        document.location.href = "home.jsp?username="+username;
      }
    }
  });
  
}

function registerUser() {
	
  let userName = $("#user").val();
  let passWord = $("#password").val();
  
    $.ajax({
    type: "POST",
    dataType: "html",
    url: "./ServletRegister",
    data: $.param({
      username: userName,
      password: passWord
    }),
    success: function(result) {
     window.location.href="index.jsp"
    }
  });
  
}
