<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>

    <body>
        <form action="./insert_view" method="post">
            메뉴(선택바) : <input type="text" name="menu"> 1 <br>
            카테고리(선택바) : <input type="text" name="category"> 3 아니면 4<br>
            파일(파일) : <input type="text" name="file"><br>
            제목 : <input type="text" name="title"><br>
            내용 : <input type="text" name="contents"><br>

            <input type="submit">
        </form>
    </body>

    </html>