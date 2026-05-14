<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>成績登録</title>
</head>

<body>

	<h2>成績登録</h2>

	<form action="" method="post">

		<p>
			学生番号<br>
			<input type="text" name="studentNo">
		</p>

		<p>
			科目コード<br>
			<input type="text" name="subjectCd">
		</p>

		<p>
			点数<br>
			<input type="text" name="point">
		</p>

		<p>
			<input type="submit" value="登録して終了">
		</p>

	</form>

	<p>
		<a href="ScoreList.action">戻る</a>
	</p>

</body>
</html>