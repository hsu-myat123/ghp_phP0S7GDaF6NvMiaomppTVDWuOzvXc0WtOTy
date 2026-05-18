<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:import url="/common/base.jsp">

	<c:param name="title">
		成績登録
	</c:param>

	<c:param name="scripts"></c:param>

	<c:param name="content">

		<section class="me-4">

			<h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">
				成績登録
			</h2>

			<form action="TestRegistExecute.action" method="post">

				<div class="mb-3">

					<label class="form-label">
						学生番号
					</label>

					<input type="text"
						name="studentNo"
						class="form-control">

				</div>

				<div class="mb-3">

					<label class="form-label">
						科目コード
					</label>

					<input type="text"
						name="subjectCd"
						class="form-control">

				</div>

				<div class="mb-3">

					<label class="form-label">
						回数
					</label>

					<input type="number"
						name="no"
						class="form-control">

				</div>

				<div class="mb-4">

					<label class="form-label">
						点数
					</label>

					<input type="text"
						name="point"
						class="form-control">

				</div>

				<div>

					<input type="submit"
						value="登録して終了"
						class="btn btn-primary">

				</div>

			</form>

			<div class="mt-3">

				<a href="TestList.action">
					戻る
				</a>

			</div>

		</section>

	</c:param>

</c:import>