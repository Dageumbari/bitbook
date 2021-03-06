var isRecaptchachecked = false;

function recaptchaCallback() {
    isRecaptchachecked = true;
}

function doLogin() {

    var loginFailCount = $("#loginFailCount").val();
    this.loginFailCount = loginFailCount;
    
    if (!isRecaptchachecked && loginFailCount > 3) {
    
        alert('자동 로그인 방지!');
        $("#recaptcha").focus();
        
        return false;
        
    } else{
    
    	doVaildRecaptcha();
    }
}

function doVaildRecaptcha() {

	var that = this;
	
	if ( that.loginFailCount > 3) {
		var formData = $("#login").serialize(); // 해당 데이터의 값을 직렬화
	    
	    $.ajax({
	        type : 'POST',
	        contentType : "application/x-www-form-urlencoded",
	        url : '/valid-recaptcha',
	        data : formData,
	        dataType : 'text',
	        cache : false,
	        success : function(data) {
	            if (data == 'success') {
	                $('#login').submit();

	            } else {
	                alert('관리자에게 문의해주세요.');
	            }
	        },
	        error : function(xhr, status, error) {
	            console.log(error);
	        }
	    });
    } else{
    	
    	$('#login').submit(); 
    	
    }
}