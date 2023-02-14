
var editorConfig = {
    filebrowserUploadUrl: "/file/fileUpload",//이미지 업로드
    height: "400",
};
CKEDITOR.on('dialogDefinition', function (ev) {
    var dialogName = ev.data.name;
    var dialogDefinition = ev.data.definition;
    var dialog = ev.data.definition.dialog;
    if (dialogName == 'image') {
        dialog.on('show', function (obj) {
            this.selectPage('Upload'); //업로드텝으로 시작
        });
    }
    switch (dialogName) {
        case 'image':
            dialogDefinition.removeContents('Link');
            dialogDefinition.removeContents('advanced');
            var infoTab = dialogDefinition.getContents('info');
            infoTab.remove('txtAlt'); // 대체 문자열
            infoTab.remove('txtBorder'); // 테두리 
            infoTab.remove('txtHSpace'); // 세로여백 
            infoTab.remove('txtVSpace'); // 가로여백 
            infoTab.remove('ratioLock'); // 비율유지 
            infoTab.remove('browse'); //원래 크기로 	         

    }
});
window.onload = function () {
    ck = CKEDITOR.replace("contents", editorConfig);
};
