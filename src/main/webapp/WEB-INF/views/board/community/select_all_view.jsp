<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:set var="contextPath" value="${pageContext.request.contextPath}" />
        <%-- <c:if test="${empty sessionScope.id}">
            <script type="text/javascript">
                location.href = "./LoginView.me"
            </script>
            </c:if> --%>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>QnA 게시판</title>
                <link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css">
                <script src="${contextPath}/resources/js/jquery-3.5.1.min.js" type="text/javascript"></script>
                <script src="${contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
                <script src="https://kit.fontawesome.com/58abbffa46.js"></script>
            </head>

            <body>
                <!-- Header -->

                <%@ include file="../../include/header.jsp" %>

                    <!-- Header -->

                    <!-- Board -->

                    <section>
                        <div class="container-fluid">
                            <div class="row justify-content-center">
                                <div class="col-8">
                                    <div class="card">
                                        <div class="card-header">
                                            <h3 align="center">글목록</h3>
                                            <div align="right">
                                                전체 글 : <strong>${boardListCount}</strong>
                                            </div>
                                        </div>
                                        <div class="card-body">
                                            <div align="center">
                                                <button type="button" class="btn btn-primary float-end" name="kind"
                                                    value="QNA_ALL">전체</button>
                                                <button type="button" class="btn btn-primary float-end" name="kind"
                                                    value="QNA_TECH">기술</button>
                                                <button type="button" class="btn btn-primary float-end" name="kind"
                                                    value="QNA_CAREER">커리어</button>
                                                <button type="button" class="btn btn-primary float-end" name="kind"
                                                    value="QNA_ETC">기타</button>
                                            </div>
                                            <div class="d-flex justify-content-end">
                                                <a class="btn btn-warning float-end" href="./BoardInsertView.do"> <i
                                                        class="fas fa-edit"></i> 글 작성
                                                </a>
                                            </div>
                                            <table class="table table-hover table-striped text-center"
                                                style="table-layout: fixed">
                                                <thead class="thead-dark">
                                                    <tr>
                                                        <th width="5%">번호</th>
                                                        <th width="25%">제목</th>
                                                        <th width="5%">작성자</th>
                                                        <th width="10%">작성일</th>
                                                        <th width="4%">조회수</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach varStatus="status" var="board" items="${boardList}">
                                                        <tr>
                                                            <th>${board.bNo}</th>
                                                            <td class="text-truncate" style="max-width: 500px;">
                                                                <a
                                                                    href="./listDetail?bNo=${board.bNo}">${board.title}</a>
                                                            </td>
                                                            <td>${board.id}</td>
                                                            <td>${board.writeDay}</td>
                                                            <td>${board.readCount}</td>
                                                        </tr>
                                                    </c:forEach>
            </body>

            </html>