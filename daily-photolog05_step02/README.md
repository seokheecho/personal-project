# daily-photolog05_step02
 - daily-photolog05 포토로그(PhotoLog)
 - 포토로그 사진파일 저장
 (\org.eclipse.wst.server.core\tmp1\wtpwebapps\daily-photolog\files)
 - Controller
 (ServletContext, MultipartFile[], getRealPath("/files/" + newfilename))
 - form.js
 ($('#fileupload').fileupload(){...} 작성, '#add-btn'은 submit 활용) 
 
 
1) PhotoLogController
(파일명 DB 저장제외 - 다음 step에서 VO, DAO, Service_ServiceImpl 작성)

2) webapp/html/photolog
 - form.html - form.js 

**form.html 
script 태그 위치 주의!
- 참고 : HTML에서 script태그는 어디에 위치해야 할까?
(https://junhobaik.github.io/js-script-position/)

~~~html
<script src="../node_modules/jquery/dist/jquery.js"></script>
<script src="../node_modules/blueimp-file-upload/js/vendor/jquery.ui.widget.js"></script>
<script src="../node_modules/blueimp-load-image/js/load-image.all.min.js"></script>
<script src="../node_modules/blueimp-canvas-to-blob/js/canvas-to-blob.js"></script>
<script src="../node_modules/bootstrap/dist/js/bootstrap.js"></script>
<script src="../node_modules/blueimp-file-upload/js/jquery.iframe-transport.js"></script>
<script src="../node_modules/blueimp-file-upload/js/jquery.fileupload.js"></script>
<script src="../node_modules/blueimp-file-upload/js/jquery.fileupload-process.js"></script> 
<script src="../node_modules/blueimp-file-upload/js/jquery.fileupload-image.js"></script>  


<script src="../js/jquery.bit.js"></script>
<script src="../js/common2.js"></script>
<script src="form.js"></script>


<script src="../node_modules/handlebars/dist/handlebars.min.js"></script>
<script src="../node_modules/jquery/dist/jquery.min.js"></script>
<script src="../node_modules/popper.js/dist/umd/popper.min.js"></script>
<script src="../node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
~~~~