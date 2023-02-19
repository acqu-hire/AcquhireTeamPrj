# ✨ ACQ-HIRE 커뮤니티 게시판
> - 개발자 관련 정보를 공유하는 커뮤니티 게시판 입니다.   
> - 공지사항, QnA, 이벤트, 커뮤니티 게시판 형태입니다.
> - 상세한 내용은 Wiki 또는 프로젝트 첨부 pdf에 작성   
> - 도메인 주소 : www.aqh-hire.link
## ✅ 프로젝트 개요

***1. 📅 프로젝트 기간***
 - **2023.01.01 ~ 2023.02.06**

***2. 🎯 프로젝트 목표***
 - 최소한 ***CRUD*** 로직에 대한 이해와 구현
 - ***인터셉터***를 이용한 세션(로그인) 관리
 - 게시판 이름, 제목, 내용 등 ***검색기능***
 - 게시판 ***파일 업로드***
 - 특정 게시물에서 게시글 리스트로 돌아갈 시 검색어, 기존 페이지, 카테고리 유지
 - ***AOP***를 통한 로깅 중복코드 제거
 - ~회원권한별 기능제어~
 - AWS EC2(윈도우 환경) ***서버 배포***
 
***3. 💻 개발환경 및 언어, 라이브러리(버전)***


<a href="https://www.java.com/ko/"><img src="https://img.shields.io/badge/Java(8)-007396?style=for-the-badge&logo=Java&logoColor=white"></a><a href="https://www.w3.org/"><img src="https://img.shields.io/badge/html-E34F26?style=for-the-badge&logo=html5&logoColor=white"></a><a href=
"https://www.w3.org/TR/CSS/"><img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"></a><a href="https://developer.mozilla.org/ko/docs/Web/JavaScript"><img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"></a>

<a href="https://spring.io/"><img src="https://img.shields.io/badge/Spring(5.0.7)-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"></a><a href="https://tomcat.apache.org/"><img src="https://img.shields.io/badge/apache tomcat(9.0.65)-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black"></a><a href="https://www.mysql.com/"><img src="https://img.shields.io/badge/mysql(8.0.31)-4479A1?style=for-the-badge&logo=mysql&logoColor=white"></a>

<a href="https://jquery.com/"><img src="https://img.shields.io/badge/jquery(3.5.1)-0769AD?style=for-the-badge&logo=jquery&logoColor=white"></a><a href="https://getbootstrap.com/docs/4.5/getting-started/introduction/"><img src="https://img.shields.io/badge/bootstrap(4.5.3)-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white"></a><a href="https://git-scm.com/"><img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"></a><a href="https://github.com/"><img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"></a><a href="https://aws.amazon.com/ko/ec2/"><img src="https://img.shields.io/badge/AWS EC2(window)-FF9900?style=for-the-badge&logo=aws&logoColor=white">
 
***4. 🙍‍♂️🙍 팀 구성 및 역할***  
|`👨🏽‍💻김시형(팀장)`|`👨‍💻엄성규(팀원)`|`👩‍💻김도연(팀원)`|`👩🏻‍💻박소연(팀원)`|
|:---------:|:---------:|:---------:|:---------:|
|**QnA,회원가입, 로그인**|**커뮤니티**|**공지사항**|**이벤트**|
| [GitHub](https://github.com/makemegrowup) | [GitHub](https://github.com/Devesg) | [GitHub](https://github.com/kimdoyeon12) | [GitHub](https://github.com/ori52) |
| makemegrowup4@gmail.com | z9rehwa@gmail.com | do.younkim.944@gmail.com | 1225kcal@gmail.com |
  
***5. 📌 메뉴 구조***

<img src="https://user-images.githubusercontent.com/117618309/218298624-ed0266dc-5555-41b9-bdff-dad3596d0778.png" width="60%">   

## ✅ Preview
 
[`Home`](https://github.com/acqu-hire/AcquhireTeamPrj/wiki/main(index.jsp))|[`회원가입`](https://github.com/acqu-hire/AcquhireTeamPrj/wiki/register(register_form.jsp))|[`로그인`]()|
:-------:|:-------:|:-------:|
![image](https://user-images.githubusercontent.com/117618309/218314186-57d880f0-c3e5-472e-8153-13b0503d77f1.png)|![image](https://user-images.githubusercontent.com/117618309/218315152-f36601be-c29b-4edf-822c-ef8f2762eca9.png)|![image](https://user-images.githubusercontent.com/117618309/218315194-b656c074-4953-497b-bebc-19f6ca12e072.png)|
[`회원정보`]()|[`회원정보 수정`]()|[`게시판 list`]()|
![image](https://user-images.githubusercontent.com/117618309/218315248-85778e14-7c7c-4bf8-871d-8f6cb9cb5d9a.png)|![image](https://user-images.githubusercontent.com/117618309/218315282-db785206-b150-43e9-8029-da4050ee0291.png)|![image](https://user-images.githubusercontent.com/117618309/218315315-a3d16357-b6f4-4db1-98b9-edb29f4ab562.png)|
[`게시물 쓰기`]()|[`게시물 수정`]()|[`게시물 보기`]()|
![image](https://user-images.githubusercontent.com/117618309/218315376-7069186f-901d-4b46-ac9f-7fa69d04df87.png)|![image](https://user-images.githubusercontent.com/117618309/218315430-040cf7e1-1006-49b9-91fb-f7792bd75c5e.png)|![image](https://user-images.githubusercontent.com/117618309/218315455-02ef1182-2163-43a4-a32b-985a9793c540.png)

## 📚 [Project Wiki(세부내용)](https://github.com/acqu-hire/AcquhireTeamPrj/wiki)




