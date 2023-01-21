$(function(){
	/* 주소 합치기 */
	$("#memberUpdateForm").submit(function(){
		var address = "(" + $("#zipNo").val() + ")";
		var roadAddrPart1 = $("#roadAddrPart1").val();
		var roadAddrPart2 = $("#roadAddrPart2").val();
		var addrDetail = $("#addrDetail").val();
		alert(address)
		alert(roadAddrPart1)
		alert(roadAddrPart2)
		alert(addrDetail)
		address += roadAddrPart1;
		address += roadAddrPart2;
		if(addrDetail != null && addrDetail != ''){
			address += ' ' + addrDetail;
		}
		$("#address").val(address);
		alert(address)
	})
});

function goPopup(){
	var pop = window.open("/jusoPopup","pop", "width=570,height=420,scrollbars=yes,resizable=yes");	
}
function jusoCallBack(zipNo, roadAddrPart1, roadAddrPart2, addrDetail) {
	$("#zipNo").val(zipNo);
	$("#roadAddrPart1").val(roadAddrPart1);
	$("#roadAddrPart2").val(roadAddrPart2);
	$("#addrDetail").val(addrDetail);
}