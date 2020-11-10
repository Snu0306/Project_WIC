<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>옷장 회원정보 수정</title>
        
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
        <link rel="stylesheet" href="resource/style/myPage-style.css">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="js/main.js"></script>
        	
    </head>
    <body>
    		
        <section>
			<!-- Top -->
            <header>
				<jsp:include page="WEB-INF/views/common/Top.jsp"></jsp:include>
            </header>

            <!--Profile-->
            <div class ="container" >
            	<div>
						<i id="heart" class="far fa-heart"></i>
						<div id="cnt">
							100
						</div>
				</div>
				<form name="profileEdit" action>
                <div class="profile">
                <div class="profile-image">
                    <img src="resource/image/mypage/man.png"  alt="">
                    
                </div>
                <div class="profile-user-setting">
                    <input type="text" name="username" placeholder="이름">
                </div>
                <div>
                	<input type="text" name="address" placeholder="주소" readonly>
                </div>
               
                <!--
                <div class="profile-stats">
                    <ul>
                        <li><span class="profile-stat-count">164러ㅏ어라어라어라어ㅏ</span>posts</li>
                        <li><span class="profile-stat-count">188</span>followers</li>
                        <li><span class="profile-stat-count">206</span>following</li>
                    </ul>
                </div>
                -->
                <div class="profile-bio">
                	<!-- <input type="text" name="intro" placeholder="자기소개">-->
                    <input type="text" name="intro" placeholder="자기소개">
                </div>
                </div>
                
                <div>
                	<button type="submit" formaction="MyCloset.jsp"
                          formmethod="get" formtarget="_blank">취소</button>
                    <button type="submit" formaction="myInfoEditPage.my"
                          formmethod="post" formtarget="_self">완료</button>
                </div>
				</form>
            </div>
            
            <main>
            	<div class="nav1">
            	<ul>
            		<li>
            			<a href="#tabContent01" >판매내역</a>
            		</li>
            		<li>
            			<a href="#tabContent01" >찜내역</a>
            		</li>
            	</ul>
            	</div>
            	
                <div class="gallery">
                    <div class="gallery-item" tabindex="0">
                        <img class="gallery-image" src="resource/image/mypage/1.jpg" width="200px" height="200px" alt="">
                        <div class="gallery-item-info">
                            <ul>
                                <li class="gallery-item-likes"><span class="visually-hidden">Likes : </span>56</li><br>
                                <li class="gallery-item-comments"><span class="visually-hidden">Comments : </span>2</li>
                            </ul>
                        </div>
                    </div>
                    <div class="gallery-item" tabindex="0">
                        <img class="gallery-image" src="resource/image/mypage/2.jpg" width="200px" height="200px" alt="">
                        <div class="gallery-item-info">
                            <ul>
                                <li class="gallery-item-likes"><span class="visually-hidden">Likes : </span>56</li><br>
                                <li class="gallery-item-comments"><span class="visually-hidden">Comments : </span>5</li>
                            </ul>
                        </div>
                    </div>
                    <div class="gallery-item" tabindex="0">
                        <img class="gallery-image" src="resource/image/mypage/3.jpg" width="200px" height="200px" alt="">
                        <div class="gallery-item-info">
                            <ul>
                                <li class="gallery-item-likes"><span class="visually-hidden">Likes : </span></li><br>
                                <li class="gallery-item-comments"><span class="visually-hidden">Comments : </span>2</li>
                            </ul>
                        </div>
                    </div>
                    <div class="gallery-item" tabindex="0">
                        <img class="gallery-image" src="resource/image/mypage/4.jpg" width="200px" height="200px" alt="">
                        <div class="gallery-item-info">
                            <ul>
                                <li class="gallery-item-likes"><span class="visually-hidden">Likes : </span>56</li><br>
                                <li class="gallery-item-comments"><span class="visually-hidden">Comments : </span>2</li>
                            </ul>
                        </div>
                    </div>
                    <div class="gallery-item" tabindex="0">
                        <img class="gallery-image" src="resource/image/mypage/5.png" width="200px" height="200px" alt="">
                        <div class="gallery-item-info">
                            <ul>
                                <li class="gallery-item-likes"><span class="visually-hidden">Likes : </span>56</li><br>
                                <li class="gallery-item-comments"><span class="visually-hidden">Comments : </span>2</li>
                            </ul>
                        </div>
                    </div>
                    <div class="gallery-item" tabindex="0">
                        <img class="gallery-image" src="resource/image/mypage/1.jpg" width="200px" height="200px" alt="">
                        <div class="gallery-item-info">
                            <ul>
                                <li class="gallery-item-likes"><span class="visually-hidden">Likes : </span>56</li><br>
                                <li class="gallery-item-comments"><span class="visually-hidden">Comments : </span>2</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </main>
            </div>
        
        </section>
	<jsp:include page="WEB-INF/views/common/Bottom.jsp"></jsp:include>
    </body>
</html>