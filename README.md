# ACQ-HIRE 커뮤니티 게시판
- 개발자 관련 정보를 공유하는 커뮤니티 게시판 입니다.
- 도메인 주소 : www.aqh-hire.link
# 프로젝트 개요
<a href="https://www.java.com/ko/"><img src="https://img.shields.io/badge/Java(8)-007396?style=for-the-badge&logo=Java&logoColor=white"></a><a href="https://spring.io/"><img src="https://img.shields.io/badge/Spring(5.0.7)-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"></a><a href="https://www.w3.org/"><img src="https://img.shields.io/badge/html-E34F26?style=for-the-badge&logo=html5&logoColor=white"></a><a href=
"https://www.w3.org/TR/CSS/"><img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"></a><a href="https://developer.mozilla.org/ko/docs/Web/JavaScript"><img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"></a><a href="https://tomcat.apache.org/"><img src="https://img.shields.io/badge/apache tomcat(9.0.65)-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black"></a><a href="https://www.mysql.com/"><img src="https://img.shields.io/badge/mysql(8.0.31)-4479A1?style=for-the-badge&logo=mysql&logoColor=white"></a>

<a href="https://jquery.com/"><img src="https://img.shields.io/badge/jquery(3.5.1)-0769AD?style=for-the-badge&logo=jquery&logoColor=white"></a><a href="https://getbootstrap.com/docs/4.5/getting-started/introduction/"><img src="https://img.shields.io/badge/bootstrap(4.5.3)-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white"></a><a href="https://git-scm.com/"><img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"></a><a href="https://github.com/"><img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"></a><a href="https://aws.amazon.com/ko/ec2/"><img src="https://img.shields.io/badge/AWS EC2(window)-FF9900?style=for-the-badge&logo=aws&logoColor=white">

```
│  pom.xml
│  README.md
├── src/main/java
│    ├──com.aqh 
│         ├── aop
│              ├──LoggingAdvice.java
│              ├──LoginCheck.java
│              └──LoginCheckAspect.java
│         ├── board
│              ├──controller
│                  ├──CommunityController.java
│                  ├──EventController.java
│                  ├──NoticeController.java
│                  └──QnAController.java
│              ├──dao
│                  ├──BoardDAO.java
│                  ├──CommunityDAOImpl.java
│                  ├──EventDAOImpl.java
│                  ├──NoticeDAOImpl.java
│                  └──QnADAOImpl.java
│              ├──domain
│                  ├──dto
│                     ├──BoardDTO.java
│                     └──Criteria.java
│                  └──pagehandler
│                     └──Pagination.java
│              └──service
│                  ├──BoardService.java
│                  ├──CommunityServiceImpl.java
│                  ├──EventServiceImpl.java
│                  ├──NoticeServiceImpl.java
│                  └──QnAServiceImpl.java
│         ├── exception
│              └──CommonExceptionAdvice.java
│         ├── file
│              ├──controller
│                  └──FileController.java
│              ├──dao
│                  └──FileDAO.java
│              ├──domain
│                  └──FileDTO.java
│              └──service
│                  └──FileService.java
│         ├── interceptor
│              └──LoginInterceptor.java
│         ├── login
│              ├──controller
│                  └──LoginController.java
│              ├──dao
│                  └──RoleDAO.java
│              ├──dto
│              └──service
│                  └──RoleService.java
│         ├── member
│              ├──controller
│                  └──MemberController.java
│              ├──dao
│                  └──MemberDAO.java
│              ├──domain
│                  └──MemberDTO.java
│              └──service
│                  └──MemberService.java
│         └── reply
│              ├──controller
│                  └──ReplyController.java
│              ├──dao
│                  └──RoplyDAO.java
│              ├──domain
│                  ├──ReplyCriteria.java
│                  ├──ReplyDTO.java
│                  └──ReplyPageDTO.java
│              └──service
│                  └──ReplyService.java

 ```
 
 작성중....
