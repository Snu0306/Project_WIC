<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Product Detail</title>

<!-- Bootstrap cdn -->
<link rel="stylesheet" href="resource/style/productDetail.css" />
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
<link rel="stylesheet"
   href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />


<script
   src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<style>
.modal-header, h4, .close {
   background-color: #ddc5ee;
   color: white !important;
   text-align: center;
   font-size: 30px;
}

.modal-footer {
   background-color: #f9f9f9;
}
</style>
</head>

<body>
   <!-- Top -->
   <jsp:include page="/WEB-INF/views/common/Top.jsp"></jsp:include>


   <!-- 변수선언 -->
   <c:set var="product" value="${requestScope.product}"></c:set>
   <c:set var="price" value="${requestScope.price}"></c:set>
   <c:set var="fileList" value="${requestScope.fileList}"></c:set>
   <c:set var="member" value="${requestScope.member}"></c:set> <!-- 판매자의 정보  -->
   <c:set var="getLike" value="${requestScope.getLike}"></c:set>
   <c:set var="checkLike" value="${requestScope.checkLike}"></c:set>
   <c:set var="id" value="${sessionScope.id}"></c:set> <!-- 들어온 사람의 정보  -->

   <div class="mb-5"></div>
   <div class="container">
      <div class="row">
         <!-- Left -->
         <div class="col-md-6 mb-5 leftDiv">

            <!-- carousel slide -->
            <div id="imgCarousel" class="carousel slide" data-interval="false">

               <!-- data-target -->
               <c:choose>
                  <c:when test="${fn:length(fileList) <= 1}"></c:when>
                  <c:otherwise>
                     <ol class="carousel-indicators">
                        <li data-target="imgCarousel" data-slide-to="0" class="active"></li>
                        <c:forEach var="i" begin="1" end="${fn:length(fileList) - 1}">
                           <li data-target="imgCarousel" data-slide-to="${i}"></li>
                        </c:forEach>
                     </ol>
                  </c:otherwise>
               </c:choose>

               <!-- carousel-inner 이미지 -->
               <div class="carousel-inner">
                  <c:choose>
                     <c:when test="${fn:length(fileList) eq 0}">
                        <div class="carousel-item active">
                           <img src="upload/xmark.png" alt="">
                        </div>
                     </c:when>
                     <c:when test="${fn:length(fileList) eq 1}">
                        <div class="carousel-item active">
                           <c:forEach var="file" items="${fileList}">
                              <img src="upload/${file.files_name}" alt="">
                           </c:forEach>
                        </div>
                     </c:when>
                     <c:otherwise>
                        <c:forEach var="file" items="${fileList}" varStatus="status">
                           <c:choose>
                              <c:when test="${status.first}">
                                 <div class="carousel-item active">
                                    <img src="upload/${file.files_name}" alt="">
                                 </div>
                              </c:when>
                              <c:otherwise>
                                 <div class="carousel-item">
                                    <img src="upload/${file.files_name}" alt="">
                                 </div>
                              </c:otherwise>
                           </c:choose>
                        </c:forEach>
                     </c:otherwise>
                  </c:choose>

                  <!-- 이전/다음페이지 아이콘(이미지가 없거나 1개이면 삭제) -->
                  <c:choose>
                     <c:when test="${fn:length(fileList) <= 1}"></c:when>
                     <c:otherwise>
                        <a class="carousel-control-prev" href="#imgCarousel"
                           role="button" data-slide="prev"> <span
                           class="carousel-control-prev-icon" aria-hidden="true"></span> <span
                           class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#imgCarousel"
                           role="button" data-slide="next"> <span
                           class="carousel-control-next-icon" aria-hidden="true"></span> <span
                           class="sr-only">Next</span>
                        </a>
                     </c:otherwise>
                  </c:choose>
               </div>
            </div>
         </div>

         <!-- Right -->
         <!-- member(profile_pic, name, addr), like_record(count수), product(prd_num, prd_title, prd_price, prd_content, files) -->
         <div class="col-md-6 rightDiv">
            <div class="mb-4">
               <div class="d-flex justify-content-between">
                  <!-- 이미지 클릭 시 해당 회원 옷장으로 이동 -->
                  <a class="toCloset"
                     href="<%=request.getContextPath()%>/memberClosetPage.my?prd_num=${product.prd_num}">
                     <img id="userPic" src="upload/${member.profile_pic}">
                  </a>
                  <div class="mr-auto">
                     ${member.name}<br>
                     <c:choose>
                        <c:when test="${checkLike eq 0}">
                           <i id="heart" class="far fa-heart" aria-hidden="true"></i>
                        </c:when>
                        <c:otherwise>
                           <i id="heart" class="fas fa-heart" aria-hidden="true"></i>
                        </c:otherwise>
                     </c:choose>
                     <span id="cnt">${getLike}</span>
                  </div>
                  <button id="edit" class="btn btn-primary"
                     onclick="location.href='<%=request.getContextPath()%>/ProductEditPage.Pd?prd_num=${product.prd_num}'">글수정</button>
               </div>
            </div>
            <div class="mb-3">
               <h3 id="title">${product.prd_title}</h3>
            </div>
            <div class="mb-2">
               <h5 id="price">${price}<span id="location">${member.addr}</span>
               </h5>
            </div>
            <div class="mb-4 description">${product.prd_content}</div>
            <div class="mb-2 d-flex justify-content-between">
               <span class="prdReply">채팅방</span> <a id="modalBtn"
                  href="<%= request.getContextPath()%>/Page.askProduct?prd_num=${product.prd_num}"
                  data-toggle="modal" data-target="#myModal"> <input
                  type="button" id="ask" class="btn btn-primary" value="만들기"></a>
            </div>

         

            <div>
            <c:set var="dtos" value="${requestScope.chatRoomDTOs}"/>
               <!-- 상품문의 테이블 -->
               <table class="table myTable">
                  <thead class="thead-light">
                     <tr>
                        <th>번호</th>
                        <th>채팅방</th>
                        <th>작성자</th>
                     </tr>
                  
                  </thead>
                  <tbody>
                     <c:forEach var="dto" items="${dtos}">
                        <tr>
                           <td>${dto.ch_num}</td>
                           
                           <td> <button class ="ch_num" name="hiddenNum" value="${dto.ch_num }" data-toggle="modal" data-target="#myModal2">${dto.ch_title}</button>
                           </td>
                           
                           
                           <td>${dto.name}</td>
                        </tr>
                     </c:forEach>
                  </tbody>
               </table>
               <c:set var="startPage" value="${requestScope.startPage}" />
               <c:set var="endPage" value="${requestScope.endPage}" />
               <c:set var="pageSize" value="${requestScope.pageSize}" />
               <c:set var="currentPage" value="${requestScope.currentPage}" />
               <c:set var="maxPage" value="${requestScope.maxPage}" />

               <!-- Pagination -->
                              <!-- Pagination -->
               <div class="">
                  <nav aria-label="Page navigation">
                     <ul class="pagination pagination-sm justify-content-center"
                        style="margin-bottom: 0px;">
                        <li class="page-item"><c:if test="${cureentPage > 1}">
                              <a class="page-link" href="<%= request.getContextPath()%>/ProductDetailPage.Pd?prd_num=${product.prd_num}&currentPage=${currentPage-1}" aria-label="Previous"> <span
                                 aria-hidden="true">&laquo;</span>
                              </a>
                           </c:if></li>
                        <c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
                           <c:choose>
                              <c:when test="${currentPage == i}">
                                 <li class="page-item"><a class="page-link">${i}</a></li>
                              </c:when>
                              <c:otherwise>
                                 <li class="page-item"><a class="page-link" href="<%= request.getContextPath()%>/ProductDetailPage.Pd?prd_num=${product.prd_num}&currentPage=${i}">${i}</a>
                                 </li>
                              </c:otherwise>

                           </c:choose>
                        </c:forEach>
                        <c:if test="${cureentPage < maxPage }">
                           <li class="page-item"><a class="page-link" href="<%= request.getContextPath()%>ProductDetailPage.Pd?prd_num=${product.prd_num}&currentPage=${currentPage+1}"
                              aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                           </a></li>
                        </c:if>
                     </ul>
                  </nav>
               </div>
            </div>

         </div>
      </div>
   </div>
   


   <!-- Modal -->
   <div class="modal fade" id="myModal" role="dialog">
      <div class="modal-dialog" style="position: absolute;">
         <!-- Modal content-->
         <div class="modal-content"
            style="min-width: 1200px; margin: 100px 180px;">
            <div class="modal-header" style="padding: 25px 35px;">
               <div>
                  <h4>채팅방 만들기</h4>
               </div>
               <div>
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4>
                     <span class="glyphicon glyphicon-lock"></span>
                  </h4>
                  <br>
               </div>
            </div>
            <div class="modal-body" style="padding: 40px 50px;">
               <form role="form"
                  action="<%=request.getContextPath()%>/write.askProduct">
                  <input type="text" name="prd_num" value=${product.prd_num} hidden>
                  
                  <div class="form-group">
                     <label for="ch-content"><span
                        class="glyphicon glyphicon-user"></span> 방 제목</label> <input
                        type="text" class="form-control" name="title" required>
                  </div>
                  <div class="modal-footer">
                     <input type="submit" class="btn-success" value="개설">
                     <input type="submit" class="btn-danger" value="취소"
                        data-dismiss="modal">
                  </div>
               </form>
            </div>
         </div>

      </div>
   </div>



   <!-- Modal for comment 댓글용 모달 -->   
   <div class="modal fade" id="myModal2" role="dialog">
      <div class="modal-dialog" style="position: absolute;">

         <!-- Modal content-->
         <div class="modal-content"
            style="min-width: 1200px; min-height: 600px; margin: 20px 180px;">
            <div class="modal-header" style="padding: 25px 35px;">
               <div>
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4>
                     <span class="glyphicon glyphicon-lock"></span></h4>
               </div>

            </div>
            <div class="modal-body" style="padding: 40px 50px;">
               <div class="form-group" style="width: 50%; float: left;">
                  <label for="commentlist"><span
                     class="glyphicon glyphicon-eye-open"></span> 대화창</label>
                  <div id="commentlist">
                <!-- <div class="owner col-md-6 bd-1"></div>		
				<div class="sender col-md-6 bd-1"></div> -->				
                  </div>
               </div>
               <div>
                  <div class="form-group"
                     style="width: 40%; float: left; margin-left: 10%;">
                     <label for="comment"><span
                        class="glyphicon glyphicon-eye-open"></span> 작성자</label> <input
                        type="text" class="form-control" id="id" value="${member.name}"
                        style="background: #eee;" readonly><br> 
                        
                        <label
                        for="msg_content"><span
                        class="glyphicon glyphicon-eye-open"></span> 댓글</label> <input
                        type="text" class="form-control" id="msg_content"><br>
                  </div>
               </div>
            </div>

            <div class="modal-footer">
               <button  class="btn-success" id="btn-msg-write" >작성</button> <input
                  type="button" class="btn-danger" value="취소"
                  data-dismiss="modal"  id="btn-msg-cancle" >
            </div>
         </div>

      </div>
   </div>


   <!-- Modal for ask button ends  -->

   <div class="mb-5"></div>
   <jsp:include page="/WEB-INF/views/common/Bottom.jsp"></jsp:include>
</body>

<!-- <script>
 //채팅방 모달
    $(document).ready(function(){
      $("#comment-modal").click(function(){
        $("#myModal2").modal();
      });
    });
    </script>

<script>
 //채팅방 만들기 모달
    $(document).ready(function(){
      $("#modalBtn").click(function(){
        $("#myModal").modal();
      });
    });
</script> -->
<script>
$(document).ready(function() {
   if(!('${member.id}' == '${id}' || '${id}' == 'admin@admin.com')) {
      $("#edit").hide();
   }
   
   $("#heart").click(function(e) {
      if('${id}' != '') {   
         if($(this).hasClass('far fa-heart')){
            $.ajax(
               {
                  url: "<%=request.getContextPath()%>/sendLike.Ajax",
                  data:{send_id:'${id}', get_id:'${member.id}'},
                  type:"post",
                  dataType:"html",  
                  success:function(responsedata, textStatus, xhr){
                     $("#heart").attr('class', 'fas fa-heart');
                     $("#cnt").html(responsedata);
                  },
                  error:function(xhr){
                     alert(xhr.status + " : ERROR");
                  }
               }      
            );
            $(this).attr('class', 'fas fa-heart');         
         } else {
            $.ajax(
               {
                  url: "<%=request.getContextPath()%>/deleteLike.Ajax",
                  data:{send_id:'<%=request.getSession().getAttribute("id")%>', get_id:'${member.id}'},
                  type:"post",
                  dataType:"html",  
                  success:function(responsedata, textStatus, xhr){
                     $("#heart").attr('class', 'far fa-heart');
                     $("#cnt").html(responsedata);
                  },
                  error:function(xhr){
                     alert(xhr.status + " : ERROR");
                  }
               }      
            );         
         }
      }
   });
});
</script>
<script>
$(function(){

	
	
	
    $('.ch_num').click(function(e){
    	$('#btn-msg-write').val($('.ch_num').val());
       $('#commentlist').empty();
       console.log($(this).val());
       $.ajax({
          url:'msgList.Ajax',
          type:'POST',
          dataType:'JSON',
          data:{
             ch_num : $(this).val()
          },
          success:function(data){
        	 console.log(data);
             console.log(data.length);
             for(var i=0; i<data.length; i++) {
                console.log(data[i].msg_content);
                if(data[i].id == '${member.id}' ){
		            let ownerHtml = "<div class='owner'>"+data[i].msg_content+"</div>";
                	$('#commentlist').append(ownerHtml);
                 }else{
                    let senderHtml = "<div class='sender'>"+data[i].msg_content+"</div>";
                    $('#commentlist').append(senderHtml);
                 } 
             }
             
          }
          
          
       })
       
       
       
    });
    
    
    $('#btn-msg-write').click(function(e){
			console.log($('#msg_content').val());
    		console.log($(this).val());
    	$.ajax({
           url:'msgSend.Ajax',
           type:'POST',
           data:{
              ch_num : $(this).val(),
              content : $('#msg_content').val()
           },
           success:function(data){
         		console.log(data);
         		for(var i=0; i<data.length; i++) {
                	console.log(data[i].msg_content);
                    if(data[i].id == '${member.id}' ){
    		            let ownerHtml = "<div class='owner'>"+data[i].msg_content+"</div>";
                    	$('#commentlist').append(ownerHtml);
                     }else{
                        let senderHtml = "<div class='sender'>"+data[i].msg_content+"</div>";
                        $('#commentlist').append(senderHtml);
                     } 
                 }
         		$('#msg_content').empty();
           }
           
           
        })
        
        
        
     });
    
   
    
    
    
    
    
});

</script>
<style>
.owner{
 text-align:left;
 background-color:red;
 margin-bottom:2px;
 width:52%;
 float:left;
}
.owner::after{
	clear:both;
}
.sender{
 text-align:right;
 background-color:yellow;
 width:52%;
 float:right;
 margin-bottom:2px;
 
}
.sender::after{
	clear:both;
}
.ch_num{
	background:hlsa(0,100%,100%,1);
	border:0;
}
</style>
</html>