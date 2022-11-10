<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>새글등록</title>
</head>
<body>
<center>
<h1>새글 등록하기</h1>
    <hr>
    <form action="insertBoard" method="post">
        <table border="1" cellspacing="0" cellpadding="0">
            <tr>
                <td bgcolor="orange" width="70">제목</td>
                <td align="left"><input type="text" name="title"></td>
            </tr>
            <tr>
                <td bgcolor="orange">작성자</td>
                <td align="left"><input type="text" name="writer" size="10"></td>
            </tr>
            <tr>
                <td bgcolor="orange">내용</td>
                <td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="새글 등록"/></td>
            </tr>
        </table>


    </form>
<br>
<a href="insertBoard">새글 등록</a>
</center>
</body>

</html>