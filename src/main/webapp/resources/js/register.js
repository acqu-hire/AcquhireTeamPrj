/* 회원가입 유효성 검사 */

$(function() {
	$("#register").submit(function() {
		/* 이름 유효성 검사 */
		if(!$("input[name='name']").val()) {
			alert("이름을 입력하세요.");
			$("input[name='name']").focus();
			return false;
		}
		var regexp_name = /^[가-힣]{2,14}$/;
		var name_check = $("input[name='name']").val();
		
		if (!regexp_name.test(name_check)) {
			alert("이름은 공백을 제외한 한글 2~14자만 입력할 수 있습니다.")
			$("input[name='name']").focus();
			return false;
		}
		/* ID 유효성 검사 */
		if(!$("input[name='id']").val()){
			alert("아이디를 입력하세요.");
			$("input[name='id']").focus();
			return false;
		}
		
		var regexp_id = /^[a-zA-Z0-9]{3,20}$/;
		var id_check = $("input[name='i']").val();
		
		if(!regexp_id.test(id_check)) {
			alert("아이디는 공백을 제외한 영문이나 숫자의 형태의 3~20자리만 입력할 수 있습니다.")
			$("input[name='id']").focus();
			return false;
		}
		/* 중복체크 확인 */
		if($("#idCheck").val() != 1) {
			alert("아이디 중복체크를 해주세요.");
			$("input[name='id']").focus();
			return false;
		}
		/* 비밀번호 유효성 검사 */
		if (!$("input[name='password']").val()) {
			alert("비밀번호를 입력하세요.");
			$("input[name='password']").focus();
			return false;
		}
		var regexp_password = /^[A-Za-z0-9]{8,16}$/;
		var password_check = $("input[name='password']").val();
		if (!regexp_password.test(password_check)) {
			alert("비밀번호는 공백을 제외한 영문이나 숫자 형태의 8~16자리만 입력할 수 있습니다.");
			$("input[name='password']").focus();
			return false;
		}
		/* 비밀번호 일치 검사 */
		if($("input[name='password']").val() != $("input[name='pwdConfirm']").val()) {
			alert("비밀번호가 일치하지 않습니다.");
			$("input[name='pwdConfirm']").focus();
			return false;
		}
		
		/* 성별 유효성 검사 */
		if($(":radio[name='gender']:checked").length < 1) {
			alert("성별을 선택해주세요.");
			return false;
		}

		/* 주소 유효성검사 */
		if(!$("#zipNo").val()) {
			alert("주소를 입력해주세요.");
			return false;
		}
		
		/* 휴대폰 번호 유효성 검사 */
		if(!$("input[name='phone_number']").val()) {
			alert("휴대폰 번호를 입력하세요.");
			$("input[name='phone_number']").focus();
			return false;
		}
		var regexp_phoneNum = /^[0-9]{10,11}$/;
		var phoneNum_check = $("input[name='phone_number']").val();
		
		if(!regexp_phoneNum.test(phoneNum_check)) {
			alert("연락처는 공백과 \'-\'을 제외한 숫자 10~11자리만 입력할 수 있습니다.");
			$("input[name='phone_number']").focus();
			return false;
		}
		/* 이메일 유효성 검사 */
		if(!$("input[name='email']").val()){
			alert("이메일을 입력하세요.");
			$("input[name='email']").focus();
			return false;
		}
		var regexp_email = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		var email_check = $("input[name='email']").val();
		
		if(!regexp_email.test(email_check)) {
			alert("이메일을 형식에 맞게 작성하세요.")
			$("input[name='email']").focus();
			return false;
		}
		/* 주소 합치기 */
		var address = $("#zipNo").val();
		var roadAddrPart1 = $("#roadAddrPart1").val();
		var roadAddrPart2 = $("#roadAddrPart2").val();
		var addrDetail = $("#addrDetail").val();
		address += ' ' + roadAddrPart1;
		address += roadAddrPart2;
		if(addrDetail != null && addrDetail != ''){
			address += ' ' + addrDetail;
		}
		$("#address").val(address);

		var name = $("input[name='name']").val()
		alert(name+'님 회원가입을 축하합니다.');
	});
});

/* 회원가입 폼 취소버튼 이벤트 */
function resetCheck() {
	if(confirm("회원가입을 취소하시겠습니까?")){
		location.href="/"
	}
}

/* 아이디 중복체크 */
$(function(){
	$("#dbIdCheck").on("click",function() {
		var id = $("#id").val();
		if (id.search(/\s/) != -1) {	// 정규표현식과 주어진 스트링간에 첫번째로 매치되는 것의 인덱스를 반환한다. 찾지 못하면 -1 를 반환한다.) // \s 공백 정규식
			alert("아이디에는 공백이 들어갈 수 없습니다.");
		} else {
			if (id.trim().length != 0) {
				$.ajax({
					url : './idCheck',
					type : 'post',
					data : {id : id},
					dataType : 'json',
					success : function(result) {
						console.log("아이디 값 - " + result);
						if ($.trim(result) == 1) {
							alert("이미 등록된 아이디 입니다.");
							$("#id").focus();
						} else {
							alert("등록할 수 있는 아이디입니다.");
							$("#idCheck").val("1");
							$("#password").focus();
						}
					}
				});
			} else {
				alert("아이디를 입력해주세요.");
			}
		}
	});
})

function goPopup(){
	var pop = window.open("/jusoPopup","pop", "width=570,height=420,scrollbars=yes,resizable=yes");	
}
function jusoCallBack(zipNo, roadAddrPart1, roadAddrPart2, addrDetail) {
	$("#zipNo").val(zipNo);
	$("#roadAddrPart1").val(roadAddrPart1);
	$("#roadAddrPart2").val(roadAddrPart2);
	$("#addrDetail").val(addrDetail);
}
