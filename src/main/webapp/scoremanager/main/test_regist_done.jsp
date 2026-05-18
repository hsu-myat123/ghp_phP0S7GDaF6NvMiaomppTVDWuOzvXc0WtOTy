<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:import url="/common/base.jsp">

	<c:param name="title">
		登録完了
	</c:param>

	<c:param name="content">

		<section class="me-4">

			<div class="alert alert-success mt-4">

				<h2 class="h4">
					登録が完了しました。
				</h2>

			</div>

			<div class="mt-3">

				<a href="TestRegist.action"
					class="btn btn-primary">
					戻る
				</a>

			</div>

		</section>

	</c:param>

</c:import>